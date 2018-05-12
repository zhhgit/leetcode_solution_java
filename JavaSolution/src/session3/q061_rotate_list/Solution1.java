package session3.q061_rotate_list;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] kArr = {1,2,3,4,5,6};
        for(int i = 0;i<kArr.length;i++){
            int[] nums = {1,2,3,4,5};
            ListBuilder listBuilder = new ListBuilder(nums);
            PrintUtil.printList(rotateRight(listBuilder.getHead(),kArr[i]));
            System.out.println("----------------------");
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = getLen(head);
        int realK = k % len;
        if(realK == 0){
            return head;
        }
        ListNode curr = head;
        for(int i = 0;i<len - 1 - realK;i++){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        curr = newHead;
        for(int i = 0;i<realK - 1;i++){
            curr = curr.next;
        }
        curr.next = head;
        return newHead;
    }

    private static int getLen(ListNode head){
        int i = 0;
        while (head != null){
            head = head.next;
            i++;
        }
        return i;
    }
}
