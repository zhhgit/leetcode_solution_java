package session2.q103_binary_tree_zigzag_level_order_traversal;

import session2.common.TreeBuilder;
import session2.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeBuilder tb = new TreeBuilder(nums);
        System.out.println(zigzagLevelOrder(tb.getRoot()));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }
        Stack<TreeNode> currStack = new Stack<>();
        currStack.push(root);
        boolean flag = true;
        while (currStack.size()!=0){
            Stack<TreeNode> nextStack = new Stack<>();
            List<Integer> addList = new LinkedList<>();
            while(currStack.size()!=0){
                TreeNode currNode = currStack.pop();
                addList.add(currNode.val);
                if(flag){
                    if(currNode.left != null){
                        nextStack.push(currNode.left);
                    }
                    if(currNode.right != null){
                        nextStack.push(currNode.right);
                    }
                }
                else{
                    if(currNode.right != null){
                        nextStack.push(currNode.right);
                    }
                    if(currNode.left != null){
                        nextStack.push(currNode.left);
                    }
                }
            }
            lists.add(addList);
            currStack = nextStack;
            flag = !flag;
        }
        return lists;
    }
}
