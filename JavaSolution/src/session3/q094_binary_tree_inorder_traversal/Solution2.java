package session3.q094_binary_tree_inorder_traversal;

import session3.common.PrintUtil;
import session3.common.TreeBuilder;
import session3.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        PrintUtil.printTree(treeBuilder.getRoot());
        System.out.println("----------------------");
        System.out.println(inorderTraversal(treeBuilder.getRoot()));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || stack.size() != 0){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode tempNode = stack.pop();
            list.add(tempNode.val);
            curr = tempNode.right;
        }
        return list;
    }
}
