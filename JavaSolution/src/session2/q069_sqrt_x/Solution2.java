package session2.q069_sqrt_x;

/**
 * Created by zhanghao1 on 2017/11/2.
 */
public class Solution2 {
    public static void main(String[] args){
        int[] nums = {0,1,2,4,9,16};
        for(int num:nums){
            System.out.println(mySqrt(num));
        }
    }
    //二分法查找
    private static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int left = 1,right = x,mid;
        while(left < right){
            mid = (left + right) /2;
            if(x / mid < mid){
                right = mid -1;
            }
            else{
                if(x / (mid+1) < (mid+1)){
                    return mid;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return left;
    }
}
