package session3.q086_partition_list;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,4,3,2,5,2};
        int x = 3;
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printList(partition(listBuilder.getHead(),x));
    }

    private static ListNode partition(ListNode head, int x) {
        ListNode fakeHeadLeft = new ListNode(0);
        ListNode fakeHeadRight = new ListNode(0);
        ListNode left = fakeHeadLeft;
        ListNode right = fakeHeadRight;
        partitionEach(left,right,head,x);
        left = fakeHeadLeft;
        while (left.next!= null){
            left = left.next;
        }
        left.next = fakeHeadRight.next;
        return fakeHeadLeft.next;
    }

    private static void partitionEach(ListNode left,ListNode right,ListNode remain,int x){
        if(remain != null){
            ListNode nextNode = remain.next;
            if(remain.val < x){
                left.next = remain;
                left = left.next;
            }
            else{
                right.next = remain;
                right = right.next;
            }
            partitionEach(left,right,nextNode,x);
        }
        else{
            left.next = null;
            right.next = null;
        }
    }
}
