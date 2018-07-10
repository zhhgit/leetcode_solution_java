package session3.q101_symmetric_tree;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

public class Solution1 {

    public static void main(String[] args){
        int[] nums = {1,2,2,3,4,4,1};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(isSymmetric(treeBuilder.getRoot()));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        return compare(root.left,root.right);
    }

    // 两棵树对称
    private static boolean compare(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null){
            return false;
        }
        if (node2 == null){
            return false;
        }
        return (node1.val == node2.val) && compare(node1.left,node2.right) && compare(node1.right,node2.left);
    }
}
