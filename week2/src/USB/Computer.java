package USB;

import java.util.ArrayList;

public class Computer {
    private final ArrayList<UsbImpl> UsbArr = new ArrayList<>();
    //final表示UsbArr所含的usb不会被修改，但是UsbArr本身可增删整个的usb
    private static void print___() {
        System.out.println("-------------");
    }

    public void add(UsbImpl usb) {
        UsbArr.add(usb);
    }

    public void begin() {
        for (UsbImpl usb : UsbArr) usb.begin();
        System.out.println("电脑开机成功");
        print___();
    }

    public void end() {
        for (UsbImpl usb : UsbArr) usb.end();
        System.out.println("电脑关机成功");
        print___();
    }
}
