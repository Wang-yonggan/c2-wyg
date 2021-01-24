import java.util.Scanner;

public class Complex_num {
    private double int_;
    private double virtual;
    public Complex_num(double int_,double virtual){
        this.int_=int_;
        this.virtual=virtual;
    }
    public void add(Complex_num b){
        int_+= b.int_;
        virtual+= b.virtual;
        System.out.printf("两个复数相加的结果：%f+%fi\n",int_,virtual);
    }
    public void reduce(Complex_num b){
        this.int_-=b.int_;
        this.virtual-=b.virtual;
        System.out.printf("两个复数相减的结果：%f+%fi\n",int_,virtual);
    }
    public void multiply(Complex_num b){
        double tmep=int_;
        int_=b.int_*int_-b.virtual*virtual;
        virtual=tmep*b.virtual+b.int_*virtual;
        System.out.printf("两个复数相乘的结果：%f+%fi\n",int_,virtual);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double int_1,virtual1,int_2,virtual2;
        int_1=in.nextDouble();
        virtual1=in.nextDouble();
        int_2=in.nextDouble();
        virtual2=in.nextDouble();
        for(int i=0;i<3;i++) {
            Complex_num a = new Complex_num(int_1,virtual1);
            Complex_num b = new Complex_num(int_2,virtual2);
            switch (i){
                case 0:
                    a.add(b);
                    break;
                case 1:
                    a.reduce(b);
                    break;
                case 2:
                    a.multiply(b);
                    break;
            }
        }
    }
}
