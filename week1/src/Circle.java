import java.util.Scanner;

public class Circle {
    private double radius;
    private double pi=3.14;
    public void getArea(){
        System.out.printf("the area is %.2f\n",pi*radius*radius);
    }
    public void getPerimeter(){
        System.out.printf("the perimeter is %.2f\n",pi*radius*2);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Circle circle=new Circle();
        circle.radius=in.nextDouble();
        circle.getArea();
        circle.getPerimeter();
    }
}
