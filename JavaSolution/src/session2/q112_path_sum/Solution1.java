package session2.q112_path_sum;

import session2.common.TreeBuilder;
import session2.common.TreeNode;

/**
 * Created by zhanghao1 on 2017/11/6.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeBuilder tb = new TreeBuilder(nums);
        int sum = 15;
        System.out.println(hasPathSum(tb.getRoot(),sum));
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.val == sum && root.left == null && root.right ==null){
            return true;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
