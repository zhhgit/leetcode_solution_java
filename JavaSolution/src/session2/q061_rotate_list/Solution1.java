package session2.q061_rotate_list;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(rotateRight(listBuilder.getHead(),6));
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        k = getActualK(head,k);
        ListNode fast = head,slow = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }

    private static int getActualK(ListNode head,int k){
        ListNode pointer = head;
        int size = 1;
        while(pointer.next!=null){
            pointer = pointer.next;
            size++;
        }
        return k % (size);
    }
}
