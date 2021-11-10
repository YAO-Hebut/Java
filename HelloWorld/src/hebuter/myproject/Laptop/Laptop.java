package hebuter.myproject.Laptop;

public class Laptop {
    public void powerOn() {
        System.out.println("电脑开机");
        System.out.println();
    }

    public void powerOff() {
        System.out.println("电脑关机");
    }

    public void useDevice(Usb usb) {
        usb.Open();

        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.Click();
            System.out.println();
        } else if (usb instanceof Keyboard) {
            Keyboard keyboard = (Keyboard) usb;
            keyboard.Input();
            System.out.println();
        }

        usb.Close();
    }
}
