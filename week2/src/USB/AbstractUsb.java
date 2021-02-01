package USB;

public abstract class AbstractUsb implements UsbImpl {
    private boolean is_begin = false;
    private String NAME;//部件名字，如鼠标

    public void setIsBegin(boolean is_begin) {
        this.is_begin = is_begin;
    }

    public void printState() {
        if (is_begin)
            System.out.println(NAME+"已启动");
        else
            System.out.println(NAME+"已关闭");
    }

    public void setName(String name) {
        this.NAME = name;
    }
}
