package session2.q021_merge_two_sorted_lists;

import session2.common.*;
/**
 * Created by zhanghao1 on 2017/10/24.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {4,5,6,7,8};
        ListBuilder listBuilder1 = new ListBuilder(nums1);
        ListNode head1 = listBuilder1.getHead();
        ListBuilder listBuilder2 = new ListBuilder(nums2);
        ListNode head2 = listBuilder2.getHead();
        ListNode mergeHead = mergeTwoLists(head1,head2);
        while(mergeHead != null){
            System.out.println(mergeHead.val);
            mergeHead = mergeHead.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //特殊情况先考虑
        if(l1 == null && (l2 != null)){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        ListNode preNewHead,curr;
        //新head之前的节点
        preNewHead = new ListNode(0);
        curr = preNewHead;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        //余下部分直接添加
        if(l1 == null){
            curr.next = l2;
        }
        else{
            curr.next = l1;
        }
        return preNewHead.next;
    }
}
