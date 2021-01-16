package org.mobeho.calendar.cyclic;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class SunRiseAndSet
{
    // Returns an angle in the range 0 to 2*Math.PI
    private static double angelInRange(double angel)
    {
        double dev = angel / (2D * Math.PI);
        double part = (2D * Math.PI) * (dev - Math.floor(dev));
        if (part < 0) part += (2D * Math.PI);
        return part;
    }

    // Display decimal hours in hours and minutes
    public static String timeToString(double time)
    {
        if (time == 0)
            return "NaN";

        int minutes = (int)((time - Math.floor(time)) * 60);
        int hour = (int)(Math.floor(time));
        if (minutes == 60)
        {
            hour++;
            minutes = 0;
        }
        if (hour == 24)
            hour = 0;

        return String.format("%02d:%02d", hour, minutes);
    }

    /// <param name="timeZone">Time zone</param>
    /// <param name="latit">+ North</param>
    /// <param name="longit">+ East</param>
    /// <param name="days">Days from start of the year</param>
    /// <param name="morningTime"></param>
    /// <param name="riseTime"></param>
    /// <param name="noonTime"></param>
    /// <param name="setTime"></param>
    /// <param name="evningTime"></param>
    public static double[] getTimes(double timeZone, double latit, double longit, double days)
    {

        double degs = 180D / Math.PI;
        double rads = Math.PI / 180D;
        double sunLongitude = angelInRange(280.461D * rads + .9856474D * rads * days);
        double sunAnomaly = angelInRange(357.528D * rads + .9856003D * rads * days);
        double sunElipticLongitude = angelInRange(sunLongitude + 1.915D * rads * Math.sin(sunAnomaly) + .02D * rads * Math.sin(2D * sunAnomaly));
        double eclipticObliquity = 23.439D * rads - .0000004D * rads * days;

        // Find the RA and DEC of the Sun
        double alpha = Math.atan2(Math.cos(eclipticObliquity) * Math.sin(sunElipticLongitude), Math.cos(sunElipticLongitude));
        double declin = Math.asin(Math.sin(eclipticObliquity) * Math.sin(sunElipticLongitude));

        // Find the Equation of Time in minutes
        double LL = sunLongitude - alpha;
        if (sunLongitude < Math.PI)
            LL += (2D * Math.PI);
        double equation = 1440D * (1D - LL / (2D * Math.PI));

        double SunDia = 0.5D * 0.53D;     // Sun Radius degrees
        double athmosphericRefraction = 34D / 60D; // Athmospheric refraction degrees //

        double dfo = rads * (SunDia + athmosphericRefraction);
        if (latit < 0.0)
            dfo = -dfo;

        double fo = Math.asin(Math.tan(declin + dfo) * Math.tan(latit * rads)) + Math.PI / 2D;

        if (fo == 0)
            return new double[]{};

        double df1 = rads * 8D;
        if (latit < 0D)
            df1 = -df1;

        double fi = Math.asin(Math.tan(declin + df1) * Math.tan(latit * rads)) + Math.PI / 2D;

        if (fi == 0)
            return new double[]{};

        double twilightLength = fi - fo;
        twilightLength = 12D * twilightLength / Math.PI; // convert length of twilight to hours
        // Conversion of angle to hours and minutes //
        double daylen = degs * fo / 7.5D;
        if (daylen < 0.0001D)
            daylen = 0D;

        double riseTime = (12D - 12.06042D * fo / Math.PI + timeZone - longit / 15D + equation / 60D);
        double setTime = (12D + 12.0592D * fo / Math.PI + timeZone - longit / 15D + equation / 60D);

        double noonTime = riseTime + 12D * fo / Math.PI;
        /*
        // Express altitude as degrees from the N horizon
        altmax = 90D + declin * degs - latit;
        if (latit < declin * degs)
            altmax = 180D - altmax; */

        double morningTime = riseTime - twilightLength;
        double evningTime = setTime + twilightLength;
        if (morningTime > 24D) morningTime = morningTime - 24D;
        else if (morningTime < 0D) morningTime = morningTime + 24D;
        if (evningTime > 24D) evningTime = evningTime - 24D;
        else if (evningTime < 0D) evningTime = evningTime + 24D;

        if (riseTime > 24D) riseTime = riseTime - 24D;
        else if (riseTime < 0D) riseTime = riseTime + 24D;
        if (setTime > 24D) setTime = setTime - 24D;
        else if (setTime < 0D) setTime = setTime + 24D;

        return new double[]{morningTime, riseTime, noonTime, setTime, evningTime/*, out double altmax*/};
    }
}
