package org.mobeho.calendar.cyclic;

import org.mobeho.calendar.HebrewDate;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class DafYomiBavli
{
    private static class Masechet
    {
        public String Name;
        public int pages;

        public Masechet(String name, int pages)
        {
            this.Name = name;
            this.pages = pages;
        }
    }

    private static Masechet[] Shas = new Masechet[]{
            new Masechet("ברכות", 63),
            new Masechet("שבת", 156),
            new Masechet("עירובין", 104),
            new Masechet("פסחים", 120),
            new Masechet("שקלים", 21),
            new Masechet("יומא", 87),
            new Masechet("סוכה", 55),
            new Masechet("ביצה", 39),
            new Masechet("ראש השנה", 34),
            new Masechet("תענית", 30),
            new Masechet("מגילה", 31),
            new Masechet("מועד קטן", 28),
            new Masechet("חגיגה", 26),
            new Masechet("יבמות", 121),
            new Masechet("כתובות", 111),
            new Masechet("נדרים", 90),
            new Masechet("נזיר", 65),
            new Masechet("סוטה", 48),
            new Masechet("גיטין", 89),
            new Masechet("קידושין", 81),
            new Masechet("בבא קמא", 118),
            new Masechet("בבא מציעא", 118),
            new Masechet("בבא בתרא", 175),
            new Masechet("סנהדרין", 112),
            new Masechet("מכות", 23),
            new Masechet("שבועות", 48),
            new Masechet("עבודה זרה", 75),
            new Masechet("הוריות", 13),
            new Masechet("זבחים", 119),
            new Masechet("מנחות", 109),
            new Masechet("חולין", 141),
            new Masechet("בכורות", 60),
            new Masechet("ערכין", 33),
            new Masechet("תמורה", 33),
            new Masechet("כריתות", 27),
            new Masechet("מעילה", 36),
            new Masechet("נדה", 72)
    };

    public static int getCycle(HebrewDate date)
    {
        return (int)((date.getDaysFromStart() - 2075613F) / 2711F) + 1;
    }

    // Starting from 1 for Brachot
    public static int getMasechetIndex(HebrewDate date)
    {
        return getMasechetAndDaf(date)[1] + 1;
    }

    public static String getMasechetName(HebrewDate date)
    {
        return Shas[getMasechetAndDaf(date)[1]].Name;
    }

    public static int getPage(HebrewDate date)
    {
        return getMasechetAndDaf(date)[2];
    }

    public static String getPageName(HebrewDate date)
    {
        return getPageString(getMasechetAndDaf(date)[2]);
    }

    public static int getCoveredCurrentCycle(HebrewDate date)
    {
        int days =  date.getDaysFromStart() - 2094590;
        if (days < 0)
            return -1;

        days = days % 2711;
        return (int) (100F * days / 2711F);
    }

    public static String getFullInfo(HebrewDate date)
    {
        int[] place = getMasechetAndDaf(date);
        if (place.length == 0)
            return null;

        return String.format("מחזור:%d - מסכת:%s דף:%s", place[0], Shas[place[1]].Name, getPageString(place[2]));
    }

    public static String getInfo(HebrewDate date)
    {
        int[] place = getMasechetAndDaf(date);
        if (place.length == 0)
            return null;

        return String.format("מסכת:%s דף:%s", Shas[place[1]].Name, getPageString(place[2]));
    }

    // 15/10/5775 start of the 8th cycle that contains 2711 pages
    // 15/10/5775 is 2094590 days from start
    private static int[] getMasechetAndDaf(HebrewDate date)
    {
        int days =  date.getDaysFromStart() - 2094590;
        if (days < 0)
            return new int[]{};

        int machzor = 8;
        while (days >= 2711)
        {
            machzor++;
            days -= 2711;
        }

        int masechet = 0;
        for(; days > Shas[masechet].pages; masechet++)
        {
            days -= Shas[masechet].pages;
        }

        return new int[]{machzor, masechet, days+2};
    }


    private enum Units {א,ב,ג,ד,ה,ו,ז,ח,ט}
    private enum Tens {י,כ,ל,מ,נ,ס,ע,פ,צ}
    private enum Hundreds {ק,ר,ש,ת,תק,תר,תש,תת,תתק}
    private static String getPageString(int page)
    {
        int hundreds = page / 100;
        int tens = (page - 100*hundreds)/10;
        int units = page - 100*hundreds - 10*tens;

        String numberString = "";
        if (hundreds > 0)
            numberString += Hundreds.values()[hundreds-1].name();
        if (tens > 0)
            numberString += Tens.values()[tens-1].name();
        if (units > 0)
            numberString += Units.values()[units-1];
        return numberString;
    }
}
