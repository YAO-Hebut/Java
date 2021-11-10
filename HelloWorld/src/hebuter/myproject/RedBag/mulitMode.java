package hebuter.myproject.RedBag;

import java.util.ArrayList;
import java.util.Random;

public class mulitMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, final int totalCount) {
        ArrayList<Integer> redBag = new ArrayList<>();
        int aveNum = totalMoney / totalCount;
        Random r = new Random();
        int everBag;
        int alreadyMoney = 0;
        for (int i = 0; i < totalCount - 1; i++) {
            everBag = r.nextInt(2 * aveNum - 1) + 1;
            alreadyMoney += everBag;
            totalMoney -= everBag;
            aveNum = totalMoney / totalCount;
            redBag.add(everBag);
        }
        redBag.add(totalMoney);
        return redBag;
    }
}
