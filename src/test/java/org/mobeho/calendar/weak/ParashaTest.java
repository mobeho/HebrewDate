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
        assertNull(of("ז אלול")[0]);

        assertEquals(Parasha.of("שבת וראש השנה")[0], Parasha.שבת_וראש_השנה);
        assertEquals(Parasha.of("שבת ראש השנה")[0], Parasha.שבת_וראש_השנה);
        assertEquals(Parasha.of("שבת ויום כיפור")[0], Parasha.שבת_ויום_כיפור);
        assertEquals(Parasha.of("שבת יום כיפור")[0], Parasha.שבת_ויום_כיפור);
        assertEquals(Parasha.of("שבת כיפור")[0], Parasha.שבת_ויום_כיפור);
        assertEquals(Parasha.of("שבת וסוכות")[0], Parasha.שבת_וסוכות);
        assertEquals(Parasha.of("שבת סוכות")[0], Parasha.שבת_וסוכות);
        assertEquals(Parasha.of("סוכות ושבת")[0], Parasha.שבת_וסוכות);
        assertEquals(Parasha.of("שבת בסוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת חול המועד סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("חול המועד סוכות ושבת")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת וחול המועד סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת חולה" + "\"" + "מ סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת חול" + "\"" + "מ סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת חול" + "\"" + "מ סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("חול" + "\"" + "מ סוכות")[0], Parasha.שבת_חול_המועד_סוכות);
        assertEquals(Parasha.of("שבת ושמיני עצרת")[0], Parasha.שבת_ושמיני_עצרת);
        assertEquals(Parasha.of("שבת שמיני עצרת")[0], Parasha.שבת_ושמיני_עצרת);
        assertEquals(Parasha.of("שמיני עצרת ושבת")[0], Parasha.שבת_ושמיני_עצרת);

        assertEquals(Parasha.of("שבת ופסח")[0], Parasha.שבת_ופסח);
        assertEquals(Parasha.of("פסח ושבת")[0], Parasha.שבת_ופסח);
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

        assertEquals(Parasha.of("בראשית")[0],בראשית);
        assertEquals(Parasha.of("נח")[0],נח);
        assertEquals(Parasha.of("לך לך")[0],לך_לך);
        assertEquals(Parasha.of("לך_לך")[0],לך_לך);
        assertEquals(Parasha.of("לך-לך")[0],לך_לך);
        assertEquals(Parasha.of("וירא")[0],וירא);
        assertEquals(Parasha.of("חיי שרה")[0],חיי_שרה);
        assertEquals(Parasha.of("חיי_שרה")[0],חיי_שרה);
        assertEquals(Parasha.of("חיי-שרה")[0],חיי_שרה);
        assertEquals(Parasha.of("תולדות")[0],תולדות);
        assertEquals(Parasha.of("ויצא")[0],ויצא);
        assertEquals(Parasha.of("וישלח")[0],וישלח);
        assertEquals(Parasha.of("וישב")[0],וישב);
        assertEquals(Parasha.of("מקץ")[0],מקץ);
        assertEquals(Parasha.of("מיקץ")[0],מקץ);
        assertEquals(Parasha.of("מקץ - חנוכה")[0], מקץ);
        assertEquals(Parasha.of("מקץ - וחנוכה")[0], מקץ);
        assertEquals(Parasha.of("מקץ וחנוכה")[0], מקץ);
        assertEquals(Parasha.of("מקץ וחנוכה")[0], מקץ);
        assertEquals(Parasha.of("ויגש")[0],ויגש);
        assertEquals(Parasha.of("ויגש - חנוכה")[0], ויגש);
        assertEquals(Parasha.of("ויגש וערב ראש חודש")[0], ויגש);
        assertEquals(Parasha.of("ויגש - חנוכה ב")[0], ויגש);
        assertEquals(Parasha.of("ויגש - חנוכה ב'")[0], ויגש);
        assertEquals(Parasha.of("ויחי")[0],ויחי);
        assertEquals(Parasha.of("שמות")[0],שמות);
        assertEquals(Parasha.of("וארא")[0],וארא);
        assertEquals(Parasha.of("וארא - ראש חודש")[0], וארא);
        assertEquals(Parasha.of("וארא ראש חודש")[0], וארא);
        assertEquals(Parasha.of("וארא וראש חודש")[0], וארא);
        assertEquals(Parasha.of("וארא (ראש חודש)")[0], וארא);
        assertEquals(Parasha.of("וארא (ערב ראש חודש)")[0], וארא);
        assertEquals(Parasha.of("וארא (וערב ראש חודש)")[0], וארא);
        assertEquals(Parasha.of("בא")[0],בא);
        assertEquals(Parasha.of("בוא")[0],בא);
        assertEquals(Parasha.of("בשלח")[0],בשלח);
        assertEquals(Parasha.of("בשלח (שירה)")[0], בשלח);
        assertEquals(Parasha.of("יתרו")[0],יתרו);
        assertEquals(Parasha.of("משפטים")[0],משפטים);
        assertEquals(Parasha.of(" משפטים-שקלים")[0], Parasha.משפטים);
        assertEquals(Parasha.of("תרומה")[0],תרומה);
        assertEquals(Parasha.of("תצוה")[0],תצוה);
        assertEquals(Parasha.of("תצווה")[0],תצוה);
        assertEquals(Parasha.of("כי תשא")[0],כי_תשא);
        assertEquals(Parasha.of("כי_תשא")[0],כי_תשא);
        assertEquals(Parasha.of("כי-תשא")[0],כי_תשא);
        assertEquals(Parasha.of("ויקהל")[0],ויקהל);
        assertEquals(Parasha.of("פקודי")[0],פקודי);
        assertArrayEquals(Parasha.of("ויקהל-פקודי"), new Parasha[]{ויקהל, פקודי});
        assertArrayEquals(Parasha.of("ויקהל-פקודי זכור"), new Parasha[]{ויקהל, פקודי});
        assertArrayEquals(Parasha.of("ויקהל פקודי"), new Parasha[]{ויקהל, פקודי});
        assertEquals(Parasha.of("ויקרא")[0],ויקרא);
        assertEquals(Parasha.of("צו")[0],צו);
        assertEquals(Parasha.of(" צו פרה")[0], צו);
        assertEquals(Parasha.of(" צו הגדול")[0], צו);
        assertEquals(Parasha.of("שמיני")[0],שמיני);
        assertEquals(Parasha.of("תזריע")[0],תזריע);
        assertEquals(Parasha.of("מצורע")[0],מצרע);
        assertEquals(Parasha.of("מצרע")[0],מצרע);
        assertArrayEquals(Parasha.of("תזריע-מצורע"), new Parasha[]{תזריע, מצרע});
        assertArrayEquals(Parasha.of("תזריע מצורע"), new Parasha[]{תזריע, מצרע});
        assertArrayEquals(Parasha.of("תזריע מצורע החודש"), new Parasha[]{תזריע, מצרע});
        assertEquals(Parasha.of("אחרי-מות")[0],אחרי_מות);
        assertEquals(Parasha.of("אחרי_מות")[0],אחרי_מות);
        assertEquals(Parasha.of("קדושים")[0],קדשים);
        assertEquals(Parasha.of("קדשים")[0],קדשים);
        assertArrayEquals(Parasha.of("אחרי מות קדושים"), new Parasha[]{אחרי_מות, קדשים});
        assertArrayEquals(Parasha.of("אחרי-מות קדושים"), new Parasha[]{אחרי_מות, קדשים});
        assertEquals(Parasha.of("אמור")[0],אמר);
        assertEquals(Parasha.of("אמר")[0],אמר);
        assertEquals(Parasha.of("בהר")[0],בהר);
        assertEquals(Parasha.of("בחקתי")[0],בחקתי);
        assertEquals(Parasha.of("בחוקתי")[0],בחקתי);
        assertEquals(Parasha.of("בחקותי")[0],בחקתי);
        assertEquals(Parasha.of("בחוקותי")[0],בחקתי);
        assertArrayEquals(Parasha.of("בהר בחוקותי") , new Parasha[]{בהר, בחקתי});
        assertEquals(Parasha.of("במדבר")[0],במדבר);
        assertEquals(Parasha.of("נשא")[0],נשא);
        assertEquals(Parasha.of("נשוא")[0],נשא);
        assertEquals(Parasha.of("בהעלתך")[0],בהעלתך);
        assertEquals(Parasha.of("בהעלותך")[0],בהעלתך);
        assertEquals(Parasha.of("שלח_לך")[0],שלח_לך);
        assertEquals(Parasha.of("שלח-לך")[0],שלח_לך);
        assertEquals(Parasha.of("שלח")[0],שלח_לך);
        assertEquals(Parasha.of("קורח")[0],קרח);
        assertEquals(Parasha.of("קרח")[0],קרח);
        assertEquals(Parasha.of("חוקת")[0],חקת);
        assertEquals(Parasha.of("חקת")[0],חקת);
        assertEquals(Parasha.of("בלק")[0],בלק);
        assertEquals(Parasha.of("פנחס")[0],פינחס);
        assertEquals(Parasha.of("פינחס")[0],פינחס);
        assertEquals(Parasha.of("מטות")[0],מטות);
        assertEquals(Parasha.of("מסעי")[0],מסעי);
        assertArrayEquals(Parasha.of("מטות מסעי"), new Parasha[]{מטות, מסעי});
        assertEquals(Parasha.of("דברים")[0],דברים);
        assertEquals(Parasha.of("ואתחנן")[0],ואתחנן);
        assertEquals(Parasha.of("עקב")[0],עקב);
        assertEquals(Parasha.of("ראה")[0],ראה);
        assertEquals(Parasha.of("שפטים")[0],שפטים);
        assertEquals(Parasha.of("שופטים")[0],שפטים);
        assertEquals(Parasha.of("כי_תצא")[0],כי_תצא);
        assertEquals(Parasha.of("כי-תצא")[0],כי_תצא);
        assertEquals(Parasha.of("כי תצא")[0],כי_תצא);
        assertEquals(Parasha.of("כי_תבוא")[0],כי_תבוא);
        assertEquals(Parasha.of("כי-תבוא")[0],כי_תבוא);
        assertEquals(Parasha.of("כי תבוא")[0],כי_תבוא);
        assertEquals(Parasha.of("נצבים")[0],נצבים);
        assertEquals(Parasha.of("ניצבים")[0],נצבים);
        assertEquals(Parasha.of("וילך")[0],וילך);
        assertArrayEquals(Parasha.of("ניצבים וילך"), new Parasha[]{נצבים, וילך});
        assertEquals(Parasha.of("האזינו")[0],האזינו);
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
