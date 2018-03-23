package session1.q110_balanced_binary_tree;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] arr = {1,2};
        tb1.createBinTree(arr);
        TreeNode root = tb1.nodeList.get(0);
        System.out.println(isBalanced(root));
    }

    private static int maxDepth(TreeNode root){
        int ret = 0;
        if(root == null){
            return ret;
        }
        else if((root.left == null) && (root.right == null)){
            ret = 1;
            return ret;
        }
        else{
            ret = 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
            return ret;
        }
    }

    private static boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        else if(isBalanced(root.right) && isBalanced(root.left) && (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1)){
            return true;
        }
        else{
            return false;
        }
    }
}
