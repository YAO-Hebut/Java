package hebuter.myproject.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        String s1 = DateUtils.dateToString(d, "yyyy年MM月dd日 HH:mm:ss");
        System.out.println(s1);


        String s2 = "2021/8/9 11:25";
        Date date = DateUtils.StringToDate(s2, "yyyy/MM/dd HH:mm");
        System.out.println(date);
    }


}
