package animalStore;

import java.util.Objects;

public class Dog implements AnimalImpl {
    private String name;
    private int age;

    public Dog(String name, int age) {
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
        return "种类:狗" + "\t" + "名字:" + name + "\t" + "年龄:" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;//是否对象与类的关系
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(name, dog.name);
    }

}
