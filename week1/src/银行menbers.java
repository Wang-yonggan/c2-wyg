public class 银行menbers {
    private String name="Null";
    private double rest;
    public 银行menbers(String name, double rest){
        this.name=name;
        this.rest=rest;
    }
    public double get_rest(){
        return rest;
    }
    public static void main(String[] args) {
        银行menbers me =new 银行menbers("wyg",100);
        System.out.println(me.get_rest());
    }
}

