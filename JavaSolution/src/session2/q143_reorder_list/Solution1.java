package session2.q143_reorder_list;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        ListBuilder listBuilder = new ListBuilder(nums);
        reorderList(listBuilder.getHead());
        PrintUtil.printList(listBuilder.getHead());
    }

    private static void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        if(head.next == null){
            return;
        }
        backTracking(head);
    }

    private static ListNode backTracking(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head.next;
        fast = fast.next;
        while(fast.next != null && slow.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = null;
        head.next = fast;
        fast.next = backTracking(temp);
        return head;
    }
}
