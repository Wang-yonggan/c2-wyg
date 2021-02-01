public class HumanMonkey {
    static class Monkey {
        private String name;

        public Monkey(String s) {
            this.name = s;
        }

        public void speak() {
            System.out.println("咿咿呀呀......");
        }

        public String getName() {
            return name;
        }
    }

    static class Human extends Monkey {
        /*
        子类可继承父类的private变量，需要在构造函数中用super传递
        传递后得到的private不能在子类直接用，而需要根据父类的使用方式（fun(this.a)）,调用父类方法来使用这个private
         */
        public Human(String s) {
            super(s);
        }

        public void think() {
            System.out.println("别说话！认真思考！");
        }

        @Override
        public void speak() {
            System.out.println("我叫" + this.getName());
            System.out.println("小样的，不错嘛！会说话了！");
        }
    }

    public static void main(String[] args) {
        Monkey monkey = new Monkey("小黑");
        Human human = new Human("小明");
        monkey.speak();
        human.speak();
    }
}
