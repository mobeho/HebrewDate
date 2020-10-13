package org.mobeho.calendar;

import java.time.LocalDate;
import java.util.HashMap;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class Christian
{
    private int dayOfWeak;
    private int dayInMonth;
    private int month;
    private int dayInYear;
    private int year;
    private int startYearDayOfWeak;
    private int daysFromStart;
    private boolean gregorianAge;

    static final int DAYS_FROM_BERESHIT_TO_1900 = 2067023;

    public Christian(boolean from19000101)
    {
        if (from19000101)
            reset(DAYS_FROM_BERESHIT_TO_1900);
        else
            reset(0);
    }

    protected boolean reset(int daysFromStart)
    {
        if (daysFromStart >= this.daysFromStart && this.daysFromStart > 0)
            return false;

        if (daysFromStart >= DAYS_FROM_BERESHIT_TO_1900)
        {
            this.dayInYear = 1;
            this.dayInMonth = 1;
            this.month = 1;
            this.year = 1900;
            this.dayOfWeak = 2;
            this.startYearDayOfWeak = 2;
            this.daysFromStart = 2067023;
            this.gregorianAge = true;
        }
        else
        {
            this.dayInYear = 280;
            this.dayInMonth = 7;
            this.month = 10;
            this.year = -3761;
            this.dayOfWeak = 2;
            this.startYearDayOfWeak = 2;
            this.daysFromStart = 0;
            this.gregorianAge = false;
        }

        return true;
    }

    public void set(int year, int month, int day)
    {
        if (year < getYear() || (year == getYear() && month < getMonth()) || (year == getYear() && month == getMonth() && day < getDay()))
        {
            if (year >= 1900 && month >= 1)
                reset(DAYS_FROM_BERESHIT_TO_1900);
            else
                reset(0);
        }

        while (getDay() != 1 && getYear() < year) addDays(1);
        while (getMonth() != 1 && getYear() < year) addMonths(1);
        while (getYear() < year) addYears(1);
        while (getMonth() < month && getMonth() < getNumberOfMonths()) addMonths(1);
        while (getDay() < day && getDay() < getNumberDaysInMonth()) addDays(1);
    }

    public boolean isLeapYear()
    {
        return getIfLeapYear(this.year);
    }

    public boolean getIfLeapYear(int someYear)
    {
        if (!this.gregorianAge)
        {
            return someYear != 0 && someYear % 4 == 0;
        }
        else
        {
            //	Every year divisible by 4 is a leap year.
            //	But every year divisible by 100 is NOT a leap year
            //	Unless the year is also divisible by 400, then it is still a leap year.
            return someYear % 4 == 0 && (someYear % 100 != 0 || someYear % 400 == 0);
        }
    }

    public boolean isGregorianAge()
    {
        if (this.year > 1582) return true;
        else if (this.year < 1582) return false;
        // in year 1582
        if (this.month > 10) return true;
        else if (this.month < 10) return false;
        // in month 10
        if (this.dayInMonth > 4) return true;
        else if (this.dayInMonth < 4) return false;
        return false;
    }

    private void setGregorianAge()
    {
        if (!this.gregorianAge && isGregorianAge())
        {
            // Just once
            this.gregorianAge = true;

            if (this.year == 1582 && this.month == 10 && (this.dayInMonth > 4 && this.dayInMonth < 15))
            {
                adv(10);
                this.dayInYear = adv(this.dayInYear, getNumberOfMonths(), 10);
            }
            else
            {
                this.daysFromStart -= 10;
                this.dayOfWeak = adv(this.dayOfWeak, 7, -10);
            }
        }
    }

    private int getFebruaryLength()
    {
        if (isLeapYear())
            return 29;
        else
            return 28;
    }

    private int shift(int val, int bas, int add)
    {
        return ((val + --add) / bas);
    }

    private int adv(int val, int bas, int add)
    {
        val = ((val + --add) % bas + 1);
        if (val == 0)
        {
            if (add < -1) val = bas;
            else if (add > -1) val = 1;
        }
        return val;
    }

    public void addDays(int days)
    {
        int daysFromStart = this.daysFromStart;
        if (reset(this.daysFromStart + days))
            days += daysFromStart - this.daysFromStart;

        if (days < 0)
            return;

        // max days in _year
        while (days > 366)
        {
            days += this.daysFromStart;
            addYears(1);
            days -= this.daysFromStart;
        }

        // max days in _month
        while (days > 31)
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
            this.dayInYear = adv(this.dayInYear, getNumberDaysInYear(), 28);
            this.dayInYear = ((this.dayInYear + 28) % getNumberDaysInYear());
            adv(28);
        }

        //The next lines order is important
        this.daysFromStart += days;
        this.dayInYear = adv(this.dayInYear, getNumberDaysInYear(), days);
        this.dayOfWeak = adv(this.dayOfWeak, 7, days);
        this.startYearDayOfWeak = (this.dayOfWeak);
        adv(days);

        setGregorianAge();

        if (this.dayInMonth > getNumberDaysInMonth())
            adv(0);
    }

    public void addMonths(int months)
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
            this.startYearDayOfWeak = this.dayOfWeak;
            int shift = shift(this.month, getNumberOfMonths(), 1);
            this.month = adv(this.month, getNumberOfMonths(), 1);
            this.year = adv(this.year, 100000, shift);
            setGregorianAge();
        }

        if (this.dayInMonth > getNumberDaysInMonth())
            adv(0);
    }

    public void addYears(int years)
    {
        if (years <= 0)
            return;

        for (; years > 0; years--)
        {
            int numbersDaysToAdd = getNumberDaysInYear() + addMonthTuning(getIfLeapYear(this.year), getIfLeapYear(this.year + 1));
            this.daysFromStart += numbersDaysToAdd;
            this.dayInYear = adv(this.dayInYear, getNumberDaysInYear(), numbersDaysToAdd);
            this.dayOfWeak = adv(this.dayOfWeak, 7, numbersDaysToAdd);
            this.startYearDayOfWeak = this.dayOfWeak;
            this.year = adv(this.year, 100000, 1);
            setGregorianAge();
        }


        if (this.dayInMonth > getNumberDaysInMonth())
            adv(0);
    }

    private void adv(int adding)
    {
        int shiftMonth = shift(this.dayInMonth, getNumberDaysInMonth(), adding);
        this.dayInMonth = adv(this.dayInMonth, getNumberDaysInMonth(), adding);

        int shiftYear = shift(this.month, getNumberOfMonths(), shiftMonth);
        this.month = adv(this.month, getNumberOfMonths(), shiftMonth);

        this.year = adv(this.year, 100000, shiftYear);
    }

    ///		1	2	3	4	5	6	7	8	9	10	11	12
    ///	N	31	28	31	30	31	30	31	31	30	31	30	31	365
    ///	P	31	29	31	30	31	30	31	31	30	31	30	31	366
    ///
    ///	n->p
    ///	1	31	28	31	30	31	30	31	31	30	31	30	31	365	0
    ///	2	28	31	30	31	30	31	31	30	31	30	31	31	365	0
    ///	3	31	30	31	30	31	31	30	31	30	31	31	29	366	+1
    ///	4	30	31	30	31	31	30	31	30	31	31	29	31	366	+1
    ///	5	31	30	31	31	30	31	30	31	31	29	31	30	366	+1
    ///	6	30	31	31	30	31	30	31	31	29	31	30	31	366	+1
    ///	7	31	31	30	31	30	31	31	29	31	30	31	30	366	+1
    ///
    ///		1	2	3	4	5	6	7	8	9	10	11	12
    ///	P	31	29	31	30	31	30	31	31	30	31	30	31	366
    ///	N	31	28	31	30	31	30	31	31	30	31	30	31	365
    ///
    ///	p->n
    ///	1	31	29	31	30	31	30	31	31	30	31	30	31	366	0
    ///	2	29	31	30	31	30	31	31	30	31	30	31	31	366	0
    ///	3	31	30	31	30	31	31	30	31	30	31	31	28	365	-1
    ///	4	30	31	30	31	31	30	31	30	31	31	28	31	365	-1
    ///	5	31	30	31	31	30	31	30	31	31	28	31	30	365	-1
    ///	6	30	31	31	30	31	30	31	31	28	31	30	31	365	-1
    ///	7	31	31	30	31	30	31	31	28	31	30	31	30	365	-1
    private int addMonthTuning(boolean fromYear, boolean toYear)
    {
        if (!fromYear)
        {
            if (toYear)
            {
                if (this.month >= 3) return +1;
            }
        }
        else
        {
            if (!toYear)
            {
                if (this.month >= 3) return -1;
            }
        }
        return 0;
    }

    HashMap<Integer, String> WeakDay = new HashMap<Integer, String>()
    {{
        put(1, "Sunday");
        put(2, "Monday");
        put(3, "Tuesday");
        put(4, "Wednesday");
        put(5, "Thursday");
        put(6, "Friday");
        put(7, "Saturday");
    }};

    int getNumberDaysInMonth()
    {
        switch (this.month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 12:
                return 31;
            case 2:
                return getFebruaryLength();
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 10:
                if (this.year == 1582)
                    return 21;
                else
                return 31;
        }
        return -1;
    }
    String[] getDaysOfMonthString()
    {
        String[] days = new String[getNumberDaysInMonth()];
        for (int index = 1; index <= getNumberDaysInMonth(); index++)
            days[index - 1] = String.valueOf(index);

        return days;
    }

    public LocalDate getLocalDate()
    {
        if (this.year < 1)
            return null;

        return LocalDate.of(this.year, this.month, this.dayInMonth);
    }

    //Properties
    public int getDay()
    {
        return this.dayInMonth;
    }
    public String getDayString()
    {
        return String.valueOf(this.dayInMonth);
    }
    public int getDayOfWeak()
    {
        return this.dayOfWeak;
    }
    public String getDayOfWeakString()
    {
        return WeakDay.get(getDayOfWeak());
    }
    public int getMonth()
    {
        return this.month;
    }
    public int getYear()
    {
        return this.year;
    }
    int getNumberOfMonths()
    {
        return 12;
    }
    private int getNumberDaysInYear()
    {
        return getFebruaryLength() + 4 * 30 + 7 * 31;
    }
    int getDaysInYear()
    {
        return getFebruaryLength() + 4 * 30 + 7 * 31-((this.year==1582)?10:0);
    }
    public int getCrisNumberOfWeeks()
    {
        return (getStartYearDayOfYear() + getNumberDaysInYear()) / 7;
    }
    public int getDaysFromStart()
    {
        return this.daysFromStart;
    }
    public int getDayInYear()
    {
        return this.dayInYear;
    }
    public int getStartYearDayOfYear()
    {
        return this.startYearDayOfWeak;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", this.dayInMonth, this.month, this.year);
    }
}
