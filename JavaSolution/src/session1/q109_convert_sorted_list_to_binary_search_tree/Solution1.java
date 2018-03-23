package session1.q109_convert_sorted_list_to_binary_search_tree;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        ListBuilder lb = new ListBuilder();
        lb.createList(nums);
        ListNode head = lb.nodeList.get(0);
        TreeNode root = sortedListToBST(head);
        System.out.println("finish");
    }

    //依次取list中的值
    private static ListNode node;

    private static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        int size = 0;
        ListNode runner = head;
        node = head;
        while(runner != null){
            runner = runner.next;
            size ++;
        }
        return buildTree(0, size - 1);
    }

    private static TreeNode buildTree(int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = buildTree(start, mid - 1);
        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;
        treenode.right = buildTree(mid + 1, end);
        return treenode;
    }
}
