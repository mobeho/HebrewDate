package org.mobeho.calendar.calendar;

import java.util.Scanner;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public abstract class Month extends Day
{
    int month;

    public int getMonth()
    {
        return this.month;
    }

    int moladHachodesh;

    public int getMoladHachodesh()
    {
        return moladHachodesh;
    }

    TimeClass moladHachodeshTime;

    public TimeClass getMoladHachodeshTime()
    {
        return moladHachodeshTime;
    }

    protected boolean reset(int daysFromStart)
    {
        if (!super.reset(daysFromStart))
            return false;

        if (daysFromStart >= DAYS_FROM_START_TO_1900)
        {
            this.month = 5;
            this.moladHachodesh = 1;
            this.moladHachodeshTime = new TimeClass();
            this.moladHachodeshTime.jiffy = 432;
            this.moladHachodeshTime.hour = 16;
        }
        else
        {
            this.month = 1;
            this.moladHachodesh = 1;
            this.moladHachodeshTime = new TimeClass();
        }

        return true;
    }

    protected abstract void addYears(int yearsAdd);

    protected void addMonths(int months)
    {
        if (months <= 0)
            return;

        while (months > getNumberOfMonths())
        {
            months -= getNumberOfMonths();
            addYears(1);
        }

        while (months-- > 0)
        {
            this.daysFromStart += getNumberDaysInMonth();
            this.dayInYear = adv(this.dayInYear, getNumberDaysInYear(), getNumberDaysInMonth());
            this.dayOfWeak = adv(this.dayOfWeak, 7, getNumberDaysInMonth());
            setNextMonth();
        }

        if (this.dayInMonth > getNumberDaysInMonth())
        {
            this.dayInMonth = 1;
            setNextMonth();
        }
    }

    protected abstract void setNextYear();

    protected void setNextMonth()
    {
        boolean shift = isShift(this.month, getNumberOfMonths(), 1);
        this.month = adv(this.month, getNumberOfMonths(), 1);
        if (shift) setNextYear();
        // The time adding to the new Molad
        this.moladHachodesh = adv(this.moladHachodesh, 7, 1 + this.moladHachodeshTime.addTime(12, 793));
    }

    protected static int compare(Month monthClass1, Month monthClass2)
    {
        if (monthClass1.month > monthClass2.month) return 1;
        else if (monthClass1.month < monthClass2.month) return -1;
        return Day.compare(monthClass1, monthClass2);
    }

    protected enum MONTHS
    {תשרי, חשוון, כסלו, טבת, שבט, אדר, ניסן, אייר, סיוון, תמוז, אב, אלול}

    public String getMonthString()
    {
        return getMonthString(this.month, getNumberOfMonths());
    }

    public static String getMonthString(int month, int numberOfMonths)
    {
        if (numberOfMonths == 13)
        {
            if (month == 6) return "אדר-א";
            else if (month == 7) return "אדר-ב";
            else if (month > 7) return MONTHS.values()[month-2].name();
        }

        return  MONTHS.values()[month-1].name();
    }

    abstract public int getNumberOfMonths();

    // earlier = true, we sure it is leap year, and we want to be on Adar א
    public static int[] convertMonthAndDay(String monthAndDay, boolean earlier)
    {
        monthAndDay = convertMonth(monthAndDay);
        Scanner scanner = new Scanner(monthAndDay);
        scanner.useDelimiter(" ");

        int day;
        String monthName;
        try
        {
            day = MONTH_DAY.valueOf(scanner.next()).ordinal() + 1;
            monthName = scanner.next();
        }
        catch (Exception ex)
        {
            return new int[]{-1, -1};
//            throw new Exception("לא ניתן להמיר את שדה זה: '" + monthAndDay + "' ליום וחודש. " + "\n" +
//               "  נא לציין בפורמט כזה: יום בחודש (ללא תג או מרכאות), רווח בודד, שם החודש, רק אלו: תשרי, חשוון, כסלו, טבת, שבט, אדר-א, אדר, ניסן, אייר, סיוון, תמוז, אב או אלול" + "\n" +
//               "  לדוגמא: יח תשרי או כב אדר-א"
//            );
        }

        int leapYear = 0;
        int month;
        if ("אדר-א".equals(monthName))
        {
            month = 6;
            leapYear = 1;
        }
        else if ("אדר-ב".equals(monthName) && earlier)
        {
            month = 7;
            leapYear = 1;
        }
        else if ("אדר".equals(monthName) && earlier)
        {
            month = 6;
            leapYear = 1;
        }
        else if ("אדר-ב".equals(monthName))
            month = 6;
        else
        {
            try
            {
                month = MONTHS.valueOf(monthName).ordinal() + 1;
            }
            catch (Exception ex)
            {
                return new int[]{-1, -1};
//                throw new Exception("לא ניתן להמיר  את שדה זה: '" + monthAndDay + "' את החודש. " + "\n" +
//                   "  שם החודש יכול להיות רק אלו: תשרי, חשוון, כסלו, טבת, שבט, אדר-א, אדר, ניסן, אייר סיוון, תמוז, אב או אלול"
//                );
            }
        }

        return new int[]{month, day, leapYear};
    }

    public static String convertMonth(String value)
    {
        value = value.trim();
        value = value.replaceAll("_"," ");
        value = value.replaceAll("-"," ");
        value = value.replaceAll(" {2}"," ");
        value = value.replaceAll("'","");
        value = value.replaceAll("\"","");
        value = value.replaceAll("תישרי","תשרי");
        value = value.replaceAll("בתישרי","תשרי");
        value = value.replaceAll("בתשרי","תשרי");
        value = value.replaceAll("חשון","חשוון");
        value = value.replaceAll("בחשון","חשוון");
        value = value.replaceAll("בחשוון","חשוון");
        value = value.replaceAll("בכסלו","כסלו");
        value = value.replaceAll("בטבת","טבת");
        value = value.replaceAll("בשבט","שבט");
        // אדר ישאר אדר
        value = value.replaceAll("אדר א","אדר-א");
        value = value.replaceAll("באדר א","אדר-א");
        value = value.replaceAll("אדר 1","אדר-א");
        value = value.replaceAll("אדר ראשון","אדר-א");
        value = value.replaceAll("באדר ראשון","אדר-א");
        value = value.replaceAll("אדר ב","אדר-ב");
        value = value.replaceAll("באדר ב","אדר-ב");
        value = value.replaceAll("אדר 2","אדר-ב");
        value = value.replaceAll("אדר שני","אדר-ב");
        value = value.replaceAll("באדר שני","אדר-ב");
        value = value.replaceAll("סיון","סיוון");
        value = value.replaceAll("בסיון","סיוון");
        value = value.replaceAll("בתמוז","תמוז");
        value = value.replaceAll("מנחם אב","אב");
        value = value.replaceAll("במנחם אב","אב");
        return value.replaceAll("באלול","אלול");
    }

    public String[] getMonthsString()
    {
        String[] months = new String[getNumberOfMonths()];
        for (int i = 0 ; i < getNumberOfMonths(); i++)
        {
            if (getNumberOfMonths() == 13)
            {
                if (i==5) months[i] = "אדר-א";
                else if (i == 6) months[i] = "אדר-ב";
                else if (i > 6) months[i] = MONTHS.values()[i-1].name();
                else months[i] = MONTHS.values()[i].name();
            }
            else
                months[i] = MONTHS.values()[i].name();
        }

        return months;
    }
    public int getMoonDayInWeak()
    {
        return this.moladHachodesh+1;
    }
    public int getFirstDayInMonth()
    {
        return (7+ this.dayOfWeak - this.dayInMonth %7 ) % 7 + 1;
    }
}

