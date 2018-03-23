package session1.q024_swap_nodes_in_pairs;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int n1 = 7;
        ListNode[] listArray1 = new ListNode[n1];
        for(int i=0;i<listArray1.length ;i++){
            listArray1[i] = new ListNode(i+1);
        }
        int len1  = listArray1.length;
        for(int i=0;i<len1 - 1;i++){
            listArray1[i].next = listArray1[i+1];
        }
        listArray1[len1-1].next = null;
        ListNode temp;
        temp = swapPairs(listArray1[0]);
        for(int i=0;i<len1;i++){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode swapPairs(ListNode head){
        ListNode temp = new ListNode(0);
        ListNode newHead;
        if(head == null){
            return null;
        }
        else if(head.next == null){
            return head;
        }
        else{
            temp.next = swapPairs(head.next.next);
            newHead = head.next;
            newHead.next = head;
            head.next = temp.next;
            return newHead;
        }
    }
}
