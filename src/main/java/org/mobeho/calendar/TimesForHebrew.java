package org.mobeho.calendar;

import org.mobeho.calendar.cyclic.SummerTime;
import org.mobeho.calendar.cyclic.SunRiseAndSet;

public class TimesForHebrew
{
    private static HebrewDate date;
    private static Location location;

    public static TimesForHebrew of(HebrewDate date, Location location)
    {
        TimesForHebrew me = new TimesForHebrew();
        me.date = date;
        me.location = location;
        return me;
    }

    public String[] getSunSetAndRise()
    {
        double offset = 2D + (SummerTime.isSummnertime(date) ? 1D: 0D);
        return SunRiseAndSet.asString(offset, location.latitude, location.longitude, date.getChrisDayInYear());
    }

    public boolean isSummnerTime()
    {
        return SummerTime.isSummnertime(date);
    }

    public String getSummnerTimeTitle()
    {
        return SummerTime.getInfo(date);
    }

    public enum Location
    {
        Tel_Aviv(32.1004629, 34.812675),
        Modiin(31.897319, 35.008280),
        Jerusalem(31.777974, 35.235640);

        private double latitude;
        private double longitude;

        Location(double latitude, double longitude)
        {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
