package org.mobeho.calendar.hilchaty;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public enum YearType
{
    בחג(353, false, 50),בחה(383, true, 54),
    בשה(355, false, 50), בשז(385, true, 55),
    גכה(354, false, 50),גכז(384, true, 55),
    הכז(354, false, 51),החא(383, true, 55),
    השא(355, false, 51),השג(385, true, 55),
    זחא(353, false, 51),זחג(383, true, 55),
    זשג(355, false, 51),זשה(385, true, 55);

    int numberDaysInYear;
    boolean leap;
    int numberOFShabatot;

    YearType(int numberDaysInYear, boolean leap, int numberOFShabatot)
    {
        this.numberDaysInYear = numberDaysInYear;
        this.leap = leap;
        this.numberOFShabatot = numberOFShabatot;
    }

    public int getNumberDaysInYear()
    {
        return this.numberDaysInYear;
    }

    public boolean isLeap()
    {
        return this.leap;
    }

    /* Might used in the future
    int getNumberOfShabatot()
    {
        return this.numberOFShabatot;
    } */

    int getBalance()
    {
        if (this.name().charAt(1) == 'ח') return -1;
        else if (this.name().charAt(1) == 'כ') return 0;
        return 1;
    }


    public int getFirstDay()
    {
        if (this.name().charAt(0) == 'ב') return 2;
        else if (this.name().charAt(0) == 'ג') return 3;
        else if (this.name().charAt(0) == 'ה') return 5;
        return 7;
    }

    public int getPesachDay()
    {
        if (this.name().charAt(2) == 'א') return 1;
        else if (this.name().charAt(2) == 'ג') return 3;
        else if (this.name().charAt(2) == 'ה') return 5;
        else if (this.name().charAt(2) == 'ז') return 7;
        return 7;
    }

    private final static String cycle19 = "0010010100100100101";
    static boolean getIfLeapYear(int yearP)
    {
        return (cycle19.charAt((yearP-1) % 19) == '1');
    }
}
