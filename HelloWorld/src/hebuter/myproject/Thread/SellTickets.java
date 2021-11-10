package hebuter.myproject.Thread;

public class SellTickets implements Runnable {
    private int tickets = 100;
    Object obj = new Object();

    @Override
    public void run() {
        synchronized(obj) {
            while (true) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票...");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tickets--;
                }
            }
        }
    }
}
