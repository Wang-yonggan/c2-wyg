package USB;

public class KeyBoard extends AbstractUsb{
    private static final String NAME ="键盘";
    public KeyBoard() {
        setName(NAME);
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
