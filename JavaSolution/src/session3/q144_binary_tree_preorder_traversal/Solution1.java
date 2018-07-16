package session3.q144_binary_tree_preorder_traversal;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(preorderTraversal(treeBuilder.getRoot()));
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null){
            return ret;
        }
        ret.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        ret.addAll(left);
        ret.addAll(right);
        return ret;
    }
}
