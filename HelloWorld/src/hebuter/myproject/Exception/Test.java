package hebuter.myproject.Exception;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ScoreException {
        Teacher t = new Teacher();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数：");
        int score = sc.nextInt();
        t.ScoreTest(score);
    }
}
