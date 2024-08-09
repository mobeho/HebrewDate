package org.mobeho.calendar.cyclic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mobeho.calendar.cyclic.SunRiseAndSet.stringToTime;
import static org.mobeho.calendar.cyclic.SunRiseAndSet.timeToString;

public class SunRiseAndSetTest
{
    @Test
    public void testStringToTime()
    {
        assertEquals(-1.0, stringToTime("-2:00:00"), 0.0);
        assertEquals(-1.0, stringToTime("00:-2:00"), 0.0);
        assertEquals(-1.0, stringToTime("00:00:-2"), 0.0);
        assertEquals(-1.0, stringToTime("a:00:00"), 0.0);
        assertEquals(-1.0, stringToTime("00:b:00"), 0.0);
        assertEquals(-1.0, stringToTime("00:00:c"), 0.0);
        assertEquals(-1.0, stringToTime("24:00:00"), 0.0);
        assertEquals(-1.0, stringToTime("00:60:00"), 0.0);
        assertEquals(-1.0, stringToTime("00:00:60"), 0.0);
        assertEquals(10.05222, stringToTime("10:03:08"), 0.01);
        assertEquals(23.999, stringToTime("23:59:59"), 0.001);
    }

    @Test
    public void testStringToTime_timeToString()
    {
        assertEquals("00:00:00", timeToString(stringToTime("00:00:00")));
        assertEquals("10:03:08", timeToString(stringToTime("10:03:08")));
        assertEquals("23:59:59", timeToString(stringToTime("23:59:59")));
    }

    @Test
    public void testTimeToStringWihthRound()
    {
        assertEquals("00:00", timeToString(stringToTime("00:00:00"), true));
        assertEquals("00:00", timeToString(stringToTime("00:00:00"), false));
        assertEquals("10:04", timeToString(stringToTime("10:03:08"), true));
        assertEquals("10:03", timeToString(stringToTime("10:03:08"), false));
        assertEquals("10:04", timeToString(stringToTime("10:03:30"), true));
        assertEquals("10:04", timeToString(stringToTime("10:03:30"), false));
        assertEquals("00:00", timeToString(stringToTime("23:59:08"), true));
        assertEquals("00:00", timeToString(stringToTime("23:59:30"), false));
    }
}
