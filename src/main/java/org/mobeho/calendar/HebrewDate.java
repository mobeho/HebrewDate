package org.mobeho.calendar;

import org.mobeho.calendar.calendar.*;
import org.mobeho.calendar.hilchati.HolyDay;
import org.mobeho.calendar.hilchati.SfiratHaomer;
import org.mobeho.calendar.hilchati.weak.Shabat;
import org.mobeho.calendar.hilchati.weak.Parasha;

import java.time.LocalDate;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class HebrewDate
{
    private Hebrew hebrew;
    private Christian christian;

    /* Future feature private final boolean israel = true; */
    // Constructors

    private HebrewDate()
    {
        this(true);
    }

    private HebrewDate(boolean from19000101)
    {
        reset(from19000101);
    }

    private HebrewDate(int year, int month, int day)
    {
        this.reset(year >= 5660 && month >= 5);
        this.hebrew.set(year, month, day);
        this.christian.addDays(this.hebrew.getDaysFromStart() - this.christian.getDaysFromStart());
    }

    private void reset(boolean from19000101)
    {
        this.hebrew = new Hebrew(from19000101);
        this.christian = new Christian(from19000101);
    }

    // Ofs

    public static HebrewDate of(HebrewDate other)
    {
        return new HebrewDate(other.getYear(), other.getMonth(), other.getDay());
    }

    public static HebrewDate of(int year, int month, int day)
    {
        return new HebrewDate(year, month, day);
    }

    public static HebrewDate of(int year, int dayInYear)
    {
        HebrewDate me = new HebrewDate();
        me.hebrew.set(year, 1, 1);
        me.hebrew.addDays(dayInYear - 1);
        me.christian.addDays(me.hebrew.getDaysFromStart() - me.christian.getDaysFromStart());
        return me;
    }

    public static HebrewDate ofChris(int year, int month, int day)
    {
        HebrewDate me = new HebrewDate(false);
        me.christian.set(year, month, day);
        me.hebrew.addDays(me.christian.getDaysFromStart() - me.hebrew.getDaysFromStart());
        return me;
    }

    public static HebrewDate of(LocalDate date)
    {
        HebrewDate me = new HebrewDate();
        me.christian.set(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        me.hebrew.addDays(me.christian.getDaysFromStart() - me.hebrew.getDaysFromStart());
        return me;
    }

    public static HebrewDate of(String taarich)
    {
        HebrewDate me = new HebrewDate();
        if (me.hebrew.of(taarich))
            me.christian.addDays(me.hebrew.getDaysFromStart() - me.christian.getDaysFromStart());

        return me;
    }

    public static HebrewDate of(int year, Parasha parasha)
    {
        return HebrewDate.of(year, parasha, false);
    }

    public static HebrewDate of(int year, Parasha parasha, boolean secondPhase)
    {
        // Condition = Is after 1900/01/01
        HebrewDate me = new HebrewDate(year >= 5660 && parasha.index >= Parasha.בא.index);

        me.hebrew.set(year, 1, 1);
        int days = Shabat.getDayInYear(me.getYearType(), parasha, secondPhase);
        if (days == -1)
            return null;

        me.addDays(days - 1);
        me.christian.addDays(me.hebrew.getDaysFromStart() - me.christian.getDaysFromStart());
        return me;
    }

    public static HebrewDate now()
    {
        HebrewDate me = new HebrewDate(true);
        me.hebrew.today();
        me.christian.addDays(me.hebrew.getDaysFromStart() - me.christian.getDaysFromStart());
        return me;
    }

    public HebrewDate addDays(int days)
    {
        this.hebrew.addDays(days);
        this.christian.addDays(days);
        return this;
    }

    public HebrewDate setNextShabat()
    {
        addDays(7 - this.hebrew.getDayOfWeak());
        return this;
    }

    public HebrewDate addMonths(int months)
    {
        this.hebrew.addMonths(months);
        this.christian.addDays(this.hebrew.getDaysFromStart() - this.christian.getDaysFromStart());
        return this;
    }

    public HebrewDate addChrisMonths(int months)
    {
        this.christian.addMonths(months);
        this.hebrew.addDays(this.christian.getDaysFromStart() - this.hebrew.getDaysFromStart());
        return this;
    }

    public HebrewDate addYears(int years)
    {
        this.hebrew.addYears(years);
        this.christian.addDays(this.hebrew.getDaysFromStart() - this.christian.getDaysFromStart());
        return this;
    }

    public HebrewDate addChrisYears(int years)
    {
        this.christian.addYears(years);
        this.hebrew.addDays(this.christian.getDaysFromStart() - this.hebrew.getDaysFromStart());
        return this;
    }

    public static int[] convertMonthAndDay(String monthAndDay)
    {
        return Hebrew.convertMonthAndDay(monthAndDay);
    }

    public static String convertMonthAndDay(int month, int day, boolean isLeapYear)
    {
        return Hebrew.convertMonthAndDay(month, day, isLeapYear);
    }

    public static String convertDayOfWeek(int day)
    {
        return Hebrew.getDayOfWeekString(day);
    }

    public String getMonthAndDay()
    {
        return this.hebrew.getMonthAndDay();
    }

    public String getHolidayName()
    {
        return HolyDay.getName(this.hebrew.getYearType(), this.hebrew.getDayInYear());
    }

    public String getShabatName()
    {
        return Parasha.toString(Shabat.getShabat(this.hebrew.getYearType(), this.hebrew.getDayInYear()));
    }

    public String getParashaName()
    {
        Parasha[] parashot = Shabat.getShabat(this.hebrew.getYearType(), this.hebrew.getDayInYear());
        if (parashot[0] == null)
            return "";

        if (parashot.length > 1 && parashot[1].isOrdered())
            return parashot[0].toString() + " " + parashot[1].toString();

        return parashot[0].toString();
    }

    public static String[] getDaysOfWeakString()
    {
        return Day.getDaysOfWeakString();
    }

    public int getLastShabatDayInYear()
    {
        return Shabat.getLastShabatDayInYear(this.hebrew.getYearType());
    }

    public String toShortString()
    {
        return this.hebrew.getDayString() + " " + getMonthString();
    }

    public LocalDate getLocalDate()
    {
        return this.christian.getLocalDate();
    }

    public int getYear()
    {
        return this.hebrew.getYear();
    }

    public String getYearTypeName()
    {
        return this.hebrew.getYearType().name();
    }

    public String toYearString()
    {
        return this.hebrew.toYearString();
    }

    public int getChrisYear()
    {
        return this.christian.getYear();
    }

    public String getYearString()
    {
        return this.hebrew.getYearString();
    }

    public String[] getDaysOfMonthString()
    {
        return this.hebrew.getDaysOfMonthString();
    }

    public String[] getChrisDaysOfMonthString()
    {
        return this.christian.getDaysOfMonthString();
    }

    public int getMonth()
    {
        return this.hebrew.getMonth();
    }

    public int getNumberOfMonths()
    {
        return this.hebrew.getNumberOfMonths();
    }

    public String getMonthString()
    {
        return this.hebrew.getMonthString();
    }

    public String[] getMonthsString()
    {
        return this.hebrew.getMonthsString();
    }

    public int getChrisMonth()
    {
        return this.christian.getMonth();
    }

    public String getChrisMonthString()
    {
        return this.christian.getMonthString();
    }

    public int[] getMolad()
    {
        return new int[]{this.hebrew.getMoladHachodesh(), this.hebrew.getMoladHachodeshTime().getHour(), this.hebrew.getMoladHachodeshTime().getJiffy()};
    }

    public int getMoonDayInWeak()
    {
        return this.hebrew.getMoonDayInWeak();
    }

    public int getFirstDayInMonth()
    {
        return this.hebrew.getFirstDayInMonth();
    }

    public int getDay()
    {
        return this.hebrew.getDayInMonth();
    }

    public int getDayInYear()
    {
        return this.hebrew.getDayInYear();
    }

    public String getDayString()
    {
        return this.hebrew.getDayString();
    }

    public int getChrisDay()
    {
        return this.christian.getDay();
    }

    public String getDayOfWeakString()
    {
        return this.hebrew.getDayOfWeakString();
    }

    public String getChrisDayOfWeakString()
    {
        return this.christian.getDayOfWeakString();
    }

    public String getChrisDayString()
    {
        return this.christian.getDayString();
    }

    public int getChrisDayInYear()
    {
        return this.christian.getDayInYear();
    }

    public int getDayOfWeak()
    {
        return this.hebrew.getDayOfWeak();
    }

    public int getNumberDaysInMonth()
    {
        return this.hebrew.getNumberDaysInMonth();
    }

    public int getChrisNumberDaysInMonth()
    {
        return this.christian.getNumberDaysInMonth();
    }

    public int getNumberDaysInYear()
    {
        return this.hebrew.getNumberDaysInYear();
    }

    public int getChrisNumberDaysInYear()
    {
        return this.christian.getDaysInYear();
    }

    public int getDaysFromStart()
    {
        return this.hebrew.getDaysFromStart();
    }

    public YearType getYearType()
    {
        return this.hebrew.getYearType();
    }

    public boolean isToday(String checkThis)
    {
        return this.hebrew.isToday(checkThis);
    }

    public boolean isLeapYear()
    {
        return this.hebrew.getYearType().isLeap();
    }

    public boolean isChrisLeapYear()
    {
        return this.christian.isLeapYear();
    }

    public boolean isGregorianAge()
    {
        return this.christian.isGregorianAge();
    }

    public int getNumberOfShabatot()
    {
        return this.hebrew.getNumberOfShabatot();
    }

    public int getNumberOfWeeks()
    {
        return this.hebrew.getNumberOfWeeks();
    }

    public int getChrisNumberOfWeeks()
    {
        return (this.christian.getChrisNumberOfWeeks());
    }

    @Override
    public String toString()
    {
        return this.toString(" ");
    }

    public String toDateFormat()
    {
        return this.hebrew.toDateFormat();
    }

    public String toString(String delimiter)
    {
        return getDayString() + delimiter + getMonthString() + delimiter + getYearString();
    }

    public String toDayMonthString(String delimiter)
    {
        return getDayString() + delimiter + getMonthString();
    }

    public String toChrisString()
    {
        return this.christian.toString();
    }

    public String toDayMonthChrisString(String delimiter)
    {
        return getChrisDayString() + delimiter + getChrisMonthString();
    }

    public int getSfiratHaomer()
    {
        return SfiratHaomer.getInfo(this.hebrew);
    }

    public static int compare(HebrewDate hebrewDate1, HebrewDate hebrewDate2)
    {
        return Hebrew.compare(hebrewDate1.hebrew, hebrewDate2.hebrew);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;

        if (obj == this)
            return true;

        if (!(obj instanceof HebrewDate))
            return false;

        HebrewDate date = (HebrewDate)obj;
        return compare(this, date) == 0;
    }


    @Override
    public int hashCode()
    {
        return getYear() ^ getMonth() ^ getDay();
    }

    /* Not calculate correctly. Should be fixed and opened
    public static void check(int year, int myMonth, int dayInMonth, int dayInWeek)
    {
        int month = 3;
        int a = (12*year+17)%19;
        int leap = year%4;
        double day = (32+4343/98496) + (1+ 272953/492480)*a + 0.25f*leap - (313/98496)*year;
        int M = (int) Math.floor(day);
        day -= M;
        int dayOfWeek = (M + 3*a + 5*leap + 5)%7;
        if (dayOfWeek == 2 || dayOfWeek == 4 || dayOfWeek == 6)
        {
            M +=1;
            dayOfWeek +=1;
        }
        else if (dayOfWeek == 1 && a>6 && day>=(1367/2160))
        {
            M +=2;
            dayOfWeek +=2;
        }
        else if (dayOfWeek == 0 && a>11 && day>=(23269/25920))
        {
            M +=1;
            dayOfWeek = 1;
        }

        M += 13;
        dayOfWeek = (dayOfWeek + 13) %7;
        if (M > 31)
        {
            M -= 31;
            month++;
        }
        if (M > 61)
        {
            M -= 61;
            month += 2;
        }

        System.out.println("Month:" + month + "=" + myMonth + "Day:" + M + "=" +  dayInMonth);
    }
    */

    static
    {
        new Init();
    }
}