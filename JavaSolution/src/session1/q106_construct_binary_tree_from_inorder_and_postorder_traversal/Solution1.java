package session1.q106_construct_binary_tree_from_inorder_and_postorder_traversal;

import session1.common.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] inorder = {4,2,5,1,6,3,7};
        int[] postorder = {4,5,2,6,7,3,1};
        TreeNode result = buildTree(inorder,postorder);
        System.out.println("finished");
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0 || inorder.length==0){
            return null;
        }
        else{
            int currVal =  postorder[postorder.length-1];
            int i=0;
            while(inorder[i]!=currVal){
                i++;
            }
            int leftLen = i;
            int rightLen = inorder.length-i-1;
            TreeNode root = new TreeNode(currVal);
            root.left = buildTree(Arrays.copyOfRange(inorder,0,leftLen),Arrays.copyOfRange(postorder,0,leftLen));
            root.right = buildTree(Arrays.copyOfRange(inorder,inorder.length-rightLen,inorder.length),Arrays.copyOfRange(postorder,postorder.length-rightLen-1,postorder.length-1));
            return root;
        }
    }
}
