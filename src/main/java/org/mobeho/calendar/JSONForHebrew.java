package org.mobeho.calendar;

import org.mobeho.calendar.hilchaty.Shabbat;
import org.mobeho.calendar.hilchaty.YearType;

public class JSONForHebrew
{
    public static String getYears(int shana, boolean direction, int size)
    {
        return getYears(shana, direction, size, (byte) 0);
    }

    /**
     * This method retries json that contains list of years with dynamic information for each
     * The default information will contain the "year" followed by the Christian year, and the "shnan" followed by the Hebrew year
     * Extra information can be added by the {@code shana}
     * @param shana The first year in the list
     * @param direction Subsequent years or previous years
     * @param size How many years starting from {@code shana}
     * @param mask Whats information to integrated (bit mask)
     * 1 - number of Months
     * 2 - number days in each year
     * 4 - "siman": the Hebrew type of the year
     * 8 - pos in the cycle of 19 years
     * @return json contains list of years with extra information
     */
    public static String getYears(int shana, boolean direction, int size, byte mask)
    {
        HebrewDate temp = HebrewDate.of(shana, 1, 1);
        StringBuilder builder = new StringBuilder("{\"list\":[");
        /* Future feature Backward
        if (!direction)
            shana -= size; */

        while(size-- > 0)
        {
            builder
                .append("{")
                .append("\"year\":").append(temp.getYear())
                .append(",\"shana\":").append("\"").append(temp.getYearString()).append("\"");
            if ((mask & 1) > 0)
                builder.append(",\"numberOfMonths\":").append(temp.getNumberOfMonths());
            if ((mask & 2) > 0)
                builder.append(",\"numberDaysInYear\":").append(temp.getNumberDaysInYear());
            if ((mask & 4) > 0)
                builder.append(",\"siman\":").append("\"").append(temp.getYearTypeName()).append("\"");
            if ((mask & 8) > 0)
                builder.append(",\"cycle\":").append("\"").append((temp.getYear() - 1) % 19 + 1).append("/").append(temp.getYear() / 19 + 1).append("\"");

            builder.append("},");
            temp.addYears(1);
        }
        builder.replace(builder.length() - 1, builder.length(), "]}");
        return builder.toString();
    }

    public static String getMonths(int shana)
    {
        HebrewDate temp = HebrewDate.of(shana, 1, 1);
        StringBuilder builder = new StringBuilder("{\"list\":[");

        int months = temp.getNumberOfMonths();
        for (int index = 1; index <= months; index++)
        {
            builder
                .append("{")
                .append("\"index\":").append(index)
                .append(",\"month\":").append("\"").append(temp.getMonthString()).append("\"");

            builder.append("},");
            temp.addMonths(1);
        }

        builder.replace(builder.length() - 1, builder.length(), "]}");
        return builder.toString();
    }

    public static String getDays(int shana, int month)
    {
        HebrewDate temp = HebrewDate.of(shana, month, 1);
        StringBuilder builder = new StringBuilder("{\"list\":[");

        int days = temp.getNumberDaysInMonth();
        for (int index = 1; index <= days; index++)
        {
            builder
                .append("{")
                .append("\"index\":").append(index)
                .append(",\"day\":").append("\"").append(temp.getDayString()).append("\"")
                .append(",\"weekDay\":").append("\"").append(temp.getDayOfWeakString()).append("\"");

            builder.append("},");
            temp.addDays(1);
        }

        builder.replace(builder.length() - 1, builder.length(), "]}");
        return builder.toString();
    }

    public static String getShabatot(int shana)
    {
        return getShabatot(shana, (byte)0);
    }

    /**
     * This method retries json that contains list of Shabatot for the specified year
     * @param shana the year required
     * @param mask Whats information to integrated (bit mask)
     * 1 - Number days in each year
     * 2 - The hebrew date of this Shabat
     * @return json contains list of Shabatot with extra information
     */
    public static String getShabatot(int shana, byte mask)
    {
        HebrewDate temp = HebrewDate.of(shana, 1,  1);
        YearType type = temp.getYearType();
        int bereshit = Shabbat.getFirstShabatDayInYear(type);
        temp.addDays(bereshit);
        StringBuilder builder = new StringBuilder("{\"list\":[");

        for (int day = bereshit; day <= type.getNumberDaysInYear(); day += 7)
        {
            builder
                .append("{")
                .append("\"index\":").append((day - bereshit) / 7 + 1)
                .append(",\"name\":").append("\"").append(Shabbat.getShabatName(type, day)).append("\"");
            if ((mask & 1) > 0)
                builder.append(",\"dayInYear\":").append(day);
            if ((mask & 2) > 0)
                builder.append(",\"taarich\":").append("\"").append(temp.getMonthAndDay()).append("\"");

            builder.append("},");
            temp.addDays(7);
        }

        builder.replace(builder.length() - 1, builder.length(), "]}");
        return builder.toString();
    }
}
