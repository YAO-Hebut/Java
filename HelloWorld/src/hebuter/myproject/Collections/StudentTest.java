package hebuter.myproject.Collections;

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> stu = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("请输入学生个数：");
        num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            Student s = new Student();
            String name;
            int age, chineseScore, mathScore;
            System.out.print("请输入第" + (i + 1) + "位学生姓名、年龄、语文成绩、数学成绩：");
            name = sc.next();
            age = sc.nextInt();
            chineseScore = sc.nextInt();
            mathScore = sc.nextInt();
            s.setName(name);
            s.setAge(age);
            s.setChineseScore(chineseScore);
            s.setMathScore(mathScore);
            s.setScore(mathScore + chineseScore);
            stu.add(s);
        }

        Collections.sort(stu, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o2.getScore() - o1.getScore();
                if (num == 0) {
                    num = o1.getAge() - o2.getAge();
                }
                if (num == 0) {
                    num = o1.getName().compareTo(o2.getName());
                }
                return num;
            }
        });
//        Iterator<Student> it = stu.iterator();
//        while (it.hasNext()) {
//            Student student = it.next();
//            System.out.println("姓名：" + student.getName() + "年龄" + student.getAge());
//        }
        Iterator<Student> it = stu.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println("姓名：" + s.getName() + "年龄" + s.getAge() + "总分" + s.getScore());
        }

//        for (int i = 0; i < stu.size(); i++) {
//            Student s = stu.get(i);
//            System.out.println("姓名：" + s.getName() + "年龄" + s.getAge());
//        }


        for (Student s : stu) {
            System.out.println("姓名：" + s.getName() + "年龄" + s.getAge() + "总分" + s.getScore());
        }
    }
}
