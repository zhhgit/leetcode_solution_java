package session2.q110_balanced_binary_tree;

import common.TreeBuilder;
import common.TreeNode;

/**
 * Created by zhanghao1 on 2017/11/3.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        TreeBuilder tb = new TreeBuilder(nums);
        System.out.println(isBalanced(tb.getRoot()));
    }

    private static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        if(Math.abs(leftHeight -rightHeight) > 1){
            return false;
        }
        if(!isBalanced(root.left)){
            return false;
        }
        if(!isBalanced(root.right)){
            return false;
        }
        return true;
    }

    private static int getTreeHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(getTreeHeight(root.left),getTreeHeight(root.right));
    }
}
