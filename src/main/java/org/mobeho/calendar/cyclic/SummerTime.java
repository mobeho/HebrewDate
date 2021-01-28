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
        HebrewDate start = getStart(date);
        HebrewDate end = getEnd(date);
        return  (date.getChrisDayInYear() >= start.getChrisDayInYear() && date.getChrisDayInYear() <= end.getChrisDayInYear());
    }

    static public String getDayInfo(HebrewDate date)
    {
        HebrewDate start = getStart(date);
        HebrewDate end = getEnd(date);

        if (date.getChrisDayInYear() > 0 && date.getChrisDayInYear() < start.getChrisDayInYear() - 1)
            return "בשעון חורף";
        if (date.getChrisDayInYear() == (start.getChrisDayInYear() - 1))
            return "סוף שעון חורף";
        else if (date.getChrisDayInYear() == start.getChrisDayInYear())
            return "תחילת שעון קיץ";
        else if (date.getChrisDayInYear() > start.getChrisDayInYear() && date.getChrisDayInYear() < end.getChrisDayInYear())
            return "בשעון קיץ";
        else if (date.getChrisDayInYear() == end.getChrisDayInYear())
            return "סוף שעון קיץ";
        else if (date.getChrisDayInYear() == (end.getChrisDayInYear() + 1))
            return "תחילת שעון חורף";
        else
            return "בשעון חורף";
    }

    static public HebrewDate getStart(HebrewDate date)
    {
        // Last friday before Mars 31
        HebrewDate springDate = HebrewDate.ofChris(date.getChrisYear(), 3, 31);
        return springDate.addDays(-(springDate.getDayOfWeak() + 1));
    }

    static public HebrewDate getEnd(HebrewDate date)
    {
        // Last Sunday before Oct 31
        HebrewDate fallDate = HebrewDate.ofChris(date.getChrisYear(), 10, 31);
        return fallDate.addDays(-(fallDate.getDayOfWeak() - 1));
    }
}
