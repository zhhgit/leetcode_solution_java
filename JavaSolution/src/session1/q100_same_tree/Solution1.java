package session1.q100_same_tree;

import session1.common.*;

public class Solution1 {

    public static void main(String[] args){
        //建立二叉树1
        TreeBuilder tb1 = new TreeBuilder();
        int[] nodeArr1 = {1,2,3,4,5,6,7,8,9};
        tb1.createBinTree(nodeArr1);
        TreeNode root1 = tb1.nodeList.get(0);
        //建立二叉树2
        TreeBuilder tb2 = new TreeBuilder();
        int[] nodeArr2 = {1,2,3,4,5,6,7,8,9};
        tb2.createBinTree(nodeArr2);
        TreeNode root2 = tb2.nodeList.get(0);
        System.out.println(isSameTree(root1,root2));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q){
        if((p == null) && (q == null)){
            return true;
        }
        else if((p == null) || (q == null)){
            return false;
        }
        else if(p.val != q.val){
            return false;
        }
        else{
            return (isSameTree(p.left,q.left)) && isSameTree(p.right,q.right);
        }
    }
}
