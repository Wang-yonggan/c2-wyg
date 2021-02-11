import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Task2
 * @Author : wang-yonggan
 * @Date: 2021-02-11 23:53
 */

public class Task2 {
    public static void main(String[] args) {
        List<people> peoples = new ArrayList<>();
        peoples.add(new people(1, "Joe", 70000, 3));
        peoples.add(new people(2, "Henry", 80000, 4));
        peoples.add(new people(3, "Sam", 60000, null));
        peoples.add(new people(4, "Max", 90000, null));
        System.out.println();
        for (people p : peoples)
            System.out.println(p);
    }
}

class people {
    private int id, Salary;
    private Integer ManagerId;
    private String name;

    public people(int id, String name, int salary, Integer managerId) {
        this.id = id;
        Salary = salary;
        ManagerId = managerId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "|" + id + "\t|" + name + "\t|" + Salary + "|\t" + ManagerId + "\t|" + "\n";
    }
}
