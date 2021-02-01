package USB;

public class TestUsb {
    public static void main(String[] args) {
        Mouse mouse=new Mouse();
        KeyBoard keyBoard=new KeyBoard();
        Microphone microphone=new Microphone();
        Computer computer=new Computer();
        computer.add(microphone);
        computer.add(mouse);
        computer.add(keyBoard);
        computer.begin();
        computer.end();
    }
}
