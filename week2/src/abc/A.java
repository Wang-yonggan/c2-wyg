package abc;

public abstract class A {
    private int numa = 10;

    public void setNuma(int numa) {
        this.numa = numa;
    }

    public int getNuma() {
        return numa;
    }

    public abstract void showA();
}
