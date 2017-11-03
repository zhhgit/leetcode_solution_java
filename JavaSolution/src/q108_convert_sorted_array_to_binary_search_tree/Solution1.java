package q108_convert_sorted_array_to_binary_search_tree;

import common.PrintUtil;
import common.TreeBuilder;
import common.TreeNode;

/**
 * Created by zhanghao1 on 2017/11/2.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        TreeNode root = sortedArrayToBST(nums);
        PrintUtil.printTree(root);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return buildBSTWithRange(nums,0,nums.length -1);
    }

    private static TreeNode buildBSTWithRange(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBSTWithRange(nums,start,mid -1);
        root.right = buildBSTWithRange(nums,mid + 1,end);
        return root;
    }
}
