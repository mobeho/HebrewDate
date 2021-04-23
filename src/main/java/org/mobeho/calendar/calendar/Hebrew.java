package org.mobeho.calendar.calendar;

import java.util.Scanner;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class Hebrew extends Year
{
    private int numberOfMonths;
    private boolean[] fullMonth;

    private int yearMoonDayInWeak;
    private TimeClass yearMoonTime;

    private int roshHashanahDayOfWeak;
    private int nextRoshHashanahDayOfWeak;

    private int nextYearMoonDayInWeak;
    private TimeClass nextYearMoonTime;

    public Hebrew(boolean from19000101)
    {
        if (from19000101)
            reset(DAYS_FROM_START_TO_1900);
        else
            reset(0);
    }

    protected boolean reset(int daysFromStart)
    {
        if (!super.reset(daysFromStart))
            return false;

        if (this.daysFromStart >= DAYS_FROM_START_TO_1900)
        {
            this.yearMoonDayInWeak = 2;
            this.yearMoonTime = new TimeClass();
            this.yearMoonTime.jiffy = 500;
            this.yearMoonTime.hour = 13;
            this.roshHashanahDayOfWeak = 2;

            this.yearType = YearType.גכז;

            this.numberOfMonths = 13;
            this.fullMonth = new boolean[14];
            this.fullMonth[1] = true;
            this.fullMonth[2] = false;
            this.fullMonth[3] = true;
            this.fullMonth[4] = false;
            this.fullMonth[5] = true;
            this.fullMonth[6] = true;
            this.fullMonth[7] = false;
            this.fullMonth[8] = true;
            this.fullMonth[9] = false;
            this.fullMonth[10] = true;
            this.fullMonth[11] = false;
            this.fullMonth[12] = true;
            this.fullMonth[13] = false;

            this.nextYearMoonDayInWeak = 1;
            this.nextYearMoonTime = new TimeClass();
            this.nextYearMoonTime.jiffy = 9;
            this.nextYearMoonTime.hour = 11;
            this.nextRoshHashanahDayOfWeak = 1;
        }
        else
        {
            this.yearMoonDayInWeak = 1;
            this.yearMoonTime = new TimeClass();
            this.roshHashanahDayOfWeak = 1; //Monday

            this.yearType = YearType.בשה;

            this.numberOfMonths = 12;
            this.fullMonth = new boolean[13];
            this.fullMonth[1] = true;
            this.fullMonth[2] = true;
            this.fullMonth[3] = true;
            this.fullMonth[4] = false;
            this.fullMonth[5] = true;
            this.fullMonth[6] = false;
            this.fullMonth[7] = true;
            this.fullMonth[8] = false;
            this.fullMonth[9] = true;
            this.fullMonth[10] = false;
            this.fullMonth[11] = true;
            this.fullMonth[12] = false;

            this.nextYearMoonDayInWeak = this.yearMoonDayInWeak;
            this.nextYearMoonTime = new TimeClass();
            this.nextYearMoonTime.copy(this.yearMoonTime);
            this.nextYearMoonDayInWeak = (this.nextYearMoonDayInWeak + 4 + this.nextYearMoonTime.addTime(8, 876)) % 7;
            this.nextRoshHashanahDayOfWeak = 6; //Shabat
        }

        return true;
    }

    public void set(int year, int month, int day)
    {
        if (year < getYear() || (year == getYear() && month < getMonth()) || (year == getYear() && month == getMonth() && day < getDayInMonth()))
        {
            if (year >= 5660 && month >= 5)
                reset(DAYS_FROM_START_TO_1900);
            else
                reset(0);
        }

        while (getDayInMonth() != 1 && getYear() < year)
        {
            addDays(1);    // #1: 15/05/5779 -> 01/01/5780  move the next year
        }
        while (getDayInMonth() != 1 && getMonth() < month)
        {
            addDays(1);    // #2: 15/05/5779 -> 01/06/5779 (in case #1 wasn't required)
        }
        while (getMonth() != 1 && getYear() < year)
        {
            addMonths(1);  // #3: 01/06/5779 -> 01/08/5779 (in case #1 wasn't required)
        }
        while (getYear() < year)
        {
            addYears(1);  // #4: 01/01/5780 -> 01/01/5783 must do after #1
        }
        while (getMonth() < month && getMonth() < getNumberOfMonths())
        {
            addMonths(1); // #5: 01/01/5783 -> 01/03/5783 must do after #4
        }
        while (getDayInMonth() < day && getDayInMonth() < getNumberDaysInMonth())
        {
            addDays(1);  // #6: 01/03/5783 -> 15/03/5783 must do after #5
        }
    }

    public void today()
    {
        // System.currentTimeMillis() works from 01/01/1970
        // 25556 days from 01/01/1900 until 01/01/1970
        addDays(25567);

        long seconds = System.currentTimeMillis() / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        int days = (int) (hours + 2) / 24; /* + getCurrentZoneOffset()*/

        addDays(days);
    }

    public boolean of(String taarich)
    {
        Scanner scanner = new Scanner(taarich);
        scanner.useDelimiter(" ");

        String monthAndDayString = scanner.next() + " " + scanner.next();
        int[] monthAndDay = convertMonthAndDay(monthAndDayString);
        if (monthAndDay[0] == -1)
            return false;

        int year = Hebrew.getYearString(scanner.next());
        if (year == -1)
            return false;

        set(year, monthAndDay[0], monthAndDay[1]);
        return true;
    }

    public static int compare(Hebrew hebrewDate1, Hebrew hebrewDate2)
    {
        return Year.compare(hebrewDate1, hebrewDate2);
    }

    // Finding a day on which next Rosh Hashana can follow the 4 postponements rules
    // This function must be called after adding a year
    protected void setNextRoshHashanahDayInWeak()
    {
        this.yearMoonDayInWeak = this.nextYearMoonDayInWeak;
        this.yearMoonTime.copy(this.nextYearMoonTime);

        //Un leap year left
        if (!YearType.getIfLeapYear(this.year) /*_yearType.isLeap()*/)
            this.nextYearMoonDayInWeak = (this.nextYearMoonDayInWeak + 4 + this.nextYearMoonTime.addTime(8, 876)) % 7;
            //Leap year left
        else
            this.nextYearMoonDayInWeak = (this.nextYearMoonDayInWeak + 5 + this.nextYearMoonTime.addTime(21, 589)) % 7;

        // This Rosh Hashana is going to be next Rosh Hashana
        this.roshHashanahDayOfWeak = this.nextRoshHashanahDayOfWeak;

        // Next Rosh Hashana becomes the Molad of next year
        this.nextRoshHashanahDayOfWeak = this.nextYearMoonDayInWeak;

        // (Molad in parts) just to comparing
        int molad = this.nextYearMoonTime.getHour() * 1080 + this.nextYearMoonTime.getJiffy();

        if ((this.nextRoshHashanahDayOfWeak == 2 &&
                (molad > (9 * 1080 + 204) && molad < (18 * 1080)) &&
                !YearType.getIfLeapYear(this.year + 1)))
        {
            //"ג-ט-רד"
            this.nextRoshHashanahDayOfWeak = 4;
        }

        else if ((this.nextRoshHashanahDayOfWeak == 1 &&
                (molad > (15 * 1080 + 589) && molad < (18 * 1080)) &&
                !YearType.getIfLeapYear(this.year - 1) && YearType.getIfLeapYear(this.year)))
        {
            //"ב-טו-תקפט"
            this.nextRoshHashanahDayOfWeak = 2;
        }

        //"מולד זקן"
        if (molad > (18 * 1080))
        {
            switch (this.nextRoshHashanahDayOfWeak)
            {
                case 1:
                    this.nextRoshHashanahDayOfWeak = 2;
                    break;
                case 2:
                    this.nextRoshHashanahDayOfWeak = 4;
                    break;
                case 4:
                    this.nextRoshHashanahDayOfWeak = 6;
                    break;
                case 6:
                    this.nextRoshHashanahDayOfWeak = 1;
                    break;
            }
        }

        //"לא אד'ו ראש"
        switch (this.nextRoshHashanahDayOfWeak)
        {
            case 0:
                this.nextRoshHashanahDayOfWeak = 1;
                break;
            case 3:
                this.nextRoshHashanahDayOfWeak = 4;
                break;
            case 5:
                this.nextRoshHashanahDayOfWeak = 6;
                break;
        }
    }

    private YearType yearType;
    public YearType getYearType()
    {
        return this.yearType;
    }

    protected void setYearType()
    {
        setFullYear();

        int difference = 7 + this.nextRoshHashanahDayOfWeak - this.roshHashanahDayOfWeak;
        if (difference > 7) difference %= 7;

        if (!YearType.getIfLeapYear(this.year) /*_yearType.isLeap()*/)
        {
            switch (difference)
            {
                case 3:
                    if (this.roshHashanahDayOfWeak == 1)
                        this.yearType = YearType.בחג;
                    else if (this.roshHashanahDayOfWeak == 6)
                        this.yearType = YearType.זחא;
                    break;
                case 4:
                    if (this.roshHashanahDayOfWeak == 2)
                        this.yearType = YearType.גכה;
                    else if (this.roshHashanahDayOfWeak == 4)
                        this.yearType = YearType.הכז;
                    break;
                case 5:
                    if (this.roshHashanahDayOfWeak == 1)
                        this.yearType = YearType.בשה;
                    else if (this.roshHashanahDayOfWeak == 4)
                        this.yearType = YearType.השא;
                    else if (this.roshHashanahDayOfWeak == 6)
                        this.yearType = YearType.זשג;
                    break;
            }
        }
        else
        {
            switch (difference)
            {
                case 5:
                    if (this.roshHashanahDayOfWeak == 1)
                        this.yearType = YearType.בחה;
                    else if (this.roshHashanahDayOfWeak == 4)
                        this.yearType = YearType.החא;
                    else if (this.roshHashanahDayOfWeak == 6)
                        this.yearType = YearType.זחג;
//                    else
//                       throw new Exception("Year sign is wrong");
                    break;
                case 6:
                    if (this.roshHashanahDayOfWeak == 2)
                        this.yearType = YearType.גכז;
//                    else
//                       throw new Exception("Year sign is wrong");
//
                    break;
                case 7:
                    if (this.roshHashanahDayOfWeak == 1)
                        this.yearType = YearType.בשז;
                    else if (this.roshHashanahDayOfWeak == 4)
                        this.yearType = YearType.השג;
                    else if (this.roshHashanahDayOfWeak == 6)
                        this.yearType = YearType.זשה;
//                    else
//                       throw new Exception("Year sign is wrong");
                    break;
//                default:
//                      throw new Exception("Year sign is wrong");
            }
        }

        this.numberDaysInYear = this.yearType.numberDaysInYear;
        this.fullMonth[2] = (this.yearType.getBalance() > 0);
        this.fullMonth[3] = (this.yearType.getBalance() >= 0);
    }

    private void setFullYear()
    {
        this.fullMonth = new boolean[14];

        this.fullMonth[1] = true;
        this.fullMonth[4] = false;
        this.fullMonth[5] = true;

        if (!YearType.getIfLeapYear(this.year) /*_yearType.isLeap()*/)
        {
            this.numberOfMonths = 12;
            this.fullMonth[6] = false;
            this.fullMonth[7] = true;
            this.fullMonth[8] = false;
            this.fullMonth[9] = true;
            this.fullMonth[10] = false;
            this.fullMonth[11] = true;
            this.fullMonth[12] = false;
        }
        else
        {
            this.numberOfMonths = 13;
            this.fullMonth[6] = true;
            this.fullMonth[7] = false;
            this.fullMonth[8] = true;
            this.fullMonth[9] = false;
            this.fullMonth[10] = true;
            this.fullMonth[11] = false;
            this.fullMonth[12] = true;
            this.fullMonth[13] = false;
        }
    }

    public boolean isToday(String checkThis)
    {
        try
        {
            Scanner scanner = new Scanner(checkThis);
            scanner.useDelimiter(" ");

            int dayIndex = MONTH_DAY.valueOf(scanner.next()).ordinal() + 1;
            int monthIndex = MONTHS.valueOf(scanner.next()).ordinal() + 1 + ((getNumberOfMonths() == 13) ? 1 : 0);

            return (this.dayInMonth == dayIndex && this.month == monthIndex);
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    public static String convertMonthAndDay(int month, int day, boolean isLeapYear)
    {
        if (month < 1 || month > 12 + (isLeapYear ? 1 : 0))
        {
            return null;
        }

        if (isLeapYear && month == 6)
        {
            return MONTH_DAY.values()[day-1].toString() + " אדר-א";
        }

        if (day < 1 || day > 30)
        {
            return null;
        }

        return MONTH_DAY.values()[day-1].toString() + " " + MONTHS.values()[month-1].toString();
    }

    @Override public void addDays(int days)
    {
        super.addDays(days);
    }
    @Override public void addMonths(int months)
    {
        super.addMonths(months);
    }
    @Override public void addYears(int years)
    {
        super.addYears(years);
    }
    public int getNumberDaysInMonth()
    {
        return (this.fullMonth[this.month]) ? 30 : 29;
    }
    public int getNumberOfMonths()
    {
        return this.numberOfMonths;
    }
    public int getDaysFromStart()
    {
        return this.daysFromStart;
    }
    public int getDayInYear()
    {
        return this.dayInYear;
    }
    public int getNumberDaysInYear()
    {
        return this.numberDaysInYear;
    }
    public int getNumberOfShabatot()
    {
        return (roshHashanahDayOfWeak + this.numberDaysInYear) / 7;
    }
    public int getNumberOfWeeks()
    {
        return (roshHashanahDayOfWeak%7 + this.numberDaysInYear) / 7;
    }
    public String toDateFormat()
    {
        return  String.format("%02d/%02d/%04d", this.dayInMonth, this.month, this.year);
    }

    public String getMonthAndDay()
    {
        if (month < 1 || month > 12 + (yearType.isLeap() ? 1 : 0))
        {
            return null;
        }

        if (yearType.isLeap() && month == 6)
        {
            return MONTH_DAY.values()[dayInMonth -1].toString() + " אדר-א";
        }

        if (dayInMonth < 1 || dayInMonth > 30)
        {
            return null;
        }

        return MONTH_DAY.values()[dayInMonth-1].toString() + " " + MONTHS.values()[month-1].toString();
    }

    public String toYearString()
    {
        return String.format("%s סימן:%s, מחזור:%s, שעת מולד:%s, חודשים:%s, ימים:%s",
            getYearString(),
            this.yearType.name(),
            ((getYear()-1)%19+1) + "/" + (getYear()/19 + 1),
            this.yearMoonTime.getTimeString(),
            this.numberOfMonths,
            getNumberDaysInYear());
     }
}
