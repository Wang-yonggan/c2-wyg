package AbstractClass;

public class C extends B {
    private int numc = 30;

    public int getNumc() {
        return numc;
    }

    public void setNumc(int numc) {
        this.numc = numc;
    }

    @Override
    public void showA() {
        //子承父：①通过super.fun(this.a)    ②通过提高a的修饰符可见等级,直接调用this.a,但造成耦合性更高
        System.out.println("A类中numa:" + getNuma());
    }

    @Override
    public void showB() {
        System.out.println("B类中numb:" + getNumb());
    }

    public void showC() {
        System.out.println("C类中numc:" + numc);
    }
}
