package org.mobeho.calendar;

import org.junit.Test;
import org.mobeho.calendar.cyclic.DafYomiBavli;
import org.mobeho.calendar.cyclic.SummerTime;
import org.mobeho.calendar.cyclic.SunRiseAndSet;
import java.util.Calendar;

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
    public void ShowPlace()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        int days = cal.get(Calendar.DAY_OF_YEAR);

        double[] results = SunRiseAndSet.getTimes(2, 31.777970, 35.235416, days);
        Double morningTime = results[0];
        Double riseTime = results[1];
        Double noonTime = results[2];
        Double setTime = results[3];
        Double eveningTime = results[4];

        System.out.print("Morning: "+ SunRiseAndSet.timeToString(morningTime));
        System.out.print(" | Rise: "+ SunRiseAndSet.timeToString(riseTime));
        System.out.print(" | Noon: " + SunRiseAndSet.timeToString(noonTime));
        System.out.print(" | Set: " + SunRiseAndSet.timeToString(setTime));
        System.out.print(" | Evening: " + SunRiseAndSet.timeToString(eveningTime));
        System.out.println("\n");
    }
}
