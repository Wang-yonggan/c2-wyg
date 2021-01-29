

public abstract class Animal extends Cell_abstract {
    private static String food_this="meat";//自己的被吃种类，如肉
    private static String big_kind="animal";//大类
    private boolean sleep_flag = true;
    public Animal(double height, double weight, String name) {
        this.height = height;
        this.weight = weight;
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

    public void eat(Cell_abstract cell) {
        cell.die();
    }

    public abstract String get_food();
    @Override
    public boolean is_live() {
        return live_flag;
    }

    @Override
    public void get_x_y() {
        ;
    }

    @Override
    public void reborn() {
        live_flag=true;
    }

    @Override
    public void die() {
        live_flag=false;
    }

    public String get_big_kind() {
        return big_kind;
    }

    public static void main(String[] args) {
        System.out.println("sss");
    }
}
