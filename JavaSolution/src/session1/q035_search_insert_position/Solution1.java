package session1.q035_search_insert_position;

public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{1,3,5,6},{1,3,5,6},{1,3,5,6},{1,3,5,6}};
        int[] targetArr = {5,2,7,0};
        for(int i=0;i<arr.length;i++){
            System.out.println(searchInsert(arr[i],targetArr[i]));
        }
    }

    private static int searchInsert(int[] nums, int target) {
        int i = 0;
        while((i<nums.length) && (nums[i])<target){
            i++;
        }
        return i;
    }
}
