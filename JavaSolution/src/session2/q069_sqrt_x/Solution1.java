package session2.q069_sqrt_x;

/**
 * Created by zhanghao1 on 2017/11/1.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {0,1,4,9,16};
        for(int num:nums){
            System.out.println(mySqrt(num));
        }
    }
    private static int mySqrt(int x) {
        double y = (double) x;
        double result = Math.sqrt(x);
        String resultStr = Double.toString(result);
        StringBuffer sb = new StringBuffer();
        int i=0;
        while(resultStr.charAt(i)!='.'){
            sb.append(resultStr.charAt(i++));
        }
        return Integer.parseInt(sb.toString());
    }
}
