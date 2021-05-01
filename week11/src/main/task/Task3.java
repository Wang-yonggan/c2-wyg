import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static boolean is_hui(ListNode head){
        List<Integer>list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        Integer nums[]=new Integer[list.size()] ;
        list.toArray(nums);
        for(int i=0;i<nums.length/2;i++)
            if(nums[i]!=nums[nums.length-i-1])
                return false;
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i=1;i<10;i++){
            cur.next=new ListNode(Math.abs(i-5));
            cur=cur.next;
        }
        head=head.next;
        head.print();
        System.out.println(is_hui(head));


        head=head.next;
        System.out.println(is_hui(head));
    }

}
