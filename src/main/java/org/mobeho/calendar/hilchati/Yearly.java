package org.mobeho.calendar.hilchati;

import org.mobeho.calendar.HebrewDate;
import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.weak.Parasha;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.mobeho.calendar.hilchati.HolyDay.*;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class Yearly
{
    public static List<String> getInfo(HebrewDate date)
    {
        return Arrays.stream(Yearly.class.getDeclaredMethods())
           .filter(m -> !m.getName().equals("getInfo") && !m.getName().equals("getSfiraAsNumber"))
           .map(m ->
           {
               try
               {
                   return (String)m.invoke(null, date);
               }
               catch (Exception ignore)
               {
                   return null;
               }
           })
           .filter(Objects::nonNull)
           .filter(s-> !s.isEmpty()).collect(Collectors.toList());
    }

    public static String switchSlichot(final HebrewDate date)
    {
        if (date.getMonth() > 1)
            return "";

        YearType yearType = date.getYearType();
        if (yearType.getFirstDay() == 7)
        {
            if (date.getDay() == 6)
                return "סליחות חמישי של עשי\"ת";
            else if (date.getDay() == 7)
                return "סליחות רביעי של עשי\"ת";
        }
        else if (yearType.getFirstDay() == 3)
        {
            if (date.getDay() == 7)
                return "סליחות חמישי של עשי\"ת";
            else if (date.getDay() == 8)
                return "סליחות רביעי של עשי\"ת";
        }

        return "";
    }

    public static String hoshanot(final HebrewDate date)
    {
        if (date.getMonth() != 1 || date.getDay() < 15 || date.getDay() > 21)
            return "";

        List<String> hoshanot = Arrays.asList("למען אמיתך", "אבן השתיה", "אערוך שועי", "אום אני חומה", "אל למושעות", "אדון המושיע");
        int day = date.getDay() - 15;

        if (date.getDayOfWeak() == 7)
            return "אום נצורה";

        if (date.getDayOfWeak() == 1 && day == 1)
            return "למען אמיתך";

        else if (day == 3)
        {
            switch (date.getDayOfWeak())
            {
                case 6: return "אל למושעות";
                case 1: return "אערוך שועי";
                case 3: return "אבן השתיה";
            }
        }

        return hoshanot.get(day);
    }

    public static String mizmorLetoda(HebrewDate date)
    {
        if (date.getMonth() == 1 && date.getDay() == 9)
            return "א\"א מזמור לתודה";

        else if (date.getMonth() == (7 + (date.isLeapYear()?1:0)) && date.getDay() == 14)
            return "א\"א מזמור לתודה";

        return "";
    }

    public static String veten(HebrewDate date)
    {
        if (date.getMonth() == 2 && date.getDay() == 7)
            return "מתחילים בהזכרת גשמים";

        return "";
    }

    public static int getSfiraAsNumber(HebrewDate date)
    {
        // After Pesach
        int firstDay = date.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15);
        if (date.getDayInYear() > firstDay && date.getDayInYear() <= firstDay + 49)
            return date.getDayInYear() - firstDay;
        else
            return 0;
    }

    private enum Units {א,ב,ג,ד,ה,ו,ז,ח,ט,י}
    private enum Tens {י,כ,ל,מ}
    public static String getSfiraAsText(HebrewDate date)
    {
        // After Pesach
        int days = 0;
        int firstDay = date.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15);
        if (date.getDayInYear() <= firstDay || date.getDayInYear() >= firstDay + 49)
            return "";

        days =  date.getDayInYear() - firstDay;
        int tens = days / 10;
        int units = days - 10 * tens;

        String numberString = "";
        if (tens == 1 && (units == 5 || units == 6))
        {
            numberString += "ט";
            units++;
        }
        else if (tens > 0) numberString += Tens.values()[tens - 1].name();
        if (units > 0) numberString += Units.values()[units - 1];

        numberString += " בעומר";

        int weeks = days / 7;
        int left = days - 7 * weeks;

        if (weeks == 1 && left == 0)
            numberString += ".שבוע";
        else if (weeks == 1 && left > 0)
            numberString += ".שבוע+" + left;
        else if (weeks > 1 && left == 0)
            numberString += "." + weeks + " ש'";
        else if (weeks > 1 && left > 0)
            numberString += "." + weeks + " ש'+" + left;

        return numberString;
    }


    public static String ledavid(HebrewDate date)
    {
        if (date.getMonth() == (date.isLeapYear() ? 13 : 12) && date.getDay() == 1)
            return "מתחילים לדוד ה'";

        return "";
    }

    public static String slichot(HebrewDate date)
    {
        if (date.getMonth() == (date.isLeapYear() ? 13 : 12) && date.getDay() == 2)
            return "מתחילים סליחות לספרדים";

        int less = date.getYearType().getPesachDay() == 1 ? 9 : date.getYearType().getPesachDay() + 1;
        int firstDay = date.getNumberDaysInYear() - less;
        if (date.getMonth() == (date.isLeapYear() ? 13 : 12) && date.getDayInYear() == firstDay)
            return "מתחילים סליחות לאשכנזים";

        return "";
    }

    public static String einAvHarachamim(HebrewDate date)
    {
        if (date.getDayOfWeak() != 7)
            return "";

        Parasha[] parashot = date.getShabat();
        if (parashot.length == 1)
            return "";

        if (parashot[1].equals(Parasha.שבת_שובה))
            return "";

        if (!parashot[1].isOrdered() && getSfiraAsNumber(date) == 0)
            return "מדלגים אב הרחמים";

        return "";
    }

    public static String einTachanun(HebrewDate date)
    {
        if (!HolyDay.isTachanun(date.getYearType(), date.getDayInYear()) && date.getDayOfWeak() != 7)
            return "אין תחנון";

        return "";
    }

    public static String einLamenatzeach(HebrewDate date)
    {
        if (!HolyDay.isLamenatzeach(date.getYearType(), date.getDayInYear()) && date.getDayOfWeak() != 7)
            return "א\"א למנצח";

        return "";
    }

    public static String shabtChodesh(final HebrewDate date)
    {
        if (date.getDayOfWeak() == 7 && (date.getDay() == 1 || date.getDay() ==  date.getNumberDaysInMonth()))
        {
            if (date.isLeapYear() && date.getMonth() < 8)
                return "אתה יצרת (ולכפרת פשע)";
            else
                return "אתה יצרת";
        }

        return "";
    }

    public static String threeSefreiTora(final HebrewDate date)
    {
        if (date.getDayOfWeak() == 7 &&
           (date.getDay() == 1 || date.getDay() ==  date.getNumberDaysInMonth()) &&
           date.getDayInYear() == (92 - date.getYearType().getFirstDay()))
        {
            return "3 ספרי תורה";
        }

        return "";
    }

    public static String biurMaasrot(HebrewDate date)
    {
        if (date.getYear() % 7 == 0)
        {
            // Erev Pesach
            int holiday = date.getYearType().getNumberDaysInYear() - (29+30+29+30+29+16);
            if (date.getDayInYear() == holiday)
                return "ביעור מעשרות";
        }

        return "";
    }
}