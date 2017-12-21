package q025_reverse_nodes_in_k_group;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        ListBuilder listBuilder = new ListBuilder(nums);
        int k = 3;
        PrintUtil.printList(reverseKGroup(listBuilder.getHead(),k));
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int total = getListLen(head);
        int group =  total / k;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        for(int i=0;i<group;i++){
            reverseK(getBeforeHead(fakeHead,i,k),k);
        }
        return fakeHead.next;
    }

    private static void reverseK(ListNode beforeHead,int k){
        ListNode curr = beforeHead;
        //找到afterTail
        for(int i=0;i<=k;i++){
            curr = curr.next;
        }
        ListNode afterTail = curr;
        curr = beforeHead.next;
        ListNode prev = afterTail;
        for(int i=0;i<k;i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        beforeHead.next = prev;
    }

    private static int getListLen(ListNode head){
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    private static ListNode getBeforeHead(ListNode fakeHead,int groupNo, int k){
        int move = groupNo * k;
        ListNode curr = fakeHead;
        for(int i=0;i<move;i++){
            curr = curr.next;
        }
        return curr;
    }
}
