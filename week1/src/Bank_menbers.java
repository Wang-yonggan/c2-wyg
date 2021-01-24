public class Bank_menbers {
    public String name = "Null";
    public double rest;

    public Bank_menbers(String name, double rest) {
        this.name = name;
        this.rest = rest;
    }

    public double get_rest() {
        return rest;
    }

    public static void main(String[] args) {
        Bank_menbers me = new Bank_menbers("wyg", 100);
        System.out.println(me.get_rest());
    }
}

