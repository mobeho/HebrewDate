package org.mobeho.calendar;

import org.junit.Test;
import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.HolyDay;

import static org.junit.Assert.*;

public class HolidayTest
{
    @Test
    public void checkHolidayבחג()
    {
        final YearType type = YearType.בחג;
        assertEquals(HolyDay.HolyDays.א_ראש_שנה, HolyDay.getInfo(type, 1));
        assertFalse(HolyDay.isTachanun(type, 1));
        assertEquals(HolyDay.HolyDays.ב_ראש_שנה, HolyDay.getInfo(type, 2));
        assertFalse(HolyDay.isTachanun(type, 2));
        assertTrue(HolyDay.isTachanun(type, 3));
        assertFalse(HolyDay.isTachanun(type, 9));
        assertEquals(HolyDay.HolyDays.כיפור, HolyDay.getInfo(type, 10));
        assertFalse(HolyDay.isTachanun(type, 10));
        assertFalse(HolyDay.isTachanun(type, 14));
        assertEquals(HolyDay.HolyDays.סוכות, HolyDay.getInfo(type, 15));
        assertFalse(HolyDay.isTachanun(type, 15));
        assertEquals(HolyDay.HolyDays.ב_של_סוכות, HolyDay.getInfo(type, 16));
        assertEquals(HolyDay.HolyDays.ג_של_סוכות, HolyDay.getInfo(type, 17));
        assertEquals(HolyDay.HolyDays.ד_של_סוכות, HolyDay.getInfo(type, 18));
        assertEquals(HolyDay.HolyDays.ה_של_סוכות, HolyDay.getInfo(type, 19));
        assertEquals(HolyDay.HolyDays.ו_של_סוכות, HolyDay.getInfo(type, 20));
        assertEquals(HolyDay.HolyDays.הושענא_רבא, HolyDay.getInfo(type, 21));
        assertEquals(HolyDay.HolyDays.שמחת_תורה, HolyDay.getInfo(type, 22));
        assertFalse(HolyDay.isTachanun(type, 22));

        assertFalse(HolyDay.isTachanun(type, 30));// ר"ח
        assertFalse(HolyDay.isTachanun(type, 31)); // ר"ח
        assertTrue(HolyDay.isTachanun(type, 32)); // ר"ח

        assertTrue(HolyDay.isTachanun(type, 59));
        assertFalse(HolyDay.isTachanun(type, 60)); // ר"ח
        assertTrue(HolyDay.isTachanun(type, 61));

        assertEquals(HolyDay.HolyDays.א_של_חנוכה, HolyDay.getInfo(type, 84));
        assertEquals(HolyDay.HolyDays.ב_של_חנוכה, HolyDay.getInfo(type, 85));
        assertEquals(HolyDay.HolyDays.ג_של_חנוכה, HolyDay.getInfo(type, 86));
        assertEquals(HolyDay.HolyDays.ד_של_חנוכה, HolyDay.getInfo(type, 87));

        assertEquals(HolyDay.HolyDays.ה_של_חנוכה, HolyDay.getInfo(type, 88));
        assertFalse(HolyDay.isTachanun(type, 88));

        assertEquals(HolyDay.HolyDays.ו_של_חנוכה, HolyDay.getInfo(type, 89));
        assertFalse(HolyDay.isTachanun(type, 89)); // ר"ח + חנוכה

        assertEquals(HolyDay.HolyDays.ז_של_חנוכה, HolyDay.getInfo(type, 90));
        assertFalse(HolyDay.isTachanun(type, 90));

        assertEquals(HolyDay.HolyDays.ח_חנוכה, HolyDay.getInfo(type, 91));
        assertFalse(HolyDay.isTachanun(type, 91));

        assertEquals(HolyDay.HolyDays.עשרה_בטבת, HolyDay.getInfo(type, 99));
        assertTrue(HolyDay.isTachanun(type, 99));

        assertTrue(HolyDay.isTachanun(type, 117));
        assertFalse(HolyDay.isTachanun(type, 118)); // ר"ח
        assertTrue(HolyDay.isTachanun(type, 119));

        assertEquals(HolyDay.HolyDays.טו_בשבט, HolyDay.getInfo(type, 132));
        assertFalse(HolyDay.isTachanun(type, 132));

        assertTrue(HolyDay.isTachanun(type, 146));
        assertFalse(HolyDay.isTachanun(type, 147)); // ר"ח
        assertFalse(HolyDay.isTachanun(type, 148)); // ר"ח
        assertTrue(HolyDay.isTachanun(type, 149));

        assertEquals(HolyDay.HolyDays.תענית_אסתר, HolyDay.getInfo(type, 158));
        assertTrue(HolyDay.isTachanun(type, 158));

        assertEquals(HolyDay.HolyDays.פורים, HolyDay.getInfo(type, 161));
        assertFalse(HolyDay.isTachanun(type, 161));

        assertEquals(HolyDay.HolyDays.שושן_פורים, HolyDay.getInfo(type, 162));
        assertFalse(HolyDay.isTachanun(type, 162));

        assertTrue(HolyDay.isTachanun(type, 176));
        assertFalse(HolyDay.isTachanun(type, 177)); // ר"ח
        assertFalse(HolyDay.isTachanun(type, 178)); // ניסן

        assertFalse(HolyDay.isTachanun(type, 189)); // ניסן
        assertFalse(HolyDay.isTachanun(type, 190)); // ערב חג
        assertEquals(HolyDay.HolyDays.פסח, HolyDay.getInfo(type, 191));
        assertFalse(HolyDay.isTachanun(type, 191));
        assertEquals(HolyDay.HolyDays.ב_של_פסח, HolyDay.getInfo(type, 192));
        assertEquals(HolyDay.HolyDays.ג_של_פסח, HolyDay.getInfo(type, 193));
        assertEquals(HolyDay.HolyDays.ד_של_פסח, HolyDay.getInfo(type, 194));
        assertEquals(HolyDay.HolyDays.ה_של_פסח, HolyDay.getInfo(type, 195));
        assertEquals(HolyDay.HolyDays.ו_של_פסח, HolyDay.getInfo(type, 196));
        assertEquals(HolyDay.HolyDays.שביעי_של_פסח, HolyDay.getInfo(type, 197));
        assertFalse(HolyDay.isTachanun(type, 197));

        assertEquals(HolyDay.HolyDays.הזכרון, HolyDay.getInfo(type, 210));
        assertEquals(HolyDay.HolyDays.העצמאות, HolyDay.getInfo(type, 211));
        assertEquals(HolyDay.HolyDays.פסח_שני, HolyDay.getInfo(type, 220));
        assertEquals(HolyDay.HolyDays.לג_בעומר, HolyDay.getInfo(type, 224));
        assertEquals(HolyDay.HolyDays.ירושלים, HolyDay.getInfo(type, 234));
        assertEquals(HolyDay.HolyDays.שבועות, HolyDay.getInfo(type, 241));

        assertTrue(HolyDay.isTachanun(type, 264));
        assertFalse(HolyDay.isTachanun(type, 265)); // ר"ח
        assertFalse(HolyDay.isTachanun(type, 266)); // ניסן
        assertTrue(HolyDay.isTachanun(type, 267));

        assertEquals(HolyDay.HolyDays.יז_בתמוז, HolyDay.getInfo(type, 282));
        assertEquals(HolyDay.HolyDays.ט_באב, HolyDay.getInfo(type, 303));
        assertEquals(HolyDay.HolyDays.טו_באב, HolyDay.getInfo(type, 309));
    }

    @Test
    public void checkHolidayבחה()
    {
        final YearType type = YearType.בחה;
        assertEquals(HolyDay.HolyDays.טו_בשבט, HolyDay.getInfo(type, 132));
        assertEquals(HolyDay.HolyDays.תענית_אסתר, HolyDay.getInfo(type, 190));
        assertEquals(HolyDay.HolyDays.פורים, HolyDay.getInfo(type, 191));
        assertEquals(HolyDay.HolyDays.שושן_פורים, HolyDay.getInfo(type, 192));
    }

    @Test
    public void checkHolidayבשה()
    {
        final YearType type = YearType.בשה;
        assertEquals(HolyDay.HolyDays.טו_בשבט, HolyDay.getInfo(type, 134));
        assertEquals(HolyDay.HolyDays.תענית_אסתר, HolyDay.getInfo(type, 162));
        assertEquals(HolyDay.HolyDays.פורים, HolyDay.getInfo(type, 163));
        assertEquals(HolyDay.HolyDays.שושן_פורים, HolyDay.getInfo(type, 164));
    }


}
