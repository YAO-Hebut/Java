package hebuter.myproject.Laptop;

public class main {
    public static void main(String[] args) {
        Laptop computer = new Laptop();
        Mouse mouse = new Mouse();
        Keyboard keyboard = new Keyboard();

        computer.powerOn();

        computer.useDevice(mouse);
        computer.useDevice(keyboard);

        computer.powerOff();
    }
}
