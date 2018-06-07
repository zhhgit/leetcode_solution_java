package session3.q114_flatten_binary_tree_to_linked_list;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        TreeNode root = treeBuilder.getRoot();
        flatten(root);
        System.out.println("finish");
    }
    private static void flatten(TreeNode root) {
        if (root != null){
            if (root.left == null){
                flatten(root.right);
            }
            else {
                TreeNode keepRight = root.right;
                TreeNode keepLeft = root.left;
                flatten(keepLeft);
                root.right = keepLeft;
                root.left = null;
                TreeNode curr = root;
                while (curr.right != null){
                    curr = curr.right;
                }
                flatten(keepRight);
                curr.right = keepRight;
            }
        }
    }
}
