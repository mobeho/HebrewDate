package org.mobeho.calendar.weak;

import org.junit.Test;
import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.weak.Convert;
import org.mobeho.calendar.hilchati.weak.Shabat;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ConvertTest
{
    // Just for tests
    public static int numberOfParashot(YearType yearType, int index, int weeks)
    {
        return Arrays.stream(Convert.numbersOfParashot(yearType, index, weeks)).sum();
    }

    @Test
    public void numberOfParashotבחג()
    {
        final YearType type = YearType.בחג;

        assertEquals(1, numberOfParashot(type, -2, 0)); //
        assertEquals(2, numberOfParashot(type, -2, 1)); // האזינו
        assertEquals(2, numberOfParashot(type, -2, 2)); // סוכות
        assertEquals(3, numberOfParashot(type, -2, 3)); // בראשית
        assertEquals(4, numberOfParashot(type, -2, 4)); // נח

        assertEquals(23, numberOfParashot(type, -2, 23));
        assertEquals(25, numberOfParashot(type, -2, 24));
        assertEquals(26, numberOfParashot(type, -2, 25));
        assertEquals(27, numberOfParashot(type, -2, 26));
        assertEquals(27, numberOfParashot(type, -2, 27));
        assertEquals(28, numberOfParashot(type, -2, 28));
        assertEquals(30, numberOfParashot(type, -2, 29));
        assertEquals(32, numberOfParashot(type, -2, 30));
        assertEquals(33, numberOfParashot(type, -2, 31));
        assertEquals(35, numberOfParashot(type, -2, 32));

        assertEquals(1, numberOfParashot(type, -1, 0));
        assertEquals(1, numberOfParashot(type, -1, 1));
        assertEquals(2, numberOfParashot(type, -1, 2));
        assertEquals(3, numberOfParashot(type, -1, 3));

        assertEquals(0, numberOfParashot(type, 0, 0));
        assertEquals(1, numberOfParashot(type, 0, 1));
        assertEquals(2, numberOfParashot(type, 0, 2));

        assertEquals(1, numberOfParashot(type, 1, 0));
        assertEquals(2, numberOfParashot(type, 1, 1));
        assertEquals(21, numberOfParashot(type, 1, 20));  // כי תשא
        assertEquals(22 + 1, numberOfParashot(type, 1, 21)); // ויקהל פקויד
        assertEquals(23 + 1, numberOfParashot(type, 1, 22));
        assertEquals(24 + 1, numberOfParashot(type, 1, 23));
        assertEquals(25 + 1 - 1, numberOfParashot(type, 1, 24)); // שבת חול המועד פסח
        assertEquals(26 + 1 - 1, numberOfParashot(type, 1, 25));
        assertEquals(27 + 1 - 1 + 1, numberOfParashot(type, 1, 26)); //תזריע מצורע
        assertEquals(28 + 1 - 1 + 1 + 1, numberOfParashot(type, 1, 27)); //אחרי מות קדושים
        assertEquals(29 + 1 - 1 + 1 + 1, numberOfParashot(type, 1, 28)); // אמור
        assertEquals(30 + 1 - 1 + 1 + 1 + 1, numberOfParashot(type, 1, 29)); // בהר בחוקותי
        assertEquals(31 + 1 - 1 + 1 + 1 + 1, numberOfParashot(type, 1, 30)); // במדבר
        assertEquals(38 + 1 - 1 + 1 + 1 + 1, numberOfParashot(type, 1, 37)); // פנסח
        assertEquals(39 + 1 - 1 + 1 + 1 + 1 + 1, numberOfParashot(type, 1, 38)); // מטות מסעי
        assertEquals(46 + 1 - 1 + 1 + 1 + 1 + 1, numberOfParashot(type, 1, 45)); // כי תבוא
        assertEquals(47 + 1 - 1 + 1 + 1 + 1 + 1 + 1, numberOfParashot(type, 1, 46)); // נצבים
//      assertEquals(49+1-1+1+1+1+1+1	, Shabbat.numberOfParashot(type, 1, 49)); //

        assertEquals(1, numberOfParashot(type, 21, 0));
        assertEquals(3, numberOfParashot(type, 21, 1));
        assertEquals(4, numberOfParashot(type, 21, 2));
        assertEquals(5, numberOfParashot(type, 21, 3));
        assertEquals(5, numberOfParashot(type, 21, 4));
        assertEquals(6, numberOfParashot(type, 21, 5));

        assertEquals(0, numberOfParashot(type, 25, 0));
        assertEquals(1, numberOfParashot(type, 25, 1));

        assertEquals(1, numberOfParashot(type, 26, 0));
        assertEquals(3, numberOfParashot(type, 26, 1));
        assertEquals(5, numberOfParashot(type, 26, 2));
        assertEquals(6, numberOfParashot(type, 26, 3));
        assertEquals(8, numberOfParashot(type, 26, 4));
        assertEquals(9, numberOfParashot(type, 26, 5));

        // Last Shabat
        assertEquals(1, numberOfParashot(type, 47, 0));
        assertEquals(2, numberOfParashot(type, 47, 1));
        assertEquals(2, numberOfParashot(type, 47, 2));
        assertEquals(2, numberOfParashot(type, 47, 3));
        assertEquals(4, numberOfParashot(type, 47, 5));
    }

    @Test
    public void numberOfParashotבחה()
    {
        final YearType type = YearType.בחה;
        assertEquals(1, numberOfParashot(type, 1, 0));
        assertEquals(2, numberOfParashot(type, 1, 1));
        assertEquals(21, numberOfParashot(type, 1, 20));
        assertEquals(28, numberOfParashot(type, 1, 27)); // Metzora
        assertEquals(29 - 1, numberOfParashot(type, 1, 28)); // Pesach
        assertEquals(30 - 1, numberOfParashot(type, 1, 29)); // Achrei
        assertEquals(43 - 1 + 1, numberOfParashot(type, 1, 42)); // Matot
        assertEquals(51 - 1 + 1 + 1, numberOfParashot(type, 1, 50)); // Nitzavim
        assertEquals(51 - 1 + 1 + 1, numberOfParashot(type, 1, 51)); // Nitzavim
        assertEquals(51 - 1 + 1 + 1 + 1, numberOfParashot(type, 1, 52)); // Next Rosh Hashana
    }

    @Test
    public void numberOfParashotזחא()
    {
        final YearType type = YearType.זחא;
        assertEquals(0, numberOfParashot(type, -3, 0)); // Rosh Hashan
        assertEquals(1, numberOfParashot(type, -3, 1)); // Rosh Hashan
        assertEquals(1, numberOfParashot(type, -3, 2)); // Aazinu
        assertEquals(1, numberOfParashot(type, -3, 3)); // Succot
        assertEquals(2, numberOfParashot(type, -3, 4)); // Succot
        assertEquals(3, numberOfParashot(type, -3, 5)); // Bereshit
        assertEquals(1, numberOfParashot(type, -2, 0));
        assertEquals(1, numberOfParashot(type, -2, 1));
        assertEquals(1, numberOfParashot(type, -2, 2));
        assertEquals(2, numberOfParashot(type, -2, 3));
        assertEquals(3, numberOfParashot(type, -2, 4));
        assertEquals(0, numberOfParashot(type, -1, 0));
        assertEquals(0, numberOfParashot(type, -1, 1));
        assertEquals(1, numberOfParashot(type, -1, 2));
        assertEquals(2, numberOfParashot(type, -1, 3));
        assertEquals(0, numberOfParashot(type, 0, 0));
        assertEquals(1, numberOfParashot(type, 0, 1));
        assertEquals(2, numberOfParashot(type, 0, 2));
        assertEquals(1, numberOfParashot(type, 1, 0));
        assertEquals(21, numberOfParashot(type, 1, 20));
    }

    @Test
    public void numberOfParashotהכז()
    {
        final YearType type = YearType.הכז;
        assertEquals(1, numberOfParashot(type, -2, 0));
        assertEquals(1, numberOfParashot(type, -2, 1));
        assertEquals(1, numberOfParashot(type, -2, 2));
        assertEquals(2, numberOfParashot(type, -2, 3));

        assertEquals(0, numberOfParashot(type, -1, 0));
        assertEquals(0, numberOfParashot(type, -1, 1));
        assertEquals(1, numberOfParashot(type, -1, 2));

        assertEquals(0, numberOfParashot(type, 0, 0));
        assertEquals(1, numberOfParashot(type, 0, 1));

        assertEquals(1, numberOfParashot(type, 1, 0));
        assertEquals(2, numberOfParashot(type, 1, 1));
        assertEquals(21, numberOfParashot(type, 1, 20));
        assertEquals(22 + 1, numberOfParashot(type, 1, 21)); // Vaiakhel
        assertEquals(23 + 1, numberOfParashot(type, 1, 22));
        assertEquals(24 + 1, numberOfParashot(type, 1, 23));
        assertEquals(25 + 1 - 1, numberOfParashot(type, 1, 24)); // Pesach
        assertEquals(26 + 1 - 1, numberOfParashot(type, 1, 25));
        assertEquals(27 + 1 - 1 + 1, numberOfParashot(type, 1, 26)); //Tazriaa
        assertEquals(28 + 1 - 1 + 1 + 1, numberOfParashot(type, 1, 27)); //Avharei
        assertEquals(29 + 1 - 1 + 1 + 1, numberOfParashot(type, 1, 28)); // Emor
        assertEquals(30 + 1 - 1 + 1 + 1, numberOfParashot(type, 1, 29)); // Behar
        assertEquals(31 + 1 - 1 + 1 + 1, numberOfParashot(type, 1, 30)); // Emor
        assertEquals(39 + 1 - 1 + 1 + 1, numberOfParashot(type, 1, 38)); //
        assertEquals(40 + 1 - 1 + 1 + 1 + 1, numberOfParashot(type, 1, 39)); //
        assertEquals(42 + 1 - 1 + 1 + 1 + 1, numberOfParashot(type, 1, 41)); //

        assertEquals(0, numberOfParashot(type, 25, 0));
        assertEquals(1, numberOfParashot(type, 25, 1));
        assertEquals(3, numberOfParashot(type, 25, 2));
        assertEquals(5, numberOfParashot(type, 25, 3));
    }

    @Test
    public void numberOfParashotהחא()
    {
        final YearType type = YearType.החא;
        assertEquals(1, numberOfParashot(type, 1, 0));
        assertEquals(2, numberOfParashot(type, 1, 1));
        assertEquals(21, numberOfParashot(type, 1, 20));
        assertEquals(30 - 1, numberOfParashot(type, 1, 29)); // Pesach
        assertEquals(43 - 1, numberOfParashot(type, 1, 42)); // Matot
        assertEquals(51 - 1, numberOfParashot(type, 1, 50)); // Nitzavim

        assertEquals(0, numberOfParashot(type, 30, 0)); // Pesach
        assertEquals(1, numberOfParashot(type, 30, 1));
    }

}
