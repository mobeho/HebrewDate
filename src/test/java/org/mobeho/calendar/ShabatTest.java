package org.mobeho.calendar;

import junit.framework.TestCase;
import org.mobeho.calendar.hilchaty.ShabatHoli;
import org.mobeho.calendar.hilchaty.Shabbat;
import org.mobeho.calendar.hilchaty.YearType;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mobeho.calendar.HebrewDate.getShabatIndexes;

/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class ShabatTest
{

   @Test
   public void numberOfParashotבחג()
   {
      final YearType type = YearType.בחג;
      
      assertEquals(1						, Shabbat.numberOfParashot(type, -2, 0)); //
      assertEquals(2						, Shabbat.numberOfParashot(type, -2, 1)); // Aazinu
      assertEquals(2						, Shabbat.numberOfParashot(type, -2, 2)); // Succot
      assertEquals(3						, Shabbat.numberOfParashot(type, -2, 3)); // Bereshit
      assertEquals(4						, Shabbat.numberOfParashot(type, -2, 4)); // Noach

      assertEquals(23						, Shabbat.numberOfParashot(type, -2, 23));
      assertEquals(25						, Shabbat.numberOfParashot(type, -2, 24));
      assertEquals(27						, Shabbat.numberOfParashot(type, -2, 26));
      assertEquals(27						, Shabbat.numberOfParashot(type, -2, 27));
      assertEquals(28						, Shabbat.numberOfParashot(type, -2, 28));
      assertEquals(30						, Shabbat.numberOfParashot(type, -2, 29));
      assertEquals(32						, Shabbat.numberOfParashot(type, -2, 30));
      assertEquals(33						, Shabbat.numberOfParashot(type, -2, 31));
      assertEquals(35						, Shabbat.numberOfParashot(type, -2, 32));
   
      assertEquals(1						, Shabbat.numberOfParashot(type, -1, 0)); //
      assertEquals(1						, Shabbat.numberOfParashot(type, -1, 1)); //
      assertEquals(2						, Shabbat.numberOfParashot(type, -1, 2)); //
      assertEquals(3						, Shabbat.numberOfParashot(type, -1, 3)); //
   
      assertEquals(0						, Shabbat.numberOfParashot(type,  0, 0));
      assertEquals(1						, Shabbat.numberOfParashot(type,  0, 1));
      assertEquals(2						, Shabbat.numberOfParashot(type,  0, 2));

      assertEquals(1						, Shabbat.numberOfParashot(type, 1, 0));
      assertEquals(2						, Shabbat.numberOfParashot(type, 1, 1));
      assertEquals(21						, Shabbat.numberOfParashot(type, 1, 20));
      assertEquals(22+1					, Shabbat.numberOfParashot(type, 1, 21)); // Vaiakhel
      assertEquals(23+1					, Shabbat.numberOfParashot(type, 1, 22));
      assertEquals(24+1					, Shabbat.numberOfParashot(type, 1, 23));
      assertEquals(25+1-1					, Shabbat.numberOfParashot(type, 1, 24)); // Pesach
      assertEquals(26+1-1					, Shabbat.numberOfParashot(type, 1, 25));
      assertEquals(27+1-1+1				, Shabbat.numberOfParashot(type, 1, 26)); //Tazriaa
      assertEquals(28+1-1+1+1			, Shabbat.numberOfParashot(type, 1, 27)); //Avharei
      assertEquals(29+1-1+1+1			, Shabbat.numberOfParashot(type, 1, 28)); // Emor
      assertEquals(30+1-1+1+1+1			, Shabbat.numberOfParashot(type, 1, 29)); // Behar
      assertEquals(31+1-1+1+1+1			, Shabbat.numberOfParashot(type, 1, 30)); // Bamidbar
      assertEquals(38+1-1+1+1+1			, Shabbat.numberOfParashot(type, 1, 37)); // Pinchas
      assertEquals(39+1-1+1+1+1+1		, Shabbat.numberOfParashot(type, 1, 38)); // Matot
      assertEquals(46+1-1+1+1+1+1		, Shabbat.numberOfParashot(type, 1, 45)); // Ki Tavo
      assertEquals(47+1-1+1+1+1+1+1	, Shabbat.numberOfParashot(type, 1, 46)); // Nitzavim
//      assertEquals(49+1-1+1+1+1+1+1	, Shabbat.numberOfParashot(type, 1, 49)); //
      
      assertEquals(1	, Shabbat.numberOfParashot(type, 21, 0));
      assertEquals(3	, Shabbat.numberOfParashot(type, 21, 1));
      assertEquals(4	, Shabbat.numberOfParashot(type, 21, 2));
      assertEquals(5	, Shabbat.numberOfParashot(type, 21, 3));
      assertEquals(5	, Shabbat.numberOfParashot(type, 21, 4));
      assertEquals(6	, Shabbat.numberOfParashot(type, 21, 5));
      
      assertEquals(0	, Shabbat.numberOfParashot(type, 25, 0));
      assertEquals(1	, Shabbat.numberOfParashot(type, 25, 1));
   
      assertEquals(1	, Shabbat.numberOfParashot(type, 26, 0));
      assertEquals(3	, Shabbat.numberOfParashot(type, 26, 1));
      assertEquals(5	, Shabbat.numberOfParashot(type, 26, 2));
      assertEquals(6	, Shabbat.numberOfParashot(type, 26, 3));
      assertEquals(8	, Shabbat.numberOfParashot(type, 26, 4));
      assertEquals(9	, Shabbat.numberOfParashot(type, 26, 5));

      // Last Shabat
      assertEquals(1	, Shabbat.numberOfParashot(type, 47, 0));
      assertEquals(2	, Shabbat.numberOfParashot(type, 47, 1));
      assertEquals(2	, Shabbat.numberOfParashot(type, 47, 2));
      assertEquals(2	, Shabbat.numberOfParashot(type, 47, 3));
		assertEquals(4	, Shabbat.numberOfParashot(type, 47, 5));
   }
	
	@Test
	public void numberOfParashotבחה()
	{
		final YearType type = YearType.בחה;
		assertEquals(1				, Shabbat.numberOfParashot(type, 1, 0));
		assertEquals(2				, Shabbat.numberOfParashot(type, 1, 1));
		assertEquals(21				, Shabbat.numberOfParashot(type, 1, 20));
		assertEquals(28				, Shabbat.numberOfParashot(type, 1, 27)); // Metzora
		assertEquals(29-1			, Shabbat.numberOfParashot(type, 1, 28)); // Pesach
      assertEquals(30-1			, Shabbat.numberOfParashot(type, 1, 29)); // Achrei
      assertEquals(43-1+1			, Shabbat.numberOfParashot(type, 1, 42)); // Matot
      assertEquals(51-1+1+1		, Shabbat.numberOfParashot(type, 1, 50)); // Nitzavim
		assertEquals(51-1+1+1		, Shabbat.numberOfParashot(type, 1, 51)); // Nitzavim
      assertEquals(51-1+1+1+1   , Shabbat.numberOfParashot(type, 1, 52)); // Next Rosh Hashana
	}
	
	@Test
	public void numberOfParashotזחא()
	{
		final YearType type = YearType.זחא;
		assertEquals(0						, Shabbat.numberOfParashot(type, -3, 0)); // Rosh Hashan
		assertEquals(1						, Shabbat.numberOfParashot(type, -3, 1)); // Rosh Hashan
		assertEquals(1						, Shabbat.numberOfParashot(type, -3, 2)); // Aazinu
		assertEquals(1						, Shabbat.numberOfParashot(type, -3, 3)); // Succot
		assertEquals(2						, Shabbat.numberOfParashot(type, -3, 4)); // Succot
		assertEquals(3						, Shabbat.numberOfParashot(type, -3, 5)); // Bereshit
		assertEquals(1						, Shabbat.numberOfParashot(type, -2, 0));
      assertEquals(1						, Shabbat.numberOfParashot(type, -2, 1));
      assertEquals(1						, Shabbat.numberOfParashot(type, -2, 2));
      assertEquals(2						, Shabbat.numberOfParashot(type, -2, 3));
      assertEquals(3						, Shabbat.numberOfParashot(type, -2, 4));
		assertEquals(0						, Shabbat.numberOfParashot(type, -1, 0));
      assertEquals(0						, Shabbat.numberOfParashot(type, -1, 1));
      assertEquals(1						, Shabbat.numberOfParashot(type, -1, 2));
      assertEquals(2						, Shabbat.numberOfParashot(type, -1, 3));
		assertEquals(0						, Shabbat.numberOfParashot(type, 0, 0));
      assertEquals(1						, Shabbat.numberOfParashot(type, 0, 1));
      assertEquals(2						, Shabbat.numberOfParashot(type, 0, 2));
		assertEquals(1						, Shabbat.numberOfParashot(type, 1, 0));
		assertEquals(21						, Shabbat.numberOfParashot(type, 1, 20));
	}

   @Test
   public void numberOfParashotהכז()
   {
      final YearType type = YearType.הכז;
		assertEquals(1					, Shabbat.numberOfParashot(type, -2, 0));
		assertEquals(1					, Shabbat.numberOfParashot(type, -2, 1));
		assertEquals(1					, Shabbat.numberOfParashot(type, -2, 2));
		assertEquals(2					, Shabbat.numberOfParashot(type, -2, 3));
	
		assertEquals(0					, Shabbat.numberOfParashot(type, -1, 0));
      assertEquals(0					, Shabbat.numberOfParashot(type, -1, 1));
      assertEquals(1					, Shabbat.numberOfParashot(type, -1, 2));
      
		assertEquals(0					, Shabbat.numberOfParashot(type,  0, 0));
		assertEquals(1					, Shabbat.numberOfParashot(type,  0, 1));
      
      assertEquals(1					, Shabbat.numberOfParashot(type, 1, 0));
      assertEquals(2					, Shabbat.numberOfParashot(type, 1, 1));
      assertEquals(21					, Shabbat.numberOfParashot(type, 1, 20));
      assertEquals(22+1				, Shabbat.numberOfParashot(type, 1, 21)); // Vaiakhel
      assertEquals(23+1				, Shabbat.numberOfParashot(type, 1, 22));
      assertEquals(24+1				, Shabbat.numberOfParashot(type, 1, 23));
      assertEquals(25+1-1				, Shabbat.numberOfParashot(type, 1, 24)); // Pesach
      assertEquals(26+1-1				, Shabbat.numberOfParashot(type, 1, 25));
      assertEquals(27+1-1+1			, Shabbat.numberOfParashot(type, 1, 26)); //Tazriaa
      assertEquals(28+1-1+1+1		, Shabbat.numberOfParashot(type, 1, 27)); //Avharei
      assertEquals(29+1-1+1+1		, Shabbat.numberOfParashot(type, 1, 28)); // Emor
      assertEquals(30+1-1+1+1		, Shabbat.numberOfParashot(type, 1, 29)); // Behar
      assertEquals(31+1-1+1+1		, Shabbat.numberOfParashot(type, 1, 30)); // Emor
      assertEquals(39+1-1+1+1		, Shabbat.numberOfParashot(type, 1, 38)); //
      assertEquals(40+1-1+1+1+1		, Shabbat.numberOfParashot(type, 1, 39)); //
      assertEquals(42+1-1+1+1+1		, Shabbat.numberOfParashot(type, 1, 41)); //
	
		assertEquals(0				, Shabbat.numberOfParashot(type, 25, 0));
		assertEquals(1				, Shabbat.numberOfParashot(type, 25, 1));
		assertEquals(3				, Shabbat.numberOfParashot(type, 25, 2));
		assertEquals(5				, Shabbat.numberOfParashot(type, 25, 3));
   }
   
   @Test
   public void numberOfParashotהחא()
   {
      final YearType type = YearType.החא;
      assertEquals(1						, Shabbat.numberOfParashot(type, 1, 0));
      assertEquals(2						, Shabbat.numberOfParashot(type, 1, 1));
      assertEquals(21						, Shabbat.numberOfParashot(type, 1, 20));
      assertEquals(30-1					, Shabbat.numberOfParashot(type, 1, 29)); // Pesach
      assertEquals(43-1					, Shabbat.numberOfParashot(type, 1, 42)); // Matot
      assertEquals(51-1					, Shabbat.numberOfParashot(type, 1, 50)); // Nitzavim
	
		assertEquals(0					, Shabbat.numberOfParashot(type, 30, 0)); // Pesach
		assertEquals(1					, Shabbat.numberOfParashot(type, 30, 1));
   }

   @Test
   public void checkShabatNameבחג()
   {
      final YearType type = YearType.בחג;
      int day = 0;
      while (day++ < 6) assertEquals("וילך", Shabbat.getShabatName(type, day));
      while (day++ < 13) assertEquals("האזינו", Shabbat.getShabatName(type, day));
      while (day++ < 20) assertEquals("שבת חול המועד סוכות", Shabbat.getShabatName(type, day));
      while (day++ < 27) assertEquals("בראשית", Shabbat.getShabatName(type, day));
      while (day++ < 34) assertEquals("נח", Shabbat.getShabatName(type, day));
      while (day++ < 41) assertEquals("לך-לך", Shabbat.getShabatName(type, day));
      while (day++ < 48) assertEquals("וירא", Shabbat.getShabatName(type, day));
      while (day++ < 55) assertEquals("חיי-שרה", Shabbat.getShabatName(type, day));
      while (day++ < 62) assertEquals("תולדות", Shabbat.getShabatName(type, day));
      while (day++ < 69) assertEquals("ויצא", Shabbat.getShabatName(type, day));
      while (day++ < 76) assertEquals("וישלח", Shabbat.getShabatName(type, day));
      while (day++ < 83) assertEquals("וישב", Shabbat.getShabatName(type, day));
      while (day++ < 90) assertEquals("מקץ", Shabbat.getShabatName(type, day));
      while (day++ < 97) assertEquals("ויגש", Shabbat.getShabatName(type, day));
      while (day++ < 104) assertEquals("ויחי", Shabbat.getShabatName(type, day));
      while (day++ < 111) assertEquals("שמות", Shabbat.getShabatName(type, day));
      while (day++ < 118) assertEquals("וארא", Shabbat.getShabatName(type, day));
      while (day++ < 125) assertEquals("בא", Shabbat.getShabatName(type, day));
      while (day++ < 132) assertEquals("בשלח", Shabbat.getShabatName(type, day));
      while (day++ < 139) assertEquals("יתרו", Shabbat.getShabatName(type, day));
      while (day++ < 146) assertEquals("משפטים (שקלים)", Shabbat.getShabatName(type, day));
      while (day++ < 153) assertEquals("תרומה", Shabbat.getShabatName(type, day));
      while (day++ < 160) assertEquals("תצוה (זכור)", Shabbat.getShabatName(type, day));
      while (day++ < 167) assertEquals("כי-תשא (פרה)", Shabbat.getShabatName(type, day));
      while (day++ < 174) assertEquals("ויקהל פקודי", Shabbat.getShabatName(type, day));
      while (day++ < 181) assertEquals("ויקרא", Shabbat.getShabatName(type, day));
      while (day++ < 188) assertEquals("צו", Shabbat.getShabatName(type, day));
      while (day++ < 195) assertEquals("שבת חול המועד פסח", Shabbat.getShabatName(type, day));
      while (day++ < 202) assertEquals("שמיני", Shabbat.getShabatName(type, day));
      while (day++ < 209) assertEquals("תזריע מצרע", Shabbat.getShabatName(type, day));
      while (day++ < 216) assertEquals("אחרי-מות קדשים", Shabbat.getShabatName(type, day));
      while (day++ < 223) assertEquals("אמר", Shabbat.getShabatName(type, day));
      while (day++ < 230) assertEquals("בהר בחקתי", Shabbat.getShabatName(type, day));
      while (day++ < 237) assertEquals("במדבר", Shabbat.getShabatName(type, day));
      while (day++ < 244) assertEquals("נשא", Shabbat.getShabatName(type, day));
      while (day++ < 251) assertEquals("בהעלתך", Shabbat.getShabatName(type, day));
      while (day++ < 258) assertEquals("שלח-לך", Shabbat.getShabatName(type, day));
      while (day++ < 265) assertEquals("קרח", Shabbat.getShabatName(type, day));
      while (day++ < 272) assertEquals("חקת", Shabbat.getShabatName(type, day));
      while (day++ < 279) assertEquals("בלק", Shabbat.getShabatName(type, day));
      while (day++ < 286) assertEquals("פינחס", Shabbat.getShabatName(type, day));
      while (day++ < 293) assertEquals("מטות מסעי", Shabbat.getShabatName(type, day));
      while (day++ < 300) assertEquals("דברים", Shabbat.getShabatName(type, day));
      while (day++ < 307) assertEquals("ואתחנן", Shabbat.getShabatName(type, day));
      while (day++ < 314) assertEquals("עקב", Shabbat.getShabatName(type, day));
      while (day++ < 321) assertEquals("ראה", Shabbat.getShabatName(type, day));
      while (day++ < 328) assertEquals("שפטים", Shabbat.getShabatName(type, day));
      while (day++ < 335) assertEquals("כי-תצא", Shabbat.getShabatName(type, day));
      while (day++ < 342) assertEquals("כי-תבוא", Shabbat.getShabatName(type, day));
      while (day++ < 349) assertEquals("נצבים וילך", Shabbat.getShabatName(type, day));
      while (day++ < 353) assertEquals("האזינו", Shabbat.getShabatName(type, day));
      while (day++ < 356) assertEquals("", Shabbat.getShabatName(type, day));
   }


   @Test
   public void checkShabatDayInYearבחג()
   {
      final YearType type = YearType.בחג;
      assertEquals(6, Shabbat.getDayInYear(type, Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(13, Shabbat.getDayInYear(type, Shabbat.Shabbatot.האזינו.ordinal()+1));

      assertEquals(27, Shabbat.getDayInYear(type, Shabbat.Shabbatot.בראשית.ordinal()+1));
      assertEquals(34, Shabbat.getDayInYear(type, Shabbat.Shabbatot.נח.ordinal()+1));
      assertEquals(41, Shabbat.getDayInYear(type, Shabbat.Shabbatot.לך_לך.ordinal()+1));
      assertEquals(48, Shabbat.getDayInYear(type, Shabbat.Shabbatot.וירא.ordinal()+1));
      assertEquals(55, Shabbat.getDayInYear(type, Shabbat.Shabbatot.חיי_שרה.ordinal()+1));
      assertEquals(62, Shabbat.getDayInYear(type, Shabbat.Shabbatot.תולדות.ordinal()+1));
      assertEquals(69, Shabbat.getDayInYear(type, Shabbat.Shabbatot.ויצא.ordinal()+1));
      assertEquals(76, Shabbat.getDayInYear(type, Shabbat.Shabbatot.וישלח.ordinal()+1));
      assertEquals(83, Shabbat.getDayInYear(type, Shabbat.Shabbatot.וישב.ordinal()+1));
      assertEquals(90, Shabbat.getDayInYear(type, Shabbat.Shabbatot.מקץ.ordinal()+1));
      assertEquals(97, Shabbat.getDayInYear(type, Shabbat.Shabbatot.ויגש.ordinal()+1));
      assertEquals(104, Shabbat.getDayInYear(type, Shabbat.Shabbatot.ויחי.ordinal()+1));
      assertEquals(111, Shabbat.getDayInYear(type, Shabbat.Shabbatot.שמות.ordinal()+1));
      assertEquals(118, Shabbat.getDayInYear(type, Shabbat.Shabbatot.וארא.ordinal()+1));
      assertEquals(125, Shabbat.getDayInYear(type, Shabbat.Shabbatot.בא.ordinal()+1));
      assertEquals(132, Shabbat.getDayInYear(type, Shabbat.Shabbatot.בשלח.ordinal()+1));
      assertEquals(139, Shabbat.getDayInYear(type, Shabbat.Shabbatot.יתרו.ordinal()+1));
      assertEquals(146, Shabbat.getDayInYear(type, Shabbat.Shabbatot.משפטים.ordinal()+1));
      assertEquals(153, Shabbat.getDayInYear(type, Shabbat.Shabbatot.תרומה.ordinal()+1));
      assertEquals(160, Shabbat.getDayInYear(type, Shabbat.Shabbatot.תצוה.ordinal()+1));
      assertEquals(167, Shabbat.getDayInYear(type, Shabbat.Shabbatot.כי_תשא.ordinal()+1));
      assertEquals(174, Shabbat.getDayInYear(type, Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(174, Shabbat.getDayInYear(type, Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(181, Shabbat.getDayInYear(type, Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(188, Shabbat.getDayInYear(type, Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(202, Shabbat.getDayInYear(type, Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(209, Shabbat.getDayInYear(type, Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(209, Shabbat.getDayInYear(type, Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(216, Shabbat.getDayInYear(type, Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(216, Shabbat.getDayInYear(type, Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(223, Shabbat.getDayInYear(type, Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(230, Shabbat.getDayInYear(type, Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(230, Shabbat.getDayInYear(type, Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(237, Shabbat.getDayInYear(type, Shabbat.Shabbatot.במדבר.ordinal()+1));
      assertEquals(244, Shabbat.getDayInYear(type, Shabbat.Shabbatot.נשא.ordinal()+1));
      assertEquals(251, Shabbat.getDayInYear(type, Shabbat.Shabbatot.בהעלתך.ordinal()+1));
      assertEquals(258, Shabbat.getDayInYear(type, Shabbat.Shabbatot.שלח_לך.ordinal()+1));
      assertEquals(265, Shabbat.getDayInYear(type, Shabbat.Shabbatot.קרח.ordinal()+1));
      assertEquals(272, Shabbat.getDayInYear(type, Shabbat.Shabbatot.חקת.ordinal()+1));
      assertEquals(279, Shabbat.getDayInYear(type, Shabbat.Shabbatot.בלק.ordinal()+1));
      assertEquals(286, Shabbat.getDayInYear(type, Shabbat.Shabbatot.פינחס.ordinal()+1));
      assertEquals(293, Shabbat.getDayInYear(type, Shabbat.Shabbatot.מטות.ordinal()+1));
      assertEquals(293, Shabbat.getDayInYear(type, Shabbat.Shabbatot.מסעי.ordinal()+1));
      assertEquals(300, Shabbat.getDayInYear(type, Shabbat.Shabbatot.דברים.ordinal()+1));
      assertEquals(307, Shabbat.getDayInYear(type, Shabbat.Shabbatot.ואתחנן.ordinal()+1));
      assertEquals(314, Shabbat.getDayInYear(type, Shabbat.Shabbatot.עקב.ordinal()+1));
      assertEquals(321, Shabbat.getDayInYear(type, Shabbat.Shabbatot.ראה.ordinal()+1));
      assertEquals(328, Shabbat.getDayInYear(type, Shabbat.Shabbatot.שפטים.ordinal()+1));
      assertEquals(335, Shabbat.getDayInYear(type, Shabbat.Shabbatot.כי_תצא.ordinal()+1));
      assertEquals(342, Shabbat.getDayInYear(type, Shabbat.Shabbatot.כי_תבוא.ordinal()+1));
      assertEquals(349, Shabbat.getDayInYear(type, Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(349, Shabbat.getDayInYear(type, Shabbat.Shabbatot.וילך.ordinal()+1));
   }


   @Test
   public void checkShabatNameבחה()
   {
      final YearType type = YearType.בחה;
      int day = 0;
      while (day++ < 6) assertEquals("וילך", Shabbat.getShabatName(type, day));
      while (day++ < 13) assertEquals("האזינו", Shabbat.getShabatName(type, day));
      while (day++ < 20) assertEquals("שבת חול המועד סוכות", Shabbat.getShabatName(type, day));
      while (day++ < 27) assertEquals("בראשית", Shabbat.getShabatName(type, day));
      while (day++ < 34) assertEquals("נח", Shabbat.getShabatName(type, day));
      while (day++ < 41) assertEquals("לך-לך", Shabbat.getShabatName(type, day));
      while (day++ < 48) assertEquals("וירא", Shabbat.getShabatName(type, day));
      while (day++ < 55) assertEquals("חיי-שרה", Shabbat.getShabatName(type, day));
      while (day++ < 62) assertEquals("תולדות", Shabbat.getShabatName(type, day));
      while (day++ < 69) assertEquals("ויצא", Shabbat.getShabatName(type, day));
      while (day++ < 76) assertEquals("וישלח", Shabbat.getShabatName(type, day));
      while (day++ < 83) assertEquals("וישב", Shabbat.getShabatName(type, day));
      while (day++ < 90) assertEquals("מקץ", Shabbat.getShabatName(type, day));
      while (day++ < 97) assertEquals("ויגש", Shabbat.getShabatName(type, day));
      while (day++ < 104) assertEquals("ויחי", Shabbat.getShabatName(type, day));
      while (day++ < 111) assertEquals("שמות", Shabbat.getShabatName(type, day));
      while (day++ < 118) assertEquals("וארא", Shabbat.getShabatName(type, day));
      while (day++ < 125) assertEquals("בא", Shabbat.getShabatName(type, day));
      while (day++ < 132) assertEquals("בשלח", Shabbat.getShabatName(type, day));
      while (day++ < 139) assertEquals("יתרו", Shabbat.getShabatName(type, day));
      while (day++ < 146) assertEquals("משפטים", Shabbat.getShabatName(type, day));
      while (day++ < 153) assertEquals("תרומה", Shabbat.getShabatName(type, day));
      while (day++ < 160) assertEquals("תצוה", Shabbat.getShabatName(type, day));
      while (day++ < 167) assertEquals("כי-תשא", Shabbat.getShabatName(type, day));
      while (day++ < 174) assertEquals("ויקהל (שקלים)", Shabbat.getShabatName(type, day));
      while (day++ < 181) assertEquals("פקודי", Shabbat.getShabatName(type, day));
      while (day++ < 188) assertEquals("ויקרא (זכור)", Shabbat.getShabatName(type, day));
      while (day++ < 195) assertEquals("צו (פרה)", Shabbat.getShabatName(type, day));
      while (day++ < 202) assertEquals("שמיני (החודש)", Shabbat.getShabatName(type, day));
      while (day++ < 209) assertEquals("תזריע", Shabbat.getShabatName(type, day));
      while (day++ < 216) assertEquals("מצרע", Shabbat.getShabatName(type, day));
      while (day++ < 223) assertEquals("שבת חול המועד פסח", Shabbat.getShabatName(type, day));
      while (day++ < 230) assertEquals("אחרי-מות", Shabbat.getShabatName(type, day));
      while (day++ < 237) assertEquals("קדשים", Shabbat.getShabatName(type, day));
      while (day++ < 244) assertEquals("אמר", Shabbat.getShabatName(type, day));
      while (day++ < 251) assertEquals("בהר", Shabbat.getShabatName(type, day));
      while (day++ < 258) assertEquals("בחקתי", Shabbat.getShabatName(type, day));
      while (day++ < 265) assertEquals("במדבר", Shabbat.getShabatName(type, day));
      while (day++ < 272) assertEquals("נשא", Shabbat.getShabatName(type, day));
      while (day++ < 279) assertEquals("בהעלתך", Shabbat.getShabatName(type, day));
      while (day++ < 286) assertEquals("שלח-לך", Shabbat.getShabatName(type, day));
      while (day++ < 293) assertEquals("קרח", Shabbat.getShabatName(type, day));
      while (day++ < 300) assertEquals("חקת", Shabbat.getShabatName(type, day));
      while (day++ < 307) assertEquals("בלק", Shabbat.getShabatName(type, day));
      while (day++ < 314) assertEquals("פינחס", Shabbat.getShabatName(type, day));
      while (day++ < 321) assertEquals("מטות מסעי", Shabbat.getShabatName(type, day));
      while (day++ < 328) assertEquals("דברים", Shabbat.getShabatName(type, day));
      while (day++ < 335) assertEquals("ואתחנן", Shabbat.getShabatName(type, day));
      while (day++ < 342) assertEquals("עקב", Shabbat.getShabatName(type, day));
      while (day++ < 349) assertEquals("ראה", Shabbat.getShabatName(type, day));
      while (day++ < 356) assertEquals("שפטים", Shabbat.getShabatName(type, day));
      while (day++ < 363) assertEquals("כי-תצא", Shabbat.getShabatName(type, day));
      while (day++ < 370) assertEquals("כי-תבוא", Shabbat.getShabatName(type, day));
      while (day++ < 377) assertEquals("נצבים וילך", Shabbat.getShabatName(type, day));
      while (day++ < 381) assertEquals("שבת וראש השנה", Shabbat.getShabatName(type, day));
      while (day++ < 382) assertEquals("", Shabbat.getShabatName(type, day));
   }

   @Test
   public void checkShabatDayInYearבחה()
   {
      final YearType type = YearType.בחה;
      assertEquals(6, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(13, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(20, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(27, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בראשית.ordinal()+1));
      assertEquals(34, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נח.ordinal()+1));
      assertEquals(41, Shabbat.getDayInYear(type,Shabbat.Shabbatot.לך_לך.ordinal()+1));
      assertEquals(48, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וירא.ordinal()+1));
      assertEquals(55, Shabbat.getDayInYear(type,Shabbat.Shabbatot.חיי_שרה.ordinal()+1));
      assertEquals(62, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תולדות.ordinal()+1));
      assertEquals(69, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויצא.ordinal()+1));
      assertEquals(76, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וישלח.ordinal()+1));
      assertEquals(83, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וישב.ordinal()+1));
      assertEquals(90, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מקץ.ordinal()+1));
      assertEquals(97, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויגש.ordinal()+1));
      assertEquals(104, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויחי.ordinal()+1));
      assertEquals(111, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמות.ordinal()+1));
      assertEquals(118, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וארא.ordinal()+1));
      assertEquals(125, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בא.ordinal()+1));
      assertEquals(132, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בשלח.ordinal()+1));
      assertEquals(139, Shabbat.getDayInYear(type,Shabbat.Shabbatot.יתרו.ordinal()+1));
      assertEquals(146, Shabbat.getDayInYear(type,Shabbat.Shabbatot.משפטים.ordinal()+1));
      assertEquals(153, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תרומה.ordinal()+1));
      assertEquals(160, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תצוה.ordinal()+1));
      assertEquals(167, Shabbat.getDayInYear(type,Shabbat.Shabbatot.כי_תשא.ordinal()+1));
      assertEquals(174, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(181, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(188, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(195, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(202, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(209, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(216, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(223, ShabatHoli.getDayInYear(type, ShabatHoli.BEPESACH.getVal()));
      assertEquals(230, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(237, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(244, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(251, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(258, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(265, Shabbat.getDayInYear(type,Shabbat.Shabbatot.במדבר.ordinal()+1));
      assertEquals(272, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נשא.ordinal()+1));
      assertEquals(279, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהעלתך.ordinal()+1));
      assertEquals(286, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שלח_לך.ordinal()+1));
      assertEquals(293, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קרח.ordinal()+1));
      assertEquals(300, Shabbat.getDayInYear(type,Shabbat.Shabbatot.חקת.ordinal()+1));
      assertEquals(307, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בלק.ordinal()+1));
      assertEquals(314, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פינחס.ordinal()+1));
      assertEquals(321, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מטות.ordinal()+1));
      assertEquals(321, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מסעי.ordinal()+1));
      assertEquals(328, Shabbat.getDayInYear(type,Shabbat.Shabbatot.דברים.ordinal()+1));
      assertEquals(335, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ואתחנן.ordinal()+1));
      assertEquals(342, Shabbat.getDayInYear(type,Shabbat.Shabbatot.עקב.ordinal()+1));
      assertEquals(349, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ראה.ordinal()+1));
      assertEquals(356, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שפטים.ordinal()+1));
      assertEquals(363, Shabbat.getDayInYear(type,Shabbat.Shabbatot.כי_תצא.ordinal()+1));
      assertEquals(370, Shabbat.getDayInYear(type,Shabbat.Shabbatot.כי_תבוא.ordinal()+1));
      assertEquals(377, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(377, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearבשה()
   {
      final YearType type = YearType.בשה;
      assertEquals(6, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(13, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(20, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(174, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(174, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(181, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(188, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(195, ShabatHoli.getDayInYear(type, ShabatHoli.BEPESACH.getVal()));
      assertEquals(202, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(209, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(209, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(216, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(216, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(223, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(230, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(230, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(349, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(349, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearבשז()
   {
      final YearType type = YearType.בשז;
      assertEquals(6, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(13, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(20, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(174, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(181, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(188, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(195, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(202, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(209, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(216, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(223, ShabatHoli.getDayInYear(type, ShabatHoli.PESACH.getVal()));
      assertEquals(230, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(237, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(244, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(251, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(258, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(384, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearגכה()
   {
      final YearType type = YearType.גכה;
      assertEquals(5, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(12, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(19, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(173, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(173, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(180, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(187, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(194, ShabatHoli.getDayInYear(type, ShabatHoli.BEPESACH.getVal()));
      assertEquals(201, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(208, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(208, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(215, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(215, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(222, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(229, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(229, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(348, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(348, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearגכז()
   {
      final YearType type = YearType.גכז;
      assertEquals(5, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(12, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(19, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(173, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(180, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(187, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(194, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(201, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(208, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(215, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(222, ShabatHoli.getDayInYear(type, ShabatHoli.PESACH.getVal()));
      assertEquals(229, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(236, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(243, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(250, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(257, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(383, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearהכז()
   {
      final YearType type = YearType.הכז;
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(3, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(10, ShabatHoli.getDayInYear(type, ShabatHoli.YOM_KIPUR.getVal()));
      assertEquals(17, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(171, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(171, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(178, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(185, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(192, ShabatHoli.getDayInYear(type, ShabatHoli.PESACH.getVal()));
      assertEquals(199, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(206, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(206, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(213, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(213, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(220, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(227, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(234, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(353, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearהחא()
   {
      final YearType type = YearType.החא;
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(3, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(10, ShabatHoli.getDayInYear(type, ShabatHoli.YOM_KIPUR.getVal()));
      assertEquals(17, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(171, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(178, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(185, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(192, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(199, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(206, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(213, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(220, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(227, ShabatHoli.getDayInYear(type, ShabatHoli.SHVIEE.getVal()));
      assertEquals(234, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(241, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(248, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(255, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(381, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearהשא()
   {
      final YearType type = YearType.השא;
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(3, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(10, ShabatHoli.getDayInYear(type, ShabatHoli.YOM_KIPUR.getVal()));
      assertEquals(17, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(171, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(178, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(185, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(192, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(199, ShabatHoli.getDayInYear(type, ShabatHoli.SHVIEE.getVal()));
      assertEquals(206, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(213, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(213, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(220, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(220, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(227, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(234, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(234, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(353, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearהשג()
   {
      final YearType type = YearType.השג;
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(3, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(10, ShabatHoli.getDayInYear(type, ShabatHoli.YOM_KIPUR.getVal()));
      assertEquals(17, ShabatHoli.getDayInYear(type, ShabatHoli.BESUKKOT.getVal()));
      assertEquals(171, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(178, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(185, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(192, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(199, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(206, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(213, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(220, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(227, ShabatHoli.getDayInYear(type, ShabatHoli.BEPESACH.getVal()));
      assertEquals(234, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(241, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(248, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(255, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(381, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(381, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearזחא()
   {
      final YearType type = YearType.זחא;
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(8, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(15, ShabatHoli.getDayInYear(type, ShabatHoli.SUKKOT.getVal()));
      assertEquals(176, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(176, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(183, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(190, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(197, ShabatHoli.getDayInYear(type, ShabatHoli.SHVIEE.getVal()));
      assertEquals(204, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(211, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(211, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(218, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(218, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(225, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(232, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(232, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(351, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearזחג()
   {
      final YearType type = YearType.זחג;
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(8, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(15, ShabatHoli.getDayInYear(type, ShabatHoli.SUKKOT.getVal()));
      assertEquals(176, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(183, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(190, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(197, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(204, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(211, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(218, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(225, ShabatHoli.getDayInYear(type, ShabatHoli.BEPESACH.getVal()));
      assertEquals(232, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(239, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(246, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(253, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(260, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(379, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(379, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearזשג()
   {
      final YearType type = YearType.זשג;
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(8, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(15, ShabatHoli.getDayInYear(type, ShabatHoli.SUKKOT.getVal()));
      assertEquals(176, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(176, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(183, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(190, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(197, ShabatHoli.getDayInYear(type, ShabatHoli.BEPESACH.getVal()));
      assertEquals(204, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(211, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(211, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(218, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(218, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(225, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(232, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(232, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(351, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(351, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void checkShabatDayInYearזשה()
   {
      final YearType type = YearType.זשה;
      assertEquals(-1, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1, true));
      assertEquals(8, Shabbat.getDayInYear(type,Shabbat.Shabbatot.האזינו.ordinal()+1));
      assertEquals(15, ShabatHoli.getDayInYear(type, ShabatHoli.SUKKOT.getVal()));
      assertEquals(176, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקהל.ordinal()+1));
      assertEquals(183, Shabbat.getDayInYear(type,Shabbat.Shabbatot.פקודי.ordinal()+1));
      assertEquals(190, Shabbat.getDayInYear(type,Shabbat.Shabbatot.ויקרא.ordinal()+1));
      assertEquals(197, Shabbat.getDayInYear(type,Shabbat.Shabbatot.צו.ordinal()+1));
      assertEquals(204, Shabbat.getDayInYear(type,Shabbat.Shabbatot.שמיני.ordinal()+1));
      assertEquals(211, Shabbat.getDayInYear(type,Shabbat.Shabbatot.תזריע.ordinal()+1));
      assertEquals(218, Shabbat.getDayInYear(type,Shabbat.Shabbatot.מצרע.ordinal()+1));
      assertEquals(225, ShabatHoli.getDayInYear(type, ShabatHoli.BEPESACH.getVal()));
      assertEquals(232, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אחרי_מות.ordinal()+1));
      assertEquals(239, Shabbat.getDayInYear(type,Shabbat.Shabbatot.קדשים.ordinal()+1));
      assertEquals(246, Shabbat.getDayInYear(type,Shabbat.Shabbatot.אמר.ordinal()+1));
      assertEquals(253, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בהר.ordinal()+1));
      assertEquals(260, Shabbat.getDayInYear(type,Shabbat.Shabbatot.בחקתי.ordinal()+1));
      assertEquals(379, Shabbat.getDayInYear(type,Shabbat.Shabbatot.נצבים.ordinal()+1));
      assertEquals(379, Shabbat.getDayInYear(type,Shabbat.Shabbatot.וילך.ordinal()+1));
   }

   @Test
   public void shabatName()
   {
      assertEquals("בראשית", HebrewDate.getShabatName(new int[]{1, 0}));
      assertEquals("[1, 0]", Arrays.toString(HebrewDate.getShabatIndexes("בראשית")));

      assertEquals("", HebrewDate.getShabatName(new int[]{1, 2}));

      assertEquals("שפטים", HebrewDate.getShabatName(new int[]{48, 0}));
      assertEquals("[48, 0]", Arrays.toString(HebrewDate.getShabatIndexes("שפטים")));

      assertEquals("נצבים", HebrewDate.getShabatName(new int[]{51, 0}));
      assertEquals("[51, 0]", Arrays.toString(getShabatIndexes("נצבים")));

      assertEquals("וילך", HebrewDate.getShabatName(new int[]{52, 0}));
      assertEquals("[52, 0]", Arrays.toString(getShabatIndexes("וילך")));

      assertEquals("נצבים וילך", HebrewDate.getShabatName(new int[]{51, 52}));
      assertEquals("[51, 52]", Arrays.toString(HebrewDate.getShabatIndexes("נצבים וילך")));
   }

   @Test
   public void setParashaבשז()
   {
      HebrewDate date = HebrewDate.ofParasha(5779, Shabbat.Shabbatot.נצבים.ordinal()+1, true);
      assertEquals(5779, date.getYear());
      assertEquals(13, date.getMonth());
      assertEquals(28, date.getDay());

      date = HebrewDate.ofParasha(5780, Shabbat.Shabbatot.וילך.ordinal()+1, false);
      assertEquals(5780, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(6, date.getDay());

      date = HebrewDate.ofParasha(5780, Shabbat.Shabbatot.האזינו.ordinal()+1, false);
      assertEquals(5780, date.getYear());
      assertEquals(1, date.getMonth());
      assertEquals(13, date.getDay());
   }
}

