package org.mobeho.calendar.weak;

import org.junit.Test;
import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.weak.Parasha;
import org.mobeho.calendar.hilchati.weak.Shabat;

import static org.junit.Assert.*;
import static org.mobeho.calendar.hilchati.weak.Parasha.*;

public class ParashaTest
{
    @Test
    public void checkParashaOf()
    {
        assertEquals(Parasha.of("שבת וראש השנה")[0], Parasha.שבת_וראש_השנה);
        assertEquals(Parasha.of("שבת ראש השנה")[0], Parasha.שבת_וראש_השנה);
        assertEquals(Parasha.of("שבת ויום כיפור")[0], Parasha.שבת_ויום_כיפור);
        assertEquals(Parasha.of("שבת יום כיפור")[0], Parasha.שבת_ויום_כיפור);
        assertEquals(Parasha.of("שבת כיפור")[0], Parasha.שבת_ויום_כיפור);
        assertEquals(Parasha.of("שבת וסוכות")[0], Parasha.שבת_וסוכות);
        assertEquals(Parasha.of("שבת סוכות")[0], Parasha.שבת_וסוכות);
        assertEquals(Parasha.of("שבת בסוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת חול המועד סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת וחול המועד סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת חולה" + "\"" + "מ סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת חול" + "\"" + "מ סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת חול" + "\"" + "מ סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("חול" + "\"" + "מ סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת ושמיני עצרת")[0], Parasha.שבת_ושמיני_עצרת);
        assertEquals(Parasha.of("שבת שמיני עצרת")[0], Parasha.שבת_ושמיני_עצרת);

        assertEquals(Parasha.of("מקץ - חנוכה")[0], מקץ);
        assertEquals(Parasha.of("מקץ - וחנוכה")[0], מקץ);
        assertEquals(Parasha.of("מקץ וחנוכה")[0], מקץ);
        assertEquals(Parasha.of("מקץ וחנוכה")[0], מקץ);
        assertEquals(Parasha.of("ויגש - חנוכה")[0], ויגש);
        assertEquals(Parasha.of("ויגש - חנוכה ב")[0], ויגש);
        assertEquals(Parasha.of("ויגש - חנוכה ב'")[0], ויגש);

        assertEquals(Parasha.of("וארא - ראש חודש")[0], וארא);
        assertEquals(Parasha.of("וארא ראש חודש")[0], וארא);
        assertEquals(Parasha.of("וארא וראש חודש")[0], וארא);
        assertEquals(Parasha.of("וארא (ראש חודש)")[0], וארא);

        assertEquals(Parasha.of(" משפטים-שקלים")[0], Parasha.משפטים);
        assertArrayEquals(Parasha.of("ויקהל-פקודי זכור"), new Parasha[]{ויקהל, פקודי});
        assertEquals(Parasha.of(" צו פרה")[0], צו);
        assertArrayEquals(Parasha.of("תזריע מצורע החודש"), new Parasha[]{תזריע, מצרע});
        assertEquals(Parasha.of("ויגש וערב ראש חודש")[0], ויגש);
        assertEquals(Parasha.of(" צו הגדול")[0], צו);

        assertEquals(Parasha.of("שבת ופסח")[0], Parasha.שבת_ופסח);
        assertEquals(Parasha.of("שבת פסח")[0], Parasha.שבת_ופסח);
        assertEquals(Parasha.of("שבת חול המועד פסח")[0], Parasha.שבת_חול_המועד_פסח);
        assertEquals(Parasha.of("שבת וחול המועד פסח")[0], Parasha.שבת_חול_המועד_פסח);
        assertEquals(Parasha.of("שבת חולה" + "\"" + "מ פסח")[0], Parasha.שבת_חול_המועד_פסח);
        assertEquals(Parasha.of("שבת חול" + "\"" + "מ פסח")[0], Parasha.שבת_חול_המועד_פסח);
        assertEquals(Parasha.of("שבת חול" + "\"" + "מ פסח")[0], Parasha.שבת_חול_המועד_פסח);
        assertEquals(Parasha.of("שבת ושביעי של פסח")[0], Parasha.שבת_ושביעי_של_פסח);
        assertEquals(Parasha.of("שבת שביעי של פסח")[0], Parasha.שבת_ושביעי_של_פסח);

        assertEquals(Parasha.of("שבת ופסח")[0], Parasha.שבת_ופסח);
        assertEquals(Parasha.of("שבת_ופסח")[0], Parasha.שבת_ופסח);
        assertEquals(Parasha.of("שבת_ופסח")[0], Parasha.שבת_ופסח);

        assertArrayEquals(Parasha.of("אחרי מות קדושים"), new Parasha[]{אחרי_מות, קדשים});
        assertArrayEquals(Parasha.of("בהר בחוקותי") , new Parasha[]{בהר, בחקתי});
        assertArrayEquals(Parasha.of("מטות מסעי"), new Parasha[]{מטות, מסעי});
        assertArrayEquals(Parasha.of("ניצבים וילך"), new Parasha[]{נצבים, וילך});

        assertNull(of("ז אלול")[0]);
    }

    @Test
    public void checkHaftaraבחג()
    {
        final YearType type = YearType.בחג;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;
        while (day++ < 6) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 13) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 20) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 27) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 34) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 41) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 48) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 55) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 62) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 69) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 76) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 83) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 90) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 97) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 104) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 111) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 118) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 125) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 132) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 139) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 146) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 153) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 160) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 167) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 174) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 181) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 188) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 195) assertEquals(שבת_חול_המועד_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 202) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 209) assertEquals(/*מצרע*/ "", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 216) assertEquals(/*קדשים*/ "", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 223) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 230) assertEquals(/*בחקתי*/ "", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 237) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 244) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 251) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 258) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 265) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 272) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 279) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 286) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 293) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 300) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 307) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 314) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 321) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 328) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 335) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 342) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 349) assertEquals(/*וילך*/ "", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 353) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraבחה()
    {
        final YearType type = YearType.בחה;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;
        while (day++ < 6) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 13) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 20) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 27) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 34) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 41) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 48) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 55) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 62) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 69) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 76) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 83) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 90) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 97) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 104) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 111) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 118) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 125) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 132) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 139) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 146) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 153) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 160) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 167) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 174) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 181) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 188) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 195) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 202) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 209) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 216) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 223) assertEquals(שבת_חול_המועד_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 230) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 237) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 244) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 251) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 258) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 265) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 272) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 279) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 286) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 293) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 300) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 307) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 314) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 321) assertEquals(/*מסעי*/ "", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 328) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 335) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 342) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 349) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 356) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 363) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 370) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 377) assertEquals(/*וילך*/ "", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 383) assertEquals(שבת_וראש_השנה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraבשה()
    {
        final YearType type = YearType.בשה;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;
        while (day++ < 13) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 20) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 83) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 90) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 111) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 118) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 125) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 139) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 146) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 153) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 160) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 167) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 174) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 181) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 188) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 195) assertEquals(שבת_חול_המועד_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 202) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 209) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 230) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 237) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 349) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 355) assertEquals(שבת_וראש_השנה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraבשז()
    {
        final YearType type = YearType.בשז;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;
        while (day++ < 13) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 20) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 83) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 90) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 111) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 118) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 167) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 174) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 181) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 188) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 195) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 202) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 209) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 216) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 223) assertEquals(שבת_ופסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 230) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 237) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 349) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 356) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 384) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraגכה()
    {
        final YearType type = YearType.גכה;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;
        while (day++ < 12) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 19) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 82) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 89) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 110) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 117) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 138) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 145) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 152) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 159) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 166) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 173) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 180) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 187) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 194) assertEquals(שבת_חול_המועד_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 201) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 208) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 229) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 236) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 348) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 354) assertEquals(שבת_וראש_השנה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraגכז()
    {
        final YearType type = YearType.גכז;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;
        while (day++ < 12) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 19) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 82) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 89) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 110) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 117) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 166) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 173) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 180) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 187) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 194) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 201) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 208) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 215) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 222) assertEquals(שבת_ופסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 229) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 236) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 347) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 355) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 384) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraהכז()
    {
        final YearType type = YearType.הכז;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;
        while (day++ < 3) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 10) assertEquals(שבת_ויום_כיפור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 17) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 24) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 31) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 52) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 59) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 80) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 87) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 136) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 143) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 150) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 157) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 164) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 171) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 178) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 185) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 192) assertEquals(שבת_ופסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 199) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 206) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 318) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 325) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 354) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraהחא()
    {
        final YearType type = YearType.החא;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;

        while (day++ < 3) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 10) assertEquals(שבת_ויום_כיפור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 17) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 24) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 31) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 52) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 59) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 80) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 87) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 171) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 178) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 185) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 192) assertEquals(פורים_מוקפין.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 199) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 206) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 213) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 220) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 227) assertEquals(שבת_ושביעי_של_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 318) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 325) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 346) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 353) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 360) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraהשא()
    {
        final YearType type = YearType.השא;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;
        while (day++ < 3) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 10) assertEquals(שבת_ויום_כיפור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 17) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 24) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 31) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 52) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 59) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 80) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 87) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 143) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 150) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 157) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 164) assertEquals(פורים_מוקפין.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 171) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 178) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 185) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 192) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 199) assertEquals(שבת_ושביעי_של_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 290) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 297) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 318) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 325) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 355) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraהשג()
    {
        final YearType type = YearType.השג;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;

        while (day++ < 3)  assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 10) assertEquals(שבת_ויום_כיפור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 17) assertEquals(שבת_חול_המועד_סוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 24) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 31) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 52) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 59) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 80) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 87) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 143) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 150) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 171) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 178) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 185) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 192) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 199) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 206) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 213) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 220) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 227) assertEquals(שבת_חול_המועד_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 290) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 297) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 318) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 325) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 381) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraזחא()
    {
        final YearType type = YearType.זחא;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;

        while (day++ < 1) assertEquals(שבת_וראש_השנה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 8) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 15) assertEquals(שבת_וסוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 22) assertEquals(שבת_ושמיני_עצרת.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 22) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 29) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 78) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 85) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 141) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 148) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 155) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 162) assertEquals(פורים_מוקפין.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 169) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 176) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 183) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 190) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 197) assertEquals(שבת_ושביעי_של_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 288) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 295) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 316) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 323) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 353) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraזחג()
    {
        final YearType type = YearType.זחג;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;

        while (day++ < 1) assertEquals(שבת_וראש_השנה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 8) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 15) assertEquals(שבת_וסוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 22) assertEquals(שבת_ושמיני_עצרת.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 22) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 29) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 78) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 85) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 141) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 148) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 169) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 176) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 183) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 190) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 197) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 204) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 211) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 218) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 225) assertEquals(שבת_חול_המועד_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 288) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 295) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 316) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 323) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 379) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraזשג()
    {
        final YearType type = YearType.זשג;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;

        while (day++ < 1) assertEquals(שבת_וראש_השנה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 8) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 15) assertEquals(שבת_וסוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 22) assertEquals(שבת_ושמיני_עצרת.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 22) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 29) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 78) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 85) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 92) assertEquals(חנוכה_ב.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 113) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 120) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 141) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 148) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 155) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 162) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 169) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 176) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 183) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 190) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 197) assertEquals(שבת_חול_המועד_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 260) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 267) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 288) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 295) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 350) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
    }

    @Test
    public void checkHaftaraזשה()
    {
        final YearType type = YearType.זשה;
        final Parasha.Eda eda = Parasha.Eda.ASHKENAZI;
        int day = 0;

        while (day++ < 1) assertEquals(שבת_וראש_השנה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 8) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 15) assertEquals(שבת_וסוכות.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 22) assertEquals(שבת_ושמיני_עצרת.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 22) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 29) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 78) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 85) assertEquals(חנוכה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 92) assertEquals(חנוכה_ב.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 113) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 120) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 141) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 148) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 169) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 176) assertEquals(שקלים.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 183) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 190) assertEquals(זכור.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 197) assertEquals(פרה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 204) assertEquals(החודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 211) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 218) assertEquals(הגדול.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 225) assertEquals(שבת_חול_המועד_פסח.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 232) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 239) assertEquals(ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 260) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 267) assertEquals(ערב_ראש_חודש.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 378) assertEquals("", Shabat.getHaftaraSpecial(type, day, eda));
        while (day++ < 385) assertEquals(שבת_וראש_השנה.ashkenazi, Shabat.getHaftaraSpecial(type, day, eda));
    }
}
