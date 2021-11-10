package hebuter.myproject.Exception;

public class Teacher {
    public static void ScoreTest(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("您输入的分数有误！");
        } else {
            System.out.println("输入正确");
        }
    }
}
