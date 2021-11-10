package hebuter.myproject.Thread;

public class Box {
    private int milk;
    private boolean state = false;

    public synchronized void put(int milk) {
        if (state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.milk = milk;
        System.out.println("生产者生产了产品" + milk);
        state = true;
        notifyAll();
    }

    public synchronized void take() {
        if (!state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("消费者拿走了产品" + milk);
        state = false;
        notifyAll();
    }
}
