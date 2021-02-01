package USB;

public class Microphone extends AbstractUsb{
    private static final String name="麦克风";

    public Microphone() {
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
