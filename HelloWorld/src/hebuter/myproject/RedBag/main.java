package hebuter.myproject.RedBag;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.print("请输入群主信息（姓名、现有金额）：");
        Scanner sc = new Scanner(System.in);
        String name;
        int money;
        name = sc.next();
        money = sc.nextInt();
        Lord lord = new Lord(name, money);

        ArrayList<Member> members = new ArrayList<>();
        System.out.println("请输入群员个数：");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("请输入第 " + (i + 1) + " 位群员的姓名：");
            name = sc.next();
            Member m = new Member(name);
            members.add(m);
        }


        ArrayList<Integer> redBag = new ArrayList<>();
        while (true) {
            redBag = lord.send();
            if (redBag.size() == 0) {
            } else {
                for (int i = 0; i < members.size(); i++) {
                    int num = redBag.get(i);
                    members.get(i).receive(num);
                }
                break;
            }
        }
        System.out.println("===================群主===================");
        System.out.println("姓名：" + lord.getName() + ",剩余金额：" + lord.getTotalMoney());
        System.out.println("==========================================");
        System.out.println();
        System.out.println("===================群员===================");
        for (int i = 0; i < members.size(); i++) {
            System.out.println("姓名：" + members.get(i).getName() + ",剩余金额："
                    + members.get(i).getTotalMoney());
        }
    }
}
