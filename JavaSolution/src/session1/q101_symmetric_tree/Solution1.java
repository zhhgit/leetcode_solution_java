package session1.q101_symmetric_tree;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] intArr = {1,3,3,4,5,5,4};
        tb1.createBinTree(intArr);
        TreeNode root = tb1.nodeList.get(0);
        System.out.println(isSymmetric(root));
    }

    //比较是否镜像
    private static boolean compare(TreeNode a, TreeNode b){
        if((a == null) && (b == null)){
            return true;
        }
        else if((a == null) || (b == null)){
            return false;
        }
        else{
            return (a.val == b.val) && compare(a.left,b.right) && compare(a.right,b.left);
        }
    }

    private static boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        else {
            return compare(root.left,root.right);
        }
    }
}
