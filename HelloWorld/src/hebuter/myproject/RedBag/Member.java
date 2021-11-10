package hebuter.myproject.RedBag;

public class Member extends User {
    public Member(String name) {
        super(name, 0);
    }

    public void receive(int receiveMoney) {
        setTotalMoney(getTotalMoney() + receiveMoney);
    }
}
