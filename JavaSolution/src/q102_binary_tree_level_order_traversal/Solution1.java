package q102_binary_tree_level_order_traversal;

import common.TreeBuilder;
import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1 {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeBuilder tb = new TreeBuilder(nums);
        System.out.println(levelOrder(tb.getRoot()));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }
        List<TreeNode> currList = new LinkedList<>();
        currList.add(root);
        while (currList.size() != 0){
            List<TreeNode> nextList = new LinkedList<>();
            List<Integer> addList = new LinkedList<>();
            for(int i=0;i<currList.size();i++){
                TreeNode currNode = currList.get(i);
                addList.add(currNode.val);
                if(currNode.left != null){
                    nextList.add(currNode.left);
                }
                if(currNode.right != null){
                    nextList.add(currNode.right);
                }
            }
            lists.add(addList);
            currList = nextList;
        }
        return lists;
    }
}
