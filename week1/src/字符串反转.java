import java.util.Scanner;
public class 字符串反转 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String old_str=in.nextLine();
        String new_str="";
        for(int i=old_str.length()-1;i>=0;i--){
            new_str=new_str+old_str.charAt(i);
        }
        System.out.println(new_str);
    }
}