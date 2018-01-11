package q142_linked_list_cycle_2;

import common.ListNode;

public class Solution1 {
    public static void main(String[] args){

    }

    private static ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next != null && fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
