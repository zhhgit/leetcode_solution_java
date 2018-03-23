package session1.q002_add_two_numbers;

import session1.common.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        ListBuilder lb1 = new ListBuilder();
        int[] arr1 = {1};
        lb1.createList(arr1);
        ListNode l1 = lb1.nodeList.get(0);

        ListBuilder lb2 = new ListBuilder();
        int[] arr2 = {9,9};
        lb1.createList(arr2);
        ListNode l2 = lb1.nodeList.get(0);

        ListNode result = addTwoNumbers(l1,l2);
        ListNode curr = new ListNode(0);
        curr.next = result;
        while(curr.next!=null) {
            System.out.println(curr.next.val);
            curr.next = curr.next.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = new ListNode(0);
        curr1.next = l1;
        ListNode curr2 = new ListNode(0);
        curr2.next = l2;
        int increase = 0;
        ArrayList<ListNode> al = new ArrayList<ListNode>();
        while((curr1.next!=null) && (curr2.next!=null)){
            int sum = curr1.next.val + curr2.next.val + increase;
            if(sum/10==1){
                sum = sum%10;
                increase = 1;
            }
            else{
                increase = 0;
            }
            al.add(new ListNode(sum));
            curr1.next = curr1.next.next;
            curr2.next = curr2.next.next;
        }
        if((curr1.next == null) && (curr2.next != null)){
            while(curr2.next != null){
                int sum = curr2.next.val + increase;
                if(sum/10==1){
                    sum = sum%10;
                    increase = 1;
                }
                else{
                    increase = 0;
                }
                al.add(new ListNode(sum));
                curr2.next = curr2.next.next;
            }
            if(increase == 1){
                al.add(new ListNode(increase));
            }
        }
        else if((curr1.next != null) && (curr2.next == null)){
            while(curr1.next != null){
                int sum = curr1.next.val + increase;
                if(sum/10==1){
                    sum = sum%10;
                    increase = 1;
                }
                else{
                    increase = 0;
                }
                al.add(new ListNode(sum));
                curr1.next = curr1.next.next;
            }
            if(increase == 1){
                al.add(new ListNode(increase));
            }
        }
        else if((curr1.next == null) && (curr2.next == null)){
            if(increase == 1){
                al.add(new ListNode(increase));
            }
        }
        int len = al.size();
        for(int i=0; i<len-1; i++){
            al.get(i).next = al.get(i+1);
        }
        al.get(len-1).next = null;
        return al.get(0);
    }
}
