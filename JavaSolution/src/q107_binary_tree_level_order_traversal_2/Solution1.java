package q107_binary_tree_level_order_traversal_2;

import common.TreeBuilder;
import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhanghao1 on 2017/11/2.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        TreeBuilder tb = new TreeBuilder(nums);
        List<List<Integer>> lists = levelOrderBottom(tb.getRoot());
        System.out.println(lists);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }
        Stack<List<TreeNode>> stack = new Stack<>();
        LinkedList<TreeNode> tempList = new LinkedList<>();
        tempList.add(root);
        stack.push(tempList);
        recursiveTraversal(root,stack,tempList);
        lists = stackToList(stack);
        return lists;
    }

    private static void recursiveTraversal(TreeNode root,Stack<List<TreeNode>> stack,LinkedList<TreeNode> curr){
        if(curr.size() == 0){
            return;
        }
        LinkedList<TreeNode> currCopy = new LinkedList<>(curr);
        LinkedList<TreeNode> tempList = new LinkedList<>();
        while(currCopy.size()>0){
            TreeNode temp = currCopy.removeFirst();
            if(temp.left != null){
                tempList.add(temp.left);
            }
            if(temp.right != null){
                tempList.add(temp.right);
            }
        }
        if(tempList.size() > 0){
            stack.push(tempList);
            recursiveTraversal(root,stack,tempList);
        }
    }

    private static List<List<Integer>> stackToList(Stack<List<TreeNode>> stack){
        List<List<Integer>> lists = new LinkedList<>();
        while(!stack.isEmpty()){
            List<TreeNode> list = stack.pop();
            lists.add(convertList(list));
        }
        return lists;
    }

    private static List<Integer> convertList(List<TreeNode> list){
        LinkedList<Integer> ret = new LinkedList<>();
        for(int i = 0;i<list.size();i++){
            ret.add(list.get(i).val);
        }
        return ret;
    }
}
