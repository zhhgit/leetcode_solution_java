package session3.q144_binary_tree_preorder_traversal;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
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
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() > 0){
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return ret;
    }
}
