package session1.q114_flatten_binary_tree_to_linked_list;

import java.util.*;
import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,2,5,3,4,6,7};
        TreeBuilder tb = new TreeBuilder();
        tb.createBinTree(arr);
        TreeNode root = tb.nodeList.get(0);
        flatten(root);
        System.out.println("finished");
    }

    private static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        else{
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev,curr;
            stack.push(root);
            prev = root;
            while(stack.size()!=0){
                curr = stack.pop();
                if(prev!=curr){
                    prev.right = curr;
                    prev.left = null;
                }
                if(curr.right!=null){
                    stack.push(curr.right);
                }
                if(curr.left!=null){
                    stack.push(curr.left);
                }
                prev = curr;
            }
        }
    }
}
