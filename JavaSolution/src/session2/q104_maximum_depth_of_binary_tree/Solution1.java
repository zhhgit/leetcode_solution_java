package session2.q104_maximum_depth_of_binary_tree;

import common.*;

/**
 * Created by zhanghao1 on 2017/11/2.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        TreeBuilder tb = new TreeBuilder(nums);
        System.out.println(maxDepth(tb.getRoot()));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
