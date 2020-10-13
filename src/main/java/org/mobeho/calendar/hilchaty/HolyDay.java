package org.mobeho.calendar.hilchaty;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class HolyDay //implements SpecialClass
{
    public enum HolyDays
    {
        ראש_השנה_א, ראש_השנה_ב,
        צום_גדליה,
        כיפור,
        א_סוכות, ב_סוכות, ג_סוכות, ד_סוכות, ה_סוכות, ו_סוכות, הושענא_רבא, שמחת_תורה,
        א_חנוכה, ב_חנוכה, ג_חנוכה, ד_חנוכה, ה_חנוכה, ו_חנוכה, ז_חנוכה, ח_חנוכה,
        עשרה_בטבת,
        טו_בשבט,
        שקלים, זכור, פרה, החודש,
        תענית_אסתר, פורים, שושן_פורים,
        א_פסח, ב_פסח, ג_פסח, ד_פסח, ה_פסח, ו_פסח, ז_פסח,
        יום_הזכרון,יום_העצמאות,
        פסח_שני,
        לג_בעומר,
        יום_ירושלים,
        שבועות,
        יז_בתמוז,
        ט_באב,
        טו_באב
//        ROSH_HASHNA_1 = 1, ROSH_HASHNA_2,
//        TSOM_GEDALYA,
//        YOM_KIPUR,
//        SUCKOT_1, SUCKOT_2, SUCKOT_3, SUCKOT_4, SUCKOT_5, SUCKOT_6, HOSHAANA_RABA, SIMCHAT_TORA,
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
        }

    public static String getInfo(YearType yearType, int dayInYear)
    {
        HolyDays day = null;

        //Holy days
        switch(dayInYear) {
            case 1:
                return HolyDays.ראש_השנה_א.name();
            case 2:
                return HolyDays.ראש_השנה_ב.name();
            case 3:
                return HolyDays.צום_גדליה.name();
            case 10:
                return HolyDays.כיפור.name();
        }

        // Sukot
        int holiday = 15;
        if (dayInYear >= holiday && dayInYear <= holiday+7)
            day = HolyDays.values()[HolyDays.valueOf(HolyDays.א_סוכות.name()).ordinal() + (dayInYear - 15)];

        // Chanuka
        holiday = (30 + 29 + ((yearType.getBalance() <= 0)?0:1) + 25);
        if (dayInYear >= holiday && dayInYear <= holiday + 7)
            day = HolyDays.values()[HolyDays.valueOf(HolyDays.א_חנוכה.name()).ordinal() + (dayInYear - holiday)];

        // Tevet 10s
        holiday = (30 + 29 + 30 + ((yearType.getBalance() <= 0)?0:1) + 10);
        if (dayInYear == holiday)
            day = HolyDays.עשרה_בטבת;

        // Tu Beshvat
        holiday = (30 + 29 + 30 + yearType.getBalance() + 29 + 15);
        if (dayInYear == holiday)
            day = HolyDays.טו_בשבט;

        // Purim
        holiday = yearType.numberDaysInYear - (29+30+29+30+29+30+15);
        if (dayInYear == holiday - (1 + (yearType.getPesachDay() == 3? 2 : 0)))
            day = HolyDays.תענית_אסתר;
        else if (dayInYear == holiday)
            day = HolyDays.פורים;
        else if (dayInYear == holiday + 1 + (yearType.getPesachDay() == 1? 1 : 0))
            day = HolyDays.שושן_פורים;

        // Pesach
        holiday = yearType.numberDaysInYear - (29+30+29+30+29+15);
        if (dayInYear >= holiday && dayInYear <= holiday+6)
            day = HolyDays.values()[HolyDays.valueOf(HolyDays.א_פסח.name()).ordinal() + (dayInYear - holiday)];

        // Hazikaron
        holiday = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 25 + (yearType.getPesachDay() == 7 ? 1 : 0) + (yearType.getPesachDay() == 1 ? 2 : 0));
        if (dayInYear == holiday)
            day = HolyDays.יום_הזכרון;

        // Hatsmaut
        holiday = yearType.numberDaysInYear - (29 + 30 + 29 + 30 + 24 + (yearType.getPesachDay() == 7 ? 1 : 0) + (yearType.getPesachDay() == 1 ? 2 : 0));
        if (dayInYear == holiday)
            day = HolyDays.יום_העצמאות;

        // Pesach2
        holiday = yearType.numberDaysInYear - (29+30+29+30+15);
        if (dayInYear == holiday)
            day = HolyDays.פסח_שני;

        // Laf Baomer
        holiday = yearType.numberDaysInYear - (29+30+29+30+11);
        if (dayInYear == holiday)
            day = HolyDays.לג_בעומר;

        // Jerusalem Day
        holiday = yearType.numberDaysInYear - (29+30+29+30+1);
        if (dayInYear == holiday)
            day = HolyDays.יום_ירושלים;

        // Shavuot
        holiday = yearType.numberDaysInYear - (29+30+29+24);
        if (dayInYear == holiday)
            day = HolyDays.שבועות;

        // Tamouz 17s
        holiday = yearType.numberDaysInYear - ( 29 + 30 + 12 - (yearType.getPesachDay() == 7 ? 1 : 0));
        if (dayInYear == holiday)
            day = HolyDays.יז_בתמוז;

        //Av 9n
        holiday = yearType.numberDaysInYear - ( 29 + 21 - (yearType.getPesachDay() == 7 ? 1 : 0));
        if (dayInYear == holiday)
            day = HolyDays.ט_באב;

        //Av 15
        holiday = yearType.numberDaysInYear - (29+15);
        if (dayInYear == holiday)
            day = HolyDays.טו_באב;

        if (day != null && day.ordinal() > 0)
            return day.name();
        else
            return "";
    }
}
