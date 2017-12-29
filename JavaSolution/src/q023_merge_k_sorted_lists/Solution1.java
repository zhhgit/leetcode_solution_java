package q023_merge_k_sorted_lists;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {

    public static void main(String[] args){
        int[][] nums = {{2},{4},{2},{2},{3},{8},{2},{}};
        ListNode[] lists = new ListNode[nums.length];
        for(int i = 0;i<nums.length;i++){
            ListBuilder listBuilder = new ListBuilder(nums[i]);
            lists[i] = listBuilder.getHead();
        }
        PrintUtil.printList(mergeKLists(lists));
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        List<ListNode> nodeList = Arrays.asList(lists);
        for(ListNode node : nodeList){
            if(node != null){
                priorityQueue.add(node);
            }
        }
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        while (!priorityQueue.isEmpty()){
            ListNode out = priorityQueue.poll();
            prev.next = out;
            prev = prev.next;
            ListNode temp = out.next;
            if(temp != null){
                priorityQueue.add(temp);
            }
        }
        return fakeHead.next;
    }
}
