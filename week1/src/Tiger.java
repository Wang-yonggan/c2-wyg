
public class Tiger extends Animal{
    String anima="tiger";
    public Tiger(double height, double weight, String kind, String food, String name) {
        super(height, weight, kind, food,name);
    }
    public void get_info(){
        print___();
        System.out.printf("它的种类:%s\n",anima);
        super.get_info();
        print___();
    }
}
