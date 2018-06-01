package session3.q109_convert_sorted_list_to_binary_search_tree;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-10,-3,0,5,9};
        ListBuilder listBuilder = new ListBuilder(nums);
        TreeNode root = sortedListToBST(listBuilder.getHead());
        System.out.println("finish");
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return (new TreeNode(head.val));
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(slow == head){
            root.right = sortedListToBST(slow.next);
        }
        else {
            ListNode prev = new ListNode(0);
            prev.next = head;
            while (prev.next != slow){
                prev = prev.next;
            }
            prev.next = null;
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);
        }
        return root;
    }
}
