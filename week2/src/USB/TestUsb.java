package USB;

public class TestUsb {
    public static void main(String[] args) {
        Mouse mouse=new Mouse();
        KeyBoard keyBoard=new KeyBoard();
        Microphone microphone=new Microphone();
        mouse.begin();
        mouse.end();
        keyBoard.begin();
        microphone.begin();
        microphone.end();
    }
}
