public class Task2 {

    public static ListNode merge_ListNode(ListNode head1, ListNode head2) {
        ListNode result = new ListNode();
        ListNode cur = result;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode cur = head1;
        for (int i = 2; i < 10; i++) {
            cur.next = new ListNode(i * 2 - 6);
            cur = cur.next;
        }
        cur = head2;
        for (int i = 2; i < 10; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        head1.print();
        head2.print();
        ListNode result = merge_ListNode(head1, head2);
        result.print();

    }

}
