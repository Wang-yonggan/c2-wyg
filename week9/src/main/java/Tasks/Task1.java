package Tasks;

import java.util.*;

public class Task1 implements Comparator<Map.Entry<Integer, Integer>> {
    public static void print_max10(List<Integer> list) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : list)
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();
        Map.Entry<Integer, Integer> entrys[] = new Map.Entry[hashMap.size()];
        set.toArray(entrys);
        Arrays.sort(entrys, new Task1());
        //core(entity)
        // hashmap-->set-->arr-->sort-->out
        for (int i = 0; i < 10; i++)
            System.out.println(entrys[i].getKey() + ":" + entrys[i].getValue());
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++)//随机1000个数字
            list.add((int) (Math.random() * 750));
        print_max10(list);
    }

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }

}
