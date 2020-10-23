# HebrewDate
The project provides everything you need to build a Jewish/Hebrew calendar in java

## Convert  
  
Convert from Hebrew to LocalDate
  
    HebrewDate date = HebrewDate.of("ז אלול התשלא");  
    assertEquals(LocalDate.of(1971, 8, 28), date.getLocalDate());

Convert from Hebrew to LocalDate using special month like "אדר א" (using hyphen)
   
    HebrewDate date = HebrewDate.of("א אדר-א התשפא");  
    assertEquals(LocalDate.of(2021, 2, 13), date.getLocalDate());
  
  
## Calendar Information 
There are many methods you can use to get calendar information. Some of them are here:    
The rest can be found in the [CalendarTest.java](https://github.com/mobeho/HebrewDate/blob/master/src/test/java/org/mobeho/calendar/CalendarTest.java) in method checkInfo() 

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

## Comparing and converting  
Usually the static methods used for comparing and converting.  
For more information please see [CalendarTest.java](https://github.com/mobeho/HebrewDate/blob/master/src/test/java/org/mobeho/calendar/CalendarTest.java) in method checkStatic()    

Convert Hebrew to Christian by specifying the day + month for current year
  
    assertEquals("[12, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אלול")));  
    assertEquals("[6, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר")));  
    assertEquals("[6, 7, 1]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר-א")));  
  
and in the opposite direction   

    assertEquals("ז אדר", HebrewDate.convertMonthAndDay(6, 7, false));  
    assertEquals("ז ניסן", HebrewDate.convertMonthAndDay(7, 7, false));  
    assertEquals("ז אדר-א", HebrewDate.convertMonthAndDay(6, 7, true));  
  
Compare two HebrewDate:
 
    assertEquals(0, HebrewDate.compare(HebrewDate.of(5731, 12, 7), HebrewDate.ofChris(1971, 8, 28)));  
    assertEquals(1, HebrewDate.compare(HebrewDate.of(5731, 12, 8), HebrewDate.ofChris(1971, 8, 28)));  

## Get cycle information  

The library supply few _Helchaty_'t information.    

Here is example for Summer Time or Daylight Saving Time   

    HebrewDate date = HebrewDate.ofChris(2020, 3, 26);  
    assertEquals("בשעון חורף", SummerTime.getInfo(date));  
    date.addDays(1);  
    assertEquals("תחילת שעון קיץ", SummerTime.getInfo(date));  
    date.addDays(1);  
    assertEquals("בשעון קיץ", SummerTime.getInfo(date));  
    date.addDays(211);  
    assertEquals("25/10/2020", date.toChrisString());  
    assertEquals("סוף שעון קיץ", SummerTime.getInfo(date)); 

This is how you get the information about the Daf-Yomi  
  
    HebrewDate date = HebrewDate.of(5743, 3, 8);  
    int machzor = 8;  
    while (date.getYear() <= 6000)  
    {  
        assertEquals("מחזור:" + (++machzor) + " - מסכת:נדה דף:עב", new DafYomiBavli().getInfo(date));  
        date.addDays(2711);  
    }  

## JSON lists  
To help you build client side code that build Hebrew calendar   
You can use the JSONForHebrew class that generate JSON lists that required for that.  
This lists can integrated in http response in Rest APIs for instance.  

The paramters describe in the code of [JSONForHebrew.java](https://github.com/mobeho/HebrewDate/blob/master/src/main/java/org/mobeho/calendar/JSONForHebrew.java)
    
        json = JSONForHebrew.getYears(5780, true, 2, (byte) 4);
        assertEquals("{\"list\":[{\"year\":5780,\"shana\":\"התשפ\",\"siman\":\"בשה\"},{\"year\":5781,\"shana\":\"התשפא\",\"siman\":\"זחא\"}]}", json);

        json = JSONForHebrew.getMonths(5780);
        assertEquals("{\"list\":[{\"index\":1,\"month\":\"תשרי\"},{\"index\":2,\"month\":\"חשוון\"},{\"index\":3,\"month\":\"כסלו\"},{\"index\":4,\"month\":\"טבת\"},{\"index\":5,\"month\":\"שבט\"},{\"index\":6,\"month\":\"אדר\"},{\"index\":7,\"month\":\"ניסן\"},{\"index\":8,\"month\":\"אייר\"},{\"index\":9,\"month\":\"סיוון\"},{\"index\":10,\"month\":\"תמוז\"},{\"index\":11,\"month\":\"אב\"},{\"index\":12,\"month\":\"אלול\"}]}", json);

For more methods please see [JSONTest.java](https://github.com/mobeho/HebrewDate/blob/master/src/test/java/org/mobeho/calendar/JSONTest.java)    
