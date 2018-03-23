package session2.q024_swap_nodes_in_pairs;

import session2.common.ListBuilder;
import session2.common.ListNode;
import session2.common.PrintUtil;

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
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;
        second.next = first;
        first.next = swapPairs(third);
        return second;
    }
}
