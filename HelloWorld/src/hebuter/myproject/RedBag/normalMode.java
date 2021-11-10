package hebuter.myproject.RedBag;

import java.util.ArrayList;

public class normalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> redBag = new ArrayList<>();
        int aveNum = totalMoney / totalCount;
        int mod = totalMoney % totalCount;
        for (int i = 0; i < totalCount - 1; i++) {
            redBag.add(aveNum);
        }
        redBag.add(mod);
        return redBag;
    }
}
