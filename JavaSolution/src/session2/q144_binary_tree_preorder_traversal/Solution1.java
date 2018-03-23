package session2.q144_binary_tree_preorder_traversal;

import session2.common.TreeBuilder;
import session2.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        TreeBuilder listBuilder = new TreeBuilder(nums);
        System.out.println(preorderTraversal(listBuilder.getRoot()));
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return list;
    }
}
