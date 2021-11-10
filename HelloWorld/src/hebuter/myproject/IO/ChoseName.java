package hebuter.myproject.IO;

import hebuter.myproject.Collections.Student;

import java.io.*;
import java.util.*;

public class ChoseName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\IO\\name.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\IO\\name.txt"));

        Scanner sc = new Scanner(System.in);

        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
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

        System.out.println("请输入学生个数：");
        int num = sc.nextInt();
        String name;
        int age, chineseScore, mathScore;
        for (int i = 0; i < num; i++) {
            Student s = new Student();
            System.out.println("请输入第" + (i + 1) + "位学生姓名、年龄、语文成绩和数学成绩：");
            s.setName(sc.next());
            s.setAge(sc.nextInt());
            s.setChineseScore(sc.nextInt());
            s.setMathScore(sc.nextInt());
            s.setScore(s.getChineseScore() + s.getMathScore());


            ts.add(s);
        }

        for (Student s : ts) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getChineseScore()).append(",").append(s.getMathScore()).append(",").append(s.getScore()).append(".");

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
