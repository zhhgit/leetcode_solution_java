package session1.q082_remove_duplicates_from_sorted_list_2;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        ListBuilder lb = new ListBuilder();
        int[] nums = {1,1,2,3,3,4};
        lb.createList(nums);
        ListNode head = lb.nodeList.get(0);
        ListNode result = deleteDuplicates(head);
        ListNode curr = new ListNode(0);
        curr.next = result;
        while(curr.next!=null){
            System.out.println(curr.next.val);
            curr.next = curr.next.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        else{
            ListNode fakeHead = new ListNode(0);
            fakeHead.next = head;
            ListNode prev = fakeHead;
            ListNode curr = head;
            while(curr!=null){
                while(curr.next!=null && curr.next.val == curr.val){
                    curr = curr.next;
                }
                if(prev.next == curr){
                    prev = prev.next;
                }
                else{
                    prev.next = curr.next;
                }
                curr = curr.next;
            }
            return fakeHead.next;
        }
    }
}
