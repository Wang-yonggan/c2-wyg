
public class Animal {
    private double height;
    private double weight;
    final String kind;//自己的种类（肉或其它）
    final String food;//食物种类
    private String name;
    public boolean live_flag = true;
    private boolean sleep_flag = false;

    public Animal(double height, double weight, String kind, String food, String name) {
        this.height = height;
        this.weight = weight;
        this.kind = kind;
        this.food = food;
        this.name = name;
    }

    public void sleep() {
        sleep_flag = true;
        get_state();
    }

    public void wake() {
        sleep_flag = false;
        get_state();
    }

    public void print___() {
        System.out.println("---------------------------");
    }

    public void get_info() {
        System.out.printf("名字:%s\n", name);
        System.out.printf("体重:%.2fkg\n", weight);
        System.out.printf("身高:%.2fm\n", height);
        if (live_flag)
            System.out.println("生存状态:存活");
        else
            System.out.println("生存状态:死亡");
        get_state();//睡眠状态
    }

    public void get_state() {
        if (sleep_flag)
            System.out.printf("%s现在处于睡眠状态\n", name);
        else
            System.out.printf("%s现在处于清醒状态\n", name);
    }

    public void eat(Animal tar) {
        if (food.equals(tar.kind)) {
            weight += tar.weight;
            System.out.printf("食入成功,%s现在体重为：%.2fkg\n", name, weight);
        } else
            System.out.println("事物种类不匹配,无法食入");
    }
    public void eat(String s, double w) {
        if (food.equals(s)) {
            weight += w;
            System.out.printf("食入成功,%s现在体重为：%.2fkg\n", name, weight);
        } else
            System.out.println("事物种类不匹配,无法食入");
    }


}
