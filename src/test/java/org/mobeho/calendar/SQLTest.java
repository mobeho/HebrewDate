package org.mobeho.calendar;

import org.mobeho.calendar.hilchaty.ShabatHoli;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SQLTest
{
    private String clearSQL(String result)
    {
        return result
                .replace("CASE WHEN M > 0 AND D > 0 THEN\n ", "")
                .replace("( (M-1)*29 + FLOOR(M/2) + D\n  +", "")
                .replace("CASE WHEN M > 0 AND D > 0 THEN\n ( (M-1)*29 + FLOOR(M/2) + D\n  +", "")
                .replace("BETWEEN 0 AND ", "| ")
                .replace("\nEND\n", "")
                .replace("\nOR\n", " ||")
                .replace("\n", "->");
    }

    @Test
    public void checkParashaYearDays()
    {
        HebrewDate date = HebrewDate.of(5779, 1, 1);
        String result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 6) | 6", result);

        //"בשז->בשה"
        date = HebrewDate.of(5779, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(55, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 6) | 379 || (CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)-> ) | 5", result);

        //"השג"
        date = HebrewDate.of(5795, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 3) | 6", result);

        //"השג->הכז"
        date = HebrewDate.of(5795, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(55, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 3) | 382 || ( (M-1)*29 + FLOOR(M/2) + D-> ) | 2", result);

        //"זשה"
        date = HebrewDate.of(5787, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 1) | 6", result);

        //"זשה->זשג"
        date = HebrewDate.of(5787, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(56, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 1) | 384 || (CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)-> ) | 7", result);


        //"בשה"
        date = HebrewDate.of(5780, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  - 6) | 6", result);

        //"בשה->זחא"
        date = HebrewDate.of(5780, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(51, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  - 6) | 349 || (CASE WHEN M>3 THEN -1 ELSE 0 END)-> ) | 7", result);

        //"השא"
        date = HebrewDate.of(5785, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  - 3) | 6", result);

        //"השא->גכה"
        date = HebrewDate.of(5785, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(51, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  - 3) | 352 || ( (M-1)*29 + FLOOR(M/2) + D-> ) | 4", result);

        //"זשג"
        date = HebrewDate.of(5788, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  - 1) | 6", result);

        //"זשג"
        date = HebrewDate.of(5788, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(51, "M", "D", "L"));
        assertEquals("(CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  - 1) | 354 || ( (M-1)*29 + FLOOR(M/2) + D-> ) | 2", result);


        //"גכה"
        date = HebrewDate.of(5786, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("( (M-1)*29 + FLOOR(M/2) + D->  - 5) | 6", result);

        //"גכה->זשה"
        date = HebrewDate.of(5786, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(51, "M", "D", "L"));
        assertEquals("( (M-1)*29 + FLOOR(M/2) + D->  - 5) | 349 || (CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)-> ) | 7", result);

        //"הכז"
        date = HebrewDate.of(5789, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("( (M-1)*29 + FLOOR(M/2) + D->  - 3) | 6", result);

        //"הכז"
        date = HebrewDate.of(5789, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(51, "M", "D", "L"));
        assertEquals("( (M-1)*29 + FLOOR(M/2) + D->  - 3) | 351 || (CASE WHEN M>3 THEN -1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)-> ) | 5", result);


        //"גכז"
        date = HebrewDate.of(5782, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 5) | 6", result);

        //"גכז"
        date = HebrewDate.of(5782, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(55, "M", "D", "L"));
        assertEquals("(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 5) | 379 || (CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)-> ) | 5", result);


        //"בחה"
        date = HebrewDate.of(5790, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN M>3 THEN -1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 6) | 6", result);

        //"בחה->זשג"
        date = HebrewDate.of(5790, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(55, "M", "D", "L"));
        assertEquals("(CASE WHEN M>3 THEN -1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 6) | 377 || (CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)-> ) | 7", result);

        //"זחג"
        date = HebrewDate.of(5784, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN M>3 THEN -1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 1) | 6", result);

        //"זחג"
        date = HebrewDate.of(5784, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(55, "M", "D", "L"));
        assertEquals("(CASE WHEN M>3 THEN -1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)->  - 1) | 382 || (CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)-> ) | 2", result);


        //"בחג"
        date = HebrewDate.of(5797, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN M>3 THEN -1 ELSE 0 END)->  - 6) | 6", result);

        //"בחג"
        date = HebrewDate.of(5797, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(50, "M", "D", "L"));
        assertEquals("(CASE WHEN M>3 THEN -1 ELSE 0 END)->  - 6) | 347 || (CASE WHEN (M=2 AND D=30) OR M>2 THEN 1 ELSE 0 END)->  +(CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)-> ) | 2", result);

        //"זחא"
        date = HebrewDate.of(5781, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(1, "M", "D", "L"));
        assertEquals("(CASE WHEN M>3 THEN -1 ELSE 0 END)->  - 1) | 6", result);

        //"זחא"
        date = HebrewDate.of(5781, 1, 1);
        result = clearSQL(SQLForHebrew.of(date).sqlDayInRange(51, "M", "D", "L"));
        assertEquals("(CASE WHEN M>3 THEN -1 ELSE 0 END)->  - 1) | 352 || (CASE WHEN (L=FALSE AND ((M=6 AND D=30) OR M>6)) THEN 30 ELSE 0 END)-> ) | 4", result);
    }

    static final String BESUKKOT = "OR S1 = " + ShabatHoli.BESUKKOT.getVal() + " ";
    static final String CHANUKA = "OR S1 = " + ShabatHoli.CHANUKA.getVal() + " ";
    static final String SHIRA = "OR S1 = " + ShabatHoli.SHIRA.getVal() + " ";
    static final String HAGADOL = "OR S1 = " + ShabatHoli.HAGADOL.getVal() + " ";
    static final String BEPESACH = "OR S1 = " + ShabatHoli.BEPESACH.getVal() + " ";
    static final String TSHUVA = "OR S1 = " + ShabatHoli.TESHUVA.getVal() + " ";

    @Test
    public void checkParashaYearMeuberet()
    {
        HebrewDate date = HebrewDate.of(5779, 1, 1);
        String result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 0) OR (S2 - 52 BETWEEN 0 AND 0) ", result);

        //"וילך"
        date = HebrewDate.of(5779, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 0) OR (S2 - 52 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5779, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"שבת חול המועד סוכות"
        date = HebrewDate.of(5779, 1, 20);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals(BESUKKOT, result);

        //"ויקהל"
        date = HebrewDate.of(5779, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 0) OR (S2 - 22 BETWEEN 0 AND 0) ", result);

        //"פקודי"
        date = HebrewDate.of(5779, 7, 2);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 23 BETWEEN 0 AND 0) OR (S2 - 23 BETWEEN 0 AND 0) ", result);

        //"תזריע"
        date = HebrewDate.of(5779, 8, 1);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 27 BETWEEN 0 AND 0) OR (S2 - 27 BETWEEN 0 AND 0) ", result);

        //"מצרע"
        date = HebrewDate.of(5779, 8, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 28 BETWEEN 0 AND 0) OR (S2 - 28 BETWEEN 0 AND 0) " + HAGADOL, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 51 BETWEEN 0 AND 0) OR (S2 - 51 BETWEEN 0 AND 0) " + TSHUVA, result);
    }

    @Test
    public void checkParashaYearMeuberetBetweenYears()
    {
        HebrewDate date = HebrewDate.of(5779, 13, 28);
        String result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 51 BETWEEN 0 AND 1) OR (S2 - 51 BETWEEN 0 AND 1) " + TSHUVA, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(3, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4 + 18, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 18) " + CHANUKA + SHIRA, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4 + 19, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 19) " + CHANUKA + SHIRA, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4 + 20, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 20) " + CHANUKA + SHIRA, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4 + 21, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 22) " + CHANUKA + SHIRA, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4 + 22, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 23) " + CHANUKA + SHIRA, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4 + 23, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 24) " + CHANUKA + SHIRA + HAGADOL, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4 + 24, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 24) " + CHANUKA + SHIRA + HAGADOL + BEPESACH, result);

        //"נצבים"
        date = HebrewDate.of(5779, 13, 28);
        result = SQLForHebrew.of(date).sqlParashaInRange(4 + 25, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 51 BETWEEN 0 AND 2) OR (S2 - 51 BETWEEN 0 AND 2) " + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 25) " + CHANUKA + SHIRA + HAGADOL + BEPESACH, result);
    }

    @Test
    public void checkParashaYearMeuberetForLong()
    {
        //"וילך"
        HebrewDate date = HebrewDate.of(5779, 1, 6);
        String result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 1) OR (S2 - 52 BETWEEN 0 AND 1) ", result);

        //"וילך"
        date = HebrewDate.of(5779, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 1) OR (S2 - 52 BETWEEN 0 AND 1) " + BESUKKOT, result);

        //"וילך"
        date = HebrewDate.of(5779, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(3, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 1) OR (S2 - 52 BETWEEN 0 AND 1) " + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"וילך"
        date = HebrewDate.of(5779, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(4, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 1) OR (S2 - 52 BETWEEN 0 AND 1) " + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 1) ", result);

        //"האזינו"
        date = HebrewDate.of(5779, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5779, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) " + BESUKKOT, result);

        //"האזינו"
        date = HebrewDate.of(5779, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) " + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5779, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(3, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) " + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 1) ", result);

        //"שבת חול המועד סוכות"
        date = HebrewDate.of(5779, 1, 20);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals(BESUKKOT + "", result);

        //"שבת חול המועד סוכות"
        date = HebrewDate.of(5779, 1, 20);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"בראשית"
        date = HebrewDate.of(5779, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"בראשית"
        date = HebrewDate.of(5779, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(29, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 28) " + CHANUKA + SHIRA + HAGADOL, result);

        //"בראשית"
        date = HebrewDate.of(5779, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(53, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + TSHUVA, result);

        //"מצרע"
        date = HebrewDate.of(5779, 8, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 28 BETWEEN 0 AND 0) OR (S2 - 28 BETWEEN 0 AND 0) " + HAGADOL, result);

        //"מצרע"
        date = HebrewDate.of(5779, 8, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 28 BETWEEN 0 AND 0) OR (S2 - 28 BETWEEN 0 AND 0) " + HAGADOL, result);

        //"מצרע"
        date = HebrewDate.of(5779, 8, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 28 BETWEEN 0 AND 1) OR (S2 - 28 BETWEEN 0 AND 1) " + HAGADOL, result);

        //"פסח"
        date = HebrewDate.of(5779, 8, 15);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("", result);

        //"פסח"
        date = HebrewDate.of(5779, 8, 15);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 29 BETWEEN 0 AND 0) OR (S2 - 29 BETWEEN 0 AND 0) ", result);
    }

    @Test
    public void checkParasha()
    {
        HebrewDate date = HebrewDate.of(5780, 1, 1);
        String result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 0) OR (S2 - 52 BETWEEN 0 AND 0) ", result);

        //"וילך"
        date = HebrewDate.of(5780, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 0) OR (S2 - 52 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5780, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5780, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) " + BESUKKOT, result);

        //"שבת חול המועד סוכות"
        date = HebrewDate.of(5779, 1, 20);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals(BESUKKOT + "", result);

        //"שבת חול המועד סוכות"
        date = HebrewDate.of(5779, 1, 20);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"ויקהל-פקודי"
        date = HebrewDate.of(5780, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 1) OR (S2 - 22 BETWEEN 0 AND 1) ", result);

        //"צו"
        date = HebrewDate.of(5780, 7, 10);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 25 BETWEEN 0 AND 0) " + HAGADOL, result);

        //"צו"
        date = HebrewDate.of(5780, 7, 10);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 25 BETWEEN 0 AND 0) " + HAGADOL + BEPESACH, result);

        //"צו"
        date = HebrewDate.of(5780, 7, 10);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 25 BETWEEN 0 AND 1) " + HAGADOL + BEPESACH, result);

        //"תזריע-מצרע"
        date = HebrewDate.of(5780, 8, 1);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 27 BETWEEN 0 AND 1) OR (S2 - 27 BETWEEN 0 AND 1) ", result);

        //"אחרי מות-קדשים"
        date = HebrewDate.of(5780, 8, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 29 BETWEEN 0 AND 1) OR (S2 - 29 BETWEEN 0 AND 1) ", result);

        //"בהר-בחקתי"
        date = HebrewDate.of(5780, 8, 22);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 32 BETWEEN 0 AND 1) OR (S2 - 32 BETWEEN 0 AND 1) ", result);

        //"מטות-מסעי"
        date = HebrewDate.of(5780, 10, 26);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 42 BETWEEN 0 AND 1) OR (S2 - 42 BETWEEN 0 AND 1) ", result);

        //"נצבים-וילך"
        date = HebrewDate.of(5780, 12, 23);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 51 BETWEEN 0 AND 1) OR (S2 - 51 BETWEEN 0 AND 1) " + TSHUVA, result);
    }

    @Test
    public void checkParashaForLong()
    {
        //"וילך"
        HebrewDate date = HebrewDate.of(5780, 1, 6);
        String result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 0) OR (S2 - 52 BETWEEN 0 AND 0) ", result);

        //"וילך"
        date = HebrewDate.of(5780, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 1) OR (S2 - 52 BETWEEN 0 AND 1) ", result);

        //"וילך"
        date = HebrewDate.of(5780, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 1) OR (S2 - 52 BETWEEN 0 AND 1) " + BESUKKOT, result);

        //"וילך"
        date = HebrewDate.of(5780, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(3, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 1) OR (S2 - 52 BETWEEN 0 AND 1) " + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"וילך"
        date = HebrewDate.of(5780, 1, 6);
        result = SQLForHebrew.of(date).sqlParashaInRange(4, "S").replace("\n", "");
        assertEquals("OR (S1 - 52 BETWEEN 0 AND 1) OR (S2 - 52 BETWEEN 0 AND 1) " + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 1) ", result);

        //"האזינו"
        date = HebrewDate.of(5780, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5780, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) " + BESUKKOT, result);

        //"האזינו"
        date = HebrewDate.of(5780, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) " + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5780, 1, 13);
        result = SQLForHebrew.of(date).sqlParashaInRange(3, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) " + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 1) ", result);

        //"שבת חול המועד סוכות"
        date = HebrewDate.of(5779, 1, 20);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals(BESUKKOT, result);

        //"שבת חול המועד סוכות"
        date = HebrewDate.of(5780, 1, 20);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"שבת חול המועד סוכות"
        date = HebrewDate.of(5780, 1, 20);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 1) ", result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(20, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 20) " + CHANUKA + SHIRA, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(21, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 22) " + CHANUKA + SHIRA, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(23, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 24) " + CHANUKA + SHIRA + HAGADOL, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(24, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 24) " + CHANUKA + SHIRA + HAGADOL + BEPESACH, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(25, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 25) " + CHANUKA + SHIRA + HAGADOL + BEPESACH, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(26, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 27) " + CHANUKA + SHIRA + HAGADOL + BEPESACH, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(27, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 29) " + CHANUKA + SHIRA + HAGADOL + BEPESACH, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(29, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 32) " + CHANUKA + SHIRA + HAGADOL + BEPESACH, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(47, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 51) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(48, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(49, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(50, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA, result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 20, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 20) ", result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 21, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 22) ", result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 23, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 24) ", result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 24, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 24) ", result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 25, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 25) ", result);

        //"בראשית"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 26, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 27) ", result);

        //"year and half"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 27, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 29) ", result);

        //"2 years"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 47, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 51) ", result);

        //"2 years"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 48, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 52) ", result);

        //"2 years"
        date = HebrewDate.of(5780, 1, 27);
        result = SQLForHebrew.of(date).sqlParashaInRange(51 + 49, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + BEPESACH + TSHUVA + BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 52) ", result);

        //"ויקהל-פקודי"
        date = HebrewDate.of(5780, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(25, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 30) OR (S2 - 22 BETWEEN 0 AND 30) " + HAGADOL + BEPESACH + TSHUVA, result);

        //"ויקהל-פקודי"
        date = HebrewDate.of(5780, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(26, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 30) OR (S2 - 22 BETWEEN 0 AND 30) " + HAGADOL + BEPESACH + TSHUVA, result);

        //"ויקהל-פקודי"
        date = HebrewDate.of(5780, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(27, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 31) OR (S2 - 22 BETWEEN 0 AND 31) " + HAGADOL + BEPESACH + TSHUVA, result);

        //"ויקהל-פקודי"
        date = HebrewDate.of(5780, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(28, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 31) OR (S2 - 22 BETWEEN 0 AND 31) " + HAGADOL + BEPESACH + TSHUVA, result);

        //"ויקהל-פקודי"
        date = HebrewDate.of(5780, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(29, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 31) OR (S2 - 22 BETWEEN 0 AND 31) " + HAGADOL + BEPESACH + TSHUVA, result);

        //"ויקהל-פקודי"
        date = HebrewDate.of(5780, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(30, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 31) OR (S2 - 22 BETWEEN 0 AND 31) " + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"ויקהל-פקודי"
        date = HebrewDate.of(5780, 6, 25);
        result = SQLForHebrew.of(date).sqlParashaInRange(60, "S").replace("\n", "");
        assertEquals("OR (S1 - 22 BETWEEN 0 AND 31) OR (S2 - 22 BETWEEN 0 AND 31) " + HAGADOL + BEPESACH + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 33) " + CHANUKA + SHIRA, result);
    }

    @Test
    public void checkParashaRoshBeshabatForLong()
    {
        //"ראש השנה"
        HebrewDate date = HebrewDate.of(5781, 1, 1);
        String result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("", result);

        //"ראש השנה"
        date = HebrewDate.of(5781, 1, 1);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"ראש השנה"
        date = HebrewDate.of(5781, 1, 1);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"ראש השנה"
        date = HebrewDate.of(5781, 1, 1);
        result = SQLForHebrew.of(date).sqlParashaInRange(3, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"ראש השנה"
        date = HebrewDate.of(5781, 1, 1);
        result = SQLForHebrew.of(date).sqlParashaInRange(4, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) OR (S1 - 1 BETWEEN 0 AND 0) ", result);


        //"האזינו"
        date = HebrewDate.of(5781, 1, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5781, 1, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5781, 1, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) ", result);

        //"האזינו"
        date = HebrewDate.of(5781, 1, 8);
        result = SQLForHebrew.of(date).sqlParashaInRange(3, "S").replace("\n", "");
        assertEquals("OR (S1 - 53 BETWEEN 0 AND 0) OR (S1 - 1 BETWEEN 0 AND 0) ", result);


        //"סוכות"
        date = HebrewDate.of(5781, 1, 15);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("", result);

        //"סוכות"
        date = HebrewDate.of(5781, 1, 15);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("", result);

        //"סוכות"
        date = HebrewDate.of(5781, 1, 15);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 0) ", result);


        //"שמיני עצרת"
        date = HebrewDate.of(5781, 1, 22);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("", result);

        //"שמיני עצרת"
        date = HebrewDate.of(5781, 1, 22);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 0) ", result);


        //"בראשית"
        date = HebrewDate.of(5781, 1, 29);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"בראשית"
        date = HebrewDate.of(5781, 1, 29);
        result = SQLForHebrew.of(date).sqlParashaInRange(28, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 30) " + CHANUKA + SHIRA + HAGADOL, result);

        //"בראשית"
        date = HebrewDate.of(5781, 1, 29);
        result = SQLForHebrew.of(date).sqlParashaInRange(29, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 32) " + CHANUKA + SHIRA + HAGADOL, result);

        //"בראשית"
        date = HebrewDate.of(5781, 1, 29);
        result = SQLForHebrew.of(date).sqlParashaInRange(48, "S").replace("\n", "");
        assertEquals("OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + TSHUVA, result);

        //"בראשית"
        date = HebrewDate.of(5781, 1, 29);
        result = SQLForHebrew.of(date).sqlParashaInRange(49, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + TSHUVA, result);

        //"בראשית"
        date = HebrewDate.of(5781, 1, 29);
        result = SQLForHebrew.of(date).sqlParashaInRange(50, "S").replace("\n", "");
        assertEquals(BESUKKOT + "OR (S1 - 1 BETWEEN 0 AND 52) " + CHANUKA + SHIRA + HAGADOL + TSHUVA + "OR (S1 - 1 BETWEEN 0 AND 0) ", result);

        //"צו"
        date = HebrewDate.of(5781, 7, 14);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("OR (S1 - 25 BETWEEN 0 AND 0) " + HAGADOL, result);

        //"צו"
        date = HebrewDate.of(5781, 7, 14);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals("OR (S1 - 25 BETWEEN 0 AND 0) " + HAGADOL, result);

        //"צו"
        date = HebrewDate.of(5781, 7, 14);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 25 BETWEEN 0 AND 1) " + HAGADOL, result);

        //"שביעי של פסח"
        date = HebrewDate.of(5781, 7, 21);
        result = SQLForHebrew.of(date).sqlParashaInRange(0, "S").replace("\n", "");
        assertEquals("", result);

        //"שביעי של פסח"
        date = HebrewDate.of(5781, 7, 21);
        result = SQLForHebrew.of(date).sqlParashaInRange(1, "S").replace("\n", "");
        assertEquals( "OR (S1 - 27 BETWEEN 0 AND 1) OR (S2 - 27 BETWEEN 0 AND 1) ", result);

        //"שביעי של פסח"
        date = HebrewDate.of(5781, 7, 21);
        result = SQLForHebrew.of(date).sqlParashaInRange(2, "S").replace("\n", "");
        assertEquals("OR (S1 - 27 BETWEEN 0 AND 3) OR (S2 - 27 BETWEEN 0 AND 3) ", result);
    }
}