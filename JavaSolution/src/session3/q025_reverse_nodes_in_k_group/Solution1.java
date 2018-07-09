package session3.q025_reverse_nodes_in_k_group;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        int[] kArr = {1,2,3,4,5,6};
        for (int k:kArr){
            ListBuilder listBuilder = new ListBuilder(nums);
            PrintUtil.printList(reverseKGroup(listBuilder.getHead(),k));
            System.out.println("-----------------");
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (k == 1){
            return head;
        }
        ListNode curr = head;
        int i = 0;
        while (curr.next != null && i < k-1){
            curr = curr.next;
            i++;
        }
        if (i != k - 1){
            return head;
        }
        ListNode keep = curr.next;
        curr.next = null;
        ListNode newHead = reverse(head);
        curr = newHead;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = reverseKGroup(keep,k);
        return newHead;
    }

    // 翻转链表
    private static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode keep = curr.next;
            curr.next = prev;
            prev = curr;
            curr = keep;
        }
        return prev;
    }
}
