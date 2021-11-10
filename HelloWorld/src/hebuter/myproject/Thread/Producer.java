package hebuter.myproject.Thread;

public class Producer implements Runnable {
    Box b = new Box();

    public Producer(Box b) {
        this.b = b;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            b.put(i);
        }
    }
}
