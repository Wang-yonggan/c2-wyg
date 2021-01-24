public class Animal_world {
    public static void main(String[] args) {
        Tiger t=new Tiger(1,100,"meet","meat","tiger1");
        Rabbit r=new Rabbit(0.2,5,"meat","grass","rabbit1");
        t.get_info();
        r.get_info();
        r.sleep();
        r.eat("grass",1);
        r.get_info();
        t.eat(r);
        r.live_flag=false;
        r.get_info();
        t.get_info();
    }
}
