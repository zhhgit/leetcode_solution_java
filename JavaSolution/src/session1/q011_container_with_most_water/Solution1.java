package session1.q011_container_with_most_water;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        System.out.println(maxArea(arr));
    }

    private static int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int maxRet = calArea(left,right,height[left],height[right]);
        while(left<right){
            if(height[left]<height[right]){
                left++;
                maxRet = Math.max(maxRet,calArea(left,right,height[left],height[right]));
            }
            else{
                right--;
                maxRet = Math.max(maxRet,calArea(left,right,height[left],height[right]));
            }
        }
        return maxRet;
    }

    private static int calArea(int i,int j, int iheight, int jheight){
        Integer width = j-i;
        Integer height = Math.min(iheight,jheight);
        return  width*height;
    }
}
