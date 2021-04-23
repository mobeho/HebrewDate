package org.mobeho.calendar.hilchati;

import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.weak.Shabat;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class HolyDay //implements SpecialClass
{
    public enum HolyDays
    {
        א_ראש_שנה, ב_ראש_שנה,
        צום_גדליה,
        כיפור,
        סוכות, ב_של_סוכות, ג_של_סוכות, ד_של_סוכות, ה_של_סוכות, ו_של_סוכות, הושענא_רבא, שמחת_תורה,
        א_של_חנוכה, ב_של_חנוכה, ג_של_חנוכה, ד_של_חנוכה, ה_של_חנוכה, ו_של_חנוכה, ז_של_חנוכה, ח_חנוכה,
        עשרה_בטבת,
        טו_בשבט,
        תענית_אסתר, פורים, שושן_פורים,
        פסח, ב_של_פסח, ג_של_פסח, ד_של_פסח, ה_של_פסח, ו_של_פסח, שביעי_של_פסח,
        הזכרון,העצמאות,
        פסח_שני,
        לג_בעומר,
        ירושלים,
        שבועות,
        יז_בתמוז,
        ט_באב,
        טו_באב;

        @Override
        public String toString()
        {
            return name().replace("_"," ");
        }
    }

    public static boolean isTachanun(YearType yearType, int dayInYear)
    {
        HolyDays holyDay = getInfo(yearType, dayInYear);
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

    public static String getName(YearType yearType, int dayInYear)
    {
        HolyDay.HolyDays holidyDay = HolyDay.getInfo(yearType, dayInYear);
        if (holidyDay == null)
            return "";

        return holidyDay.toString();
    }

    public static HolyDays getInfo(YearType yearType, int dayInYear)
    {
        //Holy days
        switch(dayInYear) {
            case 1:
                return HolyDays.א_ראש_שנה;
            case 2:
                return HolyDays.ב_ראש_שנה;
            case 3:
                return HolyDays.צום_גדליה;
            case 10:
                return HolyDays.כיפור;
        }

        // Sukot
        int holiday = 15;
        if (dayInYear >= holiday && dayInYear <= holiday+7)
            return HolyDays.values()[HolyDays.valueOf(HolyDays.סוכות.name()).ordinal() + (dayInYear - 15)];

        // Chanuka
        holiday = (30 + 29 + ((yearType.getBalance() <= 0)?0:1) + 25);
        if (dayInYear >= holiday && dayInYear <= holiday + 7)
            return HolyDays.values()[HolyDays.valueOf(HolyDays.א_של_חנוכה.name()).ordinal() + (dayInYear - holiday)];

        // Tevet 10s
        holiday = (30 + 29 + 30 + ((yearType.getBalance() <= 0)?0:1) + 10);
        if (dayInYear == holiday)
            return HolyDays.עשרה_בטבת;

        // Tu Beshvat
        holiday = (30 + 29 + 30 + yearType.getBalance() + 29 + 15);
        if (dayInYear == holiday)
            return HolyDays.טו_בשבט;

        // Purim
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+29+30+15);
        if (dayInYear == holiday - (1 + (yearType.getPesachDay() == 3? 2 : 0)))
            return HolyDays.תענית_אסתר;
        else if (dayInYear == holiday)
            return HolyDays.פורים;
        else if (dayInYear == holiday + 1 + (yearType.getPesachDay() == 1? 1 : 0))
            return HolyDays.שושן_פורים;

        // Pesach
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+29+15);
        if (dayInYear >= holiday && dayInYear <= holiday+6)
            return HolyDays.values()[HolyDays.valueOf(HolyDays.פסח.name()).ordinal() + (dayInYear - holiday)];

        // Hazikaron
        holiday = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 25 + (yearType.getPesachDay() == 7 ? 1 : 0) + (yearType.getPesachDay() == 1 ? 2 : 0));
        if (yearType.getPesachDay() == 7)
            holiday -= 2;
        if (yearType.getPesachDay() == 1)
            holiday -= 1;
        if (dayInYear == holiday)
            return HolyDays.הזכרון;

        // Hatsmaut
        holiday = yearType.getNumberDaysInYear() - (29 + 30 + 29 + 30 + 24 + (yearType.getPesachDay() == 7 ? 1 : 0) + (yearType.getPesachDay() == 1 ? 2 : 0));
        if (yearType.getPesachDay() == 7)
            holiday -= 2;
        if (yearType.getPesachDay() == 1)
            holiday -= 1;
        if (dayInYear == holiday)
            return HolyDays.העצמאות;

        // Pesach2
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+15);
        if (dayInYear == holiday)
            return HolyDays.פסח_שני;

        // Laf Baomer
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+11);
        if (dayInYear == holiday)
            return HolyDays.לג_בעומר;

        // Jerusalem Day
        holiday = yearType.getNumberDaysInYear() - (29+30+29+30+1);
        if (dayInYear == holiday)
            return HolyDays.ירושלים;

        // Shavuot
        holiday = yearType.getNumberDaysInYear() - (29+30+29+24);
        if (dayInYear == holiday)
            return HolyDays.שבועות;

        // Tamouz 17s
        holiday = yearType.getNumberDaysInYear() - ( 29 + 30 + 12 - (yearType.getPesachDay() == 7 ? 1 : 0));
        if (dayInYear == holiday)
            return HolyDays.יז_בתמוז;

        //Av 9n
        holiday = yearType.getNumberDaysInYear() - ( 29 + 21 - (yearType.getPesachDay() == 7 ? 1 : 0));
        if (dayInYear == holiday)
            return HolyDays.ט_באב;

        //Av 15
        holiday = yearType.getNumberDaysInYear() - (29+15);
        if (dayInYear == holiday)
            return HolyDays.טו_באב;

        return null;
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
