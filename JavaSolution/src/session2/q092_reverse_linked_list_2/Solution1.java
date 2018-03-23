package session2.q092_reverse_linked_list_2;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListBuilder listBuilder = new ListBuilder(nums);
        int m = 2;
        int n = 4;
        PrintUtil.printList(reverseBetween(listBuilder.getHead(),m,n));
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        //找到headPrev
        ListNode curr = fakeHead;
        ListNode headPrev;
        for(int i=0;i< m-1;i++){
            curr = curr.next;
        }
        headPrev = curr;
        //找到tailNext
        curr = fakeHead;
        ListNode tailNext;
        for(int i=0;i<n + 1;i++){
            curr = curr.next;
        }
        tailNext = curr;
        reverseWhole(headPrev.next,n-m+1,headPrev,tailNext);
        return fakeHead.next;
    }

    //反转链表，并与原来前后的节点连接起来
    private static void reverseWhole(ListNode head,int n,ListNode headPrev,ListNode tailNext){
        ListNode curr = head;
        ListNode prev = tailNext;
        ListNode temp;
        for(int i=0;i<n;i++){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        headPrev.next = prev;
    }
}
