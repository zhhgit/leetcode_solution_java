package session3.q142_linked_list_cycle_2;

import session3.common.ListNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {};
    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow = head;
                while (slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
