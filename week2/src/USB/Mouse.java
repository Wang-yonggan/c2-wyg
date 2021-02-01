package USB;

public class Mouse extends AbstractUsb{
    private static final String NAME ="鼠标";
    public Mouse(){
        setName(NAME);//初始化传入名字
    }
    @Override
    public void begin() {
        setIsBegin(true);
        printState();
    }

    @Override
    public void end() {
        setIsBegin(false);
        printState();
    }

}
