package session1.q094_binary_tree_inorder_traversal;

import java.util.*;
import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] nodeArr1 = {1,2,3,4,5,6,7};
        tb1.createBinTree(nodeArr1);
        TreeNode root1 = tb1.nodeList.get(0);
        System.out.println(inorderTraversal(root1));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        backTracking(list,root);
        return list;
    }

    private static void backTracking(List<Integer> list,TreeNode root){
        if(root.left!=null){
            backTracking(list,root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            backTracking(list,root.right);
        }
    }
}
