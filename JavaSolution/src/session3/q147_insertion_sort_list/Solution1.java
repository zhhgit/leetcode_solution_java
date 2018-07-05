package session3.q147_insertion_sort_list;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {

    public static void main(String[] args){
        int[] nums = {-1,5,3,4,0};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(insertionSortList(listBuilder.getHead()));
    }

    private static ListNode insertionSortList(ListNode head) {
        return sort(null,head);
    }

    private static ListNode sort(ListNode newHead,ListNode oldHead){
        if (oldHead == null){
            return newHead;
        }
        ListNode keep = oldHead.next;
        ListNode node = oldHead;
        node.next = null;
        if (newHead == null || node.val <= newHead.val){
            node.next = newHead;
            return sort(node,keep);
        }
        else {
            ListNode curr = newHead;
            while (curr != null && curr.next != null){
                if (curr.val <= node.val && node.val < curr.next.val){
                    ListNode next = curr.next;
                    curr.next = node;
                    node.next = next;
                    return sort(newHead,keep);
                }
                curr = curr.next;
            }
            if (curr.next == null){
                curr.next = node;
            }
            return sort(newHead,keep);
        }
    }
}
