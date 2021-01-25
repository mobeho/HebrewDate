package org.mobeho.calendar.cyclic;

import org.mobeho.calendar.HebrewDate;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class SummerTime
{
    static public boolean isSummnertime(HebrewDate date)
    {
        int[] range = getTange(date);
        return (date.getDayInYear() < range[1] || date.getDayInYear() >= range[0]);
    }

    static public String getInfo(HebrewDate date)
    {
        int[] range = getTange(date);

        // Without hours calculation
        if (date.getDayInYear() == range[0])
            return "תחילת שעון קיץ";
        if (date.getDayInYear() == range[1])
            return "סוף שעון קיץ";
        if (date.getDayInYear() >= range[1] && date.getDayInYear() < range[0])
            return "בשעון חורף";
        else
            return "בשעון קיץ";
    }

    static private int[] getTange(HebrewDate date)
    {
        HebrewDate springDate = HebrewDate.ofChris(date.getChrisYear(), 3, 31);
        // Last friday before Mars 31
        springDate.addDays(-(springDate.getDayOfWeak() + 1));
        int start = springDate.getDayInYear();

        HebrewDate fallDate = HebrewDate.ofChris(date.getChrisYear(), 10, 31);
        // Last Sunday before Oct 31
        fallDate.addDays(-(fallDate.getDayOfWeak() - 1));
        int end = fallDate.getDayInYear();

        return new int[]{start, end};
    }
}
