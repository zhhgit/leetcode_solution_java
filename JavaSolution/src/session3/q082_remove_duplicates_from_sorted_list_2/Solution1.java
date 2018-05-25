package session3.q082_remove_duplicates_from_sorted_list_2;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{1,2,3,3,4,4,5},{1,1,1,2,3}};
        for(int i = 0;i<numsArr.length;i++){
            ListBuilder listBuilder = new ListBuilder(numsArr[i]);
            PrintUtil.printList(listBuilder.getHead());
            System.out.println("----------------");
            PrintUtil.printList(deleteDuplicates(listBuilder.getHead()));
            System.out.println("----------------");
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode curr = fakeHead;
        while (curr.next != null){
            ListNode nextNode = curr.next;
            if(nextNode.next != null && nextNode.next.val == nextNode.val){
                while (nextNode.next != null && nextNode.next.val == nextNode.val){
                    nextNode = nextNode.next;
                }
                curr.next = nextNode.next;
            }
            else{
                curr = curr.next;
            }
        }
        return fakeHead.next;
    }
}
