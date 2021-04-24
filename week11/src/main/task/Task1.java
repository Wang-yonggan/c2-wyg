

public class Task1 {
    //设两个标志节点
    public static ListNode reverseList(ListNode head) {
        ListNode temp = null, cur = null;
        while (head != null) {
            temp = head.next;
            head.next = cur;
            cur = head;
            head = temp;
        }
        return cur;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i=2;i<10;i++){
            cur.next=new ListNode(i);
            cur=cur.next;
        }
        head.print();
        ListNode listNode = reverseList(head);
        listNode.print();
    }


}

class ListNode {
    int val;
    ListNode next=null;


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
    public void print(){
        ListNode listNode=this;
        while (listNode != null) {
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
