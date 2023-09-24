package org.mobeho.calendar;

import org.junit.Test;
import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.HolyDay;
import static org.junit.Assert.*;

public class HolidayTest
{
    @Test
    public void checkHolyDayOf()
    {
        assertEquals(HolyDay.of("א ראש השנה"), HolyDay.א_ראש_השנה);
        assertEquals(HolyDay.of("א  של ראש השנה"), HolyDay.א_ראש_השנה);
        assertEquals(HolyDay.of("ראשון ראש השנה"), HolyDay.א_ראש_השנה);
        assertEquals(HolyDay.of("א רה\"ש"), HolyDay.א_ראש_השנה);
        assertEquals(HolyDay.of("רה\"ש א"), HolyDay.א_ראש_השנה);
        assertEquals(HolyDay.of("רה\"ש 1"), HolyDay.א_ראש_השנה);

        assertEquals(HolyDay.of("א סוכות"), HolyDay.סוכות);
        assertEquals(HolyDay.of("חג שני של סוכות"), HolyDay.ב_סוכות);
        assertEquals(HolyDay.of("נר שלישי של חנוכה"), HolyDay.ג_חנוכה);
        assertEquals(HolyDay.of("נר 5 של חנוכה"), HolyDay.ה_חנוכה);
        assertEquals(HolyDay.of("העצמאות"), HolyDay.העצמאות);
    }

    @Test
    public void checkHolidayבחג()
    {
        final YearType type = YearType.בחג;

        assertEquals(HolyDay.א_ראש_השנה, HolyDay.getInfo(type, 1));
        assertFalse(HolyDay.isTachanun(type, 1));
        assertEquals(1, HebrewDate.of(5797, HolyDay.א_ראש_השנה).getDayInYear());

        assertEquals(HolyDay.ב_ראש_השנה, HolyDay.getInfo(type, 2));
        assertFalse(HolyDay.isTachanun(type, 2));
        assertEquals(2, HebrewDate.of(5797, HolyDay.ב_ראש_השנה).getDayInYear());

        assertTrue(HolyDay.isTachanun(type, 3));
        assertEquals(3, HebrewDate.of(5797, HolyDay.צום_גדליה).getDayInYear());

        assertEquals(HolyDay.יום_כיפור, HolyDay.getInfo(type, 10));
        assertFalse(HolyDay.isTachanun(type, 9));
        assertEquals(10, HebrewDate.of(5797, HolyDay.יום_כיפור).getDayInYear());
        assertFalse(HolyDay.isTachanun(type, 10));

        assertFalse(HolyDay.isTachanun(type, 14));
        assertEquals(HolyDay.סוכות, HolyDay.getInfo(type, 15));
        assertFalse(HolyDay.isTachanun(type, 15));
        assertEquals(15, HebrewDate.of(5797, HolyDay.סוכות).getDayInYear());

        assertEquals(HolyDay.ב_סוכות, HolyDay.getInfo(type, 16));
        assertEquals(16, HebrewDate.of(5797, HolyDay.ב_סוכות).getDayInYear());

        assertEquals(HolyDay.ג_סוכות, HolyDay.getInfo(type, 17));
        assertEquals(17, HebrewDate.of(5797, HolyDay.ג_סוכות).getDayInYear());

        assertEquals(HolyDay.ד_סוכות, HolyDay.getInfo(type, 18));
        assertEquals(18, HebrewDate.of(5797, HolyDay.ד_סוכות).getDayInYear());

        assertEquals(HolyDay.ה_סוכות, HolyDay.getInfo(type, 19));
        assertEquals(19, HebrewDate.of(5797, HolyDay.ה_סוכות).getDayInYear());

        assertEquals(HolyDay.ו_סוכות, HolyDay.getInfo(type, 20));
        assertEquals(20, HebrewDate.of(5797, HolyDay.ו_סוכות).getDayInYear());

        assertEquals(HolyDay.הושענא_רבא, HolyDay.getInfo(type, 21));
        assertEquals(21, HebrewDate.of(5797, HolyDay.הושענא_רבא).getDayInYear());

        assertEquals(HolyDay.שמחת_תורה, HolyDay.getInfo(type, 22));
        assertFalse(HolyDay.isTachanun(type, 22));
        assertEquals(22, HebrewDate.of(5797, HolyDay.שמחת_תורה).getDayInYear());

        assertFalse(HolyDay.isTachanun(type, 30));// ר"ח
        assertFalse(HolyDay.isTachanun(type, 31)); // ר"ח
        assertTrue(HolyDay.isTachanun(type, 32)); // ר"ח

        assertTrue(HolyDay.isTachanun(type, 59));
        assertFalse(HolyDay.isTachanun(type, 60)); // ר"ח
        assertTrue(HolyDay.isTachanun(type, 61));

        assertEquals(HolyDay.א_חנוכה, HolyDay.getInfo(type, 84));
        assertEquals(84, HebrewDate.of(5797, HolyDay.א_חנוכה).getDayInYear());

        assertEquals(HolyDay.ב_חנוכה, HolyDay.getInfo(type, 85));
        assertEquals(85, HebrewDate.of(5797, HolyDay.ב_חנוכה).getDayInYear());

        assertEquals(HolyDay.ג_חנוכה, HolyDay.getInfo(type, 86));
        assertEquals(86, HebrewDate.of(5797, HolyDay.ג_חנוכה).getDayInYear());

        assertEquals(HolyDay.ד_חנוכה, HolyDay.getInfo(type, 87));
        assertEquals(87, HebrewDate.of(5797, HolyDay.ד_חנוכה).getDayInYear());

        assertEquals(HolyDay.ה_חנוכה, HolyDay.getInfo(type, 88));
        assertFalse(HolyDay.isTachanun(type, 88));
        assertEquals(88, HebrewDate.of(5797, HolyDay.ה_חנוכה).getDayInYear());

        assertEquals(HolyDay.ו_חנוכה, HolyDay.getInfo(type, 89));
        assertFalse(HolyDay.isTachanun(type, 89)); // ר"ח + חנוכה
        assertEquals(89, HebrewDate.of(5797, HolyDay.ו_חנוכה).getDayInYear());

        assertEquals(HolyDay.ז_חנוכה, HolyDay.getInfo(type, 90));
        assertFalse(HolyDay.isTachanun(type, 90));
        assertEquals(90, HebrewDate.of(5797, HolyDay.ז_חנוכה).getDayInYear());

        assertEquals(HolyDay.ח_חנוכה, HolyDay.getInfo(type, 91));
        assertFalse(HolyDay.isTachanun(type, 91));
        assertEquals(91, HebrewDate.of(5797, HolyDay.ח_חנוכה).getDayInYear());

        assertEquals(HolyDay.עשרה_בטבת, HolyDay.getInfo(type, 98));
        assertTrue(HolyDay.isTachanun(type, 98));
        assertEquals(98, HebrewDate.of(5797, HolyDay.עשרה_בטבת).getDayInYear());

        assertTrue(HolyDay.isTachanun(type, 117));
        assertFalse(HolyDay.isTachanun(type, 118)); // ר"ח
        assertTrue(HolyDay.isTachanun(type, 119));

        assertEquals(HolyDay.טו_בשבט, HolyDay.getInfo(type, 132));
        assertFalse(HolyDay.isTachanun(type, 132));
        assertEquals(132, HebrewDate.of(5797, HolyDay.טו_בשבט).getDayInYear());

        assertTrue(HolyDay.isTachanun(type, 146));
        assertFalse(HolyDay.isTachanun(type, 147)); // ר"ח
        assertFalse(HolyDay.isTachanun(type, 148)); // ר"ח
        assertTrue(HolyDay.isTachanun(type, 149));

        assertEquals(HolyDay.תענית_אסתר, HolyDay.getInfo(type, 158));
        assertTrue(HolyDay.isTachanun(type, 158));
        assertEquals(158, HebrewDate.of(5797, HolyDay.תענית_אסתר).getDayInYear());

        assertEquals(HolyDay.פורים, HolyDay.getInfo(type, 161));
        assertFalse(HolyDay.isTachanun(type, 161));
        assertEquals(161, HebrewDate.of(5797, HolyDay.פורים).getDayInYear());

        assertEquals(HolyDay.שושן_פורים, HolyDay.getInfo(type, 162));
        assertFalse(HolyDay.isTachanun(type, 162));
        assertEquals(162, HebrewDate.of(5797, HolyDay.שושן_פורים).getDayInYear());

        assertTrue(HolyDay.isTachanun(type, 176));
        assertFalse(HolyDay.isTachanun(type, 177)); // ר"ח
        assertFalse(HolyDay.isTachanun(type, 178)); // ניסן

        assertFalse(HolyDay.isTachanun(type, 189)); // ניסן
        assertFalse(HolyDay.isTachanun(type, 190)); // ערב חג
        assertEquals(HolyDay.פסח, HolyDay.getInfo(type, 191));
        assertFalse(HolyDay.isTachanun(type, 191));
        assertEquals(191, HebrewDate.of(5797, HolyDay.פסח).getDayInYear());

        assertEquals(HolyDay.ב_פסח, HolyDay.getInfo(type, 192));
        assertEquals(192, HebrewDate.of(5797, HolyDay.ב_פסח).getDayInYear());

        assertEquals(HolyDay.ג_פסח, HolyDay.getInfo(type, 193));
        assertEquals(193, HebrewDate.of(5797, HolyDay.ג_פסח).getDayInYear());

        assertEquals(HolyDay.ד_פסח, HolyDay.getInfo(type, 194));
        assertEquals(194, HebrewDate.of(5797, HolyDay.ד_פסח).getDayInYear());

        assertEquals(HolyDay.ה_פסח, HolyDay.getInfo(type, 195));
        assertEquals(195, HebrewDate.of(5797, HolyDay.ה_פסח).getDayInYear());

        assertEquals(HolyDay.ו_פסח, HolyDay.getInfo(type, 196));
        assertEquals(196, HebrewDate.of(5797, HolyDay.ו_פסח).getDayInYear());

        assertEquals(HolyDay.שביעי_פסח, HolyDay.getInfo(type, 197));
        assertEquals(197, HebrewDate.of(5797, HolyDay.שביעי_פסח).getDayInYear());

        assertFalse(HolyDay.isTachanun(type, 197));

        assertEquals(HolyDay.הזכרון, HolyDay.getInfo(type, 211));
        assertEquals(211, HebrewDate.of(5797, HolyDay.הזכרון).getDayInYear());

        assertEquals(HolyDay.העצמאות, HolyDay.getInfo(type, 212));
        assertEquals(212, HebrewDate.of(5797, HolyDay.העצמאות).getDayInYear());

        assertEquals(HolyDay.פסח_שני, HolyDay.getInfo(type, 220));
        assertEquals(220, HebrewDate.of(5797, HolyDay.פסח_שני).getDayInYear());

        assertEquals(HolyDay.לג_בעומר, HolyDay.getInfo(type, 224));
        assertEquals(224, HebrewDate.of(5797, HolyDay.לג_בעומר).getDayInYear());

        assertEquals(HolyDay.ירושלים, HolyDay.getInfo(type, 234));
        assertEquals(234, HebrewDate.of(5797, HolyDay.ירושלים).getDayInYear());

        assertEquals(HolyDay.שבועות, HolyDay.getInfo(type, 241));
        assertEquals(241, HebrewDate.of(5797, HolyDay.שבועות).getDayInYear());

        assertTrue(HolyDay.isTachanun(type, 264));
        assertFalse(HolyDay.isTachanun(type, 265)); // ר"ח
        assertFalse(HolyDay.isTachanun(type, 266)); // ניסן
        assertTrue(HolyDay.isTachanun(type, 267));

        assertEquals(HolyDay.יז_בתמוז, HolyDay.getInfo(type, 282));
        assertEquals(282, HebrewDate.of(5797, HolyDay.יז_בתמוז).getDayInYear());

        assertEquals(HolyDay.ט_באב, HolyDay.getInfo(type, 303));
        assertEquals(303, HebrewDate.of(5797, HolyDay.ט_באב).getDayInYear());

        assertEquals(HolyDay.טו_באב, HolyDay.getInfo(type, 309));
        assertEquals(309, HebrewDate.of(5797, HolyDay.טו_באב).getDayInYear());
    }

    @Test
    public void checkHolidayבחה()
    {
        final YearType type = YearType.בחה;

        assertEquals(HolyDay.טו_בשבט, HolyDay.getInfo(type, 132));
        assertEquals(132, HebrewDate.of(5793, HolyDay.טו_בשבט).getDayInYear());

        assertEquals(HolyDay.תענית_אסתר, HolyDay.getInfo(type, 190));
        assertEquals(190, HebrewDate.of(5793, HolyDay.תענית_אסתר).getDayInYear());

        assertEquals(HolyDay.פורים, HolyDay.getInfo(type, 191));
        assertEquals(191, HebrewDate.of(5793, HolyDay.פורים).getDayInYear());

        assertEquals(HolyDay.שושן_פורים, HolyDay.getInfo(type, 192));
        assertEquals(192, HebrewDate.of(5793, HolyDay.שושן_פורים).getDayInYear());

        assertFalse(HolyDay.isTachanun(type, 219)); // ניסן
        assertFalse(HolyDay.isTachanun(type, 220)); // ערב חג
        assertEquals(HolyDay.פסח, HolyDay.getInfo(type, 221));
        assertFalse(HolyDay.isTachanun(type, 221));
        assertEquals(221, HebrewDate.of(5793, HolyDay.פסח).getDayInYear());
    }

    @Test
    public void checkHolidayבשה()
    {
        final YearType type = YearType.בשה;

        assertEquals(HolyDay.טו_בשבט, HolyDay.getInfo(type, 134));
        assertEquals(134, HebrewDate.of(5783, HolyDay.טו_בשבט).getDayInYear());

        assertEquals(HolyDay.תענית_אסתר, HolyDay.getInfo(type, 162));
        assertEquals(162, HebrewDate.of(5783, HolyDay.תענית_אסתר).getDayInYear());

        assertEquals(HolyDay.פורים, HolyDay.getInfo(type, 163));
        assertEquals(163, HebrewDate.of(5783, HolyDay.פורים).getDayInYear());

        assertEquals(HolyDay.שושן_פורים, HolyDay.getInfo(type, 164));
        assertEquals(164, HebrewDate.of(5783, HolyDay.שושן_פורים).getDayInYear());
    }

    @Test
    public void checkHolidayהשג()
    {
        final YearType type = YearType.השג;

        assertEquals(HolyDay.תענית_אסתר, HolyDay.getInfo(type, 190));
        assertEquals(190, HebrewDate.of(5822, HolyDay.תענית_אסתר).getDayInYear());

        assertEquals(HolyDay.פורים, HolyDay.getInfo(type, 193));
        assertEquals(193, HebrewDate.of(5822, HolyDay.פורים).getDayInYear());
    }

    @Test
    public void checkHolidayהשא()
    {
        final YearType type = YearType.השא;

        assertEquals(HolyDay.תענית_אסתר, HolyDay.getInfo(type, 162));
        assertEquals(162, HebrewDate.of(5785, HolyDay.תענית_אסתר).getDayInYear());

        assertEquals(HolyDay.פורים, HolyDay.getInfo(type, 163));
        assertEquals(163, HebrewDate.of(5785, HolyDay.פורים).getDayInYear());
    }

    @Test
    public void checkHolidayבשז()
    {
        final YearType type = YearType.בשז;

        assertEquals(HolyDay.הזכרון, HolyDay.getInfo(type, 241));
        assertEquals(241, HebrewDate.of(5803, HolyDay.הזכרון).getDayInYear());

        assertEquals(HolyDay.העצמאות, HolyDay.getInfo(type, 242));
        assertEquals(242, HebrewDate.of(5803, HolyDay.העצמאות).getDayInYear());
    }
}
