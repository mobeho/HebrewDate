package org.mobeho.calendar;

import org.junit.Test;
import org.mobeho.calendar.cyclic.DafYomiBavli;
import org.mobeho.calendar.cyclic.SummerTime;
import org.mobeho.calendar.cyclic.SunRiseAndSet;

import static junit.framework.TestCase.*;

public class CyclicTest
{
    @Test
    public void daylightSavingTime()
    {
        HebrewDate date = HebrewDate.ofChris(2021, 1, 1);
        assertEquals(HebrewDate.ofChris(2021, 3, 26), SummerTime.getStart(date));
        assertEquals(HebrewDate.ofChris(2021, 10, 30), SummerTime.getEnd(date));

        date = HebrewDate.ofChris(2021, 3, 24);
//        assertEquals("בשעון חורף", SummerTime.getDayInfo(date));
        assertFalse(SummerTime.isSummnertime(date));

        date.addDays(1);
        assertEquals("סוף שעון חורף", SummerTime.getDayInfo(date));
        assertFalse(SummerTime.isSummnertime(date));

        date.addDays(1);
        assertEquals("תחילת שעון קיץ", SummerTime.getDayInfo(date));
        assertTrue(SummerTime.isSummnertime(date));

        date.addDays(1);
//        assertEquals("בשעון קיץ", SummerTime.getDayInfo(date));

        date.addDays(217);
        assertEquals("סוף שעון קיץ", SummerTime.getDayInfo(date));
        assertTrue(SummerTime.isSummnertime(date));

        date.addDays(1);
        assertEquals("תחילת שעון חורף", SummerTime.getDayInfo(date));
        assertFalse(SummerTime.isSummnertime(date));

        date.addDays(1);
//        assertEquals("בשעון חורף", SummerTime.getDayInfo(date));
        assertFalse(SummerTime.isSummnertime(date));

        date.addDays(60);
//        assertEquals("בשעון חורף", SummerTime.getDayInfo(date));
        assertFalse(SummerTime.isSummnertime(date));
    }

    @Test
    public void checkSyiumim()
    {

        int machzor = 8;
        HebrewDate date = HebrewDate.of(5735, 10, 15);
        assertEquals("מחזור:" + machzor + " - ברכות ב", DafYomiBavli.getFullInfo(date));

        // הסיום הראשון היה ב ט"ו בשבט ה'תרצ"א, אבל הוא לא היה בן 2711 דפים
        // הסיום הראשון שהכיל 2711 דפים היה ב ח' בכסלו ה'תשמ"ג
        date = HebrewDate.of(5743, 3, 8);
        while (date.getYear() <= 6000)
        {
            assertEquals("מחזור:" + (machzor++) + " - נדה עג", DafYomiBavli.getFullInfo(date));
            date.addDays(2711);
        }

        date = HebrewDate.of(5747, 2, 7);
        assertEquals("בבא קמא מח", DafYomiBavli.getInfo(date));
        assertEquals(9, DafYomiBavli.getCycle(date));
        assertEquals(21, DafYomiBavli.getMasechetIndex(date));
        assertEquals("בבא קמא", DafYomiBavli.getMasechetName(date));
        assertEquals(48, DafYomiBavli.getPage(date));
        assertEquals("מח", DafYomiBavli.getPageName(date));
        assertEquals(53, DafYomiBavli.getCoveredCurrentCycle(date));
    }

    @Test
    public void showPlace()
    {
        System.out.println("");
        System.out.println("CyclicTest.showPlace");
        System.out.println("--------------------");
        HebrewDate date = HebrewDate.now();
        HebrewDate until = HebrewDate.of(date).addDays(100);
        for (; date.getDaysFromStart() < until.getDaysFromStart(); date.addDays(7))
        {
            String[] times = SunRiseAndSet.of(date, SunRiseAndSet.Location.Modiin);
            double[] numbers = SunRiseAndSet.as(date, SunRiseAndSet.Location.Modiin);
            System.out.println(date.toString() + ": " + times[0] + " " + times[1] + String.format(" [%.3f - %.3f]", numbers[0], numbers[1] ));
        }
    }
}
