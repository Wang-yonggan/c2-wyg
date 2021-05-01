package task;

import java.util.HashMap;

public class Task3 {

    public static boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        int i = 0;
        ListNode cur = head;
        while (cur != null) {
            if (hashMap.get(cur) != null) {
                System.out.println("第" + hashMap.get(cur) + "个");
                return true;
            } else hashMap.put(cur, i++);
            cur = cur.next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        ListNode f = head.next.next;
        ListNode l = head.next;
        while (f != null) {
            if (f == l)
                return true;
            f = f.next.next;

            l = l.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(-1);
        ListNode cur = l;
        ListNode l_temp = new ListNode();
        for (int i = 0; i < 5; i++) {
            if (i == 3)
                l_temp = cur;
            cur.next = new ListNode(i + 2);
            cur = cur.next;
        }
        l.print();
//        l_temp.print();
        cur.next=l_temp;
//        l.print();
        System.out.println(hasCycle(l));
        System.out.println(hasCycle2(l));
    }


}
