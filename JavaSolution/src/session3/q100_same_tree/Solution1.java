package session3.q100_same_tree;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,2,3,3};
        TreeBuilder treeBuilder1 = new TreeBuilder(nums1);
        TreeBuilder treeBuilder2 = new TreeBuilder(nums2);
        System.out.println(isSameTree(treeBuilder1.getRoot(),treeBuilder2.getRoot()));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        else if(p == null){
            return false;
        }
        else if(q == null){
            return false;
        }
        else{
            return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
