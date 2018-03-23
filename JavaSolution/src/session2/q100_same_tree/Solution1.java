package session2.q100_same_tree;

import session2.common.TreeBuilder;
import session2.common.TreeNode;

/**
 * Created by zhanghao1 on 2017/11/2.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2,3,4,5,6};
        TreeBuilder tb1 = new TreeBuilder(nums1);
        TreeBuilder tb2 = new TreeBuilder(nums2);
        System.out.println(isSameTree(tb1.getRoot(),tb2.getRoot()));
    }
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        else if(p == null && q != null){
            return false;
        }
        else if(q == null && p != null){
            return false;
        }
        else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right) && (p.val == q.val);
        }
    }
}
