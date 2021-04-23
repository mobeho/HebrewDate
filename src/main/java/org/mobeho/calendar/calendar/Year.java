package org.mobeho.calendar.calendar;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public abstract class Year extends Month
{
    protected int numberDaysInYear;
    protected int year;

    protected boolean reset(int daysFromStart)
    {
        if (!super.reset(daysFromStart))
            return false;

        if (daysFromStart >= DAYS_FROM_START_TO_1900)
        {
            this.year = 5660;
            this.numberDaysInYear = 384;
        }
        else
        {
            this.year = 1;
            this.numberDaysInYear = 355;
        }

        return true;
    }

    @Override
    protected void addYears(int years)
    {
        if (years <= 0)
            return;

        for (; years > 0; years--)
        {
            int prevNumberDaysInYear = this.numberDaysInYear;

            // "תוספת הזמנים למולש החודש עבור שנה הבאה
            if (!YearType.getIfLeapYear(this.year) && this.month <= 6)
                this.moladHachodesh = adv(this.moladHachodesh, 7, 4 + this.moladHachodeshTime.addTime(8, 876));
            else
                this.moladHachodesh = adv(this.moladHachodesh, 7, 5 + this.moladHachodeshTime.addTime(21, 589));

            setNextYear();

            int numbersDaysToAdd = prevNumberDaysInYear;
            numbersDaysToAdd += addMonthTuning(YearType.getIfLeapYear(this.year - 1), YearType.getIfLeapYear(this.year));
            numbersDaysToAdd += addDaysTuning(prevNumberDaysInYear, this.numberDaysInYear);

            this.dayOfWeak = adv(this.dayOfWeak, 7, numbersDaysToAdd);
            this.daysFromStart += numbersDaysToAdd;
            this.dayInYear = adv(this.dayInYear, prevNumberDaysInYear, numbersDaysToAdd);
        }
    }

    protected abstract void setNextRoshHashanahDayInWeak();
    protected abstract void setYearType();

    @Override
    protected void setNextYear()
    {
        this.year++;
        setNextRoshHashanahDayInWeak();
        setYearType();
    }

    /// <summary>
    ///		   1	2	3	4	5	6	7	8	9	10	11	12	13
    ///	354	30	29	30	29	30	29	30	29	30	29	30	29
    ///	384	30	29	30	29	30	30	29	30	29	30	29	30	29
    ///
    ///	354-384
    ///	1	30	29	30	29	30	29	30	29	30	29	30	29			354	0
    ///	2	29	30	29	30	29	30	29	30	29	30	29	30			354	0
    ///	3	30	29	30	29	30	29	30	29	30	29	30	29			354	0
    ///	4	29	30	29	30	29	30	29	30	29	30	29	30			354	0
    ///	5	30	29	30	29	30	29	30	29	30	29	30	29			354	0
    ///	6	29	30	29	30	29	30	29	30	29	30	29	30  30	354	30	_month++
    ///	7	30	29	30	29	30	29	30	29	30	29	30	30  29	355	30	_month++
    ///	8	29	30	29	30	29	30	29	30	29	30	30	29  30	354	30	_month++
    ///	9	30	29	30	29	30	29	30	29	30	30	29	30  29	355	30	_month++
    ///	10	29	30	29	30	29	30	29	30	30	29	30	29  30	354	30	_month++
    ///	11	30	29	30	29	30	29	30	30	29	30	29	30  29	355	30	_month++
    ///	12	29	30	29	30	29	30	30	29	30	29	30	29  30	354	30	_month++
    ///
    ///		   1	2	3	4	5	6	7	8	9	10	11	12	13
    ///	384	30	29	30	29	30	30	29	30	29	30	29	30	29
    ///	354	30	29	30	29	30	29	30	29	30	29	30	29
    ///
    ///	384-354
    ///	1	30	29	30	29	30	30	29	30	29	30	29	30	29		384	0
    ///	2	29	30	29	30	30	29	30	29	30	29	30	29	30		384	0
    ///	3	30	29	30	30	29	30	29	30	29	30	29	30	29		384	0
    ///	4	29	30	30	29	30	29	30	29	30	29	30	29	30		384	0
    ///	5	30	30	29	30	29	30	29	30	29	30	29	30	29		384	0
    ///	6	30	29	30	29	30	29	30	29	30	29	30	29	30		384	0	    day(30)--
    ///	7	29	30	29	30	29	30	29	30	29	30	29	30			354	-30		_month--
    ///	8	30	29	30	29	30	29	30	29	30	29	30	29			354	-30		_month--
    ///	9	29	30	29	30	29	30	29	30	29	30	29	30			354	-30		_month--
    ///	10	30	29	30	29	30	29	30	29	30	29	30	29			354	-30		_month--
    ///	11	29	30	29	30	29	30	29	30	29	30	29	30			354	-30		_month--
    ///	12	30	29	30	29	30	29	30	29	30	29	30	29			354	-30		_month--
    ///	13	29	30	29	30	29	30	29	30	29	30	29	30			354	-30		_month--
    /// </summary>
    private int addMonthTuning(boolean fromYear, boolean toYear)
    {
        // Not -> Yes
        if (!fromYear && toYear && this.month >= 6)
        {
            this.month = this.month + 1;
            return 30;
        }
        // Yes -> Not
        else if (fromYear && !toYear)
        {
            if (this.month == 6 && this.dayInMonth == 30) addDays(-1);

            else if (this.month >= 7)
            {
                this.month = this.month - 1;
                return -30;
            }
        }
        return 0;
    }

    /// <summary>
    ///  The first table shows each year
    ///		   1	2	3	4	5	6	7	8	9	10	11	12
    ///	353	30	29	29	29	30	29	30	29	30	29	30	29
    ///	354	30	29	30	29	30	29	30	29	30	29	30	29
    ///
    ///  The 2nd table shows the tuning when moving to year1->year2
    ///  for 6 months
    ///	353->354
    ///	1	30	29	29	29	30	29	30	29	30	29	30	29			353	0
    ///	2	29	29	29	30	29	30	29	30	29	30	29	30			353	0
    ///	3	29	29	30	29	30	29	30	29	30	29	30	29			353	0
    ///	4	29	30	29	30	29	30	29	30	29	30	29	30			354	1
    ///	5	30	29	30	29	30	29	30	29	30	29	30	29			354	1
    ///	6	29	30	29	30	29	30	29	30	29	30	29	30			354	1
    ///
    ///		   1	2	3	4	5	6	7	8	9	10	11	12
    ///	353	30	29	29	29	30	29	30	29	30	29	30	29
    ///	355	30	30	30	29	30	29	30	29	30	29	30	29
    ///
    ///	353->355
    ///	1	30	29	29	29	30	29	30	29	30	29	30	29			353	0
    ///	2	29	29	29	30	29	30	29	30	29	30	29	30			353	0
    ///	3	29	29	30	29	30	29	30	29	30	29	30	30			354	1
    ///	4	29	30	29	30	29	30	29	30	29	30	30	30			355	2
    ///	5	30	29	30	29	30	29	30	29	30	30	30	29			355	2
    ///	6	29	30	29	30	29	30	29	30	30	30	29	30			355	2
    ///
    ///		   1	2	3	4	5	6	7	8	9	10	11	12
    ///	354	30	29	30	29	30	29	30	29	30	29	30	29
    ///	353	30	29	29	29	30	29	30	29	30	29	30	29
    ///
    ///	354->353
    ///	1	30	29	30	29	30	29	30	29	30	29	30	29			354	0
    ///	2	29	30	29	30	29	30	29	30	29	30	29	30			354	0
    ///	3	30	29	30	29	30	29	30	29	30	29	30	29			354	0
    ///	4	29	30	29	30	29	30	29	30	29	30	29	29			353	-1
    ///	5	30	29	30	29	30	29	30	29	30	29	29	29			353	-1
    ///	6	29	30	29	30	29	30	29	30	29	29	29	30			353	-1
    ///
    ///		   1	2	3	4	5	6	7	8	9	10	11	12
    ///	354	30	29	30	29	30	29	30	29	30	29	30	29
    ///	355	30	30	30	29	30	29	30	29	30	29	30	29
    ///
    ///	354->355
    ///	1	30	29	30	29	30	29	30	29	30	29	30	29			354	0
    ///	2	29	30	29	30	29	30	29	30	29	30	29	30			354	0
    ///	3	30	29	30	29	30	29	30	29	30	29	30	30			355	1
    ///	4	29	30	29	30	29	30	29	30	29	30	30	30			355	1
    ///	5	30	29	30	29	30	29	30	29	30	30	30	29			355	1
    ///	6	29	30	29	30	29	30	29	30	30	30	29	30			355	1
    ///
    ///		   1	2	3	4	5	6	7	8	9	10	11	12
    ///	355	30	30	30	29	30	29	30	29	30	29	30	29
    ///	353	30	29	29	29	30	29	30	29	30	29	30	29
    ///
    ///	355->353
    ///	1	30	30	30	29	30	29	30	29	30	29	30	29			355	0
    ///	2	30	30	29	30	29	30	29	30	29	30	29	30			355	0
    ///	3	30	29	30	29	30	29	30	29	30	29	30	29			354	-1
    ///	4	29	30	29	30	29	30	29	30	29	30	29	29			353	-2
    ///	5	30	29	30	29	30	29	30	29	30	29	29	29			353	-2
    ///	6	29	30	29	30	29	30	29	30	29	29	29	30			353	-2
    ///
    ///		   1	2	3	4	5	6	7	8	9	10	11	12
    ///	355	30	30	30	29	30	29	30	29	30	29	30	29
    ///	354	30	29	30	29	30	29	30	29	30	29	30	29
    ///
    ///	355->354
    ///	1	30	30	30	29	30	29	30	29	30	29	30	29			355	0
    ///	2	30	30	29	30	29	30	29	30	29	30	29	30			355	0
    ///	3	30	29	30	29	30	29	30	29	30	29	30	29			354	-1
    ///	4	29	30	29	30	29	30	29	30	29	30	29	30			354	-1
    ///	5	30	29	30	29	30	29	30	29	30	29	30	29			354	-1
    ///	6	29	30	29	30	29	30	29	30	29	30	29	30			354	-1
    /// </summary>
    private int addDaysTuning(int fromYear, int toYear)
    {
        switch (fromYear)
        {
            // Chasera
            case 353:
            case 383:
                switch (toYear)
                {
                    // Kesidra
                    case 354:
                    case 384:
                        if (this.month >= 4) return 1;
                        break;
                    // Shlema
                    case 355:
                    case 385:
                        if (this.month == 3) return 1;
                        else if (this.month >= 4) return 2;
                        break;
                }
                break;
            // Kesidar
            case 354:
            case 384:
                switch (toYear)
                {
                    // Chasera
                    case 353:
                    case 383:
                        if (this.month == 3 && this.dayInMonth == 30) addDays(-1);
                        else if (this.month >= 4) return -1;
                        break;
                    // Shlema
                    case 355:
                    case 385:
                        if (this.month >= 3) return 1;
                        break;
                }
                break;
            // Shlema
            case 355:
            case 385:
                switch (toYear)
                {
                    // Chasera
                    case 353:
                    case 383:
                        if ((this.month == 2 || this.month == 3) && this.dayInMonth == 30) addDays(-1);
                        else if (this.month == 3) return -1;
                        else if (this.month >= 4) return -2;
                        break;
                    // Kesidra
                    case 354:
                    case 384:
                        if (this.month == 2 && this.dayInMonth == 30) addDays(-1);
                        else if (this.month >= 3) return -1;
                        break;
                }
                break;
        }
        return 0;
    }

    protected static int compare(Year yearClass1, Year yearClass2)
    {
        if (yearClass1.getYear() > yearClass2.getYear()) return 1;
        else if (yearClass1.getYear() < yearClass2.getYear()) return -1;
        return Month.compare(yearClass1, yearClass2);
    }

    //Properties
    public int getYear()
    {
        return this.year;
    }

    private enum Units {א,ב,ג,ד,ה,ו,ז,ח,ט,י,יא,יב,יג,יד,טו,טז}
    private enum Tens {י,כ,ל,מ,נ,ס,ע,פ,צ}
    private enum Hundreds {ק,ר,ש,ת,תק,תר,תש,תת,תתק}

    public static int getYearString(String value)
    {
        if (value.length() < 2)
            // Can't convert to hebrew year
            return -1;

        try
        {
            int pos = 0;
            int thousands = Units.valueOf(String.valueOf(value.charAt(pos++))).ordinal() + 1;
            int hundreds = 0;
            switch (value.charAt(pos++))
            {
                case 'ק': hundreds = 1; break;
                case 'ר': hundreds = 2; break;
                case 'ש': hundreds = 3; break;
                case 'ת': hundreds = 4; break;
            }
            if (hundreds == 4)
            {
                switch (value.charAt(pos++))
                {
                    case 'ק': hundreds += 1; break;
                    case 'ר': hundreds += 2; break;
                    case 'ש': hundreds += 3; break;
                    case 'ת': hundreds += 4; break;
                }
                if (hundreds == 8)
                {
                    if (value.charAt(pos++) == 'ק')
                        hundreds++;
                }
            }

            int tens = 0;
            if (value.length() > pos)
                tens = Tens.valueOf(String.valueOf(value.charAt(pos++))).ordinal() + 1;
            int units = 0;
            if (value.length() > pos)
                units = Units.valueOf(String.valueOf(value.charAt(pos))).ordinal() + 1;

            return  1000*thousands + 100*hundreds + 10*tens + units;
        }
        catch (Exception ex)
        {
            // throw new Exception("לא ניתן להמיר ערך זה לשנה עברית");
            return -1;
        }

    }

    public String getYearString()
    {
       if (this.year > 6000)
          return "הקץ";

       int thousands = this.year / 1000;
       int hundreds = (this.year - 1000 * thousands) / 100;
       int tens = (this.year - 1000 * thousands - 100 * hundreds) / 10;
       int units = this.year - 1000 * thousands - 100 * hundreds - 10 * tens;

       String numberString = "";
       if (thousands > 0) numberString += Units.values()[thousands - 1].name();
       if (hundreds > 0) numberString += Hundreds.values()[hundreds - 1].name();
       if (tens > 0) numberString += Tens.values()[tens - 1].name();
       if (units > 0) numberString += Units.values()[units - 1];
       return numberString;
    }

    @Override
    public String toString()
    {
        return getDayString() + " " + getMonthString() + " " + getYearString();
    }
}

    /* May required in the future
    protected String condition(String yearTypeFieldName, String dayInYearFieldName)
    {
        int days = this.numberDaysInYear;
        int day = this.dayInYear;

        StringBuilder sql = new StringBuilder();
        String type = yearTypeFieldName;
        String pos = dayInYearFieldName;

        // The next line + the last two lines below will calculated like that
        if (days - 205 >= 148 && days <= 355)
        {
            // In case 383->353 = -30
            // In case 383->354 = -29
            // In case 383->355 = -28

            // In case 384->353 = -31
            // in case 384->354 = -30
            // in case 384->355 = -29

            // In case 385->353 = -32
            // In case 385->354 = -31
            // In case 385->354 = -30
            sql.append(" (CASE WHEN ").append(pos).append(">= ").append(type).append("-205 AND ").append(type).append(">= 383 THEN -30 ELSE 0 END) + \n");
        }
        // days == 383 || days == 384 || days == 385
        else if (days - 205 >= 178)
        {
            // In case 353->383 = 30
            // In case 353->384 = 31
            // In case 353->385 = 32

            // In case 354->383 = 29
            // in case 354->384 = 30
            // in case 354->385 = 31

            // in case 355->383 = 28
            // in case 355->384 = 29
            // in case 355->384 = 30
            sql.append(" (CASE WHEN ").append(pos).append(">= ").append(type).append("-205 AND ").append(type).append("<= 355 THEN 30 ELSE 0 END) + \n");
        }

        if (days == 353 || days == 383)
        {
            if (day > 90)
            {
                // This line is part of the calculated above
                sql.append(" 3 - (").append(type).append(" - ROUND(").append(type).append("))");
                return sql.toString();
            }
            // day == 90 the same as above according the Halacha
            else if (day > 60)
                return sql.append(" (CASE WHEN (").append(type).append("=355 OR ").append(type).append("=385) THEN -1 ELSE 0 END)\n").toString();
        }

        if (days == 354 || days == 384)
        {
            if (day >= 89)
            {
                // This line is part of the calculated above
                sql.append(" 4 - (").append(type).append(" - ROUND(").append(type).append("))");
                return sql.toString();
            }
            else if (day >= 60)
                return sql.append(" (CASE WHEN (").append(type).append("=355 OR ").append(type).append("=385) THEN -1 ELSE 0 END)\n").toString();
        }

        if (days == 355 || days == 385)
        {
            if (day >= 89)
            {
                // This line is part of the calculated above
                sql.append(" 5 - (").append(type).append(" - ROUND(").append(type).append("))");
                return sql.toString();
            }
            else if (day >= 60)
                return sql.append(" (CASE WHEN (").append(type).append("=353 OR ").append(type).append("=383) THEN 1 ELSE 0 END)\n").toString();
        }

        return null;
    } */

