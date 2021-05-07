package org.mobeho.calendar.hilchati.weak;

import org.mobeho.calendar.calendar.YearType;

import java.util.Arrays;

import static org.mobeho.calendar.hilchati.weak.Convert.isMechubarot;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public enum Parasha
{
    // פרשות
    בראשית(1),נח(2),לך_לך(3),וירא(4),חיי_שרה(5),תולדות(6),ויצא(7),וישלח(8),וישב(9),מקץ(10),ויגש(11),ויחי(12),
    שמות(13),וארא(14),בא(15),בשלח(16),יתרו(17),משפטים(18),תרומה(19),תצוה(20),כי_תשא(21),ויקהל(22),פקודי(23),
    ויקרא(24),צו(25),שמיני(26),תזריע(27),מצרע(28),אחרי_מות(29),קדשים(30),אמר(31),בהר(32),בחקתי(33),
    במדבר(34),נשא(35),בהעלתך(36),שלח_לך(37),קרח(38),חקת(39),בלק(40),פינחס(41),מטות(42),מסעי(43),
    דברים(44),ואתחנן(45),עקב(46),ראה(47),שפטים(48),כי_תצא(49),כי_תבוא(50),נצבים(51),וילך(52),האזינו(53),

    // שבתות חג
    שבת_וראש_השנה(100),שבת_ויום_כיפור(101),שבת_וסוכות(102),שבת_חול_המועד_סוכות(103),שבת_ושמיני_עצרת(104),
    שבת_ופסח(105),שבת_חול_המועד_פסח(106),שבת_ושביעי_של_פסח(107),

    // שבתות עם מפטיר שונה
    ראש_חודש(200), חנוכה(201), חנוכה_ב(202), שקלים(203), זכור(204), פורים_מוקפין(205) ,פרה(206),החודש(207),

    // שבתות עם הפטרה שונה
    ערב_ראש_חודש(300), שבת_שובה(301), הגדול(304);

    Parasha(int index) {this.index = index;}

    public enum Eda { ASHKENAZI, SFARADI; }

    public int index;
    public String ashkenazi;
    public String sfaradi;


    public static Parasha of(int index)
    {
        return Arrays.stream(values()).filter(e -> e.index == index).findFirst().orElse(null);
    }

    public static Parasha[] of(String name)
    {
        if (name == null || name.length() < 2)
            return new Parasha[]{null, null};

        Parasha parasha1 = convertName(name, false);
        if (parasha1 == null)
            return new Parasha[]{null, null};

        Parasha parasha2 = null;

        // בדיקה אם יש מציאות של שבת מחוברת לפי הפרשה הראשונה
        // We don't care about the deFacto = [1], only the optional[0], so put any YearType and any dayInYear
        if (isMechubarot(YearType.בחג, parasha1.index, 0)[0])
            parasha2 = convertName(name, true);

        // במקרה של שבת כפולות השבתות חייבות להיות צמודות
        if (parasha2 != null)
        {
            if (parasha2.index == parasha1.index)
                return new Parasha[]{parasha1, null};
            else if ((parasha2.index - parasha1.index) == 1)
                return new Parasha[]{parasha1, parasha2};
            else
                return new Parasha[]{null, null};
        }

        return new Parasha[]{parasha1, parasha2};
    }

    @Override
    public String toString()
    {
        if (isOrdered())
            return name().replace("_","-");

        return name().replace("_"," ");
    }

    public boolean isOrdered()
    {
        return index < Parasha.שבת_וראש_השנה.index;
    }

    public static String toString(Parasha[] parashot)
    {
        if (parashot == null || parashot[0] == null)
            return "";

        StringBuilder out = new StringBuilder(parashot[0].toString());
        if (parashot[0] == בשלח)
            out.append(" (שירה)");
        if (parashot.length > 1 && parashot[1] != null)
        {
            if (parashot[1].index >= ראש_חודש.index && parashot[1].index <= החודש.index)
                out.append(" - ").append(parashot[1]);
            else if (parashot[1].index >= ערב_ראש_חודש.index && parashot[1].index <= הגדול.index)
                out.append(" (").append(parashot[1]).append(")");
            else
                out.append(" ").append(parashot[1]);
        }
        if (parashot.length == 3 && parashot[2] != null)
        {
            if (parashot[2].index >= ראש_חודש.index && parashot[2].index <= החודש.index)
                out.append(" - ").append(parashot[2]);
            else if (parashot[2].index >= ערב_ראש_חודש.index && parashot[2].index <= הגדול.index)
                out.append(" (").append(parashot[2]).append(")");
            else
                out.append(" ").append(parashot[2]);
        }

        return out.toString();
    }


    private static Parasha convertName(String value, boolean skipFirst)
    {
        // Diagnosis by Shabat name only
        value = value.replace("ושירה","");
        value = value.replace("שירה","");
        value = value.replace("ושקלים","");
        value = value.replace("שקלים","");
        value = value.replace("וזכור","");
        value = value.replace("זכור","");
        value = value.replace("ופרה","");
        value = value.replace("פרה","");
        value = value.replace("והחודש","");
        value = value.replace("החודש","");
        value = value.replace("והחדש","");
        value = value.replace("החדש","");
        value = value.replace("והגדול","");
        value = value.replace("הגדול","");
        value = value.replace("ושובה","");
        value = value.replace("שובה","");
        value = value.replace("ותשובה","");
        value = value.replace("תשובה","");
        value = value.replace("וחנוכה ב","");
        value = value.replace("חנוכה ב","");
        value = value.replace("וחנוכה","");
        value = value.replace("חנוכה","");
        value = value.replace("פורים מוקפין","");
        value = value.replace("וערב ראש חודש","");
        value = value.replace("ערב ראש חודש","");
        value = value.replace("וערב ראש חדש","");
        value = value.replace("ערב ראש חדש","");
        value = value.replace("וערב ר\"ח","");
        value = value.replace("ערב ר\"ח","");
        value = value.replace("וער\"ח","");
        value = value.replace("ער\"ח","");
        value = value.replace("וראש חודש","");
        value = value.replace("ראש חודש","");
        value = value.replace("וראש חדש","");
        value = value.replace("ראש חדש","");
        value = value.replace("'"," ");
        value = value.replace("-"," ");
        value = value.replace("_"," ");
        value = value.replace("(","");
        value = value.replace(")","");
        value = value.replace("  "," ");
        value = value.replace("  "," ");
        value = value.trim();

        if (value.contains("שבת וראש השנה")) return Parasha.שבת_וראש_השנה;
        if (value.contains("שבת ראש השנה")) return Parasha.שבת_וראש_השנה;
        if (value.contains("שבת ויום כיפור")) return Parasha.שבת_ויום_כיפור;
        if (value.contains("שבת יום כיפור")) return Parasha.שבת_ויום_כיפור;
        if (value.contains("שבת וכיפור")) return Parasha.שבת_ויום_כיפור;
        if (value.contains("שבת כיפור")) return Parasha.שבת_ויום_כיפור;

        if (value.contains("שבת וסוכות")) return Parasha.שבת_וסוכות;
        if (value.contains("שבת סוכות")) return Parasha.שבת_וסוכות;

        if (value.contains("שבת בסוכות")) return Parasha.שבת_חול_המועד_סוכות;
        if (value.contains("שבת וחול המועד סוכות")) return Parasha.שבת_חול_המועד_סוכות;
        if (value.contains("שבת חול המועד סוכות")) return Parasha.שבת_חול_המועד_סוכות;
        if (value.contains("שבת חולה" + "\"" + "מ סוכות")) return Parasha.שבת_חול_המועד_סוכות;
        if (value.contains("שבת חול" + "\"" + "מ סוכות")) return Parasha.שבת_חול_המועד_סוכות;
        if (value.contains("חול" + "\"" + "מ סוכות")) return Parasha.שבת_חול_המועד_סוכות;

        if (value.contains("שבת ושמיני עצרת")) return Parasha.שבת_ושמיני_עצרת;
        if (value.contains("שבת שמיני עצרת")) return Parasha.שבת_ושמיני_עצרת;

        if (value.contains("נוח")) return Parasha.נח;
        if (value.contains("לך לך")) return Parasha.לך_לך;
        if (value.contains("חיי שרה")) return Parasha.חיי_שרה;
        if (value.contains("מיקץ")) return Parasha.מקץ;

        if (value.contains("שבת חנוכה א")) return Parasha.חנוכה;
        if (value.contains("שבת חנוכה ב")) return Parasha.חנוכה_ב;
        if (value.contains("שבת חנוכה")) return Parasha.חנוכה;

        if (value.contains("כי תבוא")) return Parasha.כי_תבוא;
        if (value.contains("כי תבא")) return Parasha.כי_תבוא;
        if (value.contains("בוא")) return Parasha.בא;
        if (value.contains("מישפטים")) return Parasha.משפטים;
        if (value.contains("תצווה")) return Parasha.תצוה;

        if (value.contains("כי תשא")) return Parasha.כי_תשא;

        if (value.contains("ויקהל") && !skipFirst) return Parasha.ויקהל;
        if (value.contains("פקודי")) return Parasha.פקודי;

        if (value.contains("שבת ופסח")) return Parasha.שבת_ופסח;
        if (value.contains("שבת פסח")) return Parasha.שבת_ופסח;

        if (value.contains("שבת בפסח")) return Parasha.שבת_חול_המועד_פסח;
        if (value.contains("שבת וחול המועד פסח")) return Parasha.שבת_חול_המועד_פסח;
        if (value.contains("שבת חול המועד פסח")) return Parasha.שבת_חול_המועד_פסח;
        if (value.contains("שבת חולה" + "\"" + "מ פסח")) return Parasha.שבת_חול_המועד_פסח;
        if (value.contains("שבת חול" + "\"" + "מ פסח")) return Parasha.שבת_חול_המועד_פסח;
        if (value.contains("חול" + "\"" + "מ פסח")) return Parasha.שבת_חול_המועד_פסח;

        if (value.contains("שבת ושביעי של פסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת שביעי של פסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת ושביעי פסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת שביעי פסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת וז של פסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת ז של פסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת וז דפסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת ז דפסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת וז פסח")) return Parasha.שבת_ושביעי_של_פסח;
        if (value.contains("שבת ז פסח")) return Parasha.שבת_ושביעי_של_פסח;

        if (value.contains("תזרע") && !skipFirst) return Parasha.תזריע;
        if (value.contains("תזריע") && !skipFirst) return Parasha.תזריע;
        if (value.contains("מצורע")) return Parasha.מצרע;
        if (value.contains("מצרע")) return Parasha.מצרע;

        if (value.contains("אחרי מות") && !skipFirst) return Parasha.אחרי_מות;
        if (value.contains("קדושים")) return Parasha.קדשים;
        if (value.contains("קדשים")) return Parasha.קדשים;

        if (value.contains("אמור")) return Parasha.אמר;

        if (value.contains("בהר") && !skipFirst) return Parasha.בהר;
        if (value.contains("בחקתי")) return Parasha.בחקתי;
        if (value.contains("בחוקתי")) return Parasha.בחקתי;
        if (value.contains("בחקותי")) return Parasha.בחקתי;
        if (value.contains("בחוקותי")) return Parasha.בחקתי;

        if (value.contains("נשוא")) return Parasha.נשא;
        if (value.contains("בהעלותך")) return Parasha.בהעלתך;
        if (value.contains("בשלח")) return Parasha.בשלח;
        if (value.contains("וישלח")) return Parasha.וישלח;
        if (value.contains("שלח לך")) return Parasha.שלח_לך;
        if (value.contains("שלח")) return Parasha.שלח_לך;
        if (value.contains("קורח")) return Parasha.קרח;

        if (value.contains("חוקת") && !skipFirst) return Parasha.חקת;
        if (value.contains("חקת") && !skipFirst) return Parasha.חקת;
        if (value.contains("בלק")) return Parasha.בלק;

        if (value.contains("פנחס")) return Parasha.פינחס;

        if (value.contains("מטות") && !skipFirst) return Parasha.מטות;
        if (value.contains("מסעי")) return Parasha.מסעי;

        if (value.contains("שופטים")) return Parasha.שפטים;
        if (value.contains("כי תצא")) return Parasha.כי_תצא;

        if (value.contains("ניצבים") && !skipFirst) return Parasha.נצבים;
        if (value.contains("נצבים") && !skipFirst) return Parasha.נצבים;
        if (value.contains("וילך")) return Parasha.וילך;

        try
        {
            return Parasha.valueOf(value);
        }
        catch (Exception ignore)
        {
            return null;
        }
    }

    static
    {
        בראשית.ashkenazi = "ישעיהו מב ה – מג י";
        בראשית.sfaradi = "ישעיהו מב ה - כא";

        נח.ashkenazi = "ישעיהו נד א – נה ה";
        נח.sfaradi = "ישעיהו נד א - י";

        לך_לך.ashkenazi = "ישעיהו מ כז – מא טז";
        לך_לך.sfaradi = לך_לך.ashkenazi;

        וירא.ashkenazi = "מלכים ב ד א – לז";
        וירא.sfaradi = "מלכים ב ד א - כג";

        חיי_שרה.ashkenazi = "מלכים א א א – לא";
        חיי_שרה.sfaradi = חיי_שרה.ashkenazi;

        תולדות.ashkenazi = "מלאכי א א – ב ז";
        תולדות.sfaradi = תולדות.ashkenazi;

        ויצא.ashkenazi = "הושע יב יג – יד; י; יואל ב כו - כז";
        ויצא.sfaradi = "הושע יא ז - יב יב";

        וישלח.ashkenazi = "עבדיה א א – כא";
        וישלח.sfaradi = וישלח.ashkenazi;

        וישב.ashkenazi = "עמוס ב ו –  ג ח";
        וישב.sfaradi = וישב.ashkenazi;

        מקץ.ashkenazi = "מלכים א ג טו – ד א";
        מקץ.sfaradi = מקץ.ashkenazi;

        ויגש.ashkenazi = "יחזקאל לז טו – כח";
        ויגש.sfaradi = ויגש.ashkenazi;

        ויחי.ashkenazi = "מלכים א ב א – יב";
        ויחי.sfaradi = ויחי.ashkenazi;

        שמות.ashkenazi = "ישעיהו כז ו- כח יג; כט כב – כג";
        שמות.sfaradi = "ירמיהו א א - ב ג";

        וארא.ashkenazi = "יחזקאל כח כה – כט כא";
        וארא.sfaradi = וארא.ashkenazi;

        בא.ashkenazi = "ירמיהו מו יג – כח";
        בא.sfaradi = בא.ashkenazi;

        בשלח.ashkenazi = "שופטים ד ד – ה לא";
        בשלח.sfaradi = "שופטים ה א – לא";

        יתרו.ashkenazi = "ישעיהו ו א – ו יג; ישעיהו ט ה – ו";
        יתרו.sfaradi = "ישעיהו ו א – יג";

        משפטים.ashkenazi = "ירמיהו לד ח -כב; לג כה – כו";
        משפטים.sfaradi = משפטים.ashkenazi;

        תרומה.ashkenazi = "מלכים א ה כו – ו יג";
        תרומה.sfaradi = תרומה.ashkenazi;

        תצוה.ashkenazi = "יחזקאל מג י – כז";
        תצוה.sfaradi = תצוה.ashkenazi;

        כי_תשא.ashkenazi = "מלכים א יח א – לט";
        כי_תשא.sfaradi = "מלכים א יח כ - לט";

        ויקהל.ashkenazi = "מלכים א ז מ – נ";
        ויקהל.sfaradi = "מלכים א ז יג - כו";

        פקודי.ashkenazi = "מלכים א ז נא – ח כא";
        פקודי.sfaradi = "מלכים א ז מ - נ";

        ויקרא.ashkenazi = "ישעיהו מג כא – מד כג";
        ויקרא.sfaradi = ויקרא.ashkenazi;

        צו.ashkenazi = "ירמיהו ז כא – ח ג; ט כב – כג";
        צו.sfaradi = צו.ashkenazi;

        שמיני.ashkenazi = "שמואל ב ו א – ז יז";
        שמיני.sfaradi = "שמואל ב ו א - יט";

        תזריע.ashkenazi = "מלכים ב ד מב – ה יט";
        תזריע.sfaradi = תזריע.ashkenazi;

        מצרע.ashkenazi = "מלכים ב ז ג – כ";
        מצרע.sfaradi = מצרע.ashkenazi;

        אחרי_מות.ashkenazi = "יחזקאל כב א – טז";
        אחרי_מות.sfaradi = אחרי_מות.ashkenazi;

        קדשים.ashkenazi = "עמוס ט ז – טו";
        קדשים.sfaradi = "יחזקאל כ ב - כ";

        אמר.ashkenazi = "יחזקאל מד טו – לא";
        אמר.sfaradi = אמר.ashkenazi;

        בהר.ashkenazi = "ירמיהו לב ו – כז";
        בהר.sfaradi = בהר.ashkenazi;

        בחקתי.ashkenazi = "ירמיהו טז יט-יז יד";
        בחקתי.sfaradi = בחקתי.ashkenazi;

        במדבר.ashkenazi = "הושע ב א – כב";
        במדבר.sfaradi = במדבר.ashkenazi;

        נשא.ashkenazi = "שופטים יג ב – כה";
        נשא.sfaradi = נשא.ashkenazi;

        בהעלתך.ashkenazi = "זכריה ב יד – ד ז";
        בהעלתך.sfaradi = בהעלתך.ashkenazi;

        שלח_לך.ashkenazi = "יהושע ב א – כד";
        שלח_לך.sfaradi = שלח_לך.ashkenazi;

        קרח.ashkenazi = "שמואל א יא יד – יב כב";
        קרח.sfaradi = קרח.ashkenazi;

        חקת.ashkenazi = "שופטים יא א- לג";
        חקת.sfaradi = חקת.ashkenazi;

        בלק.ashkenazi = "מיכה ה ו- ו ח";
        בלק.sfaradi = בלק.ashkenazi;

        פינחס.ashkenazi = "מלכים א יח מו – יט כא";
        פינחס.sfaradi = פינחס.ashkenazi;

        מטות.ashkenazi = "ירמיהו א א – ב ג";
        מטות.sfaradi = מטות.ashkenazi;

        מסעי.ashkenazi = "ירמיהו ב ד – כח; ג ד";
        מסעי.sfaradi = "ירמיהו ב ד - כח; ד א - ב";

        דברים.ashkenazi = "ישעיהו א א – כז";
        דברים.sfaradi = דברים.ashkenazi;

        ואתחנן.ashkenazi = "ישעיהו מ א – כו";
        ואתחנן.sfaradi = ואתחנן.ashkenazi;

        עקב.ashkenazi = "ישעיהו מט יד – נא ג";
        עקב.sfaradi = עקב.ashkenazi;

        ראה.ashkenazi = "ישעיהו נד יא – נה ה";
        ראה.sfaradi = ראה.ashkenazi;

        שפטים.ashkenazi = "ישעיהו נא יב – נב יב";
        שפטים.sfaradi = שפטים.ashkenazi;

        כי_תצא.ashkenazi = "ישעיהו נד א – י";
        כי_תצא.sfaradi = כי_תצא.ashkenazi;

        כי_תבוא.ashkenazi = "ישעיהו ס א – כב";
        כי_תבוא.sfaradi = כי_תבוא.ashkenazi;

        נצבים.ashkenazi = "ישעיהו סא י- סג ט";
        נצבים.sfaradi = נצבים.ashkenazi;

        וילך.ashkenazi = "הושע יד ב – י; יואל ב טו – כז";
        וילך.sfaradi = "הושע יד ב - י; מיכה ז יח - כ";

        האזינו.ashkenazi = "שמואל ב כב א – נא";
        האזינו.sfaradi = האזינו.ashkenazi;

        שבת_וראש_השנה.ashkenazi = "שמואל א א א -כח";
        שבת_וראש_השנה.sfaradi = "שמואל א א א -י";

        שבת_ויום_כיפור.ashkenazi = "ישעיהו נז יד - נח יד";
        שבת_ויום_כיפור.sfaradi = שבת_ויום_כיפור.ashkenazi;

        שבת_וסוכות.ashkenazi = "זכריה יד א - כא";
        שבת_וסוכות.sfaradi = שבת_וסוכות.ashkenazi;

        שבת_חול_המועד_סוכות.ashkenazi = "יחזקאל לח יח – לט טז";
        שבת_חול_המועד_סוכות.sfaradi = שבת_חול_המועד_סוכות.ashkenazi;

        שבת_ושמיני_עצרת.ashkenazi = "יהושע א א - יח";
        שבת_ושמיני_עצרת.sfaradi = "יהושע א א - ט";

        שבת_ופסח.ashkenazi = "יהושע ה ב – ו א";
        שבת_ופסח.sfaradi = "יהושע ה ב – ו א; ו כז";

        שבת_חול_המועד_פסח.ashkenazi = "יחזקאל לז א – יד";
        שבת_חול_המועד_פסח.sfaradi = שבת_חול_המועד_פסח.ashkenazi;

        שבת_ושביעי_של_פסח.ashkenazi = "שמואל כ כב א - נא";
        שבת_ושביעי_של_פסח.sfaradi = שבת_ושביעי_של_פסח.ashkenazi;

        ראש_חודש.ashkenazi = "ישעיהו סו א - כד; סו כג";
        ראש_חודש.sfaradi = ראש_חודש.ashkenazi;

        שקלים.ashkenazi = "מלכים ב יב א – יז";
        שקלים.sfaradi = "מלכים ב יא יז – יב יז";

        זכור.ashkenazi = "שמואל א טו ב – לד";
        זכור.sfaradi = "שמואל א טו א – לד";

        פורים_מוקפין.ashkenazi = "שמואל א טו ב – לד";
        פורים_מוקפין.sfaradi = "שמואל א טו א – לד";

        פרה.ashkenazi = "יחזקאל לו טז – לח";
        פרה.sfaradi = "יחזקאל לו טז – לו";

        החודש.ashkenazi = "יחזקאל מה טז – מו יח";
        החודש.sfaradi = "יחזקאל מה יח – מו טו";

        ערב_ראש_חודש.ashkenazi = "שמואל א כ יח – מב";
        ערב_ראש_חודש.sfaradi = ערב_ראש_חודש.ashkenazi;

        שבת_שובה.ashkenazi = "הושע יד ב – י; יואל ב טו – כז";
        שבת_שובה.sfaradi = "הושע יד ב – י; מיכה ז יח – כ";

        חנוכה.ashkenazi = "זכריה ב יד – ד ז";
        חנוכה.sfaradi = "זכריה ב יד – ד ז";

        חנוכה_ב.ashkenazi = "מלכים א ז מ – נ";
        חנוכה_ב.ashkenazi = "מלכים א ז מ – נ";

        הגדול.ashkenazi = "מלאכי ג ד – כד";
        הגדול.sfaradi = הגדול.ashkenazi;
    }
}
