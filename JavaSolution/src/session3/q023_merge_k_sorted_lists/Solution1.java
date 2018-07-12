package session3.q023_merge_k_sorted_lists;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{1,4,5},{1,3,4},{2,6}};
        int len = numsArr.length;
        ListNode[] lists = new ListNode[len];
        for (int i = 0;i<len;i++){
            ListBuilder listBuilder = new ListBuilder(numsArr[i]);
            lists[i] = listBuilder.getHead();
        }
        PrintUtil.printList(mergeKLists(lists));
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode fakeHead = new ListNode(0);
        backTracking(lists,fakeHead);
        return fakeHead.next;
    }

    private static void backTracking(ListNode[] lists,ListNode curr){
        if (!allEmpty(lists)){
            ListNode minNode = null;
            int minIndex = -1;
            for (int i = 0;i<lists.length;i++){
                if (lists[i] != null){
                    if (minNode == null){
                        minNode = lists[i];
                        minIndex = i;
                    }
                    else{
                        minIndex = lists[i].val < minNode.val ? i : minIndex;
                        minNode = lists[i].val < minNode.val  ? lists[i] : minNode;
                    }
                }
            }
            ListNode keep = minNode.next;
            lists[minIndex] = keep;
            minNode.next = null;
            curr.next = minNode;
            backTracking(lists,curr.next);
        }
    }

    private static boolean allEmpty(ListNode[] lists){
        for (int i = 0;i<lists.length;i++){
            if (lists[i] != null){
                return false;
            }
        }
        return true;
    }
}
