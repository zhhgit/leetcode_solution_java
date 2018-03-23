package session1.q160_intersection_of_two_linked_lists;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        System.out.println("finished");
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        else{
            ListNode point1,point2;
            point1 = headA;
            point2 = headB;
            while(point1!=point2){
                point1 = (point1 == null) ? headB : point1.next;
                point2 = (point2 == null) ? headA : point2.next;
            }
            return point1;
        }
    }
}
