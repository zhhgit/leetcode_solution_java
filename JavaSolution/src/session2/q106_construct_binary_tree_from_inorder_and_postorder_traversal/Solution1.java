package session2.q106_construct_binary_tree_from_inorder_and_postorder_traversal;

import session2.common.PrintUtil;
import session2.common.TreeNode;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] inorder = {4,2,5,1,6,3,7};
        int[] postorder = {4,5,2,6,7,3,1};
        PrintUtil.printTree(buildTree(inorder,postorder));
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        int len = inorder.length;
        TreeNode root = new TreeNode(postorder[len - 1]);
        int i=0;
        while(inorder[i] != root.val){
            i++;
        }
        int leftLen = i;
        int rightLen = inorder.length - 1 - i;
        int[] leftPostorder;
        int[] rightPostorder;
        int[] leftInorder;
        int[] rightInorder;
        leftInorder = leftLen == 0 ? new int[0] : Arrays.copyOfRange(inorder,0,leftLen);
        rightInorder = rightLen == 0 ? new int[0] : Arrays.copyOfRange(inorder,1 + leftLen,inorder.length);
        leftPostorder = leftLen == 0 ? new int[0] : Arrays.copyOfRange(postorder,0,leftLen);
        rightPostorder = rightLen == 0 ? new int[0] : Arrays.copyOfRange(postorder,leftLen,postorder.length - 1);
        root.left = buildTree(leftInorder,leftPostorder);
        root.right = buildTree(rightInorder,rightPostorder);
        return root;
    }
}
