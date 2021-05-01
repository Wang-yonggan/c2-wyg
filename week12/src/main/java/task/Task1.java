package task;

public class Task1 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode start = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        while (l1 != null) {
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }
        while (l2 != null) {
            res.next = l2;
            l2 = l2.next;
            res = res.next;
        }
        return start.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l1_ = l1;
        ListNode l2_ = l2;
        for (int i = 1; i < 5; i++) {
            l1_.next = new ListNode(i * 3);
            l1_ = l1_.next;
            l2_.next = new ListNode(i + 5);
            l2_ = l2_.next;

        }
        l1.print();
        l2.print();
        mergeTwoLists(l1, l2).print();
    }

}

class ListNode {
    int val;
    ListNode next;//会默认null还是0？

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public void print() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println();
    }
}