package session2.q109_convert_sorted_list_to_binary_search_tree;

import common.ListBuilder;
import common.ListNode;
import common.PrintUtil;
import common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-10,-3,0,5,9};
        ListBuilder listBuilder = new ListBuilder(nums);
        PrintUtil.printTree(sortedListToBST(listBuilder.getHead()));
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        int len = getListLength(head);
        return backTracking(head,len);
    }

    private static TreeNode backTracking(ListNode head,int length){
        if(length == 0){
            return null;
        }
        if(length == 1){
            return new TreeNode(head.val);
        }
        ListNode pointer = head;
        int step = (length-1) / 2;
        for(int i=0;i<step;i++){
            pointer = pointer.next;
        }
        TreeNode root = new TreeNode(pointer.val);
        int leftLen = step;
        int rightLen = length - 1 - leftLen;
        root.left = backTracking(head,leftLen);
        root.right = backTracking(pointer.next,rightLen);
        return root;
    }

    private static int getListLength(ListNode head){
        int len = 0;
        ListNode pointer = head;
        while (pointer!= null){
            len++;
            pointer = pointer.next;
        }
        return len;
    }
}
