package USB;

public abstract class AbstractUsb implements UsbImpl {
    private boolean is_begin = false;
    private String name;//部件名字，如鼠标

    public void setIsBegin(boolean is_begin) {
        this.is_begin = is_begin;
    }

    public String getName() {
        return name;
    }

    public void printState() {
        if (is_begin)
            System.out.printf("%s现在为启动状态\n", name);
        else
            System.out.printf("%s现在为关闭状态\n", name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
