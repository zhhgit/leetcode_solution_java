package session2.q226_invert_binary_tree;

import common.PrintUtil;
import common.TreeBuilder;
import common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        PrintUtil.printTree(treeBuilder.getRoot());
        System.out.println("-----------------------");
        PrintUtil.printTree(invertTree(treeBuilder.getRoot()));
    }

    private static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        root.left = invertTree(tempRight);
        root.right = invertTree(tempLeft);
        return root;
    }
}