import java.util.Scanner;

public class Game {
    private int v = 100;

    public static void welcome() {
        System.out.println("欢迎来到猜字游戏，请输入一个数");
    }

    public void guess() {
        welcome();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (x != v) {
            if (x > v)
                System.out.println("猜大了噢，再试一次吧！");
            else
                System.out.println("猜的有点小，再试一次吧！");
            x = sc.nextInt();
        }
        System.out.println("恭喜你,猜对了！");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.guess();
    }
}
