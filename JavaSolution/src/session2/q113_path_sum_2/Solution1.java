package session2.q113_path_sum_2;

import common.TreeBuilder;
import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int sum = 8;
        int[] nums = {1,2,3,4,5,6,7};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(pathSum(treeBuilder.getRoot(),sum));
    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        tempList.add(root.val);
        backTracking(lists,root,sum - root.val,tempList);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,TreeNode root,int remain,List<Integer> tempList){
        //是叶子节点了
        if(root != null && root.left == null && root.right == null){
            if(remain == 0){
                List<Integer> addList = new LinkedList<>(tempList);
                lists.add(addList);
            }
            else{
                return;
            }
        }
        //不是叶子节点
        else{
            if(root.left != null){
                tempList.add(root.left.val);
                backTracking(lists,root.left,remain - root.left.val,tempList);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size() -1);
                }
            }
            if(root.right != null){
                tempList.add(root.right.val);
                backTracking(lists,root.right,remain - root.right.val,tempList);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size() -1);
                }
            }
        }
    }
}
