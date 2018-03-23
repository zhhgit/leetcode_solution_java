package session1.q105_construct_binary_tree_from_preorder_and_inorder_traversal;

import session1.common.*;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,5,1,6,3,7};
        TreeNode result = buildTree(preorder,inorder);
        System.out.println("finished");
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0){
            return null;
        }
        else{
            int currVal =  preorder[0];
            int i=0;
            while(inorder[i]!=currVal){
                i++;
            }
            int leftLen = i;
            int rightLen = preorder.length-i-1;
            TreeNode root = new TreeNode(currVal);
            root.left = buildTree(Arrays.copyOfRange(preorder,1,1+leftLen),Arrays.copyOfRange(inorder,0,leftLen));
            root.right = buildTree(Arrays.copyOfRange(preorder,preorder.length-rightLen,preorder.length),Arrays.copyOfRange(inorder,preorder.length-rightLen,preorder.length));
            return root;
        }
    }
}
