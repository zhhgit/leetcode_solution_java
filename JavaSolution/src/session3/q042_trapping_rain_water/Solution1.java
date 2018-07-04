package session3.q042_trapping_rain_water;

public class Solution1 {

    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int len = height.length;
        if (len == 0 || len == 1 | len == 2){
            return 0;
        }
        int sum = 0;
        for (int i = 0;i<len;i++){
            if (i != 0 && i != len - 1){
                int leftMax = findLeftMax(i,height);
                int rightMax = findRightMax(i,height);
                int currWater = Math.min(leftMax,rightMax) - height[i];
                if (currWater > 0){
                    sum += currWater;
                }
            }
        }
        return sum;
    }

    private static int findLeftMax(int pos,int[] height){
        int leftMax = height[0];
        for (int i = 0;i<pos;i++){
            leftMax = Math.max(leftMax,height[i]);
        }
        return leftMax;
    }

    private static int findRightMax(int pos,int[] height){
        int len = height.length;
        int rightMax = height[len - 1];
        for (int i = len - 1;i>pos;i--){
            rightMax = Math.max(rightMax,height[i]);
        }
        return rightMax;
    }
}
