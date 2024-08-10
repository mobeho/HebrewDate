package org.mobeho.calendar.cyclic;

import org.mobeho.calendar.HebrewDate;

import java.util.Arrays;

// Base on http://www.sci.fi/~benefon/rscalc_cpp.html
public class SunRiseAndSet
{
    private static double SUN_RADIUS = 0.265D; // The sun radius in degrees
    private static double ATHMOSPHERIC_REFRACTION = 34D / 60D; // Atmosphere refraction degrees
    private static double RADs = Math.PI / 180D;

    private static double ISRAEL_TIMEZONE = 2D;

    public static String[] of(HebrewDate date, Location location)
    {
        double offset = ISRAEL_TIMEZONE + (SummerTime.isSummnertime(date) ? 1D: 0D);
        return SunRiseAndSet.asString(offset, location.latitude, location.longitude, date.getChrisDayInYear());
    }

    public static double[] as(HebrewDate date, Location location)
    {
        double offset = ISRAEL_TIMEZONE + (SummerTime.isSummnertime(date) ? 1D: 0D);
        return asNumbers(offset, location.latitude, location.longitude, date.getChrisDayInYear());
    }

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

    public static double stringToTime(String timeStr)
    {
        String[] parts = timeStr.split(":");

        // Parse hours, minutes, and seconds
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        if (parts.length == 3)
        {
            try
            {
                // Format is H:MM:SS
                hours = Integer.parseInt(parts[0]);
                if (hours < 0 || hours > 23)
                    return -1.0;
                minutes = Integer.parseInt(parts[1]);
                if (minutes < 0 || minutes > 59)
                    return -1.0;
                seconds = Integer.parseInt(parts[2]);
                if (seconds < 0 || seconds > 59)
                    return -1.0;
            }
            catch (Exception ignore)
            {
                return -1.0;
            }
        }
        else if (parts.length == 2)
        {
            // Format is H:MM or MM:SS
            if (parts[0].matches("\\d+"))
            {
                // Assume the format is H:MM
                hours = Integer.parseInt(parts[0]);
                minutes = Integer.parseInt(parts[1]);
            }
            else
            {
                // Assume the format is MM:SS
                minutes = Integer.parseInt(parts[0]);
                seconds = Integer.parseInt(parts[1]);
            }
        }
        else if (parts.length == 1)
        {
            // Format is MM or SS (only for special cases)
            if (parts[0].matches("\\d+"))
            {
                minutes = Integer.parseInt(parts[0]);
            }
            else
            {
                seconds = Integer.parseInt(parts[0]);
            }
        }
        else
        {
            return  -1.0;
        }

        // Convert to double
        double totalMinutes = hours * 60.0 + minutes;
        double totalHours = totalMinutes / 60.0 + seconds / 3600.0;

        return totalHours;
    }

    // Display decimal time in hours, minutes and second
    public static String timeToString(double time)
    {
        int hour = (int) time;
        time -= (double) hour;
        int minutes = (int) (time *= 60.0);
        time -= (double) minutes;
        int seconds = (int) (time *= 60.0);
        return String.format("%02d:%02d:%02d", hour, minutes, seconds);
    }

    // Display decimal time in hours and minutes, with round options
    public static String timeToString(double time, boolean roundUp)
    {
        int hour = (int) time;
        time -= (double) hour;
        int minutes = (int) (time *= 60.0);
        time -= (double) minutes;
        int seconds = (int) (time *= 60.0);

        if (roundUp)
        {
            if (seconds > 5)
                minutes++;
        }
        else
        {
            if (seconds > 29)
                minutes++;
        }

        if (minutes == 60)
        {
            hour++;
            minutes = 0;
        }

        if (hour == 24)
            hour = 0;

        return String.format("%02d:%02d", hour, minutes);
    }


    public enum Location
    {
        Or_Yehuda(32.0306, 34.8533, "אור יהודה"),
        Or_Aqiva(32.5, 34.9167, "אור עקיבא"),
        Ofaqim(31.3167, 34.6167, "אופקים"),
        Eilat(29.5569, 34.9517, "אילת"),
        Elad(32.0522, 34.9511, "אלעד"),
        Arad(31.2611, 35.2153, "ארד"),
        Ashdod(31.8, 34.65, "אשדוד"),
        Ashqelon(31.6667, 34.5667, "אשקלון"),

        Beer_Yaaqov(31.9425, 34.8336, "באר יעקב"),
        Beersheba(31.2589, 34.7997, "באר שבע"),
        Bet_Shean(32.5, 35.5, "בית שאן"),
        Bet_Shemesh(31.7456, 34.9867, "בית שמש"),
        Bene_Beraq(32.0833, 34.8333, "בני ברק"),
        Bat_Yam(32.0167, 34.75, "בת ים"),

        Givat_Shemuel(32.0781, 34.8475, "גבעת שמואל"),
        Givatayim(32.0714, 34.81, "גבעתיים"),
        Gedera(31.8119, 34.7772, "גדרה"),
        Glil_Yam(32.7019, 35.3033, "גליל ים"),
        Gan_Yavne(31.7822, 34.7053, "גן יבנה"),

        Dimona(31.0667, 35.0333, "דימונה"),

        Hod_HaSharon(32.15, 34.8833, "הוד השרון"),
        Herzliyya(32.1653, 34.8458, "הרצליה"),

        Hadera(32.45, 34.9167, "חדרה"),
        Holon(32.0167, 34.7667, "חולון"),
        Haifa(32.8192, 34.9992, "חיפה"),

        Tveriah(32.7944, 35.5333, "טבריה"),
        Tirat_Hakarmel(32.7667, 34.9667, "טירת הכרמל"),

        Yehud(32.0333, 34.8833, "יהוד"),
        Yoqneam(32.6594, 35.11, "יקנעם"),
        Jerusalem(31.777974, 35.235640, "ירושלים"),

        Kefar_Yona(32.3171, 34.9358, "כפר יונה"),
        Kefar_Sava(32.1714, 34.9083, "כפר סבא"),
        Karmiel(32.9136, 35.2961, "כרמיאל"),

        Lod(31.9519, 34.8881, "לוד"),

        Migdal_HaEmeq(32.6714, 35.2406, "מגדל העמק"),
        Modiin(31.897319, 35.008280, "מודיעין"),
        Maalot(33.0167, 35.2708, "מעלות"),

        Nahariyya(33.0058, 35.0989, "נהריה"),
        Nes_Ziyyona(31.9333, 34.8, "נס ציונה"),
        Netanya(32.3286, 34.8567, "נתניה"),
        Netivot(31.4167, 34.5833, "נתיבות"),
        Nesher(32.7711, 35.0394, "נשר"),


        Akko(32.9278, 35.0817, "עכו"),
        Afula(32.6064, 35.2881, "עפולה"),
        Atlit(32.6872, 34.9383, "עתלית"),


        Pardes_Hanna(32.4711, 34.9675, "פרדס חנה"),
        Petah_Tiqwa(32.0889, 34.8864, "פתח תקווה"),

        Zfat(32.9658, 35.4983, "צפת"),

        Qiryat_Ono(32.0636, 34.8553, "קרית אונו"),
        Qiryat_Ata(32.8, 35.1, "קרית אתא"),
        Qiryat_Bialik(32.8333, 35.0833, "קרית ביאליק"),
        Qiryat_Gat(31.6061, 34.7717, "קרית גת"),
        Qiryat_Yam(32.8333, 35.0667, "קרית ים"),
        Qiryat_Mozqin(32.8333, 35.0833, "קרית מוצקין"),
        Qiryat_Malakhi(31.7292, 34.7461, "קרית מלאכי"),
        Qiryat_Shemona(33.2075, 35.5697, "קרית שמונה"),

        Rosh_HaAyin(32.0956, 34.9567, "ראש העין"),
        Rishon_LeZiyyon(31.95, 34.8, "ראשון לציון"),
        Rehovot(31.8969, 34.8167, "רחובות"),
        Ramla(31.9275, 34.8625, "רמלה"),
        Ramat_Gan(32.07, 34.8236, "רמת גן"),
        Ramat_HaSharon(32.15, 34.8333, "רמת השרון"),
        Raananna(32.1833, 34.8667, "רעננה"),

        Sederot(31.5228, 34.5953, "שדרות"),
        Tel_Aviv(32.1004629, 34.812675, "תל אביב");


        private final double latitude;
        private final double longitude;
        private final String text;

        Location(double latitude, double longitude, String text)
        {
            this.latitude = latitude;
            this.longitude = longitude;
            this.text = text;
        }

        public static Location of(String text)
        {
            if (text == null)
            {
                return null;
            }
            return Arrays.stream(Location.values()).filter(e -> text.equals(e.text)).findFirst().orElse(null);
        }

        public static String[] toArray()
        {
            return Arrays.stream(Location.values()).map(Location::toString).toArray(String[]::new);
        }

        @Override
        public String toString()
        {
            return text;
        }
    }

}
