package session3.q074_search_a_2d_matrix;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[] targetArr = {3,13};
        for(int target:targetArr){
            System.out.println(searchMatrix(matrix,target));
        }
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
        for(int i = 0;i<rowLen;i++){
            if(target >= matrix[i][0] && target <= matrix[i][columnLen - 1]){
                return searchArr(matrix[i],target);
            }
        }
        return false;
    }

    private static boolean searchArr(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(left == right){
            if(arr[left] == target){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
