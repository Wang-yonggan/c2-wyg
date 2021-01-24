public class Rabbit extends Animal{
    String anima="rabbit";
    public Rabbit(double height, double weight, String kind, String food, String name) {
        super(height, weight, kind, food, name);
    }
    public void get_info(){
        print___();
        System.out.printf("它的种类是:%s\n",anima);
        super.get_info();
        print___();
    }
}
