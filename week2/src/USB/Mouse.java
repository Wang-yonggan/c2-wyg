package USB;

public class Mouse implements UsbImpl {
    private static final String NAME = "鼠标";
    private boolean is_begin = false;

    public void begin() {
        is_begin = true;
        System.out.println(NAME + "已启动");
    }

    public void end() {
        is_begin = false;
        System.out.println(NAME + "已关闭");
    }

}
