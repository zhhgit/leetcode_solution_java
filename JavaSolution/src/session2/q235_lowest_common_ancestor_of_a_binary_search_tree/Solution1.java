package session2.q235_lowest_common_ancestor_of_a_binary_search_tree;

import session2.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else if(root.val == p.val){
            return p;
        }
        else if(root.val == q.val){
            return q;
        }
        else{
            return root;
        }
    }
}
