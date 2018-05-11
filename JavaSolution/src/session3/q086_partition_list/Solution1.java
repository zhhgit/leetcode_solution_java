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
        ListNode fakeHeadLeft;
        ListNode fakeHeadRight;
        return new ListNode(0);
    }
}
