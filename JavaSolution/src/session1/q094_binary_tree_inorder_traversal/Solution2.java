package session1.q094_binary_tree_inorder_traversal;

import session1.common.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] nodeArr1 = {1,2,3,4,5,6,7};
        tb1.createBinTree(nodeArr1);
        TreeNode root1 = tb1.nodeList.get(0);
        System.out.println(inorderTraversal(root1));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || stack.size()!=0){
            while(curr!=null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
