package q148_sort_list;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution2 {

    public static void main(String[] args){
        int[] nums = {3,5,7,1,3,2};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(sortList(listBuilder.getHead()));
    }

    private static ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (slow.next != null && fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1,head2);
    }

    //总长度为偶数时，head1与head2一样长；总长度为奇数时，head1比head2长1；
    private static ListNode merge(ListNode head1,ListNode head2){
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode fakeHead = new ListNode(0);
        ListNode curr = fakeHead;
        while (curr1 != null && curr2 != null){
            if(curr1.val <= curr2.val){
                curr.next = curr1;
                curr1 = curr1.next;
            }
            else{
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        if(curr1 == null){
            curr.next = curr2;
        }
        else {
            curr.next = curr1;
        }
        return fakeHead.next;
    }
}
