package session2.q002_add_two_numbers;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

/**
 * Created by zhanghao1 on 2017/11/7.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {2,9,1};
        ListBuilder lb1 = new ListBuilder(nums1);
        ListBuilder lb2 = new ListBuilder(nums2);
        PrintUtil.printList(addTwoNumbers(lb1.getHead(),lb2.getHead()));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode prevRetHead = new ListNode(0);
        ListNode curr = prevRetHead;
        int carry =0;
        int temp = 0;
        int pointer1Val = 0, pointer2Val = 0;
        while(pointer1 != null || pointer2 != null){
            pointer1Val = pointer1 != null ? pointer1.val : 0;
            pointer2Val = pointer2 != null ? pointer2.val : 0;
            temp = pointer1Val + pointer2Val + carry;
            if(temp < 10){
                carry = 0;
                curr.next = new ListNode(temp);
                curr = curr.next;
            }
            else{
                carry = 1;
                curr.next = new ListNode(temp % 10);
                curr = curr.next;
            }
            if(pointer1 != null){
                pointer1 = pointer1.next;
            }
            if(pointer2 != null){
                pointer2 = pointer2.next;
            }
        }
        if(carry != 0){
            curr.next = new ListNode(1);
        }
        return prevRetHead.next;
    }
}
