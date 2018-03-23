package session2.q074_search_a_2d_matrix;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 34;
        System.out.println(searchMatrix(matrix,target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if(rowLen == 0){
            return false;
        }
        int columnLen = matrix[0].length;
        if(columnLen == 0){
            return false;
        }
        if(target < matrix[0][0] || target > matrix[rowLen-1][columnLen-1]){
            return false;
        }
        //先找到在哪一行
        int i = 0;
        while(i<rowLen-1){
            if(matrix[i][0] <= target && matrix[i+1][0] > target){
                break;
            }
            i++;
        }
        //此时的i就是行号，转为化一维的问题
        return searchArray(matrix[i],target);
    }

    private static boolean searchArray(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int middle;
        while(left < right){
            middle = (left + right) /2;
            if(target == nums[middle]){
                return true;
            }
            else if(target < nums[middle]){
                right = middle-1;
            }
            else{
                left = middle + 1;
            }
        }
        return (nums[left] == target);
    }
}
