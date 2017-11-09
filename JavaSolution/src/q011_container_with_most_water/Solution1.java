package q011_container_with_most_water;

public class Solution1 {
    public static void main(String[] args){
        int[] height = {1,2,3,4,5};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int left=0,right = height.length-1;
        int max = getArea(left,height[left],right,height[right]);
        while(left < right){
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
            max = Math.max(max,getArea(left,height[left],right,height[right]));
        }
        return max;
    }

    private static int getArea(int i,int iHeight,int j,int jHeight){
        int width = Math.abs(i-j);
        int height = Math.min(iHeight,jHeight);
        return height * width;
    }
}