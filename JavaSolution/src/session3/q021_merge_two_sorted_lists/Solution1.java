package session3.q021_merge_two_sorted_lists;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = {1,3,5};
        int[] nums2 = {0};
        ListBuilder listBuilder1 = new ListBuilder(nums1);
        ListBuilder listBuilder2 = new ListBuilder(nums2);
        PrintUtil.printList(mergeTwoLists(listBuilder1.getHead(),listBuilder2.getHead()));
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            ListNode nextNode = l1.next;
            l1.next = mergeTwoLists(nextNode,l2);
            return l1;
        }
        else {
            ListNode nextNode = l2.next;
            l2.next = mergeTwoLists(l1,nextNode);
            return l2;
        }
    }
}
