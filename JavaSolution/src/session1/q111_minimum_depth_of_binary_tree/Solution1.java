package session1.q111_minimum_depth_of_binary_tree;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] arr = {1,2};
        tb1.createBinTree(arr);
        TreeNode root = tb1.nodeList.get(0);
        System.out.println(minDepth(root));
    }

    private static int minDepth(TreeNode root){
        int ret = 0;
        if(root == null){
            return ret;
        }
        else if((root.left == null) && (root.right == null)){
            ret = 1;
            return ret;
        }
        else if((root.left == null) || (root.right == null)){
            if(root.left == null){
                ret = minDepth(root.right) + 1;
            }
            else if(root.right == null){
                ret = minDepth(root.left) + 1;
            }
            return ret;
        }
        else{
            ret = 1 + Math.min(minDepth(root.left),minDepth(root.right));
            return ret;
        }
    }
}
