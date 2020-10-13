package org.mobeho.calendar.cyclic;

import org.mobeho.calendar.HebrewDate;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class DafYomiBavli
{
    static class Masechet
    {
        public String Name;
        public int pages;

        public Masechet(String name, int pages)
        {
            this.Name = name;
            this.pages = pages;
        }
    }

    Masechet[] Shas = new Masechet[]{
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


    // 2075613 - start
    public String getInfo(HebrewDate date)
    {
        double cycle = (date.getDaysFromStart() - 2075613D) / 2711D;

        if (cycle < 0)
            return "";

        int daf = (int) ((cycle - Math.floor(cycle)) * 2711);

        int sum = 0;
        int index = 0;
        for (; index < Shas.length; index++)
        {
            if (sum + Shas[index].pages > daf)
                break;
            else
                sum += Shas[index].pages;
        }

        daf += 2;

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

        return String.format("מחזור:%s - מסכת:%s דף:%s", df.format(++cycle), Shas[index].Name, getYearString(daf - sum));
    }

    private enum Units {א,ב,ג,ד,ה,ו,ז,ח,ט}
    private enum Tens {י,כ,ל,מ,נ,ס,ע,פ,צ}
    private enum Hundreds {ק,ר,ש,ת,תק,תר,תש,תת,תתק}

    private String getYearString(int page)
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
