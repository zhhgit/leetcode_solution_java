package session1.q021_merge_two_sorted_lists;

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

        int n2 = 9;
        ListNode[] listArray2 = new ListNode[n2];
        for(int i=0;i<listArray2.length ;i++){
            listArray2[i] = new ListNode(i+1);
        }
        int len2  = listArray2.length;
        for(int i=0;i<len2 - 1;i++){
            listArray2[i].next = listArray2[i+1];
        }
        listArray2[len2-1].next = null;

        ListNode temp;
        temp = mergeTwoLists(listArray1[0],listArray2[0]);
        for(int i=0;i<len1+len2-1;i++){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head1,head2;
        head1 = l1;
        head2 = l2;
        ListNode newHead;
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else{
            if(head1.val<=head2.val){
                newHead = head1;
                newHead.next = mergeTwoLists(head1.next,head2);
            }
            else{
                newHead = head2;
                newHead.next = mergeTwoLists(head1,head2.next);
            }
        }
        return newHead;
    }
}
