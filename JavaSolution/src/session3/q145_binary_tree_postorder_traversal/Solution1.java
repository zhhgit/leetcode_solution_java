package session3.q145_binary_tree_postorder_traversal;

import session3.common.TreeBuilder;
import session3.common.TreeNode;
import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        TreeNode root = treeBuilder.getRoot();
        System.out.println(postorderTraversal(root));
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        stack.push(root);
        while (stack.size() > 0){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
