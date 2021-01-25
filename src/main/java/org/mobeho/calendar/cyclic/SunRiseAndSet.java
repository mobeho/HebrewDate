package org.mobeho.calendar.cyclic;

// Base on http://www.sci.fi/~benefon/rscalc_cpp.html
public class SunRiseAndSet
{
    private static double SUN_RADIUS = 0.265D; // The sun radius in degrees
    private static double ATHMOSPHERIC_REFRACTION = 34D / 60D; // Atmosphere refraction degrees
    private static double RADs = Math.PI / 180D;

    /**
     * @param timeZone Time zone
     * @param latitude + North
     * @param longitude + East
     * @param days Days from start of Jan 1st
     * @return tow string for sunrise and sunset in hh:mm:ss format
     */
    public static String[] asString(double timeZone, double latitude, double longitude, double days)
    {
        double[] times = asNumbers(timeZone, latitude, longitude, days);
        return new String[] {timeToString(times[0]), timeToString(times[1])};
    }

    /**
     * @param timeZone Time zone
     * @param latitude + North
     * @param longitude + East
     * @param days Days from start of Jan 1st
     * @return tow double represent sunrise and sunset
     */
    public static double[] asNumbers(double timeZone, double latitude, double longitude, double days)
    {
        double meanLongitude = angelInRange(280.461D * RADs + .9856474D * RADs * days);
        double meanAnomaly = angelInRange(357.5291D * RADs + 0.98560028D * RADs * days);
        double eclipticLongitude = angelInRange(meanLongitude + 1.9148D * RADs * Math.sin(meanAnomaly) + 0.02D * RADs * Math.sin(2D * meanAnomaly) + 0.00003D * RADs * Math.sin( 3D * meanAnomaly));
        double eclipticObliquity = 23.439D * RADs - .0000004D * RADs * days;
        double alpha = Math.atan2(Math.cos(eclipticObliquity) * Math.sin(eclipticLongitude), Math.cos(eclipticLongitude));
        double delta = Math.asin(Math.sin(eclipticObliquity) * Math.sin(eclipticLongitude));
        double minutes = 1440D * (1D - (meanLongitude - alpha + ((meanLongitude < Math.PI) ? (2D * Math.PI) : 0)) / (2D * Math.PI));
        double trueAltitude = Math.signum(latitude) * RADs * (SUN_RADIUS + ATHMOSPHERIC_REFRACTION);
        double hourAngle = Math.asin(Math.tan(delta + trueAltitude) * Math.tan(latitude * RADs)) + Math.PI / 2D;
        double dayHours = 12.07D * hourAngle / Math.PI;
        double middleHour = 12D + timeZone - longitude / 15D + minutes / 60D;
        double riseTime = (middleHour - dayHours) % 24D;
        double setTime = (middleHour + dayHours) % 24D;
        return new double[]{riseTime, setTime};
    }

    // Returns an angle in the range 0 to 2*Math.PI
    private static double angelInRange(double angel)
    {
        double dev = angel / (2D * Math.PI);
        double part = (2D * Math.PI) * (dev - Math.floor(dev));
        if (part < 0) part += (2D * Math.PI);
        return part;
    }

    // Display decimal hours in hours and minutes
    private static String timeToString(double time)
    {
        if (time == 0)
            return "NaN";

        int hour = (int) time;
        time -= hour;
        int minutes = (int) (time *= 60);
        time -= minutes;
        int seconds = (int) (time *= 60);
        return String.format("%02d:%02d:%02d", hour, minutes, seconds);
    }
}
