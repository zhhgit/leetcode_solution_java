package q042_trapping_rain_water;

public class Solution1 {
    public static void main(String[] args){
        int[] height = {5,2,1,2,1,5};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int ret = 0;
        if(height.length <=2){
            return ret;
        }
        for(int i=1;i<height.length-1;i++){
            int leftMax = 0;
            int rightMax = 0;
            for(int j = i -1;j>=0;j--){
                leftMax = Math.max(leftMax,height[j]);
            }
            for(int j = i + 1;j < height.length;j++){
                rightMax = Math.max(rightMax,height[j]);
            }
            int water = Math.min(leftMax,rightMax) - height[i];
            if(water >0){
                ret += water;
            }
        }
        return ret;
    }
}
