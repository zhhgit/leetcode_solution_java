package session1.q061_rotate_list;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        ListBuilder lb = new ListBuilder();
        lb.createList(arr);
        ListNode head = lb.nodeList.get(0);
        int k = 1;
        ListNode ret = rotateRight(head,k);
        ListNode curr = new ListNode(0);
        curr.next = ret;
        while(curr.next!=null){
            System.out.println(curr.next.val);
            curr.next = curr.next.next;
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        else{
            int len = 0;
            ListNode curr = new ListNode(0);
            curr.next = head;
            while(curr.next!=null){
                curr.next = curr.next.next;
                len++;
            }
            int realk = k%len;
            if(realk==0){
                return head;
            }
            else{
                ListNode ret;
                ListNode left = new ListNode(0);
                left.next = head;
                ListNode right = new ListNode(0);
                right.next = head;
                for(int i=0;i<realk;i++){
                    right.next = right.next.next;
                }
                if(right.next==null){
                    return head;
                }
                else{
                    while(right.next.next!=null){
                        right.next = right.next.next;
                        left.next = left.next.next;
                    }
                    ret = left.next.next;
                    right.next.next = head;
                    left.next.next = null;
                    return ret;
                }
            }
        }
    }
}
