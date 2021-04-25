package org.mobeho.calendar.weak;

import org.mobeho.calendar.HebrewDate;
import org.mobeho.calendar.hilchati.weak.Parasha;
import org.mobeho.calendar.calendar.YearType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class ShabatForHebrewDateTest
{

   @Test
   public void checkShabatNameבחג()
   {
      final YearType type = YearType.בחג;
      int day = 0;
      while (day++ < 6) assertEquals("וילך", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 13) assertEquals("האזינו", HebrewDate.of(5797, day).getShabatName());
      assertEquals("שבת חול המועד סוכות", HebrewDate.of(5797, day).getParashaName());
      assertEquals(Parasha.שבת_חול_המועד_סוכות, HebrewDate.of(5797, day).getParasha()[0]);
      while (day++ < 20) assertEquals("שבת חול המועד סוכות", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 27) assertEquals("בראשית", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 34) assertEquals("נח", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 41) assertEquals("לך-לך", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 48) assertEquals("וירא", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 55) assertEquals("חיי-שרה", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 62) assertEquals("תולדות", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 69) assertEquals("ויצא", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 76) assertEquals("וישלח", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 83) assertEquals("וישב", HebrewDate.of(5797, day).getShabatName());
      assertEquals("מקץ", HebrewDate.of(5797, day).getParashaName());
      assertEquals(Parasha.מקץ, HebrewDate.of(5797, day).getParasha()[0]);
      while (day++ < 90) assertEquals("מקץ - חנוכה", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 97) assertEquals("ויגש", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 104) assertEquals("ויחי", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 111) assertEquals("שמות", HebrewDate.of(5797, day).getShabatName());
      assertEquals("וארא", HebrewDate.of(5797, day).getParashaName());
      assertEquals(Parasha.וארא, HebrewDate.of(5797, day).getParasha()[0]);
      while (day++ < 118) assertEquals("וארא - ראש חודש", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 125) assertEquals("בא", HebrewDate.of(5797, day).getShabatName());
      assertEquals("בשלח", HebrewDate.of(5797, day).getParashaName());
      assertEquals(Parasha.בשלח, HebrewDate.of(5797, day).getParasha()[0]);
      while (day++ < 132) assertEquals("בשלח (שירה)", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 139) assertEquals("יתרו", HebrewDate.of(5797, day).getShabatName());
      assertEquals("משפטים", HebrewDate.of(5797, day).getParashaName());
      while (day++ < 146) assertEquals("משפטים - שקלים", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 153) assertEquals("תרומה", HebrewDate.of(5797, day).getShabatName());
      assertEquals("תצוה", HebrewDate.of(5797, day).getParashaName());
      while (day++ < 160) assertEquals("תצוה - זכור", HebrewDate.of(5797, day).getShabatName());
      assertEquals("כי-תשא", HebrewDate.of(5797, day).getParashaName());
      while (day++ < 167) assertEquals("כי-תשא - פרה", HebrewDate.of(5797, day).getShabatName());
      assertEquals("ויקהל פקודי", HebrewDate.of(5797, day).getParashaName());
      while (day++ < 174) assertEquals("ויקהל פקודי - החודש", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 181) assertEquals("ויקרא", HebrewDate.of(5797, day).getShabatName());
      assertEquals("צו", HebrewDate.of(5797, day).getParashaName());
      while (day++ < 188) assertEquals("צו (הגדול)", HebrewDate.of(5797, day).getShabatName());
      assertEquals("שבת חול המועד פסח", HebrewDate.of(5797, day).getParashaName());
      while (day++ < 195) assertEquals("שבת חול המועד פסח", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 202) assertEquals("שמיני", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 209) assertEquals("תזריע מצרע", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 216) assertEquals("אחרי-מות קדשים", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 223) assertEquals("אמר", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 230) assertEquals("בהר בחקתי", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 237) assertEquals("במדבר", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 244) assertEquals("נשא", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 251) assertEquals("בהעלתך", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 258) assertEquals("שלח-לך", HebrewDate.of(5797, day).getShabatName());
      assertEquals("קרח", HebrewDate.of(5797, day).getParashaName());
      while (day++ < 265) assertEquals("קרח - ראש חודש", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 272) assertEquals("חקת", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 279) assertEquals("בלק", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 286) assertEquals("פינחס", HebrewDate.of(5797, day).getShabatName());
      assertEquals("מטות מסעי", HebrewDate.of(5797, day).getParashaName());
      while (day++ < 293) assertEquals("מטות מסעי (ערב ראש חודש)", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 300) assertEquals("דברים", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 307) assertEquals("ואתחנן", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 314) assertEquals("עקב", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 321) assertEquals("ראה", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 328) assertEquals("שפטים", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 335) assertEquals("כי-תצא", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 342) assertEquals("כי-תבוא", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 349) assertEquals("נצבים וילך", HebrewDate.of(5797, day).getShabatName());
      while (day++ < 356) assertEquals("האזינו", HebrewDate.of(5797, day).getShabatName());
   }



   @Test
   public void checkShabatNameבחה()
   {
      final YearType type = YearType.בחה;
      int day = 0;
      while (day++ < 6) assertEquals("וילך", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 13) assertEquals("האזינו", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 20) assertEquals("שבת חול המועד סוכות", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 27) assertEquals("בראשית", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 34) assertEquals("נח", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 41) assertEquals("לך-לך", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 48) assertEquals("וירא", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 55) assertEquals("חיי-שרה", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 62) assertEquals("תולדות", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 69) assertEquals("ויצא", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 76) assertEquals("וישלח", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 83) assertEquals("וישב", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 90) assertEquals("מקץ - חנוכה", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 97) assertEquals("ויגש", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 104) assertEquals("ויחי", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 111) assertEquals("שמות", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 118) assertEquals("וארא - ראש חודש", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 125) assertEquals("בא", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 132) assertEquals("בשלח (שירה)", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 139) assertEquals("יתרו", HebrewDate.of(5793, day).getShabatName());
      assertEquals("משפטים", HebrewDate.of(5793, day).getParashaName());
      while (day++ < 146) assertEquals("משפטים (ערב ראש חודש)", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 153) assertEquals("תרומה", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 160) assertEquals("תצוה", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 167) assertEquals("כי-תשא", HebrewDate.of(5793, day).getShabatName());
      assertEquals("ויקהל", HebrewDate.of(5793, day).getParashaName());
      while (day++ < 174) assertEquals("ויקהל - שקלים", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 181) assertEquals("פקודי", HebrewDate.of(5793, day).getShabatName());
      assertEquals("ויקרא", HebrewDate.of(5793, day).getParashaName());
      while (day++ < 188) assertEquals("ויקרא - זכור", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 195) assertEquals("צו - פרה", HebrewDate.of(5793, day).getShabatName());
      assertEquals("שמיני", HebrewDate.of(5793, day).getParashaName());
      while (day++ < 202) assertEquals("שמיני - החודש", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 209) assertEquals("תזריע", HebrewDate.of(5793, day).getShabatName());
      assertEquals("מצרע", HebrewDate.of(5793, day).getParashaName());
      while (day++ < 216) assertEquals("מצרע (הגדול)", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 223) assertEquals("שבת חול המועד פסח", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 230) assertEquals("אחרי-מות", HebrewDate.of(5793, day).getShabatName());
      assertEquals("קדשים", HebrewDate.of(5793, day).getParashaName());
      while (day++ < 237) assertEquals("קדשים - ראש חודש", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 244) assertEquals("אמר", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 251) assertEquals("בהר", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 258) assertEquals("בחקתי", HebrewDate.of(5793, day).getShabatName());
      assertEquals("במדבר", HebrewDate.of(5793, day).getParashaName());
      while (day++ < 265) assertEquals("במדבר (ערב ראש חודש)", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 272) assertEquals("נשא", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 279) assertEquals("בהעלתך", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 286) assertEquals("שלח-לך", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 293) assertEquals("קרח", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 300) assertEquals("חקת", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 307) assertEquals("בלק", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 314) assertEquals("פינחס", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 321) assertEquals("מטות מסעי", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 328) assertEquals("דברים", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 335) assertEquals("ואתחנן", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 342) assertEquals("עקב", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 349) assertEquals("ראה", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 356) assertEquals("שפטים", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 363) assertEquals("כי-תצא", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 370) assertEquals("כי-תבוא", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 377) assertEquals("נצבים וילך", HebrewDate.of(5793, day).getShabatName());
      while (day++ < 381) assertEquals("שבת וראש השנה", HebrewDate.of(5793, day).getShabatName());
   }


//   @Test
//   public void shabatName()
//   {
//      Assert.assertEquals("בראשית", HebrewDate.getShabatName(new int[]{1, 0}));
//      assertEquals("[1, 0]", Arrays.toString(HebrewDate.getShabatIndexes("בראשית")));
//
//      assertEquals("", HebrewDate.getShabatName(new int[]{1, 2}));
//
//      assertEquals("שפטים", HebrewDate.getShabatName(new int[]{48, 0}));
//      assertEquals("[48, 0]", Arrays.toString(HebrewDate.getShabatIndexes("שפטים")));
//
//      assertEquals("נצבים", HebrewDate.getShabatName(new int[]{51, 0}));
//      assertEquals("[51, 0]", Arrays.toString(getShabatIndexes("נצבים")));
//
//      assertEquals("וילך", HebrewDate.getShabatName(new int[]{52, 0}));
//      assertEquals("[52, 0]", Arrays.toString(getShabatIndexes("וילך")));
//
//      assertEquals("נצבים וילך", HebrewDate.getShabatName(new int[]{51, 52}));
//      assertEquals("[51, 52]", Arrays.toString(HebrewDate.getShabatIndexes("נצבים וילך")));
//   }

   @Test
   public void checkShabatDayInYearבחג()
   {
      assertEquals(6, HebrewDate.of(5797, Parasha.וילך).getDayInYear());
      assertEquals(13, HebrewDate.of(5797, Parasha.האזינו).getDayInYear());
      assertEquals(27, HebrewDate.of(5797, Parasha.בראשית).getDayInYear());
      assertEquals(34, HebrewDate.of(5797, Parasha.נח).getDayInYear());
      assertEquals(41, HebrewDate.of(5797, Parasha.לך_לך).getDayInYear());
      assertEquals(48, HebrewDate.of(5797, Parasha.וירא).getDayInYear());
      assertEquals(55, HebrewDate.of(5797, Parasha.חיי_שרה).getDayInYear());
      assertEquals(62, HebrewDate.of(5797, Parasha.תולדות).getDayInYear());
      assertEquals(69, HebrewDate.of(5797, Parasha.ויצא).getDayInYear());
      assertEquals(76, HebrewDate.of(5797, Parasha.וישלח).getDayInYear());
      assertEquals(83, HebrewDate.of(5797, Parasha.וישב).getDayInYear());
      assertEquals(90, HebrewDate.of(5797, Parasha.מקץ).getDayInYear());
      assertEquals(97, HebrewDate.of(5797, Parasha.ויגש).getDayInYear());
      assertEquals(104, HebrewDate.of(5797, Parasha.ויחי).getDayInYear());
      assertEquals(111, HebrewDate.of(5797, Parasha.שמות).getDayInYear());
      assertEquals(118, HebrewDate.of(5797, Parasha.וארא).getDayInYear());
      assertEquals(125, HebrewDate.of(5797, Parasha.בא).getDayInYear());
      assertEquals(132, HebrewDate.of(5797, Parasha.בשלח).getDayInYear());
      assertEquals(139, HebrewDate.of(5797, Parasha.יתרו).getDayInYear());
      assertEquals(146, HebrewDate.of(5797, Parasha.משפטים).getDayInYear());
      assertEquals(153, HebrewDate.of(5797, Parasha.תרומה).getDayInYear());
      assertEquals(160, HebrewDate.of(5797, Parasha.תצוה).getDayInYear());
      assertEquals(167, HebrewDate.of(5797, Parasha.כי_תשא).getDayInYear());
      assertEquals(174, HebrewDate.of(5797, Parasha.ויקהל).getDayInYear());
      assertEquals(174, HebrewDate.of(5797, Parasha.פקודי).getDayInYear());
      assertEquals(181, HebrewDate.of(5797, Parasha.ויקרא).getDayInYear());
      assertEquals(188, HebrewDate.of(5797, Parasha.צו).getDayInYear());
      assertEquals(202, HebrewDate.of(5797, Parasha.שמיני).getDayInYear());
      assertEquals(209, HebrewDate.of(5797, Parasha.תזריע).getDayInYear());
      assertEquals(209, HebrewDate.of(5797, Parasha.מצרע).getDayInYear());
      assertEquals(216, HebrewDate.of(5797, Parasha.אחרי_מות).getDayInYear());
      assertEquals(216, HebrewDate.of(5797, Parasha.קדשים).getDayInYear());
      assertEquals(223, HebrewDate.of(5797, Parasha.אמר).getDayInYear());
      assertEquals(230, HebrewDate.of(5797, Parasha.בהר).getDayInYear());
      assertEquals(230, HebrewDate.of(5797, Parasha.בחקתי).getDayInYear());
      assertEquals(237, HebrewDate.of(5797, Parasha.במדבר).getDayInYear());
      assertEquals(244, HebrewDate.of(5797, Parasha.נשא).getDayInYear());
      assertEquals(251, HebrewDate.of(5797, Parasha.בהעלתך).getDayInYear());
      assertEquals(258, HebrewDate.of(5797, Parasha.שלח_לך).getDayInYear());
      assertEquals(265, HebrewDate.of(5797, Parasha.קרח).getDayInYear());
      assertEquals(272, HebrewDate.of(5797, Parasha.חקת).getDayInYear());
      assertEquals(279, HebrewDate.of(5797, Parasha.בלק).getDayInYear());
      assertEquals(286, HebrewDate.of(5797, Parasha.פינחס).getDayInYear());
      assertEquals(293, HebrewDate.of(5797, Parasha.מטות).getDayInYear());
      assertEquals(293, HebrewDate.of(5797, Parasha.מסעי).getDayInYear());
      assertEquals(300, HebrewDate.of(5797, Parasha.דברים).getDayInYear());
      assertEquals(307, HebrewDate.of(5797, Parasha.ואתחנן).getDayInYear());
      assertEquals(314, HebrewDate.of(5797, Parasha.עקב).getDayInYear());
      assertEquals(321, HebrewDate.of(5797, Parasha.ראה).getDayInYear());
      assertEquals(328, HebrewDate.of(5797, Parasha.שפטים).getDayInYear());
      assertEquals(335, HebrewDate.of(5797, Parasha.כי_תצא).getDayInYear());
      assertEquals(342, HebrewDate.of(5797, Parasha.כי_תבוא).getDayInYear());
      assertEquals(349, HebrewDate.of(5797, Parasha.נצבים).getDayInYear());
      assertEquals(349, HebrewDate.of(5797, Parasha.וילך, true).getDayInYear());

   }

   @Test
   public void checkShabatDayInYearבחה()
   {
      assertEquals(6, HebrewDate.of(5793,  Parasha.וילך).getDayInYear());
      assertEquals(13, HebrewDate.of(5793,  Parasha.האזינו).getDayInYear());
      assertEquals(20, HebrewDate.of(5793,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(27, HebrewDate.of(5793,  Parasha.בראשית).getDayInYear());
      assertEquals(34, HebrewDate.of(5793,  Parasha.נח).getDayInYear());
      assertEquals(41, HebrewDate.of(5793,  Parasha.לך_לך).getDayInYear());
      assertEquals(48, HebrewDate.of(5793,  Parasha.וירא).getDayInYear());
      assertEquals(55, HebrewDate.of(5793,  Parasha.חיי_שרה).getDayInYear());
      assertEquals(62, HebrewDate.of(5793,  Parasha.תולדות).getDayInYear());
      assertEquals(69, HebrewDate.of(5793,  Parasha.ויצא).getDayInYear());
      assertEquals(76, HebrewDate.of(5793,  Parasha.וישלח).getDayInYear());
      assertEquals(83, HebrewDate.of(5793,  Parasha.וישב).getDayInYear());
      assertEquals(90, HebrewDate.of(5793,  Parasha.מקץ).getDayInYear());
      assertEquals(97, HebrewDate.of(5793,  Parasha.ויגש).getDayInYear());
      assertEquals(104, HebrewDate.of(5793,  Parasha.ויחי).getDayInYear());
      assertEquals(111, HebrewDate.of(5793,  Parasha.שמות).getDayInYear());
      assertEquals(118, HebrewDate.of(5793,  Parasha.וארא).getDayInYear());
      assertEquals(125, HebrewDate.of(5793,  Parasha.בא).getDayInYear());
      assertEquals(132, HebrewDate.of(5793,  Parasha.בשלח).getDayInYear());
      assertEquals(139, HebrewDate.of(5793,  Parasha.יתרו).getDayInYear());
      assertEquals(146, HebrewDate.of(5793,  Parasha.משפטים).getDayInYear());
      assertEquals(153, HebrewDate.of(5793,  Parasha.תרומה).getDayInYear());
      assertEquals(160, HebrewDate.of(5793,  Parasha.תצוה).getDayInYear());
      assertEquals(167, HebrewDate.of(5793,  Parasha.כי_תשא).getDayInYear());
      assertEquals(174, HebrewDate.of(5793,  Parasha.ויקהל).getDayInYear());
      assertEquals(181, HebrewDate.of(5793,  Parasha.פקודי).getDayInYear());
      assertEquals(188, HebrewDate.of(5793,  Parasha.ויקרא).getDayInYear());
      assertEquals(195, HebrewDate.of(5793,  Parasha.צו).getDayInYear());
      assertEquals(202, HebrewDate.of(5793,  Parasha.שמיני).getDayInYear());
      assertEquals(209, HebrewDate.of(5793,  Parasha.תזריע).getDayInYear());
      assertEquals(216, HebrewDate.of(5793,  Parasha.מצרע).getDayInYear());
      assertEquals(223, HebrewDate.of(5793,  Parasha.שבת_חול_המועד_פסח).getDayInYear());
      assertEquals(230, HebrewDate.of(5793,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(237, HebrewDate.of(5793,  Parasha.קדשים).getDayInYear());
      assertEquals(244, HebrewDate.of(5793,  Parasha.אמר).getDayInYear());
      assertEquals(251, HebrewDate.of(5793,  Parasha.בהר).getDayInYear());
      assertEquals(258, HebrewDate.of(5793,  Parasha.בחקתי).getDayInYear());
      assertEquals(265, HebrewDate.of(5793,  Parasha.במדבר).getDayInYear());
      assertEquals(272, HebrewDate.of(5793,  Parasha.נשא).getDayInYear());
      assertEquals(279, HebrewDate.of(5793,  Parasha.בהעלתך).getDayInYear());
      assertEquals(286, HebrewDate.of(5793,  Parasha.שלח_לך).getDayInYear());
      assertEquals(293, HebrewDate.of(5793,  Parasha.קרח).getDayInYear());
      assertEquals(300, HebrewDate.of(5793,  Parasha.חקת).getDayInYear());
      assertEquals(307, HebrewDate.of(5793,  Parasha.בלק).getDayInYear());
      assertEquals(314, HebrewDate.of(5793,  Parasha.פינחס).getDayInYear());
      assertEquals(321, HebrewDate.of(5793,  Parasha.מטות).getDayInYear());
      assertEquals(321, HebrewDate.of(5793,  Parasha.מסעי).getDayInYear());
      assertEquals(328, HebrewDate.of(5793,  Parasha.דברים).getDayInYear());
      assertEquals(335, HebrewDate.of(5793,  Parasha.ואתחנן).getDayInYear());
      assertEquals(342, HebrewDate.of(5793,  Parasha.עקב).getDayInYear());
      assertEquals(349, HebrewDate.of(5793,  Parasha.ראה).getDayInYear());
      assertEquals(356, HebrewDate.of(5793,  Parasha.שפטים).getDayInYear());
      assertEquals(363, HebrewDate.of(5793,  Parasha.כי_תצא).getDayInYear());
      assertEquals(370, HebrewDate.of(5793,  Parasha.כי_תבוא).getDayInYear());
      assertEquals(377, HebrewDate.of(5793,  Parasha.נצבים).getDayInYear());
      assertEquals(377, HebrewDate.of(5793,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void checkShabatDayInYearבשה()
   {
      assertEquals(6, HebrewDate.of(5783,  Parasha.וילך).getDayInYear());
      assertEquals(13, HebrewDate.of(5783,  Parasha.האזינו).getDayInYear());
      assertEquals(20, HebrewDate.of(5783,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(174, HebrewDate.of(5783,  Parasha.ויקהל).getDayInYear());
      assertEquals(174, HebrewDate.of(5783,  Parasha.פקודי).getDayInYear());
      assertEquals(181, HebrewDate.of(5783,  Parasha.ויקרא).getDayInYear());
      assertEquals(188, HebrewDate.of(5783,  Parasha.צו).getDayInYear());
      assertEquals(195, HebrewDate.of(5783,  Parasha.שבת_חול_המועד_פסח).getDayInYear());
      assertEquals(202, HebrewDate.of(5783,  Parasha.שמיני).getDayInYear());
      assertEquals(209, HebrewDate.of(5783,  Parasha.תזריע).getDayInYear());
      assertEquals(209, HebrewDate.of(5783,  Parasha.מצרע).getDayInYear());
      assertEquals(216, HebrewDate.of(5783,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(216, HebrewDate.of(5783,  Parasha.קדשים).getDayInYear());
      assertEquals(223, HebrewDate.of(5783,  Parasha.אמר).getDayInYear());
      assertEquals(230, HebrewDate.of(5783,  Parasha.בהר).getDayInYear());
      assertEquals(230, HebrewDate.of(5783,  Parasha.בחקתי).getDayInYear());
      assertEquals(349, HebrewDate.of(5783,  Parasha.נצבים).getDayInYear());
      assertEquals(349, HebrewDate.of(5783,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void checkShabatDayInYearבשז()
   {
      assertEquals(6, HebrewDate.of(5803,  Parasha.וילך).getDayInYear());
      assertEquals(13, HebrewDate.of(5803,  Parasha.האזינו).getDayInYear());
      assertEquals(20, HebrewDate.of(5803,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(174, HebrewDate.of(5803,  Parasha.ויקהל).getDayInYear());
      assertEquals(181, HebrewDate.of(5803,  Parasha.פקודי).getDayInYear());
      assertEquals(188, HebrewDate.of(5803,  Parasha.ויקרא).getDayInYear());
      assertEquals(195, HebrewDate.of(5803,  Parasha.צו).getDayInYear());
      assertEquals(202, HebrewDate.of(5803,  Parasha.שמיני).getDayInYear());
      assertEquals(209, HebrewDate.of(5803,  Parasha.תזריע).getDayInYear());
      assertEquals(216, HebrewDate.of(5803,  Parasha.מצרע).getDayInYear());
      assertEquals(223, HebrewDate.of(5803,  Parasha.שבת_ופסח).getDayInYear());
      assertEquals(230, HebrewDate.of(5803,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(237, HebrewDate.of(5803,  Parasha.קדשים).getDayInYear());
      assertEquals(244, HebrewDate.of(5803,  Parasha.אמר).getDayInYear());
      assertEquals(251, HebrewDate.of(5803,  Parasha.בהר).getDayInYear());
      assertEquals(258, HebrewDate.of(5803,  Parasha.בחקתי).getDayInYear());
      assertEquals(384, HebrewDate.of(5803,  Parasha.נצבים).getDayInYear());
      // Only one וילך at the first of the this year
      assertEquals(6, HebrewDate.of(5803,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void checkShabatDayInYearגכה()
   {
      assertEquals(5, HebrewDate.of(5786,  Parasha.וילך, false).getDayInYear());
      assertEquals(12, HebrewDate.of(5786,  Parasha.האזינו).getDayInYear());
      assertEquals(19, HebrewDate.of(5786,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(173, HebrewDate.of(5786,  Parasha.ויקהל).getDayInYear());
      assertEquals(173, HebrewDate.of(5786,  Parasha.פקודי).getDayInYear());
      assertEquals(180, HebrewDate.of(5786,  Parasha.ויקרא).getDayInYear());
      assertEquals(187, HebrewDate.of(5786,  Parasha.צו).getDayInYear());
      assertEquals(194, HebrewDate.of(5786,  Parasha.שבת_חול_המועד_פסח).getDayInYear());
      assertEquals(201, HebrewDate.of(5786,  Parasha.שמיני).getDayInYear());
      assertEquals(208, HebrewDate.of(5786,  Parasha.תזריע).getDayInYear());
      assertEquals(208, HebrewDate.of(5786,  Parasha.מצרע).getDayInYear());
      assertEquals(215, HebrewDate.of(5786,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(215, HebrewDate.of(5786,  Parasha.קדשים).getDayInYear());
      assertEquals(222, HebrewDate.of(5786,  Parasha.אמר).getDayInYear());
      assertEquals(229, HebrewDate.of(5786,  Parasha.בהר).getDayInYear());
      assertEquals(229, HebrewDate.of(5786,  Parasha.בחקתי).getDayInYear());
      assertEquals(348, HebrewDate.of(5786,  Parasha.נצבים).getDayInYear());
      assertEquals(348, HebrewDate.of(5786,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void checkShabatDayInYearגכז()
   {
      assertEquals(5, HebrewDate.of(5782,  Parasha.וילך).getDayInYear());
      assertEquals(12, HebrewDate.of(5782,  Parasha.האזינו).getDayInYear());
      assertEquals(19, HebrewDate.of(5782,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(173, HebrewDate.of(5782,  Parasha.ויקהל).getDayInYear());
      assertEquals(180, HebrewDate.of(5782,  Parasha.פקודי).getDayInYear());
      assertEquals(187, HebrewDate.of(5782,  Parasha.ויקרא).getDayInYear());
      assertEquals(194, HebrewDate.of(5782,  Parasha.צו).getDayInYear());
      assertEquals(201, HebrewDate.of(5782,  Parasha.שמיני).getDayInYear());
      assertEquals(208, HebrewDate.of(5782,  Parasha.תזריע).getDayInYear());
      assertEquals(215, HebrewDate.of(5782,  Parasha.מצרע).getDayInYear());
      assertEquals(222, HebrewDate.of(5782,  Parasha.שבת_ופסח).getDayInYear());
      assertEquals(229, HebrewDate.of(5782,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(236, HebrewDate.of(5782,  Parasha.קדשים).getDayInYear());
      assertEquals(243, HebrewDate.of(5782,  Parasha.אמר).getDayInYear());
      assertEquals(250, HebrewDate.of(5782,  Parasha.בהר).getDayInYear());
      assertEquals(257, HebrewDate.of(5782,  Parasha.בחקתי).getDayInYear());
      assertEquals(383, HebrewDate.of(5782,  Parasha.נצבים).getDayInYear());
      // Only one וילך at the start of the this year
      assertEquals(5, HebrewDate.of(5782,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void checkShabatDayInYearהכז()
   {
      // No וילך for this  year
      assertEquals(null, HebrewDate.of(5789,  Parasha.וילך));
      assertEquals(3, HebrewDate.of(5789,  Parasha.האזינו).getDayInYear());
      assertEquals(10, HebrewDate.of(5789,  Parasha.שבת_ויום_כיפור).getDayInYear());
      assertEquals(17, HebrewDate.of(5789,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(171, HebrewDate.of(5789,  Parasha.ויקהל).getDayInYear());
      assertEquals(171, HebrewDate.of(5789,  Parasha.פקודי).getDayInYear());
      assertEquals(178, HebrewDate.of(5789,  Parasha.ויקרא).getDayInYear());
      assertEquals(185, HebrewDate.of(5789,  Parasha.צו).getDayInYear());
      assertEquals(192, HebrewDate.of(5789,  Parasha.שבת_ופסח).getDayInYear());
      assertEquals(199, HebrewDate.of(5789,  Parasha.שמיני).getDayInYear());
      assertEquals(206, HebrewDate.of(5789,  Parasha.תזריע).getDayInYear());
      assertEquals(206, HebrewDate.of(5789,  Parasha.מצרע).getDayInYear());
      assertEquals(213, HebrewDate.of(5789,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(213, HebrewDate.of(5789,  Parasha.קדשים).getDayInYear());
      assertEquals(220, HebrewDate.of(5789,  Parasha.אמר).getDayInYear());
      assertEquals(227, HebrewDate.of(5789,  Parasha.בהר).getDayInYear());
      assertEquals(234, HebrewDate.of(5789,  Parasha.בחקתי).getDayInYear());
      assertEquals(353, HebrewDate.of(5789,  Parasha.נצבים).getDayInYear());
      // No וילך for this  year
      assertEquals(null, HebrewDate.of(5789,  Parasha.וילך, true));
   }

   @Test
   public void checkShabatDayInYearהחא()
   {
      // No וילך for this  year
      assertEquals(null, HebrewDate.of(5765,  Parasha.וילך));
      assertEquals(3, HebrewDate.of(5765,  Parasha.האזינו).getDayInYear());
      assertEquals(10, HebrewDate.of(5765,  Parasha.שבת_ויום_כיפור).getDayInYear());
      assertEquals(17, HebrewDate.of(5765,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(171, HebrewDate.of(5765,  Parasha.ויקהל).getDayInYear());
      assertEquals(178, HebrewDate.of(5765,  Parasha.פקודי).getDayInYear());
      assertEquals(185, HebrewDate.of(5765,  Parasha.ויקרא).getDayInYear());
      assertEquals(192, HebrewDate.of(5765,  Parasha.צו).getDayInYear());
      assertEquals(199, HebrewDate.of(5765,  Parasha.שמיני).getDayInYear());
      assertEquals(206, HebrewDate.of(5765,  Parasha.תזריע).getDayInYear());
      assertEquals(213, HebrewDate.of(5765,  Parasha.מצרע).getDayInYear());
      assertEquals(220, HebrewDate.of(5765,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(227, HebrewDate.of(5765,  Parasha.שבת_ושביעי_של_פסח).getDayInYear());
      assertEquals(234, HebrewDate.of(5765,  Parasha.קדשים).getDayInYear());
      assertEquals(241, HebrewDate.of(5765,  Parasha.אמר).getDayInYear());
      assertEquals(248, HebrewDate.of(5765,  Parasha.בהר).getDayInYear());
      assertEquals(255, HebrewDate.of(5765,  Parasha.בחקתי).getDayInYear());
      assertEquals(381, HebrewDate.of(5765,  Parasha.נצבים).getDayInYear());
      // No וילך for this  year
      assertEquals(null, HebrewDate.of(5765,  Parasha.וילך, true));
   }

   @Test
   public void checkShabatDayInYearהשא()
   {
      // No וילך for this  year
      assertEquals(null, HebrewDate.of(5785,  Parasha.וילך));
      assertEquals(3, HebrewDate.of(5785,  Parasha.האזינו).getDayInYear());
      assertEquals(10, HebrewDate.of(5785,  Parasha.שבת_ויום_כיפור).getDayInYear());
      assertEquals(17, HebrewDate.of(5785,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(171, HebrewDate.of(5785,  Parasha.ויקהל).getDayInYear());
      assertEquals(178, HebrewDate.of(5785,  Parasha.פקודי).getDayInYear());
      assertEquals(185, HebrewDate.of(5785,  Parasha.ויקרא).getDayInYear());
      assertEquals(192, HebrewDate.of(5785,  Parasha.צו).getDayInYear());
      assertEquals(199, HebrewDate.of(5785,  Parasha.שבת_ושביעי_של_פסח).getDayInYear());
      assertEquals(206, HebrewDate.of(5785,  Parasha.שמיני).getDayInYear());
      assertEquals(213, HebrewDate.of(5785,  Parasha.תזריע).getDayInYear());
      assertEquals(213, HebrewDate.of(5785,  Parasha.מצרע).getDayInYear());
      assertEquals(220, HebrewDate.of(5785,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(220, HebrewDate.of(5785,  Parasha.קדשים).getDayInYear());
      assertEquals(227, HebrewDate.of(5785,  Parasha.אמר).getDayInYear());
      assertEquals(234, HebrewDate.of(5785,  Parasha.בהר).getDayInYear());
      assertEquals(234, HebrewDate.of(5785,  Parasha.בחקתי).getDayInYear());
      assertEquals(353, HebrewDate.of(5785,  Parasha.נצבים).getDayInYear());
      // No וילך for this  year
      assertEquals(null, HebrewDate.of(5785,  Parasha.וילך, true));
   }

   @Test
   public void checkShabatDayInYearהשג()
   {
      // Only one וילך at the end of the this year
      assertEquals(381, HebrewDate.of(5822,  Parasha.וילך).getDayInYear());
      assertEquals(3, HebrewDate.of(5822,  Parasha.האזינו).getDayInYear());
      assertEquals(10, HebrewDate.of(5822,  Parasha.שבת_ויום_כיפור).getDayInYear());
      assertEquals(17, HebrewDate.of(5822,  Parasha.שבת_חול_המועד_סוכות).getDayInYear());
      assertEquals(171, HebrewDate.of(5822,  Parasha.ויקהל).getDayInYear());
      assertEquals(178, HebrewDate.of(5822,  Parasha.פקודי).getDayInYear());
      assertEquals(185, HebrewDate.of(5822,  Parasha.ויקרא).getDayInYear());
      assertEquals(192, HebrewDate.of(5822,  Parasha.צו).getDayInYear());
      assertEquals(199, HebrewDate.of(5822,  Parasha.שמיני).getDayInYear());
      assertEquals(206, HebrewDate.of(5822,  Parasha.תזריע).getDayInYear());
      assertEquals(213, HebrewDate.of(5822,  Parasha.מצרע).getDayInYear());
      assertEquals(220, HebrewDate.of(5822,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(227, HebrewDate.of(5822,  Parasha.שבת_חול_המועד_פסח).getDayInYear());
      assertEquals(234, HebrewDate.of(5822,  Parasha.קדשים).getDayInYear());
      assertEquals(241, HebrewDate.of(5822,  Parasha.אמר).getDayInYear());
      assertEquals(248, HebrewDate.of(5822,  Parasha.בהר).getDayInYear());
      assertEquals(255, HebrewDate.of(5822,  Parasha.בחקתי).getDayInYear());
      assertEquals(381, HebrewDate.of(5822,  Parasha.נצבים).getDayInYear());
      assertEquals(381, HebrewDate.of(5822,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void checkShabatDayInYearזחא()
   {
      // No וילך for this  year
      assertEquals(null, HebrewDate.of(5781,  Parasha.וילך));
      assertEquals(8, HebrewDate.of(5781,  Parasha.האזינו).getDayInYear());
      assertEquals(15, HebrewDate.of(5781,  Parasha.שבת_וסוכות).getDayInYear());
      assertEquals(176, HebrewDate.of(5781,  Parasha.ויקהל).getDayInYear());
      assertEquals(176, HebrewDate.of(5781,  Parasha.פקודי).getDayInYear());
      assertEquals(183, HebrewDate.of(5781,  Parasha.ויקרא).getDayInYear());
      assertEquals(190, HebrewDate.of(5781,  Parasha.צו).getDayInYear());
      assertEquals(197, HebrewDate.of(5781,  Parasha.שבת_ושביעי_של_פסח).getDayInYear());
      assertEquals(204, HebrewDate.of(5781,  Parasha.שמיני).getDayInYear());
      assertEquals(211, HebrewDate.of(5781,  Parasha.תזריע).getDayInYear());
      assertEquals(211, HebrewDate.of(5781,  Parasha.מצרע).getDayInYear());
      assertEquals(218, HebrewDate.of(5781,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(218, HebrewDate.of(5781,  Parasha.קדשים).getDayInYear());
      assertEquals(225, HebrewDate.of(5781,  Parasha.אמר).getDayInYear());
      assertEquals(232, HebrewDate.of(5781,  Parasha.בהר).getDayInYear());
      assertEquals(232, HebrewDate.of(5781,  Parasha.בחקתי).getDayInYear());
      assertEquals(351, HebrewDate.of(5781,  Parasha.נצבים).getDayInYear());
      // No וילך for this  year
      assertEquals(null, HebrewDate.of(5781,  Parasha.וילך));
   }

   @Test
   public void checkShabatDayInYearזחג()
   {
      // Only one וילך at the end of the this year
      assertEquals(379, HebrewDate.of(5784,  Parasha.וילך).getDayInYear());
      assertEquals(8, HebrewDate.of(5784,  Parasha.האזינו).getDayInYear());
      assertEquals(15, HebrewDate.of(5784,  Parasha.שבת_וסוכות).getDayInYear());
      assertEquals(176, HebrewDate.of(5784,  Parasha.ויקהל).getDayInYear());
      assertEquals(183, HebrewDate.of(5784,  Parasha.פקודי).getDayInYear());
      assertEquals(190, HebrewDate.of(5784,  Parasha.ויקרא).getDayInYear());
      assertEquals(197, HebrewDate.of(5784,  Parasha.צו).getDayInYear());
      assertEquals(204, HebrewDate.of(5784,  Parasha.שמיני).getDayInYear());
      assertEquals(211, HebrewDate.of(5784,  Parasha.תזריע).getDayInYear());
      assertEquals(218, HebrewDate.of(5784,  Parasha.מצרע).getDayInYear());
      assertEquals(225, HebrewDate.of(5784,  Parasha.שבת_חול_המועד_פסח).getDayInYear());
      assertEquals(232, HebrewDate.of(5784,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(239, HebrewDate.of(5784,  Parasha.קדשים).getDayInYear());
      assertEquals(246, HebrewDate.of(5784,  Parasha.אמר).getDayInYear());
      assertEquals(253, HebrewDate.of(5784,  Parasha.בהר).getDayInYear());
      assertEquals(260, HebrewDate.of(5784,  Parasha.בחקתי).getDayInYear());
      assertEquals(379, HebrewDate.of(5784,  Parasha.נצבים).getDayInYear());
      assertEquals(379, HebrewDate.of(5784,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void checkShabatDayInYearזשג()
   {
      // Only one וילך at the end of the this year
      assertEquals(351, HebrewDate.of(5764,  Parasha.וילך).getDayInYear());
      assertEquals(8, HebrewDate.of(5764,  Parasha.האזינו).getDayInYear());
      assertEquals(15, HebrewDate.of(5764,  Parasha.שבת_וסוכות).getDayInYear());
      assertEquals(176, HebrewDate.of(5764,  Parasha.ויקהל).getDayInYear());
      assertEquals(176, HebrewDate.of(5764,  Parasha.פקודי).getDayInYear());
      assertEquals(183, HebrewDate.of(5764,  Parasha.ויקרא).getDayInYear());
      assertEquals(190, HebrewDate.of(5764,  Parasha.צו).getDayInYear());
      assertEquals(197, HebrewDate.of(5764,  Parasha.שבת_חול_המועד_פסח).getDayInYear());
      assertEquals(204, HebrewDate.of(5764,  Parasha.שמיני).getDayInYear());
      assertEquals(211, HebrewDate.of(5764,  Parasha.תזריע).getDayInYear());
      assertEquals(211, HebrewDate.of(5764,  Parasha.מצרע).getDayInYear());
      assertEquals(218, HebrewDate.of(5764,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(218, HebrewDate.of(5764,  Parasha.קדשים).getDayInYear());
      assertEquals(225, HebrewDate.of(5764,  Parasha.אמר).getDayInYear());
      assertEquals(232, HebrewDate.of(5764,  Parasha.בהר).getDayInYear());
      assertEquals(232, HebrewDate.of(5764,  Parasha.בחקתי).getDayInYear());
      assertEquals(351, HebrewDate.of(5764,  Parasha.נצבים).getDayInYear());
      assertEquals(351, HebrewDate.of(5764,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void checkShabatDayInYearזשה()
   {
      // Only one וילך at the end of the this year
      assertEquals(379, HebrewDate.of(5814,  Parasha.וילך).getDayInYear());
      assertEquals(8, HebrewDate.of(5814,  Parasha.האזינו).getDayInYear());
      assertEquals(15, HebrewDate.of(5814,  Parasha.שבת_וסוכות).getDayInYear());
      assertEquals(176, HebrewDate.of(5814,  Parasha.ויקהל).getDayInYear());
      assertEquals(183, HebrewDate.of(5814,  Parasha.פקודי).getDayInYear());
      assertEquals(190, HebrewDate.of(5814,  Parasha.ויקרא).getDayInYear());
      assertEquals(197, HebrewDate.of(5814,  Parasha.צו).getDayInYear());
      assertEquals(204, HebrewDate.of(5814,  Parasha.שמיני).getDayInYear());
      assertEquals(211, HebrewDate.of(5814,  Parasha.תזריע).getDayInYear());
      assertEquals(218, HebrewDate.of(5814,  Parasha.מצרע).getDayInYear());
      assertEquals(225, HebrewDate.of(5814,  Parasha.שבת_חול_המועד_פסח).getDayInYear());
      assertEquals(232, HebrewDate.of(5814,  Parasha.אחרי_מות).getDayInYear());
      assertEquals(239, HebrewDate.of(5814,  Parasha.קדשים).getDayInYear());
      assertEquals(246, HebrewDate.of(5814,  Parasha.אמר).getDayInYear());
      assertEquals(253, HebrewDate.of(5814,  Parasha.בהר).getDayInYear());
      assertEquals(260, HebrewDate.of(5814,  Parasha.בחקתי).getDayInYear());
      assertEquals(379, HebrewDate.of(5814,  Parasha.נצבים).getDayInYear());
      assertEquals(379, HebrewDate.of(5814,  Parasha.וילך, true).getDayInYear());
   }

   @Test
   public void vayelechOverYears()
   {
      // בשז
      HebrewDate date = HebrewDate.of(5779, Parasha.וילך, false);
      assertEquals(5779, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(6, date.getDay());

      date = HebrewDate.of(5779, Parasha.וילך, true);
      assertEquals(5779, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(6, date.getDay());

      // זחא
      date = HebrewDate.of(5781, Parasha.וילך, false);
      assertNull(date);

      date = HebrewDate.of(5781, Parasha.וילך, true);
      assertNull(date);

      // גכז
      date = HebrewDate.of(5782, Parasha.וילך, false);
      assertEquals(5782, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(5, date.getDay());

      date = HebrewDate.of(5782, Parasha.וילך, true);
      assertEquals(5782, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(5, date.getDay());

      // בשה
      date = HebrewDate.of(5783, Parasha.וילך, false);
      assertEquals(5783, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(6, date.getDay());

      date = HebrewDate.of(5783, Parasha.וילך, true);
      assertEquals(5783, date.getYear());
      assertEquals(12, date.getMonth());
      assertEquals(23, date.getDay());

      // זחג
      date = HebrewDate.of(5784, Parasha.וילך, false);
      assertEquals(5784, date.getYear());
      assertEquals(13, date.getMonth());
      assertEquals(25, date.getDay());

      date = HebrewDate.of(5784, Parasha.וילך, true);
      assertEquals(5784, date.getYear());
      assertEquals(13, date.getMonth());
      assertEquals(25, date.getDay());

      //השא
      date = HebrewDate.of(5785, Parasha.וילך, false);
      assertNull(date);

      date = HebrewDate.of(5785, Parasha.וילך, true);
      assertNull(date);

      // גכה
      date = HebrewDate.of(5786, Parasha.וילך, false);
      assertEquals(5786, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(5, date.getDay());

      date = HebrewDate.of(5786, Parasha.וילך, true);
      assertEquals(5786, date.getYear());
      assertEquals(12, date.getMonth());
      assertEquals(23, date.getDay());

      // זשה
      date = HebrewDate.of(5787, Parasha.וילך, false);
      assertEquals(5787, date.getYear());
      assertEquals(13, date.getMonth());
      assertEquals(23, date.getDay());

      date = HebrewDate.of(5787, Parasha.וילך, true);
      assertEquals(5787, date.getYear());
      assertEquals(13, date.getMonth());
      assertEquals(23, date.getDay());

      // זשג
      date = HebrewDate.of(5788, Parasha.וילך, false);
      assertEquals(5788, date.getYear());
      assertEquals(12, date.getMonth());
      assertEquals(25, date.getDay());

      date = HebrewDate.of(5788, Parasha.וילך, true);
      assertEquals(5788, date.getYear());
      assertEquals(12, date.getMonth());
      assertEquals(25, date.getDay());

      // הכז
      date = HebrewDate.of(5789, Parasha.וילך, false);
      assertNull(date);

      date = HebrewDate.of(5789, Parasha.וילך, true);
      assertNull(date);

      // בחה
      date = HebrewDate.of(5790, Parasha.וילך, false);
      assertEquals(5790, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(6, date.getDay());

      date = HebrewDate.of(5790, Parasha.וילך, true);
      assertEquals(5790, date.getYear());
      assertEquals(13, date.getMonth());
      assertEquals(23, date.getDay());

      // השג
      date = HebrewDate.of(5795, Parasha.וילך, false);
      assertEquals(5795, date.getYear());
      assertEquals(13, date.getMonth());
      assertEquals(25, date.getDay());

      date = HebrewDate.of(5795, Parasha.וילך, true);
      assertEquals(5795, date.getYear());
      assertEquals(13, date.getMonth());
      assertEquals(25, date.getDay());
   }

   @Test
   public void aazinuOverYears()
   {
      // זחא
      HebrewDate date = HebrewDate.of(5781, Parasha.האזינו, false);
      assertEquals(5781, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(8, date.getDay());

      date = HebrewDate.of(5781, Parasha.האזינו, true);
      assertEquals(5781, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(8, date.getDay());

      // גכז
      date = HebrewDate.of(5782, Parasha.האזינו, false);
      assertEquals(5782, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(12, date.getDay());

      date = HebrewDate.of(5782, Parasha.האזינו, true);
      assertEquals(5782, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(12, date.getDay());

      // בשה
      date = HebrewDate.of(5783, Parasha.האזינו, false);
      assertEquals(5783, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(13, date.getDay());

      date = HebrewDate.of(5783, Parasha.האזינו, true);
      assertEquals(5783, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(13, date.getDay());

      // זחג
      date = HebrewDate.of(5784, Parasha.האזינו, false);
      assertEquals(5784, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(8, date.getDay());

      date = HebrewDate.of(5784, Parasha.האזינו, true);
      assertEquals(5784, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(8, date.getDay());

      //השא
      date = HebrewDate.of(5785, Parasha.האזינו, false);
      assertEquals(5785, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(3, date.getDay());

      date = HebrewDate.of(5785, Parasha.האזינו, true);
      assertEquals(5785, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(3, date.getDay());
   }
}

