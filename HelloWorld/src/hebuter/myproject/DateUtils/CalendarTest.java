package hebuter.myproject.DateUtils;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要判断的年份：");
        int year = sc.nextInt();
        Calendar cal = Calendar.getInstance();
        cal.set(year, 2, 1);
        cal.add(Calendar.DATE, -1);
        int date = cal.get(Calendar.DATE);
        if (date == 29) {
            System.out.println("该年为闰年");
        } else {
            System.out.println("该年不为闰年");
        }
    }
}
