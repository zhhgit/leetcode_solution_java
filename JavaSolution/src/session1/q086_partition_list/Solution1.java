package session1.q086_partition_list;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,4,3,2,5,2};
        int x = 3;
        ListBuilder lb = new ListBuilder();
        lb.createList(nums);
        ListNode head = lb.nodeList.get(0);
        ListNode result = partition(head,x);
        ListNode curr = new ListNode(0);
        curr.next = result;
        while(curr.next!=null){
            System.out.println(curr.next.val);
            curr.next = curr.next.next;
        }
    }

    private static ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        else{
            ListNode lessHead = new ListNode(0);
            ListNode lessPrev = lessHead;
            ListNode moreHead = new ListNode(0);
            ListNode morePrev = moreHead;
            ListNode curr = new ListNode(0);
            curr.next = head;
            while(curr.next!=null){
                if(curr.next.val<x){
                    lessPrev.next = new ListNode(curr.next.val);
                    lessPrev = lessPrev.next;
                }
                else{
                    morePrev.next = new ListNode(curr.next.val);
                    morePrev = morePrev.next;
                }
                curr.next = curr.next.next;
            }
            lessPrev.next = moreHead.next;
            return lessHead.next;
        }
    }
}
