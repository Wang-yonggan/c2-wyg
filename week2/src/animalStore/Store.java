package animalStore;

import java.util.HashMap;
import java.util.LinkedList;

public class Store {
    private HashMap<String, LinkedList<AnimalImpl>> animalHashMap = new HashMap<>();

    public void add(AnimalImpl animal) {
        LinkedList<AnimalImpl> animal_link = animalHashMap.get(animal.getName());
        if (animal_link == null) {
            LinkedList<AnimalImpl> animal_linked = new LinkedList<>();
            animal_linked.add(animal);
            animalHashMap.put(animal.getName(), animal_linked);
        } else
            animal_link.add(animal);
        System.out.println("加入成功");
    }

    public void delete(AnimalImpl animal) {
        animalHashMap.remove(animal.getName());
        System.out.println("删除成功");
    }

    public LinkedList<AnimalImpl> search(String name) {
        LinkedList<AnimalImpl> animal_link = animalHashMap.get(name);
        if (animal_link == null) {
            System.out.println("商店没有宠物叫" + name);
        } else {
            System.out.printf("共发现%d只叫%s的宠物:\n", animal_link.size(), name);
            for (AnimalImpl animal : animal_link)
                System.out.println(animal.toString());
        }
        return animal_link;
    }

    public LinkedList<AnimalImpl> search(AnimalImpl o) {
        //找种类和o相同的宠物
        LinkedList<AnimalImpl> animal_link = new LinkedList<>();
        for (LinkedList<AnimalImpl> animal_link_temp : animalHashMap.values()) {
            for (AnimalImpl animal : animal_link_temp) {
                if (animal.toString().split(":")[1].split("名字")[0].equals(o.toString().split(":")[1].split("名字")[0]))
                    animal_link.add(animal);
            }
        }
        System.out.printf("共发现%d只该种类宠物\n", animal_link.size());
        return animal_link;
    }
}
