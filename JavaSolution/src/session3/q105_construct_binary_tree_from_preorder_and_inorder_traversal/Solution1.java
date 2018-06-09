package session3.q105_construct_binary_tree_from_preorder_and_inorder_traversal;

import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
        System.out.println("finish");
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len1 = preorder.length;
        int len2 = inorder.length;
        if (len1 != len2){
            return null;
        }
        return buildTreeWithRange(preorder,inorder,0,0,len1);
    }

    private static TreeNode buildTreeWithRange(int[] preorder,int[] inorder, int preStart,int inStart, int len){
        if (len == 0){
            return null;
        }
        if (len == 1) {
            return (new TreeNode(preorder[preStart]));
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootPos = getRootPosInorder(inorder,inStart,rootVal);
        // 没有左子树
        if (rootPos == inStart){
            root.right = buildTreeWithRange(preorder,inorder,preStart + 1,inStart + 1,len - 1);
        }
        // 没有右子树
        else if(rootPos == inStart + len - 1){
            root.left = buildTreeWithRange(preorder,inorder,preStart + 1,inStart,len - 1);
        }
        // 左右子树都有
        else{
            int leftPreStart = preStart + 1;
            int leftInStart = inStart;
            int leftLen = rootPos - inStart;
            int rightPreStart = leftPreStart + leftLen;
            int rightInStart = rootPos + 1;
            int rightLen = len - 1 - leftLen;
            root.left = buildTreeWithRange(preorder,inorder,leftPreStart,leftInStart,leftLen);
            root.right = buildTreeWithRange(preorder,inorder,rightPreStart,rightInStart,rightLen);
        }
        return root;
    }

    private static int getRootPosInorder(int[] inorder,int inStart,int rootVal){
        int pos = inStart;
        while(inorder[pos] != rootVal){
            pos++;
        }
        return pos;
    }
}
