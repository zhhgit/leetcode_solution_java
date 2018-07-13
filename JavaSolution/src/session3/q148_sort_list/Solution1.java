package session3.q148_sort_list;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-1,5,3,4,0};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(sortList(listBuilder.getHead()));
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (slow.next != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode leftPart = head;
        ListNode rightPart = slow.next;
        slow.next = null;
        return mergeList(sortList(leftPart),sortList(rightPart));
    }

    private static ListNode mergeList(ListNode l1,ListNode l2){
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode curr = fakeHead;
        ListNode currl1 = l1;
        ListNode currl2 = l2;
        while (currl1 != null && currl2 != null){
            if (currl1.val <= currl2.val){
                ListNode keep = currl1.next;
                currl1.next = null;
                curr.next = currl1;
                currl1 = keep;
            }
            else {
                ListNode keep = currl2.next;
                currl2.next = null;
                curr.next = currl2;
                currl2 = keep;
            }
            curr = curr.next;
        }
        if (currl1 != null){
            curr.next = currl1;
        }
        else{
            curr.next = currl2;
        }
        return fakeHead.next;
    }
}
