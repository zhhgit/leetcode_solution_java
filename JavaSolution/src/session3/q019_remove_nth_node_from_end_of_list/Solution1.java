package session3.q019_remove_nth_node_from_end_of_list;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListBuilder lb = new ListBuilder(nums);
        int n = 1;
        PrintUtil.printList(removeNthFromEnd(lb.getHead(),n));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode keep = slow;
        for(int i = 0; i<n;i++){
            fast = fast.next;
        }
        while (fast != null && fast.next != null && slow != null && slow.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return keep.next;
    }
}
