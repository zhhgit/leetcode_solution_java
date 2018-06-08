package session3.q106_construct_binary_tree_from_inorder_and_postorder_traversal;

import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(inorder,postorder);
        System.out.println("finish");
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (postLen != inLen){
            return null;
        }
        return buildTreeWithRange(inorder,postorder,0,0,postLen);
    }

    private static TreeNode buildTreeWithRange(int[] inorder,int[] postorder,int inStart,int postStart,int len){
        if (len == 0){
            return null;
        }
        if (len == 1){
            return (new TreeNode(inorder[inStart]));
        }
        int rootVal = postorder[postStart + len - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootPos = getRootPosInorder(inorder,inStart,rootVal);
        //只有右子树
        if (rootPos == inStart){
            root.right = buildTreeWithRange(inorder,postorder,inStart + 1,postStart,len -1);
        }
        //只有左子树
        else if(rootPos == inStart + len -1){
            root.left = buildTreeWithRange(inorder,postorder,inStart,postStart,len-1);
        }
        // 都有
        else {
            int leftInStart = inStart;
            int leftLen = rootPos - leftInStart;
            int rightInStart = rootPos + 1;
            int leftPostStart = postStart;
            int rightPostStart = postStart + leftLen;
            int rightLen = len - 1 - leftLen;
            root.left = buildTreeWithRange(inorder,postorder,leftInStart,leftPostStart,leftLen);
            root.right = buildTreeWithRange(inorder,postorder,rightInStart,rightPostStart,rightLen);
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
