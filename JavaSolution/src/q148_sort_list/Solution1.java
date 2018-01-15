package q148_sort_list;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {3,5,7,1,3,2};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(sortList(listBuilder.getHead()));
    }

    private static ListNode sortList(ListNode head) {
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode curr = head;
        while (curr != null){
            queue.add(curr);
            curr = curr.next;
        }
        ListNode tail = null;
        ListNode newHead = null;
        ListNode ele;
        while (queue.peek() != null){
            ele = queue.poll();
            if(newHead == null){
                newHead = ele;
                tail = newHead;
            }
            else{
                tail.next = ele;
                tail = tail.next;
            }
        }
        if(tail != null){
            tail.next = null;
        }
        return newHead;
    }
}