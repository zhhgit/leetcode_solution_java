package session1.q083_remove_duplicates_from_sorted_list;

import java.util.*;
import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int n = 1;
        ListNode temp;
        ListNode[] listArray = new ListNode[n];
        for(int i=0;i<listArray.length ;i++){
            listArray[i] = new ListNode(i+1);
        }
        int len  = listArray.length;
        for(int i=0;i<len - 1;i++){
            listArray[i].next = listArray[i+1];
        }
        listArray[len-1].next = null;
        temp = deleteDuplicates(listArray[0]);
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head){
        HashSet<Integer> hs= new HashSet<Integer>();
        ListNode prev = new ListNode(0);
        ListNode curr = new ListNode(0);
        if(head == null){
            return null;
        }
        else{
            hs.add(head.val);
            prev.next = head;
            curr.next = head.next;
            while(curr.next != null){
                if(hs.contains(curr.next.val)){
                    prev.next.next = curr.next.next;
                    curr.next = curr.next.next;
                }
                else{
                    hs.add(curr.next.val);
                    curr.next = curr.next.next;
                    prev.next = prev.next.next;
                }
            }
            return head;
        }
    }
}
