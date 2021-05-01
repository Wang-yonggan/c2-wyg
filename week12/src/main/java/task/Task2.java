package task;

public class Task2 {
    public static void deleteDuplicates(ListNode l) {
        ListNode cur_node = l;
        ListNode pre_node = l;
        int pre_val = pre_node.val;
        cur_node = cur_node.next;
        while (cur_node != null) {
            //和上一个相同，删除该点,不用更新val
            if (cur_node.val == pre_val) {
                cur_node = cur_node.next;
                pre_node.next = cur_node;
            }
            //和上一个不相同，更新pre,val
            else {
                pre_node = cur_node;
                cur_node = cur_node.next;
                if (cur_node != null)
                    pre_val = pre_node.val;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(-1);
        ListNode cur = l;
        for (int i = 0; i < 10; i++) {
            cur.next = new ListNode(i + (int) (Math.random() * 2));
            cur = cur.next;
        }
        l.print();
        deleteDuplicates(l);
        l.print();
    }

}


