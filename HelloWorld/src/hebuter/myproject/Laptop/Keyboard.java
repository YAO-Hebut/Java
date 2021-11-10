package hebuter.myproject.Laptop;

public class Keyboard implements Usb {
    @Override
    public void Open() {
        System.out.println("键盘打开");
        System.out.println();
    }

    @Override
    public void Close() {
        System.out.println("键盘关闭");
        System.out.println();
    }

    public void Input() {
        System.out.println("键盘输入");
    }
}
