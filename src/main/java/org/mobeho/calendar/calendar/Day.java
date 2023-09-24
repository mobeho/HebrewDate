package org.mobeho.calendar.calendar;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
abstract public class Day
{
    int daysFromStart;
    public int getDaysFromStart()
    {
        return this.daysFromStart;
    }
    protected int dayInYear;
    int dayInMonth;
    public int getDayInMonth()
    {
        return this.dayInMonth;
    }
    int dayOfWeak;
    public int getDayOfWeak()
    {
        return this.dayOfWeak;
    }

    protected enum WEEK_DAY {ראשון,שני,שלישי,רביעי,חמישי,שישי,שבת}
    protected enum MONTH_DAY {א,ב,ג,ד,ה,ו,ז,ח,ט,י,יא,יב,יג,יד,טו,טז,יז,יח,יט,כ,כא,כב,כג,כד,כה,כו,כז,כח,כט,ל}

    static final int DAYS_FROM_START_TO_1900 = 2067023;
    protected boolean reset(int daysFromStart)
    {
        return true;
    }

    protected boolean isShift(int val, int bas, int add)
    {
        return ((val + --add) / bas) > 0;
    }

    protected int adv(int val, int bas, int add)
    {
        val = ((val + --add) % bas + 1);
        if (val == 0)
        {
            if (add < -1) val = bas;
            else if (add > -1) val = 1;
        }
        return val;
    }

    public abstract int getNumberDaysInYear();
    protected abstract void addYears(int years);
    protected abstract void addMonths(int months);
    protected abstract void setNextMonth();
    protected void addDays(int days)
    {
        int daysFromStart = this.daysFromStart;
        if (reset(this.daysFromStart + days))
            days += daysFromStart - this.daysFromStart;

        if (days < 0)
            return;

        // max days in _year
        while (days > 384)
        {
            days += this.daysFromStart;
            addYears(1);
            days -= this.daysFromStart;
        }

        // max days in _month
        while (days > 30)
        {
            days += this.daysFromStart;
            addMonths(1);
            days -= this.daysFromStart;
        }

        // prevent from across two months
        if ((days + this.dayInMonth) / getNumberDaysInMonth() > 1 && days > 28)
        {
            days -= 28;
            this.daysFromStart += 28;
            boolean shift = isShift(this.dayInYear, getNumberDaysInYear(), 28);
            this.dayInYear = adv(this.dayInYear, getNumberDaysInYear(), 28);
            if (shift) setNextMonth();
        }

        this.daysFromStart += days;
        this.dayInYear = adv(this.dayInYear, getNumberDaysInYear(), days);
        this.dayOfWeak = adv(this.dayOfWeak, 7, days);

        boolean shift = isShift(this.dayInMonth, getNumberDaysInMonth(), days);
        this.dayInMonth = adv(this.dayInMonth, getNumberDaysInMonth(), days);
        if (shift) setNextMonth();

        if (this.dayInMonth > getNumberDaysInMonth())
        {
            this.dayInMonth = 1;
            setNextMonth();
        }
    }

    protected static int compare(Day day1, Day day2)
    {
        return Integer.compare(day1.dayInMonth, day2.dayInMonth);
    }

    public String getDayString()
    {
        return String.valueOf(MONTH_DAY.values()[this.dayInMonth-1]);
    }

    // Expecting 1 as Sunday and 7 = שבת
    public String getDayOfWeakString()
    {
        return getDayOfWeekString(this.dayOfWeak);
    }
    public static String getDayOfWeekString(int day)
    {
        if (day == 7)
            return "שבת";

        return "יום " + WEEK_DAY.values()[day-1];
    }

    public static String[] getDaysOfWeakString()
    {
        String[] days = new String[7];
        for (int i = 0 ; i < 7; i++)
            days[i] = WEEK_DAY.values()[i].name();

        return days;
    }

    public abstract int getNumberDaysInMonth();
    public String[] getDaysOfMonthString()
    {
        String[] days = new String[getNumberDaysInMonth()];
        for (int i = 0 ; i < getNumberDaysInMonth(); i++)
            days[i] = MONTH_DAY.values()[i].name();

        return days;
    }
}

