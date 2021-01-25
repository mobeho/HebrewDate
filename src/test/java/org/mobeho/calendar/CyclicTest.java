package org.mobeho.calendar;

import org.junit.Test;
import org.mobeho.calendar.cyclic.DafYomiBavli;
import org.mobeho.calendar.cyclic.SummerTime;
import static junit.framework.TestCase.assertEquals;

public class CyclicTest
{
    @Test
    public void daylightSavingTime()
    {
        HebrewDate date = HebrewDate.ofChris(2020, 3, 26);
        assertEquals("בשעון חורף", SummerTime.getInfo(date));
        date.addDays(1);
        assertEquals("תחילת שעון קיץ", SummerTime.getInfo(date));
        date.addDays(1);
        assertEquals("בשעון קיץ", SummerTime.getInfo(date));
        date.addDays(211);
        assertEquals("סוף שעון קיץ", SummerTime.getInfo(date));
        date.addDays(1);
        assertEquals("בשעון חורף", SummerTime.getInfo(date));
    }

    @Test
    public void checkSyiumim()
    {
        // הסיום הראשון היה ב ט"ו בשבט ה'תרצ"א, אבל הוא לא היה בן 2711 דפים
        // הסיום הראשון שהכיל 2711 דפים היה ב ח' בכסלו ה'תשמ"ג
        HebrewDate date = HebrewDate.of(5743, 3, 8);
        int machzor = 8;
        while (date.getYear() <= 6000)
        {
            assertEquals("מחזור:" + (++machzor) + " - מסכת:נדה דף:עב", new DafYomiBavli().getInfo(date));
            date.addDays(2711);
        }
    }

    @Test
    public void showPlace()
    {
        HebrewDate date = HebrewDate.now();
        HebrewDate until = HebrewDate.of(date).addDays(100);
        for (; date.getDaysFromStart() < until.getDaysFromStart(); date.addDays(7))
        {
            String[] times = TimesForHebrew.of(date, TimesForHebrew.Location.Modiin).getSunSetAndRise();
            System.out.println(date.toString() + ": " + times[0] + " " + times[1]);
        }
    }
}
