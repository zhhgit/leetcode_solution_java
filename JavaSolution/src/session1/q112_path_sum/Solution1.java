package session1.q112_path_sum;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        tb1.createBinTree(arr);
        TreeNode root = tb1.nodeList.get(0);
        System.out.println(hasPathSum(root,10));
    }

    private static boolean hasPathSum(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        else if((root.left == null) && (root.right == null)){
            if(sum == root.val){
                return true;
            }
            else{
                return false;
            }
        }
        else if(hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val)){
            return true;
        }
        else{
            return false;
        }
    }
}
