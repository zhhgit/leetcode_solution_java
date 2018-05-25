package session3.q098_validate_binary_search_tree;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {5,1,4,2,3,3,6};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(isValidBST(treeBuilder.getRoot()));
    }

    private static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean bool1 = root.left == null || isValidBST(root.left);
        boolean bool2 = root.right == null || isValidBST(root.right);
        boolean bool3 = root.left == null || maxInTree(root.left) < root.val;
        boolean bool4 = root.right == null  || minInTree(root.right) > root.val;
        return bool1 && bool2 && bool3 && bool4;
    }

    private static int maxInTree(TreeNode root){
        int max = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
            max = Math.max(max,curr.val);
        }
        return max;
    }

    private static int minInTree(TreeNode root){
        int min = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
            min = Math.min(min,curr.val);
        }
        return min;
    }
}
