package hebuter.myproject.Thread;

public class SellTicketsDemo {
    public static void main(String[] args) {
        SellTickets st = new SellTickets();

        Thread w1 = new Thread(st, "窗口1");
        Thread w2 = new Thread(st, "窗口2");
        Thread w3 = new Thread(st, "窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
