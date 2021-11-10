package hebuter.myproject.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class LandLord {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();

        ArrayList<Integer> array = new ArrayList<>();

        String[] colors = {"♣", "♦", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //创造牌堆
        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                array.add(index);
                hm.put(index, color + number);
                index++;
            }
        }
        hm.put(index, "小王");
        array.add(index);
        index++;
        hm.put(index, "大王");
        array.add(index);

        //洗牌
        Collections.shuffle(array);

        //发牌
        TreeSet<Integer> Player1 = new TreeSet<>();    //一号玩家
        TreeSet<Integer> Player2 = new TreeSet<>();    //二号玩家
        TreeSet<Integer> Player3 = new TreeSet<>();    //三号玩家
        TreeSet<Integer> holeCards = new TreeSet<>();  //底牌

        for (int i = 0; i < array.size(); i++) {
            int x = array.get(i);
            if (i >= array.size() - 3) {
                holeCards.add(x);
            } else if (i % 3 == 0) {
                Player1.add(x);
            } else if (i % 3 == 1) {
                Player2.add(x);
            } else if (i % 3 == 2) {
                Player3.add(x);
            }
        }

        lookCards("玩家1", Player1, hm);
        lookCards("玩家2", Player2, hm);
        lookCards("玩家3", Player3, hm);
    }


    public static void lookCards(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.print(name + "的牌是：");
        for (Integer i : ts) {
            String poker = hm.get(i);
            System.out.print(poker + " ");
        }
        System.out.println();
    }

}
