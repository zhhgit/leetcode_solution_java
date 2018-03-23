package session2.q082_remove_duplicates_from_sorted_list_2;

import session2.common.ListBuilder;
import session2.common.ListNode;
import session2.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,3,4,4,5};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(deleteDuplicates(listBuilder.getHead()));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = head;
        while(curr != null){
            while (curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            //是否相邻是判断上一个while是否有执行，也就是curr这个数字是重复的标志。
            if(prev.next == curr){
                prev = curr;
                curr = curr.next;
            }
            else{
                prev.next = curr.next;
                curr = prev.next;
            }
        }
        return fakeHead.next;
    }
}
