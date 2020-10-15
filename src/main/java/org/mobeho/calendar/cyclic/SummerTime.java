package org.mobeho.calendar.cyclic;

import org.mobeho.calendar.HebrewDate;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class SummerTime
{
    static public String getInfo(HebrewDate date)
    {
        HebrewDate springDate = HebrewDate.ofChris(date.getChrisYear(), 3, 31);
        // Last friday before Mars 31
        springDate.addDays(-(springDate.getDayOfWeak() + 1));
        int start = springDate.getDayInYear();

        HebrewDate fallDate = HebrewDate.ofChris(date.getChrisYear(), 10, 31);
        // Last Sunday before Oct 31
        fallDate.addDays(-(fallDate.getDayOfWeak() - 1));
        int end = fallDate.getDayInYear();

        // Without hours calculation
        if (date.getDayInYear() == start)
            return "תחילת שעון קיץ";
        if (date.getDayInYear() == end)
            return "סוף שעון קיץ";
        if (date.getDayInYear() >= end && date.getDayInYear() < start)
            return "בשעון חורף";
        else
            return "בשעון קיץ";
    }
}
