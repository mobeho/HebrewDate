package org.mobeho.calendar.hilchaty;

import java.util.Arrays;

public enum ShabatHoli
{
    // Supported like all other Shabtot (int & out)
    ROSH_HASHANA("שבת וראש השנה", 100),
    YOM_KIPUR("שבת ויום כיפור", 101),
    SUKKOT("שבת וסוכות", 102),
    BESUKKOT("שבת חול המועד סוכות", 103),
    SHMINI("שבת ושמיני עצרת", 104),
    CHANUKA("שבת חנוכה", 105),
    SHIRA("שבת שירה", 106),
    HAGADOL("שבת הגדול", 107),
    PESACH("שבת ופסח", 108),
    BEPESACH("שבת חול המועד פסח", 109),
    SHVIEE("שבת ושביעי של פסח", 110),
    TESHUVA("שבת תשובה", 111),

    // Not supported like all other Shabtot - just for display
    SHKALIM("שקלים", 200),
    ZACHOR("זכור", 201),
    PARA("פרה", 202),
    HACHODESH("החודש", 203);

    private final String text;
    private final int val;

    ShabatHoli(String text, int val)
    {
        this.text = text;
        this.val = val;
    }

    public static ShabatHoli of(String text)
    {
        if (text == null) return null;
        return Arrays.stream(values()).filter(e -> text.equals(e.text)).findFirst().orElse(null);
    }

    public static ShabatHoli of(int val)
    {
        return Arrays.stream(values()).filter(e -> e.val == val).findFirst().orElse(null);
    }

    public int getVal()
    {
        return this.val;
    }

    @Override
    public String toString()
    {
        return this.text;
    }

    // Return number just in case Shabat hit the holiday, else -1
    public static int getDayInYear(YearType type, int index)
    {
        if (ShabatHoli.ROSH_HASHANA.getVal() == index && type.getFirstDay() == 7)
            return 1;

        else if (ShabatHoli.YOM_KIPUR.getVal() == index && type.getFirstDay() == 5)
            return 10;

        else if (ShabatHoli.SUKKOT.getVal() == index && type.getFirstDay() == 7)
            return 15;

        else if (ShabatHoli.BESUKKOT.getVal() == index && type.getFirstDay() != 7)
            return 22 - type.getFirstDay();

        else if (ShabatHoli.SHMINI.getVal() == index && type.getFirstDay() == 7)
            return 22;

        else if (ShabatHoli.CHANUKA.getVal() == index)
            return 92 - type.getFirstDay();

        else if (ShabatHoli.SHIRA.getVal() == index)
            return 134 - type.getFirstDay() + (type.getFirstDay() == 7 ? 7 : 0);

        else if (ShabatHoli.HAGADOL.getVal() == index)
            return type.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15 + type.getPesachDay());

        else if (ShabatHoli.PESACH.getVal() == index && type.getPesachDay() == 7)
            return type.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15);

        else if (ShabatHoli.BEPESACH.getVal() == index && type.getPesachDay() != 7 && type.getPesachDay() != 1)
            return type.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 8 + type.getPesachDay());

        else if (ShabatHoli.SHVIEE.getVal() == index && type.getPesachDay() == 1)
            return type.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 9);

        else if (ShabatHoli.TESHUVA.getVal() == index)
            return type.getNumberDaysInYear() - (1 + type.getPesachDay() %7);

        return -1;
    }

    // Check if Shabat Chol Hamoed Sukkot is in range between index and index+weeks
    public static boolean inSukkotInRange(YearType yearType, int index, int weeks)
    {
        final int shabat = yearType.getFirstDay() == 7 ? 4 : 3;
        if (index <= shabat && index + weeks >= shabat && yearType.getFirstDay() != 7)
            return true;

        // Check for next year between Roash Hasna ans Bereshit
        int shabatSukkotNextYear = (index + weeks) - yearType.numberOFShabatot;
        if (shabatSukkotNextYear > 0)
        {
            int nextFirstDayInWeek = yearType.getPesachDay() % 7 + 2;
            return nextFirstDayInWeek != 7 && shabatSukkotNextYear >= 3;
        }

        return false;
    }

    // Check if Shabat Chanuka is in range between index and index+weeks
    public static boolean isChanukaInRange(YearType yearType, int index, int weeks)
    {
        final int shabat = Shabbat.getPos(yearType, 92 - yearType.getFirstDay());
        return index <= shabat && index + weeks >= shabat;
    }

    // Check if Shabat Shira is in range between index and index+weeks
    public static boolean isShiraInRange(YearType yearType, int index, int weeks)
    {
        final int shabat = Shabbat.getPos(yearType, 134 - yearType.getFirstDay() + (yearType.getFirstDay() == 7 ? 7 : 0));
        return index <= shabat && index + weeks >= shabat;
    }

    // Check if Shabat Hagadol is in range between index and index+weeks
    public static boolean isHagadolInRange(YearType yearType, int index, int weeks)
    {
        final int shabat = Shabbat.getPos(yearType, yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 15 + yearType.getPesachDay()));
        return index <= shabat && index + weeks >= shabat;
    }

    // Check if Shabat Chol Hamoed Pesach is in range between index and index+weeks
    public static boolean isPesachInRange(YearType yearType, int index, int weeks)
    {
        int shabtatCholHamodePesachPos;
        if (YearType.גכה.equals(yearType) || YearType.בחג.equals(yearType) || YearType.בשה.equals(yearType) || YearType.זשג.equals(yearType))
            shabtatCholHamodePesachPos = yearType.getFirstDay() == 7 ? 4 : 3 + 25;

        else if (YearType.בחה.equals(yearType) || YearType.השג.equals(yearType) || YearType.זחג.equals(yearType))
            shabtatCholHamodePesachPos = yearType.getFirstDay() == 7 ? 4 : 3 + 29;

        else
            return false;

        return index <= shabtatCholHamodePesachPos && index + weeks >= shabtatCholHamodePesachPos;
    }

    // Check if Shabat Tshuva is in range between index and index+weeks
    public static boolean isTshuvaInRange(YearType yearType, int index, int weeks)
    {
        final int shabat = Shabbat.getPos(yearType, yearType.getNumberDaysInYear() - (1 + yearType.getPesachDay() %7));
        return index <= shabat && index + weeks >= shabat;
    }

    public static ShabatHoli is4Shabtot(YearType yearType, int dayInYear)
    {
        int holiday = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 29 + 30	+ 27 + yearType.getPesachDay());
        if (dayInYear > holiday - 7 && dayInYear <= holiday)
            return SHKALIM;

        holiday = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 29 + 30	+ 13 + (yearType.getPesachDay() == 1 ? 7 : 0) + yearType.getPesachDay());
        if (dayInYear > holiday - 7 && dayInYear <= holiday)
            return ZACHOR;

        holiday = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 29 + 30	+ 6 + yearType.getPesachDay()%7);
        if (dayInYear > holiday - 7 && dayInYear <= holiday)
            return PARA;

        holiday = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 29 + 29 + yearType.getPesachDay()%7);
        if (dayInYear > holiday - 7 && dayInYear <= holiday)
            return HACHODESH;

        return null;
    }


    public static String convertName(String value)
    {
        if ("שבת ראש השנה".equals(value)) return ShabatHoli.ROSH_HASHANA.toString();
        if ("שבת יום כיפור".equals(value)) return ShabatHoli.YOM_KIPUR.toString();

        if ("שבת סוכות".equals(value)) return ShabatHoli.SUKKOT.toString();

        if ("שבת בסוכות".equals(value)) return ShabatHoli.BESUKKOT.toString();
        if (("שבת חולה" + "\"" + "מ סוכות").equals(value)) return ShabatHoli.BESUKKOT.toString();
        if (("שבת חול" + "\"" + "מ סוכות").equals(value)) return ShabatHoli.BESUKKOT.toString();
        if (("חול" + "\"" + "מ סוכות").equals(value)) return ShabatHoli.BESUKKOT.toString();

        if ("שבת שמיני עצרת".equals(value)) return ShabatHoli.SHMINI.toString();

        // Diagnosis by Shabat name only
        value = value.replace(SHKALIM.toString(),"");
        value = value.replace(ZACHOR.toString(),"");
        value = value.replace(PARA.toString(),"");
        value = value.replace(HACHODESH.toString(),"");

        if ("שבת פסח".equals(value)) return ShabatHoli.PESACH.toString();

        if ("שבת בפסח".equals(value)) return ShabatHoli.BEPESACH.toString();
        if (("שבת חולה" + "\"" + "מ פסח").equals(value)) return ShabatHoli.BEPESACH.toString();
        if (("שבת חול" + "\"" + "מ פסח").equals(value)) return ShabatHoli.BEPESACH.toString();
        if (("חול" + "\"" + "מ פסח").equals(value)) return ShabatHoli.BEPESACH.toString();

        if ("שבת שביעי של פסח".equals(value)) return ShabatHoli.SHVIEE.toString();
        if ("שבת שביעי פסח".equals(value)) return ShabatHoli.SHVIEE.toString();
        return value;
    }
}