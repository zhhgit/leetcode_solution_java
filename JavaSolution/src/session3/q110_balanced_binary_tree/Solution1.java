package session3.q110_balanced_binary_tree;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(isBalanced(treeBuilder.getRoot()));
    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(getTreeDepth(root.left) - getTreeDepth(root.right)) <= 1);
    }

    private static int getTreeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getTreeDepth(root.left),getTreeDepth(root.right)) + 1;
    }
}
