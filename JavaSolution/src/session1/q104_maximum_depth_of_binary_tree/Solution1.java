package session1.q104_maximum_depth_of_binary_tree;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        tb1.createBinTree(arr);
        TreeNode root = tb1.nodeList.get(0);
        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root){
        int ret = 0;
        if(root == null){
            return ret;
        }
        else if((root.left == null) && (root.right == null)){
            ret = 1;
            return ret;
        }
        else{
            ret = 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
            return ret;
        }
    }
}
