import java.util.Scanner;
// for-each
// scanner
//
public class 体质IBM {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("输入体重(kg)：");
        int w=in.nextInt();//体重
        System.out.print("输入身高(m)：");
        double h=in.nextDouble();//身高
        double bim=w/h/h;
        if(bim<18.5)
            System.out.println("过轻");
        else
        if(bim<25)
            System.out.println("正常");
        else
        if(bim<28)
            System.out.println("过重");
        else
        if(bim<32)
            System.out.println("肥胖");
        else
            System.out.println("非常肥胖");
    }

}