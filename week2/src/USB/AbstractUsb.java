package USB;

public abstract class AbstractUsb implements UsbImpl {
    private boolean is_begin = false;
    private String NAME;//部件名字，如鼠标

    public void setIsBegin(boolean is_begin) {
        this.is_begin = is_begin;
    }

    public String getName() {
        return NAME;
    }

    public void printState() {
        if (is_begin)
            System.out.printf("%s已启动\n", NAME);
        else
            System.out.printf("%s已关闭\n", NAME);
    }

    public void setName(String name) {
        this.NAME = name;
    }
}
