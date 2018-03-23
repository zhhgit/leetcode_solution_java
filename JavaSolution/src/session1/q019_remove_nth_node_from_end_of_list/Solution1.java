package session1.q019_remove_nth_node_from_end_of_list;

import session1.common.*;

public class Solution1 {
    public static  void main(String[] args){
        int n = 7;
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
        temp = removeNthFromEnd(listArray[0],2);
        for(int i=0;i<len - 1;i++){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
