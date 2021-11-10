package hebuter.myproject.Laptop;

public class Mouse implements Usb {
    @Override
    public void Open() {
        System.out.println("鼠标打开");
        System.out.println();
    }

    @Override
    public void Close() {
        System.out.println("鼠标关闭");
        System.out.println();
    }

    public void Click() {
        System.out.println("鼠标点击");
    }
}
