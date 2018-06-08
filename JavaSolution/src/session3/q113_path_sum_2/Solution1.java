package session3.q113_path_sum_2;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,3};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        int sum = 10;
        System.out.println(pathSum(treeBuilder.getRoot(),sum));
    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null){
            return lists;
        }
        List<TreeNode> tempList = new LinkedList<>();
        backTracking(lists,tempList,sum,0,root);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists, List<TreeNode> tempList,int sum, int tempSum, TreeNode root){
        if (root.right == null && root.left == null){
            if(root.val == sum - tempSum){
                tempList.add(root);
                lists.add(convert(tempList));
                tempList.remove(tempList.size() - 1);
            }
        }
        else {
            if (root.left != null){
                tempList.add(root);
                backTracking(lists,tempList,sum,tempSum + root.val,root.left);
                tempList.remove(tempList.size() - 1);
            }
            if (root.right != null){
                tempList.add(root);
                backTracking(lists,tempList,sum,tempSum + root.val,root.right);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static List<Integer> convert(List<TreeNode> list){
        List<Integer> ret = new LinkedList<>();
        for(TreeNode node:list){
            ret.add(node.val);
        }
        return ret;
    }
}
