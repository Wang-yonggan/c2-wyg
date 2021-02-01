package USB;

public class KeyBoard extends AbstractUsb{
    private static final String name="键盘";
    public KeyBoard() {
        setName(name);
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
