package hebuter.myproject.RedBag;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lord extends User {
    public Lord(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send() {
        System.out.println("请输入要发送的红包金额:");
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> redBag = new ArrayList<>();
        int money;
        money = sc.nextInt();
        if (money > super.getTotalMoney()) {
            System.out.println("您的金额不足：");
        } else {
            setTotalMoney(getTotalMoney() - money);
            System.out.println("请输入要发送的红包个数:");
            int count;
            count = sc.nextInt();


            System.out.println("请选择红包种类（1.平均红包  2.手气红包）：");
            int kind = sc.nextInt();
            do {
                int alreadyMoney = 0;
                if (kind == 1) {
                    redBag = new normalMode().divide(money, count);
                    break;
                } else if (kind == 2) {
                    redBag = new mulitMode().divide(money, count);
                    break;
                } else {
                    System.out.println("输入有误请重输：");
                    kind = sc.nextInt();
                }
            } while (true);
        }
        return redBag;
    }
}
