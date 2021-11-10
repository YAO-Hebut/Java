package hebuter.myproject.Collections;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int chineseScore;
    private int mathScore;
    private int score;

    public Student() {
    }

    public Student(String name, int age, int chineseScore, int mathScore) {
        this.name = name;
        this.age = age;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.score = mathScore + chineseScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;
        if (age != student.age) {
            return false;
        }
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Student s) {
        int num = this.score - s.score;
        if (num == 0) {
            num = this.age - s.age;
        }
        if (num == 0) {
            num = this.name.compareTo(s.name);
        }
        return num;
    }

}
