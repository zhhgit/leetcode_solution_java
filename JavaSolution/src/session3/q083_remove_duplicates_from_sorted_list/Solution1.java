package session3.q083_remove_duplicates_from_sorted_list;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

import java.util.HashSet;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3,4,4};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(deleteDuplicates(listBuilder.getHead()));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode curr = fakeHead;
        while (curr != null && curr.next != null){
            ListNode nextNode = curr.next;
            if(!hashSet.contains(nextNode.val)){
                hashSet.add(nextNode.val);
                curr = curr.next;
            }
            else{
                curr.next = curr.next.next;
            }
        }
        return fakeHead.next;
    }
}
