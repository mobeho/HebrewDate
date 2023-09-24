package org.mobeho.calendar.cyclic;

import org.mobeho.calendar.HebrewDate;
import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.weak.Parasha;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Customs
{
    public static String getInfos(HebrewDate date)
    {
        return shovavim(date) + betHeyBet(date) + haman(date) +
           shira(date) + shekel(date) + ptira(date);
    }

    public static List<String> getInfo(HebrewDate date)
    {
        return Arrays.stream(Customs.class.getDeclaredMethods())
           .filter(m -> !m.getName().contains("getInfo"))
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
           .filter(s-> !s.isEmpty())
           .collect(Collectors.toList());
    }

    public static String shovavim(final HebrewDate date)
    {
        YearType yearType = date.getYearType();
        int holiday = 107 - yearType.getFirstDay();
        if (date.getDayInYear() == holiday)
            return "ימי שובבים";

        return "";
    }

    public static String betHeyBet(final HebrewDate date)
    {
        YearType yearType = date.getYearType();
        if (date.getMonth() == 2 && date.getDay() < 11)
        {
            boolean start = false;
            switch (yearType.getFirstDay())
            {
                case 2:
                    start = (date.getDay() == 6);
                    break;
                case 3:
                    start = (date.getDay() == 5);
                    break;
                case 5:
                    start = (date.getDay() == 10);
                    break;
                case 7:
                    start = (date.getDay() == 8);
                    break;
            }

            if (start)
                return "תענית בה\"ב";
        }

        if (date.getMonth() == (8 + (date.isLeapYear()?1:0)) && date.getDay() < 11)
        {
            boolean start = false;
            switch (yearType.getPesachDay())
            {
                case 1:
                    start = (date.getDay() == 7);
                    break;
                case 3:
                    start = (date.getDay() == 5);
                    break;
                case 5:
                    start = (date.getDay() == 10);
                    break;
                case 7:
                    start = (date.getDay() == 8);
                    break;
            }

            if (start)
                return "תענית בה\"ב";
        }

        return "";
    }

    public static String haman(final HebrewDate date)
    {
        if (date.getParasha()[0].equals(Parasha.בשלח) && date.getDayOfWeak() == 3)
            return "פרשת המן";

        return "";
    }

    public static String shira(final HebrewDate date)
    {
        if (date.getParasha()[0].equals(Parasha.בשלח) && date.getDayOfWeak() == 7)
            return "שירת הים פסוק פסוק";

        return "";
    }

    public static String shekel(final HebrewDate date)
    {
        if (date.getMonthAndDay().equals("יג אדר") || date.getMonthAndDay().equals("יג אדר-ב"))
            return "יש נוהגים לתת לאחר תפילת מנחה זכר למחצית השקל";

        return "";
    }

    public static String ptira(final HebrewDate date)
    {
        if (date.getMonth() == 2 && date.getDay() == 11)
            return "פטירת רחל אימנו";

        if (date.getMonth() == (6 + (date.isLeapYear()?1:0)) && date.getDay() == 7)
            return "פטירת משה רבינו";

        return "";
    }



}
