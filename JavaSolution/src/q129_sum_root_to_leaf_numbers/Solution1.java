package q129_sum_root_to_leaf_numbers;

import common.TreeBuilder;
import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(sumNumbers(treeBuilder.getRoot()));
    }

    private static int sum = 0;

    private static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<TreeNode> tempList = new LinkedList<>();
        tempList.add(root);
        backTracking(root,tempList);
        return sum;
    }

    private static void backTracking(TreeNode root,List<TreeNode> tempList){
        if(root != null){
            //叶子节点
            if(root.left == null && root.right == null){
                addToSum(tempList);
            }
            //非叶子节点
            else{
                if(root.left != null){
                    tempList.add(root.left);
                    backTracking(root.left,tempList);
                    if(tempList.size() > 0){
                        tempList.remove(tempList.size() -1);
                    }
                }
                if(root.right != null){
                    tempList.add(root.right);
                    backTracking(root.right,tempList);
                    if(tempList.size() > 0){
                        tempList.remove(tempList.size() -1);
                    }
                }
            }
        }
    }

    private static void addToSum(List<TreeNode> list){
        int temp = 0;
        for(TreeNode node:list){
            temp = temp * 10 + node.val;
        }
        sum += temp;
    }
}
