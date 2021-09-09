package algorithm1.tree;

import algorithm1.common.PrintUtil;
import algorithm1.common.TreeBuilder;
import algorithm1.common.TreeNode;

public class MaxDepth {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        TreeNode root = treeBuilder.getRoot();
        PrintUtil.printTree(root);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int sonDepth = Math.max(maxDepth(root.left), maxDepth(root.right));
        return sonDepth + 1;
    }
}
