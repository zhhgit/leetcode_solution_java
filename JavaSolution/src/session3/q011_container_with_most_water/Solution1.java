package session3.q011_container_with_most_water;

public class Solution1 {
    public static void main(String[] args){
        int[] height = {2,3,4,5,3};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int len = height.length;
        int max = Math.min(height[len-1],height[0]) * (len - 1);
        int left = 0;
        int right = len - 1;
        while (left < right){
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
            max = Math.max(max,(right-left) * Math.min(height[left],height[right]));
        }
        return max;
    }
}
