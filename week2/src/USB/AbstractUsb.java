//package USB;
//public abstract class AbstractUsb implements UsbImpl {
//    private boolean is_begin = false;
//    private final String NAME;//部件名字，如鼠标
//
//    public AbstractUsb(String NAME) {
//        //还可以设置setName函数fun，子类通过fun传递name
//        this.NAME = NAME;
//    }
//
//    public void setIsBegin(boolean is_begin) {
//        this.is_begin = is_begin;
//    }
//
//    public void printState() {
//        if (is_begin)
//            System.out.println(NAME + "已启动");
//        else
//            System.out.println(NAME + "已关闭");
//    }
//
//}
