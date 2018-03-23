package session1.q108_convert_sorted_array_to_binary_search_tree;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode ret = sortedArrayToBST(arr);
        System.out.println("finished");
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode ret = construct(nums,0,nums.length-1);
        return ret;
    }

    private static TreeNode construct(int[] nums, int start, int end){
        int len = end-start+1;
        if(len<=0){
            return null;
        }
        else{
            int rootIndex = (start+end)/2;
            TreeNode insert = new TreeNode(nums[rootIndex]);
            insert.left = construct(nums,start,rootIndex-1);
            insert.right = construct(nums,rootIndex+1,end);
            return insert;
        }
    }
}
