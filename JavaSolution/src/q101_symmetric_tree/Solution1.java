package q101_symmetric_tree;

import common.TreeBuilder;
import common.TreeNode;

/**
 * Created by zhanghao1 on 2017/11/2.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,2,3,4,4,3};
        TreeBuilder tb = new TreeBuilder(nums);
        System.out.println(isSymmetric(tb.getRoot()));
    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isOppositeTree(root.left,root.right);
    }

    private static boolean isOppositeTree(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left != null && right == null){
            return false;
        }
        if(right != null && left == null){
            return false;
        }
        return (left.val == right.val) && isOppositeTree(left.left,right.right) && isOppositeTree(left.right,right.left);
    }
}
