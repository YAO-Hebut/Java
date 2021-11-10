package hebuter.myproject.Thread;

public class Consumer implements Runnable {
    Box b = new Box();

    public Consumer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            b.take();
        }
    }
}
