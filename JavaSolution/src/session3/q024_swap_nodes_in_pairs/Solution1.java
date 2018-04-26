package session3.q024_swap_nodes_in_pairs;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(swapPairs(listBuilder.getHead()));
    }

    private static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode nextHead = head.next.next;
        ListNode fakeHead = new ListNode(0);
        ListNode second = head.next;
        fakeHead.next = second;
        second.next = head;
        head.next = swapPairs(nextHead);
        return fakeHead.next;
    }
}
