package session2.q086_partition_list;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,4,3,2,5,2};
        int x = 3;
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(partition(listBuilder.getHead(),x));
    }

    private static ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode curr = fakeHead;
        ListNode pointer = head;
        while (pointer != null){
            if(pointer.val < x){
                curr.next = new ListNode(pointer.val);
                curr = curr.next;
            }
            pointer = pointer.next;
        }
        pointer = head;
        while (pointer != null){
            if(pointer.val >= x){
                curr.next = new ListNode(pointer.val);
                curr = curr.next;
            }
            pointer = pointer.next;
        }
        return fakeHead.next;
    }
}
