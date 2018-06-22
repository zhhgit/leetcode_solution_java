package session3.q129_sum_root_to_leaf_numbers;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(sumNumbers(treeBuilder.getRoot()));
    }

    private static int sum;

    private static int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return root.val;
        }
        sum = 0;
        List<Integer> tempList = new LinkedList<>();
        backTracking(tempList,root);
        return sum;
    }

    private static void backTracking(List<Integer> tempList,TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            tempList.add(root.val);
            sum += getNum(tempList);
            if (tempList.size() > 0){
                tempList.remove(tempList.size() - 1);
            }
        }
        else {
            if (root.left != null){
                tempList.add(root.val);
                backTracking(tempList,root.left);
                if (tempList.size() > 0){
                    tempList.remove(tempList.size() - 1);
                }
            }
            if (root.right != null){
                tempList.add(root.val);
                backTracking(tempList,root.right);
                if (tempList.size() > 0){
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private static int getNum(List<Integer> tempList){
        int size = tempList.size();
        int sum = 0;
        for(int i = 0;i < size;i++){
            sum = sum * 10 + tempList.get(i);
        }
        return sum;
    }
}
