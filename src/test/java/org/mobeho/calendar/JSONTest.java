package org.mobeho.calendar;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class JSONTest
{
    @Test
    public void checkJSON()
    {
        String json = JSONForHebrew.getYears(5780, true, 5);
        assertEquals("{\"list\":[{\"year\":5780,\"shana\":\"התשפ\"},{\"year\":5781,\"shana\":\"התשפא\"},{\"year\":5782,\"shana\":\"התשפב\"},{\"year\":5783,\"shana\":\"התשפג\"},{\"year\":5784,\"shana\":\"התשפד\"}]}", json);

        json = JSONForHebrew.getYears(5780, false, 4, (byte) 1);
        assertEquals("{\"list\":[{\"year\":5780,\"shana\":\"התשפ\",\"numberOfMonths\":12},{\"year\":5781,\"shana\":\"התשפא\",\"numberOfMonths\":12},{\"year\":5782,\"shana\":\"התשפב\",\"numberOfMonths\":13},{\"year\":5783,\"shana\":\"התשפג\",\"numberOfMonths\":12}]}", json);

        json = JSONForHebrew.getYears(5780, true, 3, (byte) 2);
        assertEquals("{\"list\":[{\"year\":5780,\"shana\":\"התשפ\",\"numberDaysInYear\":355},{\"year\":5781,\"shana\":\"התשפא\",\"numberDaysInYear\":353},{\"year\":5782,\"shana\":\"התשפב\",\"numberDaysInYear\":384}]}", json);

        json = JSONForHebrew.getYears(5780, true, 2, (byte) 4);
        assertEquals("{\"list\":[{\"year\":5780,\"shana\":\"התשפ\",\"siman\":\"בשה\"},{\"year\":5781,\"shana\":\"התשפא\",\"siman\":\"זחא\"}]}", json);

        json = JSONForHebrew.getYears(5780, true, 1, (byte) 13);
        assertEquals("{\"list\":[{\"year\":5780,\"shana\":\"התשפ\",\"numberOfMonths\":12,\"siman\":\"בשה\",\"cycle\":\"4/305\"}]}", json);

        json = JSONForHebrew.getMonths(5780);
        assertEquals("{\"list\":[{\"index\":1,\"month\":\"תשרי\"},{\"index\":2,\"month\":\"חשוון\"},{\"index\":3,\"month\":\"כסלו\"},{\"index\":4,\"month\":\"טבת\"},{\"index\":5,\"month\":\"שבט\"},{\"index\":6,\"month\":\"אדר\"},{\"index\":7,\"month\":\"ניסן\"},{\"index\":8,\"month\":\"אייר\"},{\"index\":9,\"month\":\"סיוון\"},{\"index\":10,\"month\":\"תמוז\"},{\"index\":11,\"month\":\"אב\"},{\"index\":12,\"month\":\"אלול\"}]}", json);

        json = JSONForHebrew.getDays(5780, 3);
        assertTrue(json.startsWith("{\"list\":[{\"index\":1,\"day\":\"א\",\"weekDay\":\"יום שישי\"},{\"index\":2,\"day\":\"ב\",\"weekDay\":\"שבת\"},{\"index\":3,\"day\":\"ג\",\"weekDay\":\"יום ראשון\"},{\"index\":4,\"day\":\"ד\",\"weekDay\":\"יום שני\"}"));

        json = JSONForHebrew.getShabatot(5780, (byte)3);
        assertTrue(json.startsWith("{\"list\":[{\"index\":1,\"name\":\"בראשית\",\"dayInYear\":27,\"taarich\":\"כח תשרי\"},{\"index\":2,\"name\":\"נח\",\"dayInYear\":34,\"taarich\":\"ה חשוון\"}"));
        assertTrue(json.endsWith("{\"index\":46,\"name\":\"כי-תבוא\",\"dayInYear\":342,\"taarich\":\"יז אלול\"},{\"index\":47,\"name\":\"נצבים וילך\",\"dayInYear\":349,\"taarich\":\"כד אלול\"}]}"));

        json = JSONForHebrew.getShabatot(5780);
        assertTrue(json.equals("{\"list\":[{\"index\":1,\"name\":\"בראשית\"},{\"index\":2,\"name\":\"נח\"},{\"index\":3,\"name\":\"לך-לך\"},{\"index\":4,\"name\":\"וירא\"},{\"index\":5,\"name\":\"חיי-שרה\"},{\"index\":6,\"name\":\"תולדות\"},{\"index\":7,\"name\":\"ויצא\"},{\"index\":8,\"name\":\"וישלח\"},{\"index\":9,\"name\":\"וישב\"},{\"index\":10,\"name\":\"מקץ - ראש חודש - חנוכה\"},{\"index\":11,\"name\":\"ויגש\"},{\"index\":12,\"name\":\"ויחי\"},{\"index\":13,\"name\":\"שמות\"},{\"index\":14,\"name\":\"וארא\"},{\"index\":15,\"name\":\"בא\"},{\"index\":16,\"name\":\"בשלח (שירה)\"},{\"index\":17,\"name\":\"יתרו\"},{\"index\":18,\"name\":\"משפטים - שקלים\"},{\"index\":19,\"name\":\"תרומה\"},{\"index\":20,\"name\":\"תצוה - זכור\"},{\"index\":21,\"name\":\"כי-תשא - פרה\"},{\"index\":22,\"name\":\"ויקהל פקודי - החודש\"},{\"index\":23,\"name\":\"ויקרא\"},{\"index\":24,\"name\":\"צו (הגדול)\"},{\"index\":25,\"name\":\"שבת חול המועד פסח\"},{\"index\":26,\"name\":\"שמיני\"},{\"index\":27,\"name\":\"תזריע מצרע - ראש חודש\"},{\"index\":28,\"name\":\"אחרי-מות קדשים\"},{\"index\":29,\"name\":\"אמר\"},{\"index\":30,\"name\":\"בהר בחקתי\"},{\"index\":31,\"name\":\"במדבר (ערב ראש חודש)\"},{\"index\":32,\"name\":\"נשא\"},{\"index\":33,\"name\":\"בהעלתך\"},{\"index\":34,\"name\":\"שלח-לך\"},{\"index\":35,\"name\":\"קרח\"},{\"index\":36,\"name\":\"חקת\"},{\"index\":37,\"name\":\"בלק\"},{\"index\":38,\"name\":\"פינחס\"},{\"index\":39,\"name\":\"מטות מסעי\"},{\"index\":40,\"name\":\"דברים\"},{\"index\":41,\"name\":\"ואתחנן\"},{\"index\":42,\"name\":\"עקב\"},{\"index\":43,\"name\":\"ראה\"},{\"index\":44,\"name\":\"שפטים\"},{\"index\":45,\"name\":\"כי-תצא\"},{\"index\":46,\"name\":\"כי-תבוא\"},{\"index\":47,\"name\":\"נצבים וילך\"}]}"));
    }
}
