package org.mobeho.calendar;

import org.mobeho.calendar.hilchaty.HolyDay;
import org.mobeho.calendar.hilchaty.YearType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HolidayTest
{
   @Test
   public void checkHolidayבחג()
   {
      final YearType type = YearType.בחג;
      HolyDay hol = new HolyDay();
      assertEquals("ראש_השנה_א", hol.getInfo(type, 1));
      assertEquals("ראש_השנה_ב", hol.getInfo(type, 2));
      assertEquals("כיפור", hol.getInfo(type, 10));
      assertEquals("א_סוכות", hol.getInfo(type, 15));
      assertEquals("ב_סוכות", hol.getInfo(type, 16));
      assertEquals("ג_סוכות", hol.getInfo(type, 17));
      assertEquals("ד_סוכות", hol.getInfo(type, 18));
      assertEquals("ה_סוכות", hol.getInfo(type, 19));
      assertEquals("ו_סוכות", hol.getInfo(type, 20));
      assertEquals("הושענא_רבא", hol.getInfo(type, 21));
      assertEquals("שמחת_תורה", hol.getInfo(type, 22));
      assertEquals("א_חנוכה", hol.getInfo(type, 84));
      assertEquals("ב_חנוכה", hol.getInfo(type, 85));
      assertEquals("ג_חנוכה", hol.getInfo(type, 86));
      assertEquals("ד_חנוכה", hol.getInfo(type, 87));
      assertEquals("ה_חנוכה", hol.getInfo(type, 88));
      assertEquals("ו_חנוכה", hol.getInfo(type, 89));
      assertEquals("ז_חנוכה", hol.getInfo(type, 90));
      assertEquals("ח_חנוכה", hol.getInfo(type, 91));
      assertEquals("עשרה_בטבת", hol.getInfo(type, 99));
      assertEquals("טו_בשבט", hol.getInfo(type, 132));
      assertEquals("תענית_אסתר", hol.getInfo(type, 158));
      assertEquals("פורים", hol.getInfo(type, 161));
      assertEquals("שושן_פורים", hol.getInfo(type, 162));
      assertEquals("א_פסח", hol.getInfo(type, 191));
      assertEquals("ב_פסח", hol.getInfo(type, 192));
      assertEquals("ג_פסח", hol.getInfo(type, 193));
      assertEquals("ד_פסח", hol.getInfo(type, 194));
      assertEquals("ה_פסח", hol.getInfo(type, 195));
      assertEquals("ו_פסח", hol.getInfo(type, 196));
      assertEquals("ז_פסח", hol.getInfo(type, 197));
      assertEquals("יום_הזכרון", hol.getInfo(type, 210));
      assertEquals("יום_העצמאות", hol.getInfo(type, 211));
      assertEquals("פסח_שני", hol.getInfo(type, 220));
      assertEquals("לג_בעומר", hol.getInfo(type, 224));
      assertEquals("יום_ירושלים", hol.getInfo(type, 234));
      assertEquals("שבועות", hol.getInfo(type, 241));
      assertEquals("יז_בתמוז", hol.getInfo(type, 282));
      assertEquals("ט_באב", hol.getInfo(type, 303));
      assertEquals("טו_באב", hol.getInfo(type, 309));
   }

   @Test
   public void checkHolidayבחה()
   {
      final YearType type = YearType.בחה;
      HolyDay hol = new HolyDay();
      assertEquals("טו_בשבט", hol.getInfo(type, 132));
      assertEquals("תענית_אסתר", hol.getInfo(type, 190));
      assertEquals("פורים", hol.getInfo(type, 191));
      assertEquals("שושן_פורים", hol.getInfo(type, 192));
   }

   @Test
   public void checkHolidayבשה()
   {
      final YearType type = YearType.בשה;
      HolyDay hol = new HolyDay();
      HebrewDate date = HebrewDate.now();
      assertEquals("טו_בשבט", hol.getInfo(type, 134));
      assertEquals("תענית_אסתר", hol.getInfo(type, 162));
      assertEquals("פורים", hol.getInfo(type, 163));
      assertEquals("שושן_פורים", hol.getInfo(type, 164));
   }



}
