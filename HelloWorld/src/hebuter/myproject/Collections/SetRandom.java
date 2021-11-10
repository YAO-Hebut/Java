package hebuter.myproject.Collections;

import java.util.*;

public class SetRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        TreeMap<Character, Integer> tm = new TreeMap<>();

        for (int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);
            Integer value = tm.get(key);
            if (value == null) {
                tm.put(key, 1);
            } else {
                value++;
                tm.put(key, value);
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Character> keySet = tm.keySet();
        for (Character key : keySet) {
            Integer value = tm.get(key);
            sb.append(key).append("(").append(value).append(")");
        }

        System.out.println(sb);
    }
}
