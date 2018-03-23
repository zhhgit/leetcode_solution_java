package session2.q019_remove_nth_node_from_end_of_list;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        ListBuilder lb = new ListBuilder(nums);
        int n = 1;
        ListNode newHead = removeNthFromEnd(lb.getHead(),n);
        PrintUtil.printList(newHead);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode fast = new ListNode(0),slow=new ListNode(0);
        fast.next = head;
        slow.next = head;
        for(int i=0;i<n;i++){
            fast.next = fast.next.next;
        }
        //考虑什么时候移除的是head的特殊情况
        if(fast.next == null){
            return head.next;
        }
        else{
            while(fast.next != null && fast.next.next != null){
                fast.next = fast.next.next;
                slow.next = slow.next.next;
            }
            slow.next.next = slow.next.next.next;
            return head;
        }
    }
}
