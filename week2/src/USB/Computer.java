package USB;

import java.util.ArrayList;

public class Computer {
    private ArrayList<UsbImpl> UsbArr =new ArrayList<>();
    private static void print___(){
        System.out.println("-------------");
    }
    public void add(UsbImpl usb){
        UsbArr.add(usb);
    }
    public void begin(){
        for(int i = 0; i< UsbArr.size(); i++)
            UsbArr.get(i).begin();
        System.out.println("电脑开机成功");
        print___();
    }
    public void end(){
        for(int i = 0; i< UsbArr.size(); i++)
            UsbArr.get(i).end();
        System.out.println("电脑关机成功");
        print___();
    }
}
