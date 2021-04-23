package org.mobeho.calendar.hilchati.weak;

import org.mobeho.calendar.calendar.YearType;

import java.util.ArrayList;
import java.util.List;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class Shabat
{

    public static int getLastShabatDayInYear(YearType yearType)  { return yearType.getNumberDaysInYear() - yearType.getPesachDay() % 7 - 1;}

    public static int countSfarim(YearType yearType, int dayInYear)
    {
        Parasha[] parashot = Shabat.getShabat(yearType, dayInYear);
        if (parashot[0] == null)
            return 0;

        return 1
                + (parashot.length > 1 && parashot[1].index >= Parasha.ראש_חודש.index && parashot[1].index <= Parasha.החודש.index ? 1 : 0)
                + (parashot.length > 2 && parashot[2].index >= Parasha.ראש_חודש.index && parashot[2].index <= Parasha.החודש.index ? 1 : 0);
    }


    public static String getHaftaraSpecial(YearType yearType, int dayInYear, Parasha.Eda eda)
    {
        if (isHaftaraSpecial(yearType, dayInYear))
            return getHaftara(yearType, dayInYear, eda);

        return "";
    }

    public static String getHaftara(YearType yearType, int dayInYear, Parasha.Eda eda)
    {
        Parasha[] parashot = Shabat.getShabat(yearType, dayInYear);
        if (parashot[0] == null)
            return "";

        Parasha haftara = parashot[0];
        if (parashot.length == 2)
            haftara = parashot[1];
        if (parashot.length == 3)
            haftara = parashot[2];

        if (haftara == Parasha.ראש_חודש && eda == Parasha.Eda.SFARADI && yearType.getPesachDay() == 7)
            return Parasha.ראה.sfaradi;

        switch (eda)
        {
            case ASHKENAZI:
                return haftara.ashkenazi;

            case SFARADI:
                return haftara.sfaradi;
        }

        return "";
    }

    public static boolean isHaftaraSpecial(YearType yearType, int dayInYear)
    {
        Parasha[] parashot = Shabat.getShabat(yearType, dayInYear);
        if (parashot[0] == null)
            return false;

        return parashot[0].index >= Parasha.שבת_וראש_השנה.index || (parashot.length > 1 && parashot[1].index >= Parasha.שבת_וראש_השנה.index) || (parashot.length > 2 && parashot[2].index >= Parasha.שבת_וראש_השנה.index);
    }

    /**
     * Get day in year from shabatIndex
     * @param yearType of the year
     * @param parasha to search for
     * @param secondPhase Only when there are two Vayelech, false for the one in Tishrei, true for the one in Elul
     * @return day in year
     */
    public static int getDayInYear(YearType yearType, Parasha parasha, boolean secondPhase)
    {
        int shabatIndex = parasha.index;

        // Shabat is special - not shabatIndex
        if (shabatIndex >= Parasha.שבת_וראש_השנה.index)
        {
            if (Parasha.שבת_וראש_השנה.index == shabatIndex && yearType.getFirstDay() == 7)
                return 1;

            else if (Parasha.שבת_שובה.index == shabatIndex)
                return 8 - yearType.getFirstDay() % 7;

            else if (Parasha.שבת_ויום_כיפור.index == shabatIndex && yearType.getFirstDay() == 5)
                return 10;

            else if (Parasha.שבת_וסוכות.index == shabatIndex && yearType.getFirstDay() == 7)
                return 15;

            else if (Parasha.שבת_חול_המועד_סוכות.index == shabatIndex && yearType.getFirstDay() != 7)
                return 22 - yearType.getFirstDay();

            else if (Parasha.שבת_ושמיני_עצרת.index == shabatIndex && yearType.getFirstDay() == 7)
                return 22;

            else if (Parasha.חנוכה.index == shabatIndex)
                return 92 - yearType.getFirstDay();

            else if (Parasha.הגדול.index == shabatIndex)
                return yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15 + yearType.getPesachDay());

            else if (Parasha.שבת_ופסח.index == shabatIndex && yearType.getPesachDay() == 7)
                return yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15);

            else if (Parasha.שבת_חול_המועד_פסח.index == shabatIndex && yearType.getPesachDay() != 7 && yearType.getPesachDay() != 1)
                return yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 8 + yearType.getPesachDay());

            else if (Parasha.שבת_ושביעי_של_פסח.index == shabatIndex && yearType.getPesachDay() == 1)
                return yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 9);

            return -1;
        }

        int firstDay = yearType.getFirstDay();

        if (shabatIndex == (Parasha.האזינו.index))
        {
            if (firstDay == 5)
                return 3;
            else
                return 15 - firstDay;
        }

        else if ((shabatIndex == (Parasha.וילך.index)))
        {
            // Year that doesn't contain וילך at all
            if (YearType.הכז.equals(yearType) || YearType.החא.equals(yearType) || YearType.השא.equals(yearType) || YearType.זחא.equals(yearType))
                return -1;

            // Year that contains וילך at start of the year
            if (YearType.בשז.equals(yearType) || YearType.גכז.equals(yearType))
                return 8 - firstDay;

            if (YearType.השג.equals(yearType) || YearType.זחג.equals(yearType) || YearType.זשג.equals(yearType) || YearType.זשה.equals(yearType))
                return yearType.getNumberDaysInYear() - yearType.getPesachDay() - 1;

            //בחג || בחה || בשה || בשז || גכה
            if (!secondPhase)
                return 8 - firstDay;

            // Year that contains וילך at the end of the year
            return yearType.getNumberDaysInYear() - yearType.getPesachDay() - 1;
        }

        int week = Convert.parashaToWeek(yearType, shabatIndex);
        return 29 - (yearType.getFirstDay() % 7) + week * 7;
    }


    // In chul there are some Shabatot that are double
    public static Parasha[] getShabat(YearType yearType, int dayInYear)
    {
        if (dayInYear > yearType.getNumberDaysInYear())
            return new Parasha[]{null};

        boolean mechubarot = false;
        int shabat = dayInYear;

        if (yearType.getFirstDay() == 7 && dayInYear == 1)
            return new Parasha[]{Parasha.שבת_וראש_השנה};

        // Vayelech
        int theDay = (8 - yearType.getFirstDay() % 7);
        if (yearType.getFirstDay() < 5 && inWeek(dayInYear, theDay))
            return new Parasha[]{Parasha.וילך};
        else if (yearType.getFirstDay() > 3 && inWeek(dayInYear, theDay))
            return new Parasha[]{Parasha.האזינו};

        // Hahazinu
        theDay = (15 - yearType.getFirstDay() % 7);
        if (yearType.getFirstDay() < 5 && inWeek(dayInYear, theDay))
            return new Parasha[]{Parasha.האזינו};
        else if (yearType.getFirstDay() == 5 && inWeek(dayInYear, theDay))
            return new Parasha[]{Parasha.שבת_ויום_כיפור};
        else if (yearType.getFirstDay() == 7 && inWeek(dayInYear, theDay))
            return new Parasha[]{Parasha.שבת_וסוכות};

        // Shabat in Sukut
        theDay = (22 - yearType.getFirstDay() % 7);
        if (yearType.getFirstDay() <= 5 && inWeek(dayInYear, theDay))
            return new Parasha[]{Parasha.שבת_חול_המועד_סוכות};
        else if (yearType.getFirstDay() > 5 && inWeek(dayInYear, theDay))
            return new Parasha[]{Parasha.שבת_ושמיני_עצרת};

        // Bereshit
        int bereshit = (29 - yearType.getFirstDay() % 7);

        // Veikehl-Pkudei
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 29 + yearType.getPesachDay());
        if (!yearType.isLeap() && yearType != YearType.השא && dayInYear >= theDay - 6)
        {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Shabat Pesach
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15);
        if (yearType.getPesachDay() == 7 && dayInYear >= theDay - 6 && dayInYear <= theDay)
            return new Parasha[]{Parasha.שבת_ופסח};

        // Shabat BePesach
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 8 + yearType.getPesachDay());
        if (dayInYear >= theDay - 6)
        {
            if (yearType.getPesachDay() != 1 && dayInYear <= theDay)
                return new Parasha[]{Parasha.שבת_חול_המועד_פסח};
            else shabat -= 7; // less Parasha due to Shabat be Pesach
        }

        // Shabat Shviee Pesach
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 9);
        if (yearType.getPesachDay() == 1 && dayInYear >= theDay - 6 && dayInYear <= theDay)
            return new Parasha[]{Parasha.שבת_ושביעי_של_פסח};

        // Tazriaa Metzora
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 23 + yearType.getPesachDay());
        if (!yearType.isLeap() && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Acharie Mot Kedoshim
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 16 + yearType.getPesachDay());
        if (!yearType.isLeap() && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Behar Bechukotai
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 2 + yearType.getPesachDay());
        if (!yearType.isLeap() && yearType != YearType.הכז && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Matot Masei
        theDay = yearType.getNumberDaysInYear() - (29 + 28 + yearType.getPesachDay() % 7);
        if (!(yearType.getPesachDay() == 7 && yearType.isLeap()) && yearType != YearType.החא && yearType != YearType.השג && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Nitzavim Vayelech
        theDay = yearType.getNumberDaysInYear() - (1 + yearType.getPesachDay() % 7);
        if (theDay < (yearType.getNumberDaysInYear() - 2) && theDay > (yearType.getNumberDaysInYear() - 7) && dayInYear >= theDay - 6) {
            if (dayInYear <= theDay) mechubarot = true;
            else shabat += 7;
        }

        // Shabat and Rosh Hashan for the next year
        theDay = yearType.getNumberDaysInYear() + 1;
        if (yearType.getPesachDay() == 5 && dayInYear >= theDay - 6)
            return new Parasha[]{Parasha.שבת_וראש_השנה};

        List<Parasha> parashot = new ArrayList<>();

        int pos = (shabat + 6 - bereshit) / 7;
        parashot.add(Parasha.values()[pos]);

        if (mechubarot)
            parashot.add(Parasha.values()[pos+1]);

        Parasha parasha = isWeakOfRoshChodesh(yearType, dayInYear);
        if (parasha != null)
            parashot.add(parasha);

        parasha = isWeakOfChanuka(yearType, dayInYear);
        if (parasha != null)
            parashot.add(parasha);

        parasha = isWeakOf4Shabtot(yearType, dayInYear);
        if (parasha != null)
        {
            int lastPos = parashot.size() - 1;
            // 4 Shabtot in override Parasha.ראש_חודש or Parasha.ערב_ראש_חודש
            if (Parasha.ראש_חודש.equals(parashot.get(lastPos))
                ||
                Parasha.ערב_ראש_חודש.equals(parashot.get(lastPos)))
                parashot.set(lastPos, parasha);
            else
                parashot.add(parasha);
        }

        parasha = isWeakOfShabatPurimYerushalim(yearType, dayInYear);
        if (parasha != null)
            parashot.add(parasha);

        parasha = isWeakOfShabatShuva(yearType, dayInYear);
        if (parasha != null)
            parashot.add(parasha);

        parasha = isWeakOfShabatHagadol(yearType, dayInYear);
        if (parasha != null)
            parashot.add(parasha);

        return parashot.toArray(new Parasha[parashot.size()]);
    }

    private static boolean inWeek(int dayInYear, int theDay)
    {
        return dayInYear >= theDay - 6 && dayInYear <= theDay;
    }

    public static Parasha isWeakOfRoshChodesh(YearType yearType, int dayInYear)
    {
        int[] convert = getMonthDay(yearType, dayInYear);
        if (convert[0] == -1)
            return null;

        int month = convert[0];
        int day = convert[1];
        int allDyas = convert[2];
        int shabat = (7 - (yearType.getFirstDay() + dayInYear -1) % 7) % 7;

        // Rosh Hashana is skipped
        if (month == 12 + (yearType.isLeap() ? 1 : 0))
            return null;

        if (day == 1 && shabat  == 0)
            return Parasha.ראש_חודש;

        if (day == allDyas - shabat)
        {
            if (allDyas == 30)
                return Parasha.ראש_חודש;
            else
                return Parasha.ערב_ראש_חודש;
        }

        if (day == allDyas - shabat + 1)
            return Parasha.ראש_חודש;

        if (day == allDyas - shabat - 1)
            return Parasha.ערב_ראש_חודש;

        return null;
    }

    private static Parasha isWeakOfChanuka(YearType yearType, int dayInYear)
    {
        // Hanuka
        int holiday = 92 - yearType.getFirstDay();
        if (dayInYear >= holiday - 6 && dayInYear <= holiday)
            return Parasha.חנוכה;

        holiday = 99 - yearType.getFirstDay();
        if (yearType.getFirstDay() == 7 && yearType.getBalance() == 1 && dayInYear >= holiday - 6 && dayInYear <= holiday)
            return Parasha.חנוכה_ב;

        return null;
    }

    private static Parasha isWeakOf4Shabtot(YearType yearType, int dayInYear)
    {
        int holiday = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 30	+ 27 + yearType.getPesachDay());
        if (dayInYear > holiday - 7 && dayInYear <= holiday)
            return Parasha.שקלים;

        holiday = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 30	+ 13 + (yearType.getPesachDay() == 1 ? 7 : 0) + yearType.getPesachDay());
        if (dayInYear > holiday - 7 && dayInYear <= holiday)
            return Parasha.זכור;

        holiday = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 30	+ 6 + yearType.getPesachDay()%7);
        if (dayInYear > holiday - 7 && dayInYear <= holiday)
            return Parasha.פרה;

        holiday = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 29 + yearType.getPesachDay()%7);
        if (dayInYear > holiday - 7 && dayInYear <= holiday)
            return Parasha.החודש;

        return null;
    }

    private static Parasha isWeakOfShabatPurimYerushalim(YearType yearType, int dayInYear)
    {
        // Purim Yerushalim
        int holiday = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 30	+ 14);
        if (yearType.getPesachDay() == 1 && dayInYear >= holiday - 6 && dayInYear <= holiday)
            return Parasha.פורים_מוקפין;
        return null;

    }

    private static Parasha isWeakOfShabatHagadol(YearType yearType, int dayInYear)
    {
        int theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 22);
        if (yearType.getPesachDay() == 7 && dayInYear >= theDay - 6 && dayInYear <= theDay)
            return Parasha.הגדול;

        // Shabat BePesach
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15 + yearType.getPesachDay());
        if (dayInYear >= theDay - 6)
        {
            if (yearType.getPesachDay() != 1 && dayInYear <= theDay)
                return Parasha.הגדול;
        }

        // Shabat Shviee Pesach
        theDay = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 16);
        if (yearType.getPesachDay() == 1 && dayInYear >= theDay - 6 && dayInYear <= theDay)
            return Parasha.הגדול;

        return null;
    }

    private static Parasha isWeakOfShabatShuva(YearType yearType, int dayInYear)
    {
        int theDay = 8 - yearType.getFirstDay() % 7;
        if (dayInYear >= theDay - 6 && dayInYear <= theDay)
            return Parasha.שבת_שובה;

        return null;
    }

    public static int[] getMonthDay(YearType yearType, int dayInYear)
    {
        if (dayInYear <= 0 || dayInYear > yearType.getNumberDaysInYear())
            return new int[]{-1, -1, -1};

        int month = 1;
        for (; dayInYear > yearType.getNumberDaysOfMonth(month); month++)
            dayInYear -= yearType.getNumberDaysOfMonth(month);

        return new int[]{month, dayInYear, yearType.getNumberDaysOfMonth(month)};
    }

}

//        BERESHIT=0, NOACH, LECHLECHA, VEYERA, CHAYESARA, TOLDOT, VAYETSE, VAYISHLACH, VAYESHEV, MIKETS, VAYIGASH, VAYCHI,
//        SHMOT, VAERA, BO, BESHALACH, ITRO, MISHPATIM, TRUMA, TETSAVE, KITISA, VAYAKHEL, PKUDEI,
//        VAYIKRA, TSAV, SHMINI, TAZRIA, METSORA, ACHARIMOT, KDOSHIM, EMOR, BEHAR, BESHUKOTAY,
//        BAMIDBAR, NASO, BEHAHALOTCHA, SHLACHLECHA, KORACH, CHUKAT, BALAK, PINCHAS, MATOT, MASEI,
//        DVARIM, VAETCHANAN, EKEV, REE, SHOFTIM, KITETSE, KITAVO, NITSAVIM, VAYELECH, HAAZINU,
//        SHABAT_VEROSH_HASHANA=100, SHABAT_VYOM_KIPUR, SHABT_SUKOT, SHABAT_BESUKOT, SHABAT_VESHMINI_ATSERET, SHABAT_PESACH, SHABAT_BEPESACH
