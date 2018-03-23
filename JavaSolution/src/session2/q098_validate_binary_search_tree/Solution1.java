package session2.q098_validate_binary_search_tree;

import common.TreeBuilder;
import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        List<TreeNode> list = new LinkedList<>();
        int[][] nums = {{1,0,1}};
        for(int i=0;i<nums.length;i++){
            TreeBuilder lb = new TreeBuilder(nums[i]);
            list.add(lb.getRoot());
        }
        for(int i=0;i<list.size();i++){
            System.out.println(isValidBST(list.get(i)));
        }
    }

    private static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean bool1 = true;
        boolean bool2 = true;
        if(root.left != null){
            if((maxInTree(root.left) >=  root.val) || !isValidBST(root.left)){
                bool1 = false;
            }
        }
        if(root.right != null){
            if((minInTree(root.right) <=  root.val) || !isValidBST(root.right)){
                bool2 = false;
            }
        }
        return bool1 && bool2;
    }

    private static int maxInTree(TreeNode root){
        if(root.right == null){
            return root.val;
        }
        else{
            return maxInTree(root.right);
        }
    }

    private static int minInTree(TreeNode root){
        if(root.left == null){
            return root.val;
        }
        else{
            return minInTree(root.left);
        }
    }
}
