package interface_;

public class Sun extends Star implements Universe {
    @Override
    public void shine() {
        System.out.println("sun:光照8分钟，到达地球");
    }

    @Override
    public void doAnything() {
        System.out.println("sun:太阳吸引九大行星旋转");
    }
}
