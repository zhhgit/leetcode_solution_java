package session3.q084_largest_rectangle_in_histogram;

public class Solution1 {
    public static void main(String[] args){
        int[] height = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }

    private static int largestRectangleArea(int[] heights) {
        int max = 0;
        int len = heights.length;
        for (int i = 0;i<len;i++){
            int height = heights[i];
            int left = i;
            while (left >= 0 && heights[left] >= height ){
                left--;
            }
            int right = i;
            while (right < len && heights[right] >= height){
                right++;
            }
            int width = right - left - 1;
            int area = width * height;
            max = Math.max(max,area);
        }
        return max;
    }
}
