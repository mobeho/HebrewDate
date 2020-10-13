package org.mobeho.calendar.hilchaty;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class SfiratHaomer
{
    public static int getInfo(Hebrew date)
    {
        // After Pesach
        int firstDay = date.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15);
        if (date.getDayInYear() > firstDay && date.getDayInYear() <= firstDay + 49)
            return date.getDayInYear() - firstDay;
        else
            return  0;
    }
}
