package session1.q141_linked_list_cycle;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        ListBuilder lb1 = new ListBuilder();
        int[] arr1 = {1,2};
        lb1.createList(arr1);
        ListNode head = lb1.nodeList.get(0);
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        if((head == null) || (head.next == null)){
            return false;
        }
        else{
            ListNode move1=new ListNode(0);
            move1.next = head;
            ListNode move2=new ListNode(0);
            move2.next = head.next;
            while((move1.next != null) && (move2.next!= null)){
                if(move1.next == move2.next){
                    return true;
                }
                else{
                    if(move1.next.next!=null){
                        move1.next = move1.next.next;
                    }
                    else{
                        return false;
                    }
                    if((move2.next.next != null) && (move2.next.next.next != null)){
                        move2.next = move2.next.next.next;
                    }
                    else{
                        return false;
                    }
                }
            }
            return false;
        }
    }
}
