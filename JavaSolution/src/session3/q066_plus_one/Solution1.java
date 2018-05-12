package session3.q066_plus_one;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[][] digitsArr = {{1,2,3,9},{1,2,4},{3,0,9,9},{9}};
        for(int[] digits:digitsArr){
            PrintUtil.printNumArray(plusOne(digits));
            System.out.println("---------------");
        }
    }

    private static int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean increaseFlag = willIncrease(digits);
        int[] ret;
        if(increaseFlag){
            ret = new int[len + 1];
        }
        else{
            ret = new int[len];
        }
        int increase = 1;
        for(int i = 0;i<len;i++){
            int sum = digits[len - 1 - i] + increase;
            if(sum >= 10){
                ret[ret.length - 1 - i] = sum  % 10;
                increase = 1;
            }
            else{
                ret[ret.length - 1 - i] = sum;
                increase = 0;
            }
        }
        if(increase == 1){
            ret[0] = 1;
        }
        return ret;
    }

    private static boolean willIncrease(int[] digits){
        for(int i = 0;i<digits.length;i++){
            if(digits[i] != 9){
                return false;
            }
        }
        return true;
    }
}
