package session2.q147_insertion_sort_list;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {3,1,5,2,4};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(insertionSortList(listBuilder.getHead()));
    }

    private static ListNode newList = null;

    private static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        doSort(head);
        return newList;
    }

    private static void doSort(ListNode oldList){
        if(oldList != null){
            ListNode nextOldList = oldList.next;
            if(newList == null){
                oldList.next = null;
                newList = oldList;
            }
            else{
                if(oldList.val <= newList.val){
                    oldList.next = newList;
                    newList = oldList;
                }
                else{
                    ListNode curr = newList;
                    while (curr.next != null && oldList.val > curr.next.val){
                        curr = curr.next;
                    }
                    ListNode temp = curr.next;
                    curr.next = oldList;
                    oldList.next = temp;
                }
            }
            doSort(nextOldList);
        }
    }
}
