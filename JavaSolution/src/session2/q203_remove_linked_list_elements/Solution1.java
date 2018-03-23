package session2.q203_remove_linked_list_elements;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int val = 1;
        int[] nums = {1,2,3,4,1,3,4};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(removeElements(listBuilder.getHead(),val));
    }

    private static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pointer = fakeHead;
        while(pointer != null && pointer.next != null){
            if(pointer.next.val == val){
                pointer.next = pointer.next.next;
            }
            else{
                pointer = pointer.next;
            }
        }
        return fakeHead.next;
    }
}
