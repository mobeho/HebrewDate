package org.mobeho.calendar;

import org.mobeho.calendar.hilchaty.ShabatHoli;
import org.mobeho.calendar.hilchaty.Shabbat;
import org.mobeho.calendar.hilchaty.YearType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShabatHoliTest
{
    @Test
    public void getDayInYearForבשה()
    {
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.ROSH_HASHANA.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.YOM_KIPUR.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.SUKKOT.getVal()));
        assertEquals(20, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.BESUKKOT.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.SHMINI.getVal()));
        assertEquals(90, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.CHANUKA.getVal()));
        assertEquals(132, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.SHIRA.getVal()));
        assertEquals(188, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.HAGADOL.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.PESACH.getVal()));
        assertEquals(195, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.BEPESACH.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.SHVIEE.getVal()));
        assertEquals(349, ShabatHoli.getDayInYear(YearType.בשה, ShabatHoli.TESHUVA.getVal()));
    }

    @Test
    public void setParashaבשז()
    {
        HebrewDate date = HebrewDate.ofParasha(5780, Shabbat.Shabbatot.וילך.ordinal()+1, false);
        assertEquals(5780, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(6, date.getDay());

        date = HebrewDate.ofParasha(5780, Shabbat.Shabbatot.האזינו.ordinal()+1, false);
        assertEquals(5780, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(13, date.getDay());

        date = HebrewDate.ofParasha(5780, ShabatHoli.BESUKKOT.getVal(), false);
        assertEquals(5780, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(20, date.getDay());

        date = HebrewDate.ofParasha(5780, ShabatHoli.BESUKKOT.getVal(), true);
        assertEquals(5780, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(20, date.getDay());
    }


    @Test
    public void getDayInYearForזחא()
    {
        assertEquals(1, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.ROSH_HASHANA.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.YOM_KIPUR.getVal()));
        assertEquals(15, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.SUKKOT.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.BESUKKOT.getVal()));
        assertEquals(22, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.SHMINI.getVal()));
        assertEquals(85, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.CHANUKA.getVal()));
        assertEquals(134, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.SHIRA.getVal()));
        assertEquals(190, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.HAGADOL.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.PESACH.getVal()));
        assertEquals(-1, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.BEPESACH.getVal()));
        assertEquals(197, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.SHVIEE.getVal()));
        assertEquals(351, ShabatHoli.getDayInYear(YearType.זחא, ShabatHoli.TESHUVA.getVal()));
    }
}
