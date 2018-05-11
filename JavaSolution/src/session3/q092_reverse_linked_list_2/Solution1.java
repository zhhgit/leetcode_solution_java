package session3.q092_reverse_linked_list_2;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListBuilder listBuilder = new ListBuilder(nums);
        int m = 2;
        int n = 2;
        PrintUtil.printList(reverseBetween(listBuilder.getHead(),m,n));
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode curr = fakeHead;
        for(int i = 0;i<m-1;i++){
            curr = curr.next;
        }
        ListNode beforeHead = curr;
        curr = fakeHead;
        for(int i = 0;i<n+1;i++){
            curr = curr.next;
        }
        ListNode afterTail = curr;
        beforeHead.next = reverseAll(beforeHead.next,n - m + 1);
        curr = fakeHead;
        while (curr.next!= null){
            curr = curr.next;
        }
        curr.next = afterTail;
        return fakeHead.next;
    }

    private static ListNode reverseAll(ListNode head,int num){
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 0;i<num;i++){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
