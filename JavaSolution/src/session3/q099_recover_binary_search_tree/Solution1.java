package session3.q099_recover_binary_search_tree;

import session3.common.PrintUtil;
import session3.common.TreeBuilder;
import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        TreeNode root = treeBuilder.getRoot();
        recoverTree(root);
        PrintUtil.printTree(root);
    }

    private static TreeNode firstElement = null;
    private static TreeNode secondElement = null;
    private static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    private static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private static void traverse(TreeNode root) {
        if (root == null){
            return;
        }
        traverse(root.left);
        // firstElement是prev.val > root.val时的prev
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        // secondElement是firstElement不为null时，prev.val > root.val时的root.val，root也就是当前
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        // 遍历完当前节点，所以prev = root
        prevElement = root;
        traverse(root.right);
    }
}
