package session2.q105_construct_binary_tree_from_preorder_and_inorder_traversal;

import common.PrintUtil;
import common.TreeNode;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] preorder = {1,2,4,5,3,6,7};
        int[] indorder = {4,2,5,1,6,3,7};
        PrintUtil.printTree(buildTree(preorder,indorder));
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i=0;
        while(inorder[i] != root.val){
            i++;
        }
        int leftLen = i;
        int rightLen = inorder.length - 1 - i;
        int[] leftPreorder;
        int[] rightPreorder;
        int[] leftInorder;
        int[] rightInorder;
        leftPreorder = leftLen == 0 ? new int[0] : Arrays.copyOfRange(preorder,1,1 + leftLen);
        rightPreorder = rightLen == 0 ? new int[0] : Arrays.copyOfRange(preorder,1 + leftLen,preorder.length);
        leftInorder = leftLen == 0 ? new int[0] : Arrays.copyOfRange(inorder,0,leftLen);
        rightInorder = rightLen == 0 ? new int[0] : Arrays.copyOfRange(inorder,1 + leftLen,inorder.length);
        root.left = buildTree(leftPreorder,leftInorder);
        root.right = buildTree(rightPreorder,rightInorder);
        return root;
    }
}
