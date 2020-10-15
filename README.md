# HebrewDate
This project allows to perform all required action and calculation for Hebrew calendar

## Convert  
  
_Convert from Hebrew to LocalDate_  
HebrewDate date = HebrewDate.of("ז אלול התשלא");  
assertEquals(LocalDate.of(1971, 8, 28), date.getLocalDate());

_Convert from Hebrew to LocalDate using special month like "אדר א" (using hyphen)_   
HebrewDate date = HebrewDate.of("א אדר-א התשפא");  
assertEquals(LocalDate.of(2021, 2, 13), date.getLocalDate());
  
  
## Information 
There are many methods you can use to get information.   
Here are some of them (The rest can be found in the test code)  

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
  
assertEquals("שפטים", date.getShabatName());  
assertEquals("[48, 0]", Arrays.toString(date.getShabatIndexes()));  
  
assertEquals("התשלא סימן:הכז, מחזור:12/302, שעת מולד:22:947(16:52), חודשים:12, ימים:354", date.toYearString());  

## Comparing and converting:  
Usully the static methods used for comparing and converting
Here some of them (The rest can be found in the test code)  

_Convert Hebrew to Christian by specifying the day + month for current year_  
assertEquals("[12, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אלול")));  
assertEquals("[6, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר")));  
assertEquals("[6, 7, 1]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר-א")));  
  
_and in the opposite direction_   
assertEquals("ז אדר", HebrewDate.convertMonthAndDay(6, 7, false));  
assertEquals("ז ניסן", HebrewDate.convertMonthAndDay(7, 7, false));  
assertEquals("ז אדר-א", HebrewDate.convertMonthAndDay(6, 7, true));  
  
_Compare two HebrewDate:_  
assertEquals(0, HebrewDate.compare(HebrewDate.of(5731, 12, 7), HebrewDate.ofChris(1971, 8, 28)));  
assertEquals(1, HebrewDate.compare(HebrewDate.of(5731, 12, 8), HebrewDate.ofChris(1971, 8, 28)));  

## Get cycle informations:  

_SummerTime/Daylight Saving Time:_   
HebrewDate date = HebrewDate.ofChris(2020, 3, 26);  
assertEquals("בשעון חורף", SummerTime.getInfo(date));  
date.addDays(1);  
assertEquals("תחילת שעון קיץ", SummerTime.getInfo(date));  
date.addDays(1);  
assertEquals("בשעון קיץ", SummerTime.getInfo(date));  
date.addDays(211);  
assertEquals("25/10/2020", date.toChrisString());  
assertEquals("סוף שעון קיץ", SummerTime.getInfo(date)); 

_Daf yomi:_  
_This is how you get the information about the Daf yomi_  
HebrewDate date = HebrewDate.of(5743, 3, 8);  
int machzor = 8;  
while (date.getYear() <= 6000)  
{  
    assertEquals("מחזור:" + (++machzor) + " - מסכת:נדה דף:עב", new DafYomiBavli().getInfo(date));  
    date.addDays(2711);  
}  




