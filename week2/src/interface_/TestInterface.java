package interface_;

public class TestInterface {
    public static void main(String[] args) {
        Star star=new Star();
        star.shine();
        Universe sun=new Sun();
        sun.doAnything();
        Sun sun1=(Sun)sun;//向下
        sun1.shine();
    }
}
