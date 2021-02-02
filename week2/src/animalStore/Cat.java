package animalStore;

import java.util.Objects;

public class Cat implements AnimalImpl {
    //可以接口加抽象:都符合接口的规则，有都是动物
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "种类:猫" + "\t" + "名字:" + name + "\t" + "年龄:" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;//是否对象与类的关系
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }

}
