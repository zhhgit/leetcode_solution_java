package session2.q111_minimum_depth_of_binary_tree;

import session2.common.TreeBuilder;
import session2.common.TreeNode;

/**
 * Created by zhanghao1 on 2017/11/3.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        TreeBuilder tb = new TreeBuilder(nums);
        System.out.println(minDepth(tb.getRoot()));
    }

    private static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right == null){
            return minDepth(root.left) + 1;
        }
        if(root.right != null && root.left == null){
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
