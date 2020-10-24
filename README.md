# HebrewDate
This project provides everything you need to build a Jewish/Hebrew calendar in java.  
Can be found and download as jar at https://mvnrepository.com/artifact/com.github.mobeho/HebrewDate 

## Convert  
  
Convert from Hebrew to LocalDate
  
    HebrewDate date = HebrewDate.of("ז אלול התשלא");  
    assertEquals(LocalDate.of(1971, 8, 28), date.getLocalDate());

Convert from Hebrew to LocalDate using special month like "אדר א" (using hyphen)
   
    HebrewDate date = HebrewDate.of("א אדר-א התשפא");  
    assertEquals(LocalDate.of(2021, 2, 13), date.getLocalDate());
  
  
## Calendar Information 
There are many methods you can use to get calendar information. Here few of them:    

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

The rest can be found in the [CalendarTest.java](https://github.com/mobeho/HebrewDate/blob/master/src/test/java/org/mobeho/calendar/CalendarTest.java) in method checkInfo() 

## Numbers and Comparing   
By specifying the the Hebrew date you can get it represented by numbers 
  
    assertEquals("[12, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אלול")));  
    assertEquals("[6, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר")));  
    assertEquals("[6, 7, 1]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר-א")));  

The first number represents the _month_, the 2nd is the _day_, and the last is the  _leap_ indicator.  
The _leap_ indicate if the Hebrew date you provide is at month אדר in a leap year   
  
and in the opposite direction   

    assertEquals("ז אדר", HebrewDate.convertMonthAndDay(6, 7, false));  
    assertEquals("ז ניסן", HebrewDate.convertMonthAndDay(7, 7, false));  
    assertEquals("ז אדר-א", HebrewDate.convertMonthAndDay(6, 7, true));  
  
Compare two HebrewDate dan do like that:
 
    assertEquals(0, HebrewDate.compare(HebrewDate.of(5731, 12, 7), HebrewDate.ofChris(1971, 8, 28)));  
    assertEquals(1, HebrewDate.compare(HebrewDate.of(5731, 12, 8), HebrewDate.ofChris(1971, 8, 28)));
    
or simply comparing the **getDaysFromStart()** values
   
For more information please see [CalendarTest.java](https://github.com/mobeho/HebrewDate/blob/master/src/test/java/org/mobeho/calendar/CalendarTest.java) in method checkStatic()    

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
You can use the **JSONForHebrew** class that generate JSON lists that required for that.  
This lists can integrated in a http response in Rest APIs for instance.  

The parameters described in the code of [JSONForHebrew.java](https://github.com/mobeho/HebrewDate/blob/master/src/main/java/org/mobeho/calendar/JSONForHebrew.java)
    
        json = JSONForHebrew.getYears(5780, true, 2, (byte) 4);
        assertEquals("{\"list\":[{\"year\":5780,\"shana\":\"התשפ\",\"siman\":\"בשה\"},{\"year\":5781,\"shana\":\"התשפא\",\"siman\":\"זחא\"}]}", json);

        json = JSONForHebrew.getMonths(5780);
        assertEquals("{\"list\":[{\"index\":1,\"month\":\"תשרי\"},{\"index\":2,\"month\":\"חשוון\"},{\"index\":3,\"month\":\"כסלו\"},{\"index\":4,\"month\":\"טבת\"},{\"index\":5,\"month\":\"שבט\"},{\"index\":6,\"month\":\"אדר\"},{\"index\":7,\"month\":\"ניסן\"},{\"index\":8,\"month\":\"אייר\"},{\"index\":9,\"month\":\"סיוון\"},{\"index\":10,\"month\":\"תמוז\"},{\"index\":11,\"month\":\"אב\"},{\"index\":12,\"month\":\"אלול\"}]}", json);

For more methods please see [JSONTest.java](https://github.com/mobeho/HebrewDate/blob/master/src/test/java/org/mobeho/calendar/JSONTest.java)

## SQL  
Sometimes you need to persist Hebrew dates in DB.
But the DB engines not provide SQL methods for Hebrew dates or calculations them.   
[SQLForHebrew.java](https://github.com/mobeho/HebrewDate/blob/master/src/main/java/org/mobeho/calendar/SQLForHebrew.java)
provide WHERE statements for sql query that can be added to native sql statements without any DB manipulations  
The only thing you required, is to add few simple columns to your table, all the hard work will do by these WHERE statements.  
Of course the WHERE statements should generated according that column names you added to your table. 

For instance we add the these 3 columns to our table  

        CREATE TABLE <table name> (
            ...
            DAY INTEGER,
            LEAP BOOLEAN,
            MONTH INTEGER,
            ...
        )

First you initialize the SQLForHebrew class:

    SQLForHebrew.of(date)
    
Then, you call **sqlDayInRange** method with these column names   

        HebrewDate date = HebrewDate.of(5779, 1, 1)
        String result = SQLForHebrew.of(date).sqlDayInRange(1, "month", "day", "leap");

Suitable WHERE clause is generated for you (include the CR LF characters)  
The _result_ value is:   

        "CASE WHEN month > 0 AND day > 0 THEN  
         ( (month-1)*29 + FLOOR(month/2) + day  
          +(CASE WHEN (month=2 AND day=30) OR month>2 THEN 1 ELSE 0 END)  
          +(CASE WHEN (leap=FALSE AND ((month=6 AND day=30) OR month>6)) THEN 30 ELSE 0 END)  
          - 7) BETWEEN 0 AND 6  
        END"  

When adding the above WHERE clause to SELECT statement it replies all rows for the week 
starting at א תשרי תשעט     
(The first parameter "1" indicate we would like to get just this week)  

By running the next call

        HebrewDate date = HebrewDate.of(5779, 5, 6);
        String result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(12, "month", "day", "leap"));

You will get WHERE clause that covers all days starting from ו שבט התרס and ending 12 weeks later 

        "CASE WHEN month > 0 AND day > 0 THEN
         ( (month-1)*29 + FLOOR(month/2) + day
          +(CASE WHEN (leap=FALSE AND ((month=6 AND day=30) OR month>6)) THEN 30 ELSE 0 END)
          - 126) BETWEEN 0 AND 83
        END"

The simple way to prepare your INSERT statement, will be by using the **convertMonthAndDay** method (explained above):
 
      assertEquals("[12, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אלול")));
      assertEquals("[6, 7, 0]", Arrays.toString(HebrewDate.convertMonthAndDay("ז אדר")));
The first number should insert into the _month_ column, the 2nd to the _day_ column, and the last to the _leap_ column.  

# 
[SQLForHebrew.java](https://github.com/mobeho/HebrewDate/blob/master/src/main/java/org/mobeho/calendar/SQLForHebrew.java)
can provide also WHERE clause for specific Shabat.  
You can do that after your table contains two columns of Shabat index.  
You must have two columns (to cover Shabat with פרשות מחוברות):  
    
        CREATE TABLE <table name> (
            ...
            SHABAT_INDEX1 INTEGER,
            SHABAT_INDEX2 INTEGER,
            ...
        )

For that you use the **sqlParashaInRange** method.  
For example, we would like to get all rows for Shabat נצבים and Shabat וילך that some times called (111) שבת תשובה.  
It should be like that: 

        HebrewDate date = HebrewDate.of(5779, 13, 28);
        String result = SQLForHebrew.of(date).sqlParashaInRange(2, "SHABAT_INDEX").replace("\n", "");
        assertEquals("OR (SHABAT_INDEX1 - 51 BETWEEN 0 AND 2) OR (SHABAT_INDEX2 - 51 BETWEEN 0 AND 2) OR SHABAT_INDEX1 = 111", result);
 
A simple way to prepare insert statement with new Hebrew date for Shabatot, is using **getShabatIndexes** method:

      TestCase.assertEquals("[48, 0]", Arrays.toString(HebrewDate.getShabatIndexes("שפטים")));
        
       // or in case you have two Parashot
      TestCase.assertEquals("[51, 52]", Arrays.toString(HebrewDate.getShabatIndexes("נצבים וילך")));
The first number should be insert to SHABAT_INDEX1 and the last to SHABAT_INDEX2 in the table  
#
You can combine both Hebrew date and Shabatot WHERE clauses at the same statement (The table have the all 5 columns):

    public void getResult(HebrewDate dateFrom, int weeks)
	{
		SQLForHebrew sql = SQLForHebrew.of(dateFrom);
		StringBuilder result = new StringBuilder();
		result
			.append("SELECT month, day, leap_year, shabat_index1, shabat_index2\n")
			.append("FROM MyTable my\n")
			.append("WHERE ")
			.append(sql.sqlDayInRange(weeks, "month", "day", "leap_year"))
			.append(sql.sqlParashaInRange(weeks - 1, "shabat_index"))
			.append(")");
			
		...

For many examples please see [SQLTest.java](https://github.com/mobeho/HebrewDate/blob/master/src/test/java/org/mobeho/calendar/SQLTest.java)
