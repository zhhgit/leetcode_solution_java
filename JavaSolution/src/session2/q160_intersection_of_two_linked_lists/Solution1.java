package session2.q160_intersection_of_two_linked_lists;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {5,6,7,8};
        ListBuilder listBuilder1 = new ListBuilder(num1);
        ListBuilder listBuilder2 = new ListBuilder(num2);
        PrintUtil.printList(getIntersectionNode(listBuilder1.getHead(),listBuilder2.getHead()));
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int len1 = getListLen(headA);
        int len2 = getListLen(headB);
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        //补足长度差别
        int gap = Math.abs(len1 - len2);
        for(int i=0;i<gap;i++){
            if(len1 > len2){
                pointerA = pointerA.next;
            }
            else{
                pointerB = pointerB.next;
            }
        }
        //不同向后移动，直到找到同一个
        while(pointerA != null && pointerB != null && pointerA != pointerB){
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA;
    }

    private static int getListLen(ListNode head){
        if(head == null){
            return 0;
        }
        int len1 = 0;
        int i = 0;
        ListNode pointerA = head;
        while(pointerA != null){
            pointerA = pointerA.next;
            i++;
        }
        return i;
    }
}
