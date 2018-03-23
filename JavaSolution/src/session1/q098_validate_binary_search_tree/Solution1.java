package session1.q098_validate_binary_search_tree;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] nodeArr1 = {1,2,3};
        tb1.createBinTree(nodeArr1);
        TreeNode root1 = tb1.nodeList.get(0);
        System.out.println(isValidBST(root1));
        TreeBuilder tb2 = new TreeBuilder();
        int[] nodeArr2 = {2,1,3};
        tb1.createBinTree(nodeArr2);
        TreeNode root2 = tb1.nodeList.get(0);
        System.out.println(isValidBST(root2));
    }

    private static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        else{
            return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
    }

    private static boolean valid(TreeNode root,long minVal,long maxVal){
        if(root==null){
            return true;
        }
        else if(root.val <= minVal || root.val >= maxVal){
            return false;
        }
        else {
            return (valid(root.left,minVal,root.val) && valid(root.right,root.val,maxVal));
        }
    }
}
