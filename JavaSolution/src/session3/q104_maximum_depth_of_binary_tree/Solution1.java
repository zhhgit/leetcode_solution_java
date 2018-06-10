package session3.q104_maximum_depth_of_binary_tree;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(maxDepth(treeBuilder.getRoot()));
    }

    private static int maxDepth;

    private static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        maxDepth = 0;
        List<TreeNode> tempList = new LinkedList<>();
        backTracking(tempList,root);
        return maxDepth;
    }

    private static void backTracking(List<TreeNode> tempList, TreeNode curr){
        if (curr.left == null && curr.right == null){
            maxDepth = Math.max(maxDepth,tempList.size() + 1);
        }
        else {
            if (curr.left != null){
                tempList.add(curr);
                backTracking(tempList,curr.left);
                if (tempList.size() > 0){
                    tempList.remove(tempList.size() - 1);
                }
            }
            if (curr.right != null){
                tempList.add(curr);
                backTracking(tempList,curr.right);
                if (tempList.size() > 0){
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
