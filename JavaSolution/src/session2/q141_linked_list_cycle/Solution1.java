package session2.q141_linked_list_cycle;

import common.ListBuilder;
import common.ListNode;

/**
 * Created by zhanghao1 on 2017/11/7.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        ListBuilder lb = new ListBuilder(nums);
        System.out.println(hasCycle(lb.getHead()));
    }

    private static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head,fast = head.next;
        while (slow.next != null && fast.next != null && fast.next.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            return true;
        }
        else{
            return false;
        }
    }
}
