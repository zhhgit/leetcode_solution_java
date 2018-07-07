package session3.q143_reorder_list;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {

    public static void main(String[] args){
        int[][] numsArr = {{1,2,3,4},{1,2,3,4,5}};
        for (int[] nums:numsArr){
            ListBuilder listBuilder = new ListBuilder(nums);
            ListNode head = listBuilder.getHead();
            reorderList(head);
            PrintUtil.printList(head);
        }
    }

    // 找到分界点，翻转后一半，再merge
    private static void reorderList(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode fast = head;
            ListNode slow = head;
            while (slow.next != null && fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode head2 = slow.next;
            slow.next = null;
            head2 = reverse(head2);
            merge(head,head2);
        }
    }


    // merge两个链表
    private static ListNode merge(ListNode head1,ListNode head2){
        if (head2 != null){
            ListNode curr1 = head1;
            ListNode curr2 = head2;
            if (curr1 != null && curr2 != null){
                ListNode keep1 = curr1.next;
                ListNode keep2 = curr2.next;
                curr1.next = curr2;
                curr2.next = merge(keep1,keep2);
            }
        }
        return head1;
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
