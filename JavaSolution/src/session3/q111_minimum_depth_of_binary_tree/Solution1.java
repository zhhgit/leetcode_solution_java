package session3.q111_minimum_depth_of_binary_tree;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(minDepth(treeBuilder.getRoot()));
    }

    private static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        else if (root.left == null && root.right == null){
            return 1;
        }
        else if (root.left == null){
            return minDepth(root.right) + 1;
        }
        else if (root.right == null){
            return minDepth(root.left) + 1;
        }
        else {
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        }
    }
}
