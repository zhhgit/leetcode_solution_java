package session1.q109_convert_sorted_list_to_binary_search_tree;

import session1.common.*;

public class Solution2 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        ListBuilder lb = new ListBuilder();
        lb.createList(nums);
        ListNode head = lb.nodeList.get(0);
        TreeNode root = sortedListToBST(head);
        System.out.println("finish");
    }

    private static TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private static TreeNode buildTree(ListNode start, ListNode end) {
        if (start == null || start == end){
            return null;
        }
        ListNode fast = start;
        ListNode slow = start;
        while (fast.next != end && fast.next.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(start, slow);
        root.right = buildTree(slow.next, end);
        return root;
    }
}
