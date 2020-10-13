package org.mobeho.calendar.hilchaty;

import java.util.Arrays;
import java.util.Scanner;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class Shabbat
{
    private static final boolean israel = true;

    public enum Shabbatot {
        בראשית, נח, לך_לך, וירא, חיי_שרה, תולדות, ויצא, וישלח, וישב, מקץ, ויגש, ויחי, //12
        שמות, וארא, בא, בשלח, יתרו, משפטים, תרומה, תצוה, כי_תשא, ויקהל, פקודי, //23
        ויקרא, צו, שמיני, תזריע, מצרע, אחרי_מות, קדשים, אמר, בהר, בחקתי, //33
        במדבר, נשא, בהעלתך, שלח_לך, קרח, חקת, בלק, פינחס, מטות, מסעי, //43
        דברים, ואתחנן, עקב, ראה, שפטים, כי_תצא, כי_תבוא, נצבים, וילך, האזינו //53

//        BERESHIT=0, NOACH, LECHLECHA, VEYERA, CHAYESARA, TOLDOT, VAYETSE, VAYISHLACH, VAYESHEV, MIKETS, VAYIGASH, VAYCHI,
//        SHMOT, VAERA, BO, BESHALACH, ITRO, MISHPATIM, TRUMA, TETSAVE, KITISA, VAYAKHEL, PKUDEI,
//        VAYIKRA, TSAV, SHMINI, TAZRIA, METSORA, ACHARIMOT, KDOSHIM, EMOR, BEHAR, BESHUKOTAY,
//        BAMIDBAR, NASO, BEHAHALOTCHA, SHLACHLECHA, KORACH, CHUKAT, BALAK, PINCHAS, MATOT, MASEI,
//        DVARIM, VAETCHANAN, EKEV, REE, SHOFTIM, KITETSE, KITAVO, NITSAVIM, VAYELECH, HAAZINU,
//        SHABAT_VEROSH_HASHANA=100, SHABAT_VYOM_KIPUR, SHABT_SUKOT, SHABAT_BESUKOT, SHABAT_VESHMINI_ATSERET, SHABAT_PESACH, SHABAT_BEPESACH
    }

    // ShabatIndex = 1 is Bereshit
    public static int getDayInYear(YearType yearType, int shabatIndex)
    {
        return getDayInYear(yearType, shabatIndex, false);
    }
	
	/**
	 * Get day in year from parasha
	 * @param yearType of the year
	 * @param parasha index. Bereshit = 1, Aazinu = 53
	 * @param prevYear is true, when Vayelech in Tishrei, false when in Elul
	 * @return day in year
	 */
	public static int getDayInYear(YearType yearType, int parasha, boolean prevYear)
	{
      // shabatIndex = 1 is Bereshit so recude to set according Shabbatot
		parasha--;
		
		if (parasha == (Shabbatot.האזינו.ordinal()))
		{
			if (yearType.getFirstDay() == 5) return 3;
			else return 15 - yearType.getFirstDay();
		}
		
		if (parasha == (Shabbatot.וילך.ordinal()))
		{
			if (prevYear && (yearType.getFirstDay() == 2 || yearType.getFirstDay() == 3))
				return 8 - yearType.getFirstDay();
			else
				if (!prevYear && (yearType.getPesachDay() == 3 || yearType.getPesachDay() == 5))
					return yearType.numberDaysInYear - yearType.getPesachDay() - 1;
				else return -1;
		}
		
		int week = convertParashaToWeek(yearType, parasha);
		return 29 - (yearType.getFirstDay() % 7) + week * 7;
	}
   
      private static int convertParashaToWeek(YearType yearType, int parasha)
      {
         int mecubarot = reduceMechuberet(yearType,parasha, Shabbatot.ויקהל.ordinal());
         int pesach = balancePesach(yearType,		parasha + 1);
         mecubarot += reduceMechuberet(yearType, 	parasha, Shabbatot.תזריע.ordinal());
         mecubarot += reduceMechuberet(yearType, 	parasha, Shabbatot.אחרי_מות.ordinal());
         mecubarot += reduceMechuberet(yearType, 	parasha, Shabbatot.בהר.ordinal());
         mecubarot += reduceMechuberet(yearType, 	parasha, Shabbatot.חקת.ordinal()); // Only for chul
         mecubarot += reduceMechuberet(yearType, 	parasha, Shabbatot.מטות.ordinal());
         mecubarot += reduceMechuberet(yearType, 	parasha, Shabbatot.נצבים.ordinal());
         
         return parasha - mecubarot - pesach;
      }
   
   // Just for tests
   public static int numberOfParashot(YearType yearType, int index, int weeks)
   {
      return Arrays.stream(numbersOfParashot(yearType, index, weeks)).sum();
   }
   
   public static int[] numberOfParashotFromPos(YearType yearType, int index, int weeks)
   {
      return numbersOfParashot(yearType, index - (yearType.getFirstDay() == 7 ? 4 : 3), weeks);
   }

    /*
     * Calculating number of shabtot between index to index + week
     * #0 - How many parashot in Tishreri for this year
     * #1 - How many parashot for this year, from Bereshit until end of year
     * #2 - How many parashot in Tishreri in the next year
     * #3 - How many parashot after Tishreri in the next year
     *
     * Calculating if Shaba Chol Hamoed Sukkot will be:
     * #4 - 1 = Will be in this year
     * #5 - 1 = Will be in next year
     */
    public static int[] numbersOfParashot(YearType yearType, int index, int weeks)
    {
//      if ((index+weeks + balanceTishrei(yearType, index+weeks)) > yearType._numberOFShabatot)
//         return -1;

        int shabatTishreiHoliday = 1;
        int shabatPesach = 1;
        if ((index == 0) || // Soccut
                (index == -3 && yearType.getFirstDay() == 7) || // Rosh Hashan
                (index == -1 && yearType.getFirstDay() > 4)  // Yom Kipur
        )
        {
            shabatTishreiHoliday = 0;
            shabatPesach = 0;
        }
        else if (index < 1)
            shabatPesach = 0;
        else if (checkForPesach(yearType, index))
        {
            shabatTishreiHoliday = 0;
            shabatPesach = 0;
        }
        else
            shabatTishreiHoliday = 0;

        int[] i1 = convertWeekToParasha(yearType, index);
        int[] i2 = convertWeekToParasha(yearType, index + weeks);
        return new int[]{i2[0] + shabatTishreiHoliday - i1[0], i2[1] + shabatPesach - i1[1], i2[2] - i1[2], i2[3] - i1[3]};
    }

        /**
         * No of parashot by unformatted week
         * This function in limted to count parashot from Rosh Hashana until Bereshit next year (not included)
         *
         * @param yearType of the year
         * @param week     represent the week position in the year
         *                 -3(Rosh Hashana in shabat), -2, -1, 0(Usually Soccut) - until Bereshit
         *                 1 = Bereshit and so on until next year's Bereshit
         * @return 4 numbers:
         * #0 - Parashot index in Tishreri for this year
         * #1 - Parashot index for this year, from Bereshit until end of year
         * #2 - Parashot index in Tishreri in the next year
         * #3 - Parashot index after Tishreri in the next year
         */
        private static int[] convertWeekToParasha(YearType yearType, int week)
        {
            int[] tishrei = balanceTishrei(yearType.getFirstDay(), week);

            int add = 0;
            add += reduceMechuberet(yearType, week + add, Shabbatot.ויקהל.ordinal());
            add += balancePesach(yearType, week + add);
            add += reduceMechuberet(yearType, week + add, Shabbatot.תזריע.ordinal());
            add += reduceMechuberet(yearType, week + add, Shabbatot.אחרי_מות.ordinal());
            add += reduceMechuberet(yearType, week + add, Shabbatot.בהר.ordinal());
            add += reduceMechuberet(yearType, week + add, Shabbatot.חקת.ordinal()); // Only for chul
            add += reduceMechuberet(yearType, week + add, Shabbatot.מטות.ordinal());
            add += reduceMechuberet(yearType, week + add, Shabbatot.נצבים.ordinal());

            int nextYearWeeks = (yearType.getFirstDay() == 7 ? 4 : 3) + week - yearType.numberOFShabatot;
            int[] nextTishreiParashot = new int[]{0, 0};
            int nextWeek = 0;
            if (nextYearWeeks > 0)
            {
                week -= nextYearWeeks;
                int nextFirstDayInWeek = yearType.getPesachDay() % 7 + 2;
                nextWeek = nextYearWeeks - (nextFirstDayInWeek == 7 ? 4 : 3);
                nextTishreiParashot = balanceTishrei(nextFirstDayInWeek, nextWeek);
            }

            return new int[]{tishrei[1], -tishrei[1] + week + tishrei[0] + add, nextTishreiParashot[1], Math.max(0, nextWeek)};
        }

        private static boolean checkForPesach(YearType yearType, int pos)
        {
            int add = 0;
            add += reduceMechuberet(yearType, pos, Shabbatot.ויקהל.ordinal());
            // pos is immediately after pesach
            return (balancePesach(yearType, pos + add - 1) == 0 && balancePesach(yearType, pos + add) == -1);
        }

        /** All information regarding to Tishrei
         * @param getFirstDay of the year
         * @param week represent the week position in the year
         *  -3(Rosh Hashana in shabat), -2, -1, 0 (Usually Soccut)
         * #0 - Delta need to add to complete shabatot to PARASHOT
         * #1 - How many PARASHOT before week pos
         * #2 - 1 = Shabat sukkot/before, 0 = after
         */
        private static int[] balanceTishrei(int getFirstDay, int week)
        {
            if (getFirstDay == 7 || getFirstDay == 5)
            {
                // week = 0 + 1 =  1
                if (week >=  0) return new int[]{1, 1};
                // week = -1 + 2 =  1
                if (week >= -1) return new int[]{2, 1};
                // week = -2 + 3 = 1
                if (week >= -2) return new int[]{3, 1};
                // week = -3 + 3 = 0; Relevant only for FirstDay() == 7
                if (week >= -3) return new int[]{3, 0};
            }
            else /*if (yearType.getFirstDay() == 3 || yearType.getFirstDay() == 2)*/
            {
                // week =  0 + 2 = 2
                if (week >=  0) return new int[]{2, 2};
                // week = -1 + 3 = 2
                if (week >= -1) return new int[]{3, 2};
                // week = -2 + 3 = 1
                if (week >= -2) return new int[]{3, 1};
            }
            return new int[]{0, 0};
        }

        private static int reduceMechuberet(YearType yearType, int shabat, int shabattoCheck)
        {
            if (shabat > shabattoCheck)
            {
                // 7 mark this is for this year end question, and not in the beginning (See the condition inside)
                boolean[] conditions = isMechubarot(yearType, shabattoCheck, 7);
                return (conditions[0] && conditions[1]) ? 1 : 0;
            }
            else
                return 0;
        }
	
		// -1 = Shabat Pesach or chol Hamoed Pesach was past
		private static int balancePesach(YearType yearType, int index)
		{
			if (!yearType.isLeap() && index > (Shabbatot.צו.ordinal() + 1)) return -1;
			else if (yearType.getFirstDay() != 5 && index > (Shabbatot.מצרע.ordinal() + 1)) return -1;
			else if (index > (Shabbatot.אחרי_מות.ordinal() + 1)) return -1;
			return 0;
		}


   public static int getFirstShabatDayInYear(YearType yearType)
    {
        return 29 - (yearType.getFirstDay() % 7);
    }

   public static int getLastShabatDayInYear(YearType yearType)
   {
      return yearType.numberDaysInYear - yearType.getPesachDay() % 7 - 1;
   }


   // In chul there are some Shabatot that are double
    public static String getShabatName(YearType yearType, int dayInYear)
    {
        if (dayInYear > yearType.numberDaysInYear)
            return "";

        boolean mechubarot = false;
        int shabat = dayInYear;

        if (yearType.getFirstDay() == 7 && dayInYear == 1)
            return ShabatHoli.ROSH_HASHANA.toString();

        // Vayelech
        int theDay = (8 - yearType.getFirstDay() % 7);
        if (yearType.getFirstDay() < 5 && inWeek(dayInYear, theDay))
            return Shabbatot.וילך.name();
        else if (yearType.getFirstDay() > 3 && inWeek(dayInYear, theDay))
            return Shabbatot.האזינו.name();

        // Hahazinu
        theDay = (15 - yearType.getFirstDay() % 7);
        if (yearType.getFirstDay() < 5 && inWeek(dayInYear, theDay))
            return Shabbatot.האזינו.name();
        else if (yearType.getFirstDay() == 5 && inWeek(dayInYear, theDay))
            return ShabatHoli.YOM_KIPUR.toString();
        else if (yearType.getFirstDay() == 7 && inWeek(dayInYear, theDay))
            return ShabatHoli.SUKKOT.toString();

        // Shabat in Sukut
        theDay = (22 - yearType.getFirstDay() % 7);
        if (yearType.getFirstDay() <= 5 && inWeek(dayInYear, theDay))
            return ShabatHoli.BESUKKOT.toString();
        else if (yearType.getFirstDay() > 5 && inWeek(dayInYear, theDay))
            return ShabatHoli.SHMINI.toString();

        // Bereshit
        int bereshit = (29 - yearType.getFirstDay() % 7);

        // Veikehl-Pkudei
        theDay = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 29 + 29 + yearType.getPesachDay());
        if (!yearType.leap && yearType != YearType.השא && dayInYear >= theDay - 6)
        {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Shabat Pesach
        theDay = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 29 + 15);
        if (yearType.getPesachDay() == 7 && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) return ShabatHoli.PESACH.toString();
        }

        // Shabat BePesach
        theDay = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 29 + 8 + yearType.getPesachDay());
        if (theDay < yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 29 + 8) && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) return ShabatHoli.BEPESACH.toString();
            else shabat -= 7;
        }

        // Tazriaa Metzora
        theDay = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 23 + yearType.getPesachDay());
        if (!yearType.leap && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Acharie Mot Kedoshim
        theDay = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 16 + yearType.getPesachDay());
        if (!yearType.leap && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Behar Bechukotai
        theDay = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 2 + yearType.getPesachDay());
        if (!yearType.leap && yearType != YearType.הכז && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Matot Masei
        theDay = yearType.numberDaysInYear - (29 + 28 + yearType.getPesachDay() % 7);
        if (!(yearType.getPesachDay() == 7 && yearType.leap) && yearType != YearType.החא && yearType != YearType.השג && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Nitzavim Vayelech
        theDay = yearType.numberDaysInYear - (1 + yearType.getPesachDay() % 7);
        if (theDay < (yearType.numberDaysInYear - 2) && theDay > (yearType.numberDaysInYear - 7) && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Shabat and Rosh Hashan for the next year
        theDay = yearType.numberDaysInYear + 1;
        if (yearType.getPesachDay() == 5 && dayInYear >= theDay - 6) return ShabatHoli.ROSH_HASHANA.toString();

        String arbaParshiot = "";
        ShabatHoli fourShabatot = ShabatHoli.is4Shabtot(yearType, dayInYear);
        if (fourShabatot != null)
            arbaParshiot = " (" + fourShabatot.toString() + ")";

        String out = Shabbatot.values()[(shabat + 6 - bereshit) / 7].name();
        if (mechubarot)
            return (out + " " + Shabbatot.values()[(7 + shabat + 6 - bereshit) / 7].name()).replace('_','-');
        else
            return (out + arbaParshiot).replace('_','-');
    }

        private static boolean inWeek(int dayInYear, int theDay)
        {
            return dayInYear >= theDay - 6 && dayInYear <= theDay;
        }

    public static int[] getShabatIndexes(YearType yearType, int dayInYear)
    {
        try
        {
            String shabat = getShabatName(yearType, dayInYear);
            shabat = convertName(shabat);

            shabat = shabat.replace('-','_');
            Scanner scanner = new Scanner(shabat);
            scanner.useDelimiter(" ");
            Shabbat.Shabbatot first = Shabbat.Shabbatot.valueOf(scanner.next().trim());

            Shabbat.Shabbatot second = null;
            if (scanner.hasNext())
                second  = Shabbat.Shabbatot.valueOf(scanner.next().trim());

            if (second != null)
                return new int[]{first.ordinal() + 1, second.ordinal() + 1};

            return new int[]{first.ordinal() + 1, 0};
        }
        catch (Exception ignore)
        {
            return new int[]{-1,-1};
        }
    }

    public static int[] getShabatIndexes(String shabat)
    {
        try
        {
            shabat = convertName(shabat);
            ShabatHoli holi = ShabatHoli.of(shabat);
            if (holi != null)
                return new int[]{holi.getVal(), 0};

            Scanner scanner = new Scanner(shabat);
            scanner.useDelimiter(" ");
            Shabbat.Shabbatot first = Shabbat.Shabbatot.valueOf(scanner.next().trim());

            Shabbat.Shabbatot second = null;
            if (scanner.hasNext())
                second  = Shabbat.Shabbatot.valueOf(scanner.next().trim());

            // במקרה של שבת כפולות השבתות חייבות להיות צמודות
            if (second != null)
            {
                if ((second.ordinal() - first.ordinal()) > 1)
                    return new int[]{-1,-1};

                return new int[]{first.ordinal() + 1, second.ordinal() + 1};
            }

            return new int[]{first.ordinal() + 1, 0};
        }
        catch (Exception ignore)
        {
            return new int[]{-1,-1};
        }
    }

    public static String getShabatName(int[] indexes)
    {
        try
        {
            ShabatHoli holi = ShabatHoli.of(indexes[0]);
            if (holi != null)
                return holi.toString();

            Shabbat.Shabbatot first;
            Shabbat.Shabbatot second;

            if (indexes[1] > 0)
            {
                first = Shabbat.Shabbatot.values()[indexes[0] - 1];
                second = Shabbat.Shabbatot.values()[indexes[1] - 1];
                // We don't care about the deFacto = [1], only the optional[0], so put any YearType
                if (!isMechubarot(YearType.בחג, first.ordinal(), second.ordinal())[0])
                    return "";

                // במקרה של שבת כפולות השבתות חייבות להיות צמודות
                if  ((second.ordinal() - first.ordinal()) > 1)
                    return "";

                return (first + " " + second).replace('_','-');
            }

            first = Shabbat.Shabbatot.values()[indexes[0] - 1];
            return first.toString().replace('_','-');
        }
        catch (Exception ignore)
        {
            return "";
        }
    }

    public static boolean[] isShabatotoMechubarot(YearType yearType, int dayInYear)
    {
        int[] indexes = Shabbat.getShabatIndexes(yearType, dayInYear);
        return isMechubarot(yearType, indexes[0] - 1, dayInYear);
    }

    // First flag if potentionally they are mechubarot , 2nd flag if actually there are for this year
    private static boolean[] isMechubarot(YearType yearType, int index1, int dayInYear)
    {
        boolean optional = false;
        boolean deFacto = false;

        if (isShabat(index1, Shabbatot.ויקהל) || isShabat(index1, Shabbatot.פקודי))
        {
            optional = true;
            deFacto =  !yearType.isLeap() && yearType != YearType.השא;
        }

        else if (isShabat(index1, Shabbatot.תזריע) || isShabat(index1, Shabbatot.מצרע))
        {
            optional = true;
            deFacto = !yearType.isLeap();
        }

        else if (isShabat(index1, Shabbatot.אחרי_מות) || isShabat(index1, Shabbatot.קדשים))
        {
            optional = true;
            deFacto = !yearType.isLeap();
        }

        else if (isShabat(index1, Shabbatot.בהר) || isShabat(index1, Shabbatot.בחקתי))
        {
            optional = true;
            deFacto = !yearType.isLeap() &&
               ((yearType != YearType.הכז && israel) || (yearType == YearType.הכז && !israel));
        }

        else if (isShabat(index1, Shabbatot.מטות) || isShabat(index1, Shabbatot.מסעי))
        {
            optional = true;
            deFacto = yearType != YearType.החא && yearType != YearType.השג &&
               (!israel || (yearType != YearType.בשז && yearType != YearType.גכז));
        }

        else if (isShabat(index1, Shabbatot.נצבים) || isShabat(index1, Shabbatot.וילך))
        {
            optional = true;
            deFacto = ( yearType == YearType.בחג || yearType == YearType.בשה || yearType == YearType.גכה || yearType == YearType.זשג
               || yearType == YearType.בחה || yearType == YearType.השג || yearType == YearType.זחג || yearType == YearType.זשה
            ) && dayInYear > 6;
        }

        else if (isShabat(index1, Shabbatot.חקת) || isShabat(index1, Shabbatot.בלק))
        {
            optional = !israel;
            deFacto = !israel &&
               ( yearType == YearType.בשה || yearType == YearType.גכה || yearType == YearType.בחה || yearType == YearType.זשה );
        }

        if (optional && deFacto)
            return new boolean[]{true, true};
        else if (optional)
            return new boolean[]{true, false};
        else
            return new boolean[]{false, false};
    }


    private static boolean isShabat(int indexd, Shabbatot shabat)
    {
        return  indexd == shabat.ordinal();
    }

    // The Shabat  position at the year
    public static int getPos(YearType yearType, int dayInYear)
    {
        return 1 + (yearType.getFirstDay()-1 + dayInYear-1) / 7;
    }

    private static String convertName(String value)
    {
        value = value.trim();
        value = value.replace("-"," ");
        value = value.replace("_"," ");
        value = value.replace("  "," ");
        value = value.replace("(","");
        value = value.replace(")","");

        value = ShabatHoli.convertName(value).trim();

        // Mechubarot should just be replace
        if ("נוח".equals(value)) return "נח";
        if ("לך לך".equals(value)) return "לך_לך";
        if ("חיי שרה".equals(value)) return "חיי_שרה";
        if ("מיקץ".equals(value)) return "מקץ";
        if ("בוא".equals(value)) return "בא";
        if ("מישפטים".equals(value)) return "משפטים";
        if ("תצווה".equals(value)) return "תצוה";
        if ("כי תשא".equals(value)) return "כי_תשא";
        value = value.replaceAll("מצורע","מצרע");
        value = value.replaceAll("אחרי מות","אחרי_מות");
        if ("קדושים".equals(value)) return "קדשים";
        if ("אמור".equals(value)) return "אמר";
        value = value.replaceAll("בחוקתי","בחקתי");
        value = value.replaceAll("בחוקותי","בחקתי");
        if ("נשוא".equals(value)) return "נשא";
        if ("בהעלותך".equals(value)) return "בהעלתך";
        if ("שלח לך".equals(value)) return "שלח_לך";
        if ("שלח".equals(value)) return "שלח_לך";
        if ("קורח".equals(value)) return "קרח";
        if ("חוקת".equals(value)) return "חקת";
        if ("פנחס".equals(value)) return "פינחס";
        if ("שופטים".equals(value)) return "שפטים";
        if ("כי תצא".equals(value)) return "כי_תצא";
        if ("כי תבוא".equals(value)) return "כי_תבוא";
        value = value.replaceAll("ניצבים","נצבים");

        return value;
    }
}
