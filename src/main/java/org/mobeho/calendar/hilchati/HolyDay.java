package org.mobeho.calendar.hilchati;

import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.weak.Parasha;
import org.mobeho.calendar.hilchati.weak.Shabat;

import java.util.Arrays;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public enum HolyDay //implements SpecialClass
{
    א_ראש_השנה(1001), ב_ראש_השנה(1002),
    צום_גדליה(1003),
    יום_כיפור(1010),
    סוכות(1020), ב_סוכות(1021), ג_סוכות(1022), ד_סוכות(1023), ה_סוכות(1024), ו_סוכות(1025), הושענא_רבא(1026), שמחת_תורה(1027),
    א_חנוכה(1030), ב_חנוכה(1031), ג_חנוכה(1032), ד_חנוכה(1033), ה_חנוכה(1034), ו_חנוכה(1035), ז_חנוכה(1036), ח_חנוכה(1037),
    עשרה_בטבת(1040),
    טו_בשבט(1050),
    פורים_קטן(1059),
    תענית_אסתר(1060), פורים(1061), שושן_פורים(1062),
    פסח(1070), ב_פסח(1071), ג_פסח(1072), ד_פסח(1073), ה_פסח(1074), ו_פסח(1075), שביעי_פסח(1076),
    הזכרון(1080),העצמאות(1081),
    פסח_שני(1082),
    לג_בעומר(1090),
    ירושלים(1091),
    שבועות(1100),
    יז_בתמוז(1110),
    ט_באב(1111),
    טו_באב(1120);

    public enum Eda { ASHKENAZI, SFARADI; }

    public int index;
    public String ashkenazi;
    public String sfaradi;

    HolyDay(int index)
    {
        this.index = index;
    }

//    @Override
//    public String toString()
//    {
//        return ().replace("_"," ");
//    }

    public static HolyDay of(int index)
    {
        return Arrays.stream(values()).filter(e -> e.index == index).findFirst().orElse(null);
    }

    public static HolyDay of(String value)
    {
        if (value == null)
            return null;

//        value = value.replace("33","לג");

        value = value.replace("יום","");
        value = value.replace("חג","");
        value = value.replace(" של ","_");
        value = value.replace("נר","");

        value = value.replace("ראשון","א");
        value = value.replace("שני","ב");
        value = value.replace("שלישי","ג");
        value = value.replace("רביעי","ד");
        value = value.replace("חמישי","ה");
        value = value.replace("שישי","ו");
        value = value.replace("שביעי","ז");
        value = value.replace("שמיני","ח");

        value = value.replace("כפור", "כיפור");
        value = value.replace("סכות", "סוכות");
        value = value.replace("סוכת", "סוכות");
        value = value.replace("הזיכרון", "הזכרון");
        value = value.replace("ירשלים", "ירושלים");
        value = value.replace("שבועת", "שבועות");
        value = value.replace("שבעות", "שבועות");

        value = value.replace("15","טו");
        value = value.replace("10","י");
        value = value.replace("1","א");
        value = value.replace("2","ב");
        value = value.replace("3","ג");
        value = value.replace("4","ד");
        value = value.replace("5","ה");
        value = value.replace("6","ו");
        value = value.replace("7","ז");
        value = value.replace("8","ח");

        value = value.replace("  "," ");
        value = value.replace("  "," ");
        value = value.trim();

        value = value.replace("(","");
        value = value.replace(")","");
        value = value.replace("'","");
        value = value.replace("\"","");
        value = value.replace("-","_");
        value = value.replace(" ","_");
        value = value.replace("__","_");

        if (value.equals("ג_בעומר" + "\"" + "ל")) return HolyDay.לג_בעומר;

        if (value.equals("א_רהש")) return HolyDay.א_ראש_השנה;
        if (value.equals("רהש_א")) return HolyDay.א_ראש_השנה;
        if (value.equals("ראש_השנה_א")) return HolyDay.א_ראש_השנה;
        if (value.equals("ראש_השנה_הא")) return HolyDay.א_ראש_השנה;

        if (value.equals("ב_רהש")) return HolyDay.ב_ראש_השנה;
        if (value.equals("רהש_ב")) return HolyDay.ב_ראש_השנה;
        if (value.equals("ראש_השנה_ב")) return HolyDay.ב_ראש_השנה;
        if (value.equals("ראש_השנה_הב")) return HolyDay.ב_ראש_השנה;

        if (value.equals("ראש_השנה")) return HolyDay.א_ראש_השנה; // mast be after all others ראש השנה

        if (value.equals("כפור")) return HolyDay.יום_כיפור;
        if (value.equals("כיפור")) return HolyDay.יום_כיפור;

        if (value.equals("הר")) return HolyDay.הושענא_רבא;
        if (value.equals("הושר")) return HolyDay.הושענא_רבא;

        if (value.equals("א_סוכות")) return HolyDay.סוכות;

        if (value.equals("שמיני_עצרת")) return HolyDay.שמחת_תורה;
        if (value.equals("שמנע")) return HolyDay.שמחת_תורה;
        if (value.equals("שת")) return HolyDay.שמחת_תורה;

        if (value.equals("י_בטבת")) return HolyDay.עשרה_בטבת;
        if (value.equals("י_טבת")) return HolyDay.עשרה_בטבת;

        if (value.equals("טו_שבט")) return HolyDay.טו_בשבט;

        if (value.equals("ז_פסח")) return HolyDay.שביעי_פסח;

        try
        {
            return HolyDay.valueOf(value);
        }
        catch (Exception ignore)
        {
            return null;
        }
    }

    @Override
    public String toString()
    {
        return name().replace("_"," ");
    }

    public static boolean isTachanun(YearType yearType, int dayInYear)
    {
        HolyDay holyDay = getInfo(yearType, dayInYear);
        if (getInfo(yearType, dayInYear) != null)
        {
            switch (holyDay)
            {
                case צום_גדליה:
                case עשרה_בטבת:
                case תענית_אסתר:
                case יז_בתמוז:
                    return true;
                default:
                    return false;
            }
        }

        int[] convert = Shabat.getMonthDay(yearType, dayInYear);
        int month = convert[0];
        int day = convert[1];

        // Rosh Chodesh
        if (day == 1 || day == 30)
            return false;

        // Purim Katan
        if (yearType.isLeap() && month == 6 && (day == 14 || convert[2] == 15))
            return false;

        // all Nisan
        if ((!yearType.isLeap() && month == 7) || (yearType.isLeap() && month == 8))
            return false;

        // 12 days in Sivan
        if (((!yearType.isLeap() && month == 9) || (yearType.isLeap() && month == 10)) && day < 12)
            return false;

        // Erev Rosh Hashana
        if (yearType.getNumberDaysInYear() == dayInYear)
            return false;

        // Erev Yom Kipur until Rosh Chodesh
        if (dayInYear > 8 && dayInYear < 30)
            return false;

        return true;
    }

    public static boolean isLamenatzeach(YearType yearType, int dayInYear)
    {
        HolyDay holyDay = getInfo(yearType, dayInYear);
        if (getInfo(yearType, dayInYear) != null)
        {
            switch (holyDay)
            {
                case טו_בשבט:
                case פורים_קטן:
                case פורים:
                case העצמאות:
                case ירושלים:
                case ט_באב:
                case טו_באב:
                    return false;
                default:
                    return true;
            }
        }

        int[] convert = Shabat.getMonthDay(yearType, dayInYear);
        int day = convert[1];

        // Rosh Chodesh
        if (day == 1 || day == 30)
            return false;

        // Erev Yom Kipur
        if (dayInYear == 9)
            return false;

        // Chol Hamoed Sukot
        if (dayInYear > 15 && dayInYear < 22)
            return false;

        // Chanuka
        int holiday = (30 + 29 + ((yearType.getBalance() <= 0)?0:1) + 25);
        if (dayInYear >= holiday && dayInYear <= holiday + 7)
            return false;

        // Erev Pesach
        if (dayInYear == yearType.getNumberDaysInYear() - (29+30+29+30+29+15))
            return false;

        return true;
    }

    public static String getName(YearType yearType, int dayInYear)
    {
        HolyDay holidyDay = HolyDay.getInfo(yearType, dayInYear);
        if (holidyDay == null)
            return "";

        return holidyDay.toString();
    }

    public static HolyDay getInfo(YearType yearType, int dayInYear)
    {
        //Holy days
        switch(dayInYear) {
            case 1:
                return HolyDay.א_ראש_השנה;
            case 2:
                return HolyDay.ב_ראש_השנה;
            case 3:
                return HolyDay.צום_גדליה;
            case 10:
                return HolyDay.יום_כיפור;
        }

        // Sukot
        int holiday = 15;
        if (dayInYear >= holiday && dayInYear <= holiday+7)
            return HolyDay.values()[HolyDay.valueOf(HolyDay.סוכות.name()).ordinal() + (dayInYear - 15)];

        // Chanuka
        holiday = (30 + 29 + ((yearType.getBalance() <= 0)?0:1) + 25);
        if (dayInYear >= holiday && dayInYear <= holiday + 7)
            return HolyDay.values()[HolyDay.valueOf(HolyDay.א_חנוכה.name()).ordinal() + (dayInYear - holiday)];

        // Tevet 10s
        holiday = (30 + 29 + 30 + yearType.getBalance() + 10);
        if (dayInYear == holiday)
            return HolyDay.עשרה_בטבת;

        // Tu Beshvat
        holiday = (30 + 29 + 30 + yearType.getBalance() + 29 + 15);
        if (dayInYear == holiday)
            return HolyDay.טו_בשבט;

        // Purim katan
        if (yearType.isLeap())
        {
            holiday = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 29 + 30 + 29 + 16);
            if (dayInYear == holiday)
                return HolyDay.פורים_קטן;
        }

        // Purim
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+29+30+15);
        if (dayInYear == holiday - (1 + (yearType.getPesachDay() == 3? 2 : 0)))
            return HolyDay.תענית_אסתר;
        else if (dayInYear == holiday)
            return HolyDay.פורים;
        else if (dayInYear == holiday + 1 + (yearType.getPesachDay() == 1? 1 : 0))
            return HolyDay.שושן_פורים;

        // Pesach
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+29+15);
        if (dayInYear >= holiday && dayInYear <= holiday+6)
            return HolyDay.values()[HolyDay.valueOf(HolyDay.פסח.name()).ordinal() + (dayInYear - holiday)];

        // Hazikaron + Hatsmaut
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+24);
        if (yearType.getPesachDay() == 7) // Hatsmaut == 6
            holiday -= 1;
        if (yearType.getPesachDay() == 1) // Hatsmaut == 7
            holiday -= 2;
        if (yearType.getPesachDay() == 3) // Hatsmaut == 2
            holiday += 1;
        if (dayInYear == holiday)
            return HolyDay.העצמאות;
        if (dayInYear == holiday - 1)
            return HolyDay.הזכרון;

        // Pesach2
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+15);
        if (dayInYear == holiday)
            return HolyDay.פסח_שני;

        // Lag Baomer
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+11);
        if (dayInYear == holiday)
            return HolyDay.לג_בעומר;

        // Jerusalem Day
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+1);
        if (dayInYear == holiday)
            return HolyDay.ירושלים;

        // Shavuot
        holiday = yearType.getNumberDaysInYear() - (29+30+29+24);
        if (dayInYear == holiday)
            return HolyDay.שבועות;

        // Tamouz 17s
        holiday = yearType.getNumberDaysInYear() - ( 29 + 30 + 12 - (yearType.getPesachDay() == 7 ? 1 : 0));
        if (dayInYear == holiday)
            return HolyDay.יז_בתמוז;

        //Av 9n
        holiday = yearType.getNumberDaysInYear() - ( 29 + 21 - (yearType.getPesachDay() == 7 ? 1 : 0));
        if (dayInYear == holiday)
            return HolyDay.ט_באב;

        //Av 15
        holiday = yearType.getNumberDaysInYear() - (29+15);
        if (dayInYear == holiday)
            return HolyDay.טו_באב;

        return null;
    }

    public static int getDayInYear(YearType yearType, HolyDay holyDay)
    {
        //Holy days
        switch(holyDay)
        {
            case א_ראש_השנה:
                return 1;
            case ב_ראש_השנה:
                return 2;
            case צום_גדליה:
                return 3;
            case יום_כיפור:
                return 10;
        }

        if (holyDay.ordinal() >= סוכות.ordinal() && holyDay.ordinal() <= שמחת_תורה.ordinal())
            return 15 + (holyDay.ordinal() - סוכות.ordinal());

        int balance = ((yearType.getBalance() <= 0)?0:1);
        if (holyDay.ordinal() >= א_חנוכה.ordinal() && holyDay.ordinal() <= ח_חנוכה.ordinal())
            return 30 + 29 + balance + 25 + (holyDay.ordinal() - א_חנוכה.ordinal());


        switch(holyDay)
        {
            case עשרה_בטבת:
                return 30 + 29 + yearType.getBalance() + 30 + 10;
            case טו_בשבט:
                return 30 + 29 + yearType.getBalance() + 30 + 29 + 15;
        }

        // Purim katan
        if (yearType.isLeap())
        {
            int base = yearType.getNumberDaysInYear() - (29+30+29+30+29+30+29+16);
            if (פורים_קטן.equals(holyDay))
                return base;
        }

        // Purim
        int base = yearType.getNumberDaysInYear() - (29+30+29+30+29+30+15);
        if (תענית_אסתר.equals(holyDay))
            return base - (1 + (yearType.getPesachDay() == 3 ? 2 : 0));
        if (פורים.equals(holyDay))
            return base;
        if (שושן_פורים.equals(holyDay))
            return base + 1 + (yearType.getPesachDay() == 1 ? 1 : 0);

        // Pesach
        base = yearType.getNumberDaysInYear() - (29+30+29+30+29+15);
        if (holyDay.ordinal() >= פסח.ordinal() && holyDay.ordinal() <= שביעי_פסח.ordinal())
            return base + (holyDay.ordinal() - פסח.ordinal());

        // Hazikaron + Hatsmaut
        base = yearType.getNumberDaysInYear() - (29+30+29+30+24);
        if (yearType.getPesachDay() == 7) // Hatsmaut == 6
            base -= 1;
        if (yearType.getPesachDay() == 1) // Hatsmaut == 7
            base -= 2;
        if (yearType.getPesachDay() == 3) // Hatsmaut == 2
            base += 1;
        if (הזכרון.equals(holyDay))
            return base-1;
        if (העצמאות.equals(holyDay))
            return base;

        // Pesach2
        if (פסח_שני.equals(holyDay))
            return yearType.getNumberDaysInYear() - (29+30+29+30+15);

        // Lag Baomer
        if (לג_בעומר.equals(holyDay))
            return yearType.getNumberDaysInYear() - (29+30+29+30+11);

        // Jerusalem Day
        if (ירושלים.equals(holyDay))
            return yearType.getNumberDaysInYear() - (29+30+29+30+1);

        // Shavuot
        if (שבועות.equals(holyDay))
            return yearType.getNumberDaysInYear() - (29+30+29+24);;

        // Tamouz 17s
        if (יז_בתמוז.equals(holyDay))
            return yearType.getNumberDaysInYear() - ( 29 + 30 + 12 - (yearType.getPesachDay() == 7 ? 1 : 0));;

        //Av 9n
        if (ט_באב.equals(holyDay))
            return yearType.getNumberDaysInYear() - ( 29 + 21 - (yearType.getPesachDay() == 7 ? 1 : 0));;

        //Av 15
        if (טו_באב.equals(holyDay))
            return yearType.getNumberDaysInYear() - (29+15);

        return -1;
    }

    static
    {
        א_ראש_השנה.ashkenazi = "ישעיהו מב ה – מג י";
        א_ראש_השנה.sfaradi = "ישעיהו מב ה - כא";
    }
}

//        ROSH_HASHNA_1, ROSH_HASHNA_2,
//        TSOM_GEDALYA,
//        YOM_KIPUR,
//        SUCKOT, SUCKOT_2, SUCKOT_3, SUCKOT_4, SUCKOT_5, SUCKOT_6, HOSHAANA_RABA, SIMCHAT_TORA,
//        CHANUKA_1, CHANUKA_2, CHANUKA_3, CHANUKA_4, CHANUKA_5, CHANUKA_6, CHANUKA_7, CHANUKA_8,
//        ASARA_BETEVET,
//        TU_BISHVAT,
//        PARASHAT_SHKALIM, PARASHAT_ZACHOR, PARASHAT_PARA, PARASHAT_HACHODESH,
//        TAANIT_ESTER, PURIM, SHUSHAN_PURIM,
//        PESACH_1, PESACH_2, PESACH_3, PESACH_4, PESACH_5, PESACH_6, PESACH_7,
//        CHAG_HATSMAUT,
//        PESACH_SHENI,
//        LAG_BOMER,
//        YOM_SHICHRUR_YERUSHALAIM,
//        SHAVUOT,
//        YUD_ZAIN_BETAMUZ,
//        TISHAA_BEAV,
//        TU_BEAV
