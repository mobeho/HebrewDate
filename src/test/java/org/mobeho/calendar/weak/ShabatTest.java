package org.mobeho.calendar.weak;

import org.junit.Test;
import org.mobeho.calendar.HebrewDate;
import org.mobeho.calendar.calendar.YearType;
import org.mobeho.calendar.hilchati.weak.Shabat;
import org.mobeho.calendar.hilchati.weak.Parasha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ShabatTest
{
    @Test
    public void checkShabatRoshChodesh()
    {
        YearType type = YearType.בחג; //5797
        assertNull(Shabat.isWeakOfRoshChodesh(type, 111));
        for (int day = 112; day < 119; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 119));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 258));
        for (int day = 259; day < 266; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 266));


        type = YearType.בחה; //5793
        assertNull(Shabat.isWeakOfRoshChodesh(type, 111));
        for (int day = 112; day < 119; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 119));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 139));
        for (int day = 140; day < 147; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 147));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 230));
        for (int day = 231; day < 238; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 238));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 258));
        for (int day = 259; day < 266; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 266));


        type = YearType.בשה; //5783
        assertNull(Shabat.isWeakOfRoshChodesh(type, 83));
        for (int day = 84; day < 91; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 91));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 202));
        for (int day = 203; day < 210; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 210));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 230));
        for (int day = 231; day < 238; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 238));


        type = YearType.בשז; //5803
        assertNull(Shabat.isWeakOfRoshChodesh(type, 83));
        for (int day = 84; day < 91; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 91));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 202));
        for (int day = 203; day < 210; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 210));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 349));
        for (int day = 350; day < 357; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 357));


        type = YearType.גכה; //5786
        assertNull(Shabat.isWeakOfRoshChodesh(type, 82));
        for (int day = 83; day < 90; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 90));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 201));
        for (int day = 202; day < 209; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 209));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 229));
        for (int day = 230; day < 237; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 237));


        type = YearType.גכז; //5782
        assertNull(Shabat.isWeakOfRoshChodesh(type, 82));
        for (int day = 83; day < 90; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 90));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 201));
        for (int day = 202; day < 209; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 209));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 229));
        for (int day = 230; day < 237; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 237));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 348));
        for (int day = 349; day < 356; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 356));


        type = YearType.הכז; //5789
        assertNull(Shabat.isWeakOfRoshChodesh(type, 24));
        for (int day = 25; day < 32; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 32));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 52));
        for (int day = 53; day < 60; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 60));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 171));
        for (int day = 172; day < 179; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 179));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 199));
        for (int day = 200; day < 207; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 207));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 318));
        for (int day = 319; day < 326; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 326));


        type = YearType.החא; //5765
        assertNull(Shabat.isWeakOfRoshChodesh(type, 24));
        for (int day = 25; day < 32; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 32));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 52));
        for (int day = 53; day < 60; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 60));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 171));
        for (int day = 172; day < 179; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 179));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 318));
        for (int day = 319; day < 326; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 326));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 346));
        for (int day = 347; day < 354; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 354));


        type = YearType.השא; //5785
        assertNull(Shabat.isWeakOfRoshChodesh(type, 24));
        for (int day = 25; day < 32; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 32));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 52));
        for (int day = 53; day < 60; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 60));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 143));
        for (int day = 144; day < 151; day++)
        {
            assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
            assertEquals(2, Shabat.countSfarim(type, day));
        }
        assertNull(Shabat.isWeakOfRoshChodesh(type, 151));

        // פרשת החודש מבטלת את ערב ראש חודש
        for (int day = 172; day < 179; day++)
        {
            assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
            assertEquals(2, Shabat.countSfarim(type, day));
        }

        assertNull(Shabat.isWeakOfRoshChodesh(type, 290));
        for (int day = 291; day < 298; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 298));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 318));
        for (int day = 319; day < 326; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 326));


        type = YearType.השג; //5822
        assertNull(Shabat.isWeakOfRoshChodesh(type, 24));
        for (int day = 25; day < 32; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 32));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 52));
        for (int day = 53; day < 60; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 60));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 143));
        for (int day = 144; day < 151; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 151));

        // פרשת שקלים מבטלת את ערב ראש חודש
        for (int day = 172; day < 179; day++)
        {
            assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
            assertEquals(2, Shabat.countSfarim(type, day));
        }

        assertNull(Shabat.isWeakOfRoshChodesh(type, 290));
        for (int day = 291; day < 298; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 298));


        type = YearType.זחא; //5781
        assertNull(Shabat.isWeakOfRoshChodesh(type, 22));
        for (int day = 23; day < 30; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 30));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 141));
        for (int day = 142; day < 149; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 149));

        // פרשת החודש מבטלת את ערב ראש חודש
        for (int day = 170; day < 177; day++)
        {
            assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
            assertEquals(2, Shabat.countSfarim(type, day));
        }


        assertNull(Shabat.isWeakOfRoshChodesh(type, 288));
        for (int day = 289; day < 296; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 296));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 316));
        for (int day = 317; day < 324; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 324));


        type = YearType.זחג; //5784
        assertNull(Shabat.isWeakOfRoshChodesh(type, 22));
        for (int day = 23; day < 30; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 30));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 141));
        for (int day = 142; day < 149; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 149));

        // פרשת שקלים מבטלת את ערב ראש חודש
        for (int day = 170; day < 177; day++)
        {
            assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
            assertEquals(2, Shabat.countSfarim(type, day));
        }

        assertNull(Shabat.isWeakOfRoshChodesh(type, 288));
        for (int day = 289; day < 296; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 296));


        type = YearType.זשג; //5764
        assertNull(Shabat.isWeakOfRoshChodesh(type, 22));
        for (int day = 23; day < 30; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 30));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 113));
        for (int day = 114; day < 121; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 121));

        // פרשת שקלים מבטלת את ערב ראש חודש
        for (int day = 142; day < 149; day++)
        {
            assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
            assertEquals(2, Shabat.countSfarim(type, day));
        }

        assertNull(Shabat.isWeakOfRoshChodesh(type, 260));
        for (int day = 261; day < 268; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 268));


        type = YearType.זשה; //5814
        assertNull(Shabat.isWeakOfRoshChodesh(type, 22));
        for (int day = 23; day < 30; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 30));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 113));
        for (int day = 114; day < 121; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 121));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 141));
        for (int day = 142; day < 149; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 149));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 232));
        for (int day = 233; day < 240; day++) assertEquals(Parasha.ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 240));

        assertNull(Shabat.isWeakOfRoshChodesh(type, 260));
        for (int day = 261; day < 268; day++) assertEquals(Parasha.ערב_ראש_חודש, Shabat.isWeakOfRoshChodesh(type, day));
        assertNull(Shabat.isWeakOfRoshChodesh(type, 268));

    }

    // Helper function
    @Test
    public void checkShabat()
    {
        System.out.println("");
        System.out.println("ShabatTest.checkShabat");
        System.out.println("----------------------");

        // בחג = 5797
        // בחה = 5793
        // בשה = 5783
        // בשז = 5803
        // גכה = 5786
        // גכז = 5782
        // הכז = 5789
        // החא = 5765
        // השא = 5785
        // השג = 5822
        // זחא = 5781
        // זחג = 5784
        // זשג = 5764
        // זשה = 5814

        HebrewDate date = HebrewDate.of(HebrewDate.now().getYear(), 1, 1);

        for (; date.getDayInYear() < date.getNumberDaysInYear(); date.addDays(1))
        {
            if (Shabat.isHaftaraSpecial(date.getYearType(), date.getDayInYear()))
                System.out.println(date.getDayInYear() + " " + date.toShortString() + " " + date.getShabatName() + " " + Shabat.countSfarim(date.getYearType(), date.getDayInYear()));
        }
    }

    @Test
    public void toMonthDayבחג()
    {
        final YearType type = YearType.בחג;
        int[] convert = Shabat.getMonthDay(type, 1);
        assertEquals(1, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 30);
        assertEquals(1, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 31);
        assertEquals(2, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 59);
        assertEquals(2, convert[0]);
        assertEquals(29, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 60);
        assertEquals(3, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 88);
        assertEquals(3, convert[0]);
        assertEquals(29, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 89);
        assertEquals(4, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 117);
        assertEquals(4, convert[0]);
        assertEquals(29, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 118);
        assertEquals(5, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 147);
        assertEquals(5, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 148);
        assertEquals(6, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 176);
        assertEquals(6, convert[0]);
        assertEquals(29, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 177);
        assertEquals(7, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);
    }

    @Test
    public void toMonthDayבחה()
    {
        final YearType type = YearType.בחה;
        int[] convert = Shabat.getMonthDay(type, 1);
        assertEquals(1, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 30);
        assertEquals(1, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 31);
        assertEquals(2, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 59);
        assertEquals(2, convert[0]);
        assertEquals(29, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 60);
        assertEquals(3, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 88);
        assertEquals(3, convert[0]);
        assertEquals(29, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 89);
        assertEquals(4, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 117);
        assertEquals(4, convert[0]);
        assertEquals(29, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 118);
        assertEquals(5, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 147);
        assertEquals(5, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 148);
        assertEquals(6, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 177);
        assertEquals(6, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 178);
        assertEquals(7, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);
    }

    @Test
    public void toMonthDayבשה()
    {
        final YearType type = YearType.בשה;
        int[] convert = Shabat.getMonthDay(type, 1);
        assertEquals(1, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 30);
        assertEquals(1, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 31);
        assertEquals(2, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 60);
        assertEquals(2, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 61);
        assertEquals(3, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 90);
        assertEquals(3, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 91);
        assertEquals(4, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);
    }

    @Test
    public void toMonthDayגכה()
    {
        final YearType type = YearType.גכה;
        int[] convert = Shabat.getMonthDay(type, 1);
        assertEquals(1, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 30);
        assertEquals(1, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 31);
        assertEquals(2, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 59);
        assertEquals(2, convert[0]);
        assertEquals(29, convert[1]);
        assertEquals(29, convert[2]);

        convert = Shabat.getMonthDay(type, 60);
        assertEquals(3, convert[0]);
        assertEquals(1, convert[1]);
        assertEquals(30, convert[2]);

        convert = Shabat.getMonthDay(type, 89);
        assertEquals(3, convert[0]);
        assertEquals(30, convert[1]);
        assertEquals(30, convert[2]);
    }

}
