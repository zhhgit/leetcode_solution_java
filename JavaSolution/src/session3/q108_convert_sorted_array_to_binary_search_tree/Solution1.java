package session3.q108_convert_sorted_array_to_binary_search_tree;

import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println("finish");
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return null;
        }
        if (len == 1){
            return (new TreeNode(nums[0]));
        }
        return buildWithRange(nums,0,len - 1);
    }

    private static TreeNode buildWithRange(int[] nums,int start,int end){
        if (start == end){
            return (new TreeNode(nums[start]));
        }
        else if (start > end){
            return null;
        }
        else {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildWithRange(nums,start,mid - 1);
            root.right = buildWithRange(nums,mid + 1,end);
            return root;
        }
    }
}
