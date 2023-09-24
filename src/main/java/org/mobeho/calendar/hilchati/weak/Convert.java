package org.mobeho.calendar.hilchati.weak;

import org.mobeho.calendar.calendar.YearType;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class Convert
{
    private static final boolean israel = true;

    static int parashaToWeek(YearType yearType, int parasha)
    {
        // Since reduceMechuberet() used also convertWeekToParasha, that comapre by >=
        // parasha should reduce here to allow valid check after (>) the index of the Shabat
        parasha--;
        int mecubarot = reduceMechuberet(yearType, parasha, Parasha.ויקהל.index);
        int pesach = balancePesach(yearType, parasha+1);
        mecubarot += reduceMechuberet(yearType, parasha, Parasha.תזריע.index);
        mecubarot += reduceMechuberet(yearType, parasha, Parasha.אחרי_מות.index);
        mecubarot += reduceMechuberet(yearType, parasha, Parasha.בהר.index);
        mecubarot += reduceMechuberet(yearType, parasha, Parasha.חקת.index); // Only for chul
        mecubarot += reduceMechuberet(yearType, parasha, Parasha.מטות.index);
        mecubarot += reduceMechuberet(yearType, parasha, Parasha.נצבים.index);

        return parasha - mecubarot - pesach;
    }


    /*
     * Calculating number of shabtot between index to index + week
     * #0 - How many parashot in Tishreri for this year
     * #1 - How many parashot for this year, from Bereshit until end of year
     * #2 - How many parashot in Tishreri in the next year
     * #3 - How many parashot after Tishreri in the next year
     *
     * Calculating if Shaba Chol Hamoed Sukkot will be:
     * #4 - 1 = Will be in this year
     * #5 - 1 = Will be in next year
     */
    public static int[] numbersOfParashot(YearType yearType, int index, int weeks)
    {
//      if ((index+weeks + balanceTishrei(yearType, index+weeks)) > yearType._numberOFShabatot)
//         return -1;

        int shabatTishreiHoliday = 1;
        int shabatPesach = 1;
        if ((index == 0) || // Soccut
            (index == -3 && yearType.getFirstDay() == 7) || // Rosh Hashan
            (index == -1 && yearType.getFirstDay() > 4)  // Yom Kipur
        )
        {
            shabatTishreiHoliday = 0;
            shabatPesach = 0;
        }
        else if (index < 1)
            shabatPesach = 0;
        else if (checkForPesach(yearType, index))
        {
            shabatTishreiHoliday = 0;
            shabatPesach = 0;
        }
        else
            shabatTishreiHoliday = 0;

        int[] i1 = weekToParasha(yearType, index);
        int[] i2 = weekToParasha(yearType, index + weeks);
        return new int[]{i2[0] + shabatTishreiHoliday - i1[0], i2[1] + shabatPesach - i1[1], i2[2] - i1[2], i2[3] - i1[3]};
    }

    /**
     * No of parashot by unformatted week
     * This function in limted to count parashot from Rosh Hashana until Bereshit next year (not included)
     *
     * @param yearType of the year
     * @param week     represent the week position in the year
     *                 -3(Rosh Hashana in shabat), -2, -1, 0(Usually Soccut) - until Bereshit
     *                 1 = Bereshit and so on until next year's Bereshit
     * @return 4 numbers:
     * #0 - Parashot index in Tishreri for this year
     * #1 - Parashot index for this year, from Bereshit until end of year
     * #2 - Parashot index in Tishreri in the next year
     * #3 - Parashot index after Tishreri in the next year
     */
    private static int[] weekToParasha(YearType yearType, int week)
    {
        int[] tishrei = balanceTishrei(yearType.getFirstDay(), week);

        int add = 0;
        add += reduceMechuberet(yearType, week + add, Parasha.ויקהל.index);
        add += balancePesach(yearType, week + add);
        add += reduceMechuberet(yearType, week + add, Parasha.תזריע.index);
        add += reduceMechuberet(yearType, week + add, Parasha.אחרי_מות.index);
        add += reduceMechuberet(yearType, week + add, Parasha.בהר.index);
        add += reduceMechuberet(yearType, week + add, Parasha.חקת.index); // Only for chul
        add += reduceMechuberet(yearType, week + add, Parasha.מטות.index);
        add += reduceMechuberet(yearType, week + add, Parasha.נצבים.index);

        int nextYearWeeks = (yearType.getFirstDay() == 7 ? 4 : 3) + week - yearType.getNumberOfShabatot();
        int[] nextTishreiParashot = new int[]{0, 0};
        int nextWeek = 0;
        if (nextYearWeeks > 0)
        {
            week -= nextYearWeeks;
            int nextFirstDayInWeek = yearType.getPesachDay() % 7 + 2;
            nextWeek = nextYearWeeks - (nextFirstDayInWeek == 7 ? 4 : 3);
            nextTishreiParashot = balanceTishrei(nextFirstDayInWeek, nextWeek);
        }

        return new int[]{tishrei[1], -tishrei[1] + week + tishrei[0] + add, nextTishreiParashot[1], Math.max(0, nextWeek)};
    }

    private static boolean checkForPesach(YearType yearType, int pos)
    {
        int add = 0;
        add += reduceMechuberet(yearType, pos, Parasha.ויקהל.index);
        // pos is immediately after pesach
        return (balancePesach(yearType, pos + add - 1) == 0 && balancePesach(yearType, pos + add) == -1);
    }

    /** All information regarding to Tishrei
     * @param getFirstDay of the year
     * @param week represent the week position in the year
     *  -3(Rosh Hashana in shabat), -2, -1, 0 (Usually Soccut)
     * #0 - Delta need to add to complete shabatot to PARASHOT
     * #1 - How many PARASHOT before week pos
     * #2 - 1 = Shabat sukkot/before, 0 = after
     */
    private static int[] balanceTishrei(int getFirstDay, int week)
    {
        if (getFirstDay == 7 || getFirstDay == 5)
        {
            // week = 0 + 1 =  1
            if (week >=  0) return new int[]{1, 1};
            // week = -1 + 2 =  1
            if (week >= -1) return new int[]{2, 1};
            // week = -2 + 3 = 1
            if (week >= -2) return new int[]{3, 1};
            // week = -3 + 3 = 0; Relevant only for FirstDay() == 7
            if (week >= -3) return new int[]{3, 0};
        }
        else /*if (yearType.getFirstDay() == 3 || yearType.getFirstDay() == 2)*/
        {
            // week =  0 + 2 = 2
            if (week >=  0) return new int[]{2, 2};
            // week = -1 + 3 = 2
            if (week >= -1) return new int[]{3, 2};
            // week = -2 + 3 = 1
            if (week >= -2) return new int[]{3, 1};
        }
        return new int[]{0, 0};
    }

    private static int reduceMechuberet(YearType yearType, int shabat, int shabattoCheck)
    {
        if (shabat >= shabattoCheck)
        {
            // 7 mark this is for this year end question, and not in the beginning (See the condition inside)
            boolean[] conditions = isMechubarot(yearType, shabattoCheck, 7);
            return (conditions[0] && conditions[1]) ? 1 : 0;
        }
        else
            return 0;
    }

    // -1 = Shabat Pesach or chol Hamoed Pesach was past
    private static int balancePesach(YearType yearType, int index)
    {
        if (!yearType.isLeap() && index > Parasha.צו.index) return -1;
        else if (yearType.getFirstDay() != 5 && index > Parasha.מצרע.index) return -1;
        else if (index > Parasha.אחרי_מות.index) return -1;
        return 0;
    }

    // Return two flags
    // 1stt flag if potentially they are mechubarot,
    // 2nd flag if actually there are for this year
    public static boolean[] isMechubarot(YearType yearType, int index1, int dayInYear)
    {
        boolean optional = false;
        boolean deFacto = false;

        if (isShabat(index1, Parasha.ויקהל) || isShabat(index1, Parasha.פקודי))
        {
            optional = true;
            deFacto =  !yearType.isLeap() && yearType != YearType.השא;
        }

        else if (isShabat(index1, Parasha.תזריע) || isShabat(index1, Parasha.מצרע))
        {
            optional = true;
            deFacto = !yearType.isLeap();
        }

        else if (isShabat(index1, Parasha.אחרי_מות) || isShabat(index1, Parasha.קדשים))
        {
            optional = true;
            deFacto = !yearType.isLeap();
        }

        else if (isShabat(index1, Parasha.בהר) || isShabat(index1, Parasha.בחקתי))
        {
            optional = true;
            deFacto = !yearType.isLeap() &&
                    ((yearType != YearType.הכז && israel) || (yearType == YearType.הכז && !israel));
        }

        else if (isShabat(index1, Parasha.מטות) || isShabat(index1, Parasha.מסעי))
        {
            optional = true;
            deFacto = yearType != YearType.החא && yearType != YearType.השג &&
                    (!israel || (yearType != YearType.בשז && yearType != YearType.גכז));
        }

        else if (isShabat(index1, Parasha.נצבים) || isShabat(index1, Parasha.וילך))
        {
            optional = true;
            deFacto = ( yearType == YearType.בחג || yearType == YearType.בשה || yearType == YearType.גכה || yearType == YearType.זשג
                    || yearType == YearType.בחה || yearType == YearType.השג || yearType == YearType.זחג || yearType == YearType.זשה
            ) && dayInYear > 6;
        }

        else if (isShabat(index1, Parasha.חקת) || isShabat(index1, Parasha.בלק))
        {
            optional = !israel;
            deFacto = !israel &&
                    ( yearType == YearType.בשה || yearType == YearType.גכה || yearType == YearType.בחה || yearType == YearType.זשה );
        }

        if (optional && deFacto)
            return new boolean[]{true, true};
        else if (optional)
            return new boolean[]{true, false};
        else
            return new boolean[]{false, false};
    }


    private static boolean isShabat(int indexd, Parasha shabat)
    {
        return  indexd == shabat.index;
    }
}
