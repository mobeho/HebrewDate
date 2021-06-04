package org.mobeho.calendar;

import junit.framework.TestCase;
import org.mobeho.calendar.hilchati.HolyDay;
import org.mobeho.calendar.cyclic.SummerTime;
import org.mobeho.calendar.cyclic.DafYomiBavli;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


/// <Description>
/// Author: Michael Maimon
/// Copyright (C) Mobeho.  All rights reserved.
/// </Description>
public class CalendarTest
{
   @Test
   public void checkHebrewChris()
   {
      HebrewDate date = HebrewDate.of("ז אלול התשלא");
      assertEquals(LocalDate.of(1971, 8, 28), date.getLocalDate());

      date = HebrewDate.of("טז כסלו התשפ");
      assertEquals(LocalDate.of(2019, 12, 14), date.getLocalDate());

      date = HebrewDate.of("א אדר-א התשפא");
      assertEquals(LocalDate.of(2021, 2, 13), date.getLocalDate());

      date = HebrewDate.of(LocalDate.of(2020, 11, 17));
      assertEquals(HebrewDate.of("א כסלו התשפא"), date);

      date = HebrewDate.of(LocalDate.of(2020, 2, 29));
      assertEquals(HebrewDate.of("ד אדר התשפ"), date);

      date = HebrewDate.ofChris(2021, 1, 1);
      assertEquals(HebrewDate.of("יז טבת התשפא"), date);
   }

   @Test
   public void checkInfo()
   {
      HebrewDate date = HebrewDate.of("ז אלול התשלא");
      assertEquals("הכז", date.getYearType().toString());
      assertEquals("התשלא", date.getYearString());
      assertEquals(5731, date.getYear());
      assertEquals(1971, date.getChrisYear());
      TestCase.assertFalse(date.isLeapYear());
      TestCase.assertFalse(date.isChrisLeapYear());
      TestCase.assertTrue(date.isGregorianAge());
      assertEquals(354, date.getNumberDaysInYear());
      assertEquals(51, date.getNumberOfShabatot());
      assertEquals(365, date.getChrisNumberDaysInYear());
      assertEquals(51, date.getNumberOfWeeks());
      assertEquals(53, date.getChrisNumberOfWeeks());

      assertEquals("אלול", date.getMonthString());
      assertEquals(12, date.getMonth());
      assertEquals(8, date.getChrisMonth());

      assertEquals("ז", date.getDayString());
      assertEquals(7, date.getDay());
      assertEquals(28, date.getChrisDay());

      assertEquals("שפטים", date.getShabatName());
      assertEquals("שפטים", date.getParashaName()); // different in Shabatot with extra Torah books

      assertEquals("", date.getHolidayName());
      assertEquals("יום שבת", date.getDayOfWeakString());
      assertEquals("Saturday", date.getChrisDayOfWeakString());
      assertEquals(353, date.getLastShabatDayInYear());

      assertEquals("ז אלול", date.toShortString());

      assertEquals("ז אלול התשלא", date.toString());
      assertEquals("07/12/5731", date.toDateFormat());
      assertEquals("ז אלול התשלא", date.toString(" "));

      assertEquals(7, date.getMoonDayInWeak());
      assertEquals(1, date.getFirstDayInMonth());

      assertEquals("[6, 18, 1030]", Arrays.toString(date.getMolad()));
      assertEquals("[א, ב, ג, ד, ה, ו, ז, ח, ט, י, יא, יב, יג, יד, טו, טז, יז, יח, יט, כ, כא, כב, כג, כד, כה, כו, כז, כח, כט]", Arrays.toString(date.getDaysOfMonthString()));
      assertEquals("[תשרי, חשוון, כסלו, טבת, שבט, אדר, ניסן, אייר, סיוון, תמוז, אב, אלול]", Arrays.toString(date.getMonthsString()));
      assertEquals("[תשרי, חשוון, כסלו, טבת, שבט, אדר-א, אדר-ב, ניסן, אייר, סיוון, תמוז, אב, אלול]", Arrays.toString(HebrewDate.of(5782, 1, 1).getMonthsString()));
      assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]", Arrays.toString(date.getChrisDaysOfMonthString()));

      assertEquals("התשלא סימן:הכז, מחזור:12/302, שעת מולד:22:947(16:52), חודשים:12, ימים:354", date.toYearString());
   }

   @Test
   public void checkStatic()
   {
      assertEquals("[12, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אלול")));
      assertEquals("[6, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר")));
//    Illegible ->  assertEquals("[7, 7, 1]", Arrays.toString(Hebrew.convertMonthAndDay("ז אדר-ב")));

      assertEquals("[6, 7, 1]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר-א")));
      assertEquals("ז אלול", HebrewDate.convertMonthAndDay(12, 7, false));
      assertEquals("ז אדר", HebrewDate.convertMonthAndDay(6, 7, false));
      assertEquals("ז ניסן", HebrewDate.convertMonthAndDay(7, 7, false));
      assertEquals("ז אדר-א", HebrewDate.convertMonthAndDay(6, 7, true));

//    Illegible ->  assertEquals("ז ניסן", Hebrew.convertMonthAndDay(7, 7, true));
      assertEquals("יום שבת", HebrewDate.convertDayOfWeek(7));
      assertEquals(0, HebrewDate.compare(HebrewDate.of(5731, 12, 7), HebrewDate.ofChris(1971, 8, 28)));
      assertEquals(1, HebrewDate.compare(HebrewDate.of(5731, 12, 8), HebrewDate.ofChris(1971, 8, 28)));
      assertEquals(-1, HebrewDate.compare(HebrewDate.of(5731, 12, 7), HebrewDate.ofChris(1971, 8, 29)));
      assertEquals(1, HebrewDate.compare(HebrewDate.of(5731, 12, 7), HebrewDate.ofChris(1971, 7, 28)));
      assertEquals(-1, HebrewDate.compare(HebrewDate.of(5731, 12, 7), HebrewDate.ofChris(1971, 9, 28)));
      assertEquals(1, HebrewDate.compare(HebrewDate.of(5732, 12, 7), HebrewDate.ofChris(1971, 8, 28)));
      assertEquals(-1, HebrewDate.compare(HebrewDate.of(5731, 12, 7), HebrewDate.ofChris(1972, 8, 28)));

      assertEquals("[ראשון, שני, שלישי, רביעי, חמישי, שישי, שבת]", Arrays.toString(HebrewDate.getDaysOfWeakString()));

      assertEquals(HebrewDate.of("כט אדר התשפ"), HebrewDate.of(5780, "ל אדר-א", true));
      assertNull(HebrewDate.of(5780, "ל אדר-א", false));
      assertEquals(HebrewDate.of("כט אדר התשפ"),HebrewDate.of(5780, "כט אדר-א", true));
      assertEquals(HebrewDate.of("כט אדר התשפא"),HebrewDate.of("כט אדר-א התשפא"));
      assertEquals(HebrewDate.of("א אלול התשפ"), HebrewDate.of(5780, 14, 1)); // force = false
      assertEquals(HebrewDate.of("ל שבט התשפ"), HebrewDate.of(5780, 5, 31)); // force = false
      assertEquals(HebrewDate.of("ל אדר-א התשפב"), HebrewDate.of(5782, "ל אדר-א", false));
      assertEquals(HebrewDate.of("ל אדר-א התשפב"), HebrewDate.of(5782, "ל אדר-א", true));

   }

   @Test
   public void checkTaarichAfterAddingDays()
   {
      HebrewDate date = HebrewDate.now();
      date.addDays(100);
      String tarich = date.toString();
      String checkThis = tarich.substring(0, tarich.lastIndexOf(' '));

      HebrewDate hebrew = HebrewDate.now();
      for (int i = 1; i < 100; i++, hebrew.addDays(1)) ;

      assertFalse(hebrew.isToday(checkThis));
      hebrew.addDays(1);
      assertTrue(hebrew.isToday(checkThis));
      hebrew.addDays(1);
      assertFalse(hebrew.isToday(checkThis));
   }

   @Test
   public void last100Years()
   {
      StringBuffer years = new StringBuffer();
      HebrewDate date = HebrewDate.of(5900, 1, 1);
      do
      {
         years.append(date.getYearString()).append(", ");
         date.addYears(1);
      } while (date.getYear() <= 6000);

      assertEquals("התתק, התתקא, התתקב, התתקג, התתקד, התתקה, התתקו, התתקז, התתקח, התתקט, התתקי, התתקיא, התתקיב, התתקיג, התתקיד, התתקיה, התתקיו, התתקיז, התתקיח, התתקיט, התתקכ, התתקכא, התתקכב, התתקכג, התתקכד, התתקכה, התתקכו, התתקכז, התתקכח, התתקכט, התתקל, התתקלא, התתקלב, התתקלג, התתקלד, התתקלה, התתקלו, התתקלז, התתקלח, התתקלט, התתקמ, התתקמא, התתקמב, התתקמג, התתקמד, התתקמה, התתקמו, התתקמז, התתקמח, התתקמט, התתקנ, התתקנא, התתקנב, התתקנג, התתקנד, התתקנה, התתקנו, התתקנז, התתקנח, התתקנט, התתקס, התתקסא, התתקסב, התתקסג, התתקסד, התתקסה, התתקסו, התתקסז, התתקסח, התתקסט, התתקע, התתקעא, התתקעב, התתקעג, התתקעד, התתקעה, התתקעו, התתקעז, התתקעח, התתקעט, התתקפ, התתקפא, התתקפב, התתקפג, התתקפד, התתקפה, התתקפו, התתקפז, התתקפח, התתקפט, התתקצ, התתקצא, התתקצב, התתקצג, התתקצד, התתקצה, התתקצו, התתקצז, התתקצח, התתקצט, ו, ", years.toString());
   }

   @Test
   public void print3MonthesCalendar()
   {
      HebrewDate hebrew = HebrewDate.now();
      HebrewDate until = HebrewDate.now().addDays(90);
      HebrewDate untilEndOfWeek = HebrewDate.of(until).setNextShabat();

      System.out.printf("%s %s לפני %s בשנת %s[%s]%n", hebrew.getDayOfWeakString(), hebrew.getHolidayName(), hebrew.getShabatName(), hebrew.getYearString(), hebrew.getYearType() );
      System.out.println(new DafYomiBavli().getFullInfo(hebrew));
      System.out.println(SummerTime.getDayInfo(hebrew));
      System.out.println("|ראשון| שני |שלישי |רביעי|חמישי| שישי | שבת |               ");
      while (hebrew.getDaysFromStart() <= untilEndOfWeek.getDaysFromStart())
      {
         if (hebrew.getDayOfWeak() == 1)
            System.out.println();

         if (hebrew.getDaysFromStart() <= until.getDaysFromStart())
            System.out.print(String.format("|%2s %2s", hebrew.getDayString(), hebrew.getChrisDayString()));
         else
            System.out.print(String.format(" %2s %2s", "  ", "  "));

         if (hebrew.getDayOfWeak() == 7)
         {
            String holiday = HolyDay.getName(hebrew.getYearType(), hebrew.getDayInYear());
            String shabat = hebrew.getShabatName();
            if (holiday.length() > 0)
               System.out.print(String.format("|%15s ", holiday));
             else
               System.out.print(String.format("|%15s ", shabat));
         }
         hebrew.addDays(1);
      }


      System.out.println();
   }

   @Test
   public void minusDays()
   {
      HebrewDate hebrew = HebrewDate.now();
      LocalDate from = hebrew.getLocalDate();

      hebrew.addDays(-70);
      LocalDate to = hebrew.getLocalDate();
      assertEquals(70L, from.toEpochDay() - to.toEpochDay());

      hebrew.addDays(-400);
      to = hebrew.getLocalDate();
      assertEquals(470L, from.toEpochDay() - to.toEpochDay());

      hebrew.addDays(-1000);
      to = hebrew.getLocalDate();
      assertEquals(1470L, from.toEpochDay() - to.toEpochDay());

      hebrew.addDays(-10000);
      to = hebrew.getLocalDate();
      assertEquals(11470L, from.toEpochDay() - to.toEpochDay());

      hebrew.addDays(-1000000);
      to = hebrew.getLocalDate();
      assertEquals(null, to);

      hebrew = HebrewDate.now();
      hebrew.addDays(-1000000000);
      assertEquals(-3761, hebrew.getChrisYear());
   }

   @Test
   public void sfiratHaomer()
   {
      HebrewDate date = HebrewDate.of(5780, 7, 15);
      for (int index = 0; index < 50 ; index++, date.addDays(1))
      {
         assertEquals(index, date.getSfiratHaomer());
      }
      assertEquals(0, date.getSfiratHaomer());
   }

   @Test
   public void JulianToGregorian()
   {
      HebrewDate date = HebrewDate.ofChris(1582 , 10, 4);
      TestCase.assertFalse(date.isGregorianAge());
      assertEquals("יח תשרי השמג", date.toString());

      date.addDays(1);

      TestCase.assertTrue(date.isGregorianAge());
      assertEquals(15, date.getChrisDay());
      assertEquals(10, date.getChrisMonth());
      assertEquals(1582, date.getChrisYear());
      assertEquals("יט תשרי השמג", date.toString());
      assertEquals(21, date.getChrisNumberDaysInMonth());
      assertEquals(355, date.getChrisNumberDaysInYear());

      date = HebrewDate.ofChris(1582 , 10, 4);
      date.addChrisMonths(1);
      assertEquals("04/11/1582",date.toChrisString());

      date = HebrewDate.ofChris(1582 , 10, 5);
      date.addChrisMonths(1);
      assertEquals("15/11/1582",date.toChrisString());
   }

   @Test
   public void BCEToCE()
   {
      HebrewDate date = HebrewDate.ofChris(-1 , 1, 1);
      assertEquals("01/01/-001", date.toChrisString());
      date.addChrisYears(1);
      assertEquals("01/01/0001", date.toChrisString());
      assertEquals("טז טבת גתשסא", date.toString());

      date = HebrewDate.ofChris(-3761 , 10, 7);
      assertEquals("07/10/-3761", date.toChrisString());
      assertEquals("א תשרי א", date.toString());

      date = HebrewDate.ofChris(-4000 , 1, 1);
      assertEquals("07/10/-3761", date.toChrisString());
      assertEquals("א תשרי א", date.toString());
   }
}

