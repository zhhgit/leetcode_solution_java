package q083_remove_duplicates_from_sorted_list;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

/**
 * Created by zhanghao1 on 2017/11/1.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,1,2,3,4,4,4,5,6,6,6,6,7};
        ListBuilder listBuilder = new ListBuilder(nums);
        ListNode head = listBuilder.getHead();
        ListNode retHead = deleteDuplicates(head);
        PrintUtil.printList(retHead);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = head,curr = head.next;
        while(curr!= null){
            if(curr.val != prev.val){
                prev = curr;
                curr = curr.next;
            }
            else{
                ListNode temp = curr.next;
                prev.next = temp;
                curr = temp;
            }
        }
        return head;
    }
}
