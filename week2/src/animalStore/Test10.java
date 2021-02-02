package animalStore;

import java.util.LinkedList;

public class Test10 {
    public static void print___() {
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        Cat cat = new Cat("狗蛋", 10);
        Cat cat1 = new Cat("狗蛋", 5);
        Dog dog = new Dog("大黄", 12);
        Dog dog1 = new Dog("小黄", 14);
        Store store = new Store();
        store.add(cat);
        store.add(cat1);
        store.add(dog);
        store.add(dog1);
        LinkedList<AnimalImpl> animal_temp = store.search("大黄");
        System.out.println(animal_temp);
        print___();
        LinkedList<AnimalImpl> animal_temp1 = store.search("狗蛋");
        System.out.println(animal_temp1);
        print___();
        LinkedList<AnimalImpl> animalLinkedList = store.search(dog);
        System.out.println(animalLinkedList);
        print___();
    }

}