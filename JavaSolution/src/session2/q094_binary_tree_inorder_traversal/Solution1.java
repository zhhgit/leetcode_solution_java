package session2.q094_binary_tree_inorder_traversal;

import common.TreeBuilder;
import common.TreeNode;
import java.util.LinkedList;
import java.util.List;


public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(inorderTraversal(treeBuilder.getRoot()));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        backTracking(root,list);
        return list;
    }

    private static void backTracking(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left != null){
            backTracking(root.left,list);
        }
        list.add(root.val);
        if(root.right != null){
            backTracking(root.right,list);
        }
    }
}
