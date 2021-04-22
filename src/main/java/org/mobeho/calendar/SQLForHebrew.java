package org.mobeho.calendar;

import org.mobeho.calendar.hilchati.weak.Convert;
import org.mobeho.calendar.hilchati.weak.Shabat;
import org.mobeho.calendar.hilchati.weak.Parasha;
import org.mobeho.calendar.calendar.YearType;

import static org.mobeho.calendar.hilchati.weak.Convert.numbersOfParashot;

public class SQLForHebrew
{
	private static int fromShabat;
	private static YearType yearType;
	private static int year;
	
	public static SQLForHebrew of(HebrewDate date)
	{
		SQLForHebrew me = new SQLForHebrew();
		me.fromShabat = date.getDayInYear() + (7 - date.getDayOfWeak());
		me.yearType = date.getYearType();
		me.year = date.getYear();
		return me;
	}
	
	// TODO calculation from yom chol not just from next SHABAT
	public static String sqlDayInRange(int weeks, String monthFieldName, String dayFieldName, String leapFlagFieldName)
	{
		if (weeks == 0)
			return "TRUE";
		
		// Range is number of days until last friday
		// Since we starting always from Shabat, we multiply full weeks, and reducing 1 to go move back to last Friday
		int range = weeks * 7 - 1;
		int rangeForThisYear = Math.min(yearType.getNumberDaysInYear() - fromShabat, range);
		
		
		StringBuilder sql = new StringBuilder("CASE WHEN " + monthFieldName + " > 0 AND " + dayFieldName + " > 0 THEN\n (");
		sql.append(sqlDayInYearTuning(yearType.getNumberDaysInYear(), monthFieldName, dayFieldName, leapFlagFieldName))
			.append("  - ").append(fromShabat).append(") BETWEEN 0 AND ").append(rangeForThisYear);
		
		if (range > rangeForThisYear)
		{
			sql.append("\nOR\n (");
			HebrewDate nextYear = HebrewDate.of(year + 1, 1, 1);
			int rangeForNextYear = range - rangeForThisYear;
			sql.append(sqlDayInYearTuning(nextYear.getNumberDaysInYear(), monthFieldName, dayFieldName, leapFlagFieldName))
				.append(" ) BETWEEN 0 AND ").append(rangeForNextYear);
		}
		
		sql.append("\nEND\n");
		return sql.toString();
	}
	
		// This function calculate the days of year for each occasion
		// The parameters will be the fields in the table
		private static String sqlDayInYearTuning(int numberDaysInYear, String monthFieldName, String dayFieldName, String leapFlagFieldName)
		{
			StringBuilder sql = new StringBuilder();
			
			// The base is year of 384 days
			// month: 1  2  3  4   5   6   7   8
			//      : 0 30 29 30  29  30  29  30
			//   pos: 0 30 59 89 118 148 177 207        + day
			//   pos = (month-1) * 29 + (month / 2)     + day;
			sql.append(" (").append(monthFieldName).append("-1)*29 + FLOOR(").append(monthFieldName).append("/2) + ").append(dayFieldName).append("\n");
			
			// Fix the days for 355 or 385
			if ((numberDaysInYear == 355 || numberDaysInYear == 385))
				sql.append("  +(CASE WHEN (").append(monthFieldName).append("=2 AND ").append(dayFieldName).append("=30) OR ").append(monthFieldName).append(">2 THEN 1 ELSE 0 END)\n");
			
			// Fix the days for 353 or 383
			if (numberDaysInYear == 353 || numberDaysInYear == 383)
				sql.append("  +(CASE WHEN ").append(monthFieldName).append(">3 THEN -1 ELSE 0 END)\n");
			
			// Fix the days for this year is leap one bu t
			if (numberDaysInYear > 355)
				sql.append("  +(CASE WHEN (").append(leapFlagFieldName).append("=FALSE AND " +
					"((").append(monthFieldName).append("=6 AND ").append(dayFieldName).append("=30) OR ").append(monthFieldName).append(">6)) THEN 30 ELSE 0 END)\n");
			
			return sql.toString();
		}
	
	
	// TODO cal fo Holiday
	public static String sqlParashaInRange(int weeks, String indexFieldName)
	{
		StringBuilder sql = new StringBuilder();
		sqlParashaInRangeInner(weeks, indexFieldName, sql);
		sql.append("\n");
		return sql.toString();
	}

	private static void sqlParashaInRangeInner(int weeks, String indexFieldName, StringBuilder sql)
	{
		int dayInYear = fromShabat;
		int weekPos = (dayInYear + yearType.getFirstDay() - 1) / 7;
		int[] numbersOfParashot = numberOfParashotFromPos(yearType, weekPos, weeks);

        // Parashot in Tishreri for this year
		sqlForYear(sql, numbersOfParashot[0], indexFieldName, dayInYear);

		if (inSukkotInRange(yearType, weekPos, weeks) && sql.indexOf("1 = " + Parasha.שבת_חול_המועד_סוכות.index) == -1)
			sql.append("OR ").append(indexFieldName).append("1 = ").append(Parasha.שבת_חול_המועד_סוכות.index).append(" ");

		// Parashot for this year, from Bereshit until end of year + in Tishreri in the next year
        int dayInYearBereshit = Shabat.getDayInYear(yearType, Parasha.בראשית, false);
		dayInYear = Math.max(dayInYearBereshit, dayInYear);
		int parahsotuntilSokkut = numbersOfParashot[1] + numbersOfParashot[2];
		sqlForYear(sql, parahsotuntilSokkut, indexFieldName, dayInYear);

		if (isChanukaInRange(yearType, weekPos, weeks) && sql.indexOf("1 = " + Parasha.חנוכה.index) == -1)
			sql.append("OR ").append(indexFieldName).append("1 = ").append(Parasha.חנוכה.index).append(" ");
		
		if (isHagadolInRange(yearType, weekPos, weeks) && sql.indexOf("1 = " + Parasha.הגדול.index) == -1)
			sql.append("OR ").append(indexFieldName).append("1 = ").append(Parasha.הגדול.index).append(" ");

		if (isPesachInRange(yearType, weekPos, weeks) && sql.indexOf("1 = " + Parasha.שבת_חול_המועד_פסח.index) == -1)
            sql.append("OR ").append(indexFieldName).append("1 = ").append(Parasha.שבת_חול_המועד_פסח.index).append(" ");

		if (isTshuvaInRange(yearType, weekPos, weeks) && sql.indexOf("1 = " + Parasha.שבת_שובה.index) == -1)
			sql.append("OR ").append(indexFieldName).append("1 = ").append(Parasha.שבת_שובה.index).append(" ");

        // Parashot for from Bereshit next year
		if (numbersOfParashot[3] > 0)
		{
			HebrewDate nextYear = HebrewDate.of(year + 1, Parasha.בראשית, false);
			of(nextYear);
			sqlParashaInRangeInner(numbersOfParashot[3] - 1, indexFieldName, sql);
		}
	}

	private static int[] numberOfParashotFromPos(YearType yearType, int index, int weeks) { return numbersOfParashot(yearType, index - (yearType.getFirstDay() == 7 ? 4 : 3), weeks); }

	private static void sqlForYear(StringBuilder sql, int week, String indexFieldName, int dayInYear)
	{
		if (week <= 0)
			return;
		
		// From Rosh Hasha / You Kipur / Shabat chol hamoed
		Parasha parasha = Shabat.getShabat(yearType, dayInYear)[0];
		if (parasha == null || !parasha.isOrdered())
		{
			dayInYear += 7;
            parasha = Shabat.getShabat(yearType, dayInYear)[0];
            if (parasha == null || !parasha.isOrdered())
				return;
		}

        boolean[] mechubarot = Convert.isMechubarot(yearType, parasha.index, dayInYear);

		int index = parasha.index;
		if (mechubarot[0])
		{
			// Let's assume: indexFieldName is "index", and range = 0, Current shabat index is 23
			// Explain:
			// 1. index( the shabat index in the DB )
			// 2. -> true/false - will translate to the BETWEEN @rang AND 0
			// 3. One of the statement must bw true
			//
			// Current isn't mechubarot [23...24], DB is mechubarot [23+24]:
			// Shabat 23: index1(23)-23 -> TRUE OR index2[24]-23 -> false
			// Shabat 24: index1(23)-24 -> false OR index2[24]-24 -> TRUE
			// Ole 23+24 will get on shabat 23 or on shabat 24
			// Ole 23 will get on Shabat 23
			// Ole 24 Will get on Shabat 24
			//
			// Current is mechubarot [23+24], DB isn't mechubarot [23...24]:
			// Ole 23 : index1(23)-23 -> TRUE  OR index2[null]-23 -> false OR index1(23)-24 -> false OR index2[null]-24 -> false
			// Ole 24 : index1(24)-23 -> false OR index2[null]-23 -> false OR index1(24)-24 -> TRUE  OR index2[null]-24 -> false
			// Ole 23 will get on Shabat 23+24
			// Ole 24 Will get on Shabat 23+24
			//
			// Both arn't mechubarot [23...24]:
			// Shabat 23: index1(23)-23 -> TRUE  OR index2[null]-23 false
			// Ole 23 will get on Shabat 23
			// Ole 24 Will get on Shabat 24
			//
			// Both are mechubarot [23+24]:
			// Shabat 23+24: index1(23)-23 -> TRUE OR index2[24]-23 -> false OR index1(23)-24 -> false OR index2[24]-24 -> TRUE
			// Ole 23+24 will get on Shabat 23+24
			// Ole 23 will get on Shabat 23
			// Ole 24 Will get on Shabat 24
			int bafoal = mechubarot[1] ? 1 : 0;
			sql.append("OR");
			sql.append(" (").append(indexFieldName).append("1 - ").append(index).append(" BETWEEN 0 AND ").append(week - 1 + bafoal).append(") OR")
				.append(" (").append(indexFieldName).append("2 - ").append(index).append(" BETWEEN 0 AND ").append(week - 1 + bafoal).append(") ");
			
		}
		else
			sql.append("OR (").append(indexFieldName).append("1 - ").append(index).append(" BETWEEN 0 AND ").append(week-1).append(") ");
	}

	// Check if Shabat Chol Hamoed Sukkot is in range between index and index+weeks
	public static boolean inSukkotInRange(YearType yearType, int index, int weeks)
	{
		final int shabat = yearType.getFirstDay() == 7 ? 4 : 3;
		if (index <= shabat && index + weeks >= shabat && yearType.getFirstDay() != 7)
			return true;

		// Check for next year between Roash Hasna ans Bereshit
		int shabatSukkotNextYear = (index + weeks) - yearType.getNumberOfShabatot();
		if (shabatSukkotNextYear > 0)
		{
			int nextFirstDayInWeek = yearType.getPesachDay() % 7 + 2;
			return nextFirstDayInWeek != 7 && shabatSukkotNextYear >= 3;
		}

		return false;
	}

	// Check if Shabat Chanuka is in range between index and index+weeks
	public static boolean isChanukaInRange(YearType yearType, int index, int weeks)
	{
		final int shabat = getPos(yearType, 92 - yearType.getFirstDay());
		return index <= shabat && index + weeks >= shabat;
	}

	// Check if Shabat Shira is in range between index and index+weeks
	public static boolean isShiraInRange(YearType yearType, int index, int weeks)
	{
		final int shabat = getPos(yearType, 134 - yearType.getFirstDay() + (yearType.getFirstDay() == 7 ? 7 : 0));
		return index <= shabat && index + weeks >= shabat;
	}

	// Check if Shabat Hagadol is in range between index and index+weeks
	public static boolean isHagadolInRange(YearType yearType, int index, int weeks)
	{
		final int shabat = getPos(yearType, yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15 + yearType.getPesachDay()));
		return index <= shabat && index + weeks >= shabat;
	}

	// Check if Shabat Chol Hamoed Pesach is in range between index and index+weeks
	public static boolean isPesachInRange(YearType yearType, int index, int weeks)
	{
		int shabtatCholHamodePesachPos;
		if (YearType.גכה.equals(yearType) || YearType.בחג.equals(yearType) || YearType.בשה.equals(yearType) || YearType.זשג.equals(yearType))
			shabtatCholHamodePesachPos = yearType.getFirstDay() == 7 ? 4 : 3 + 25;

		else if (YearType.בחה.equals(yearType) || YearType.השג.equals(yearType) || YearType.זחג.equals(yearType))
			shabtatCholHamodePesachPos = yearType.getFirstDay() == 7 ? 4 : 3 + 29;

		else
			return false;

		return index <= shabtatCholHamodePesachPos && index + weeks >= shabtatCholHamodePesachPos;
	}

	// Check if Shabat Tshuva is in range between index and index+weeks
	public static boolean isTshuvaInRange(YearType yearType, int index, int weeks)
	{
		final int shabat = getPos(yearType, yearType.getNumberDaysInYear() - (1 + yearType.getPesachDay() %7));
		return index <= shabat && index + weeks >= shabat;
	}

	// The Shabat position at the year
	private static int getPos(YearType yearType, int dayInYear)
	{
		return 1 + (yearType.getFirstDay()-1 + dayInYear-1) / 7;
	}

}
