package q007_reverse_integer;

/**
 * Created by zhanghao1 on 2017/10/23.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-123,123,-32768,561};
        for(int num : nums){
            System.out.println(reverse(num));
        }
    }

    private static int reverse(int x) {
        long longX = (long) x;
        long longRet = reverseLong(longX);
        return (int) longRet;
    }

    private static long reverseLong(long x){
        long ret = 0;
        long temp = 0;
        long sign = 1;
        long absX;
        if(x < 0){
            sign = -1;
            absX =  x * (-1);
        }
        else if (x > 0){
            sign = 1;
            absX = x;
        }
        else{
            ret = 0;
            return ret;
        }
        while(absX > 0) {
            temp = temp * 10 + absX % 10;
            absX = absX / 10;
        }
        temp = temp * sign;
        if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
            ret = 0;
        }
        else {
            ret = temp;
        }
        return ret;
    }
}
