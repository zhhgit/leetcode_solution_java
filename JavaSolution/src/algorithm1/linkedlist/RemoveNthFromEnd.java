package algorithm1.linkedlist;

import algorithm1.common.ListBuilder;
import algorithm1.common.ListNode;
import algorithm1.common.PrintUtil;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        int[][] numsArr = {{1,2,3,4,5},{1},{1,2}};
        int[] posArr = {2,1,1};
        int len = posArr.length;
        for(int i = 0;i < len;i++){
            ListBuilder listBuilder = new ListBuilder(numsArr[i]);
            PrintUtil.printLinkedList(removeNthFromEnd(listBuilder.getHead(),posArr[i]));
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode slow = fakeHead;
        ListNode fast = fakeHead;
        for (int i = 0;i < n; i++){
            fast = fast.next;
        }
        while (slow != null && slow.next != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return fakeHead.next;
    }
}
