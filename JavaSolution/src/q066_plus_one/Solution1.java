package q066_plus_one;

import java.util.Arrays;

/**
 * Created by zhanghao1 on 2017/10/30.
 */
public class Solution1 {
    public static void main(String[] args){
        int[][] digitsArr = {{1,2,3},{1,2,9},{9,9}};
        int[][] resultArr = new int[3][];
        for(int i=0;i<digitsArr.length;i++){
            resultArr[i] = plusOne(digitsArr[i]);
            for(int digit:resultArr[i]){
                System.out.println(digit);
            }
            System.out.println("---------------------");
        }

    }

    private static int[] plusOne(int[] digits) {
        int[] newDigits = new int[digits.length +1];
        for(int i=0;i<digits.length;i++){
            newDigits[i+1] = digits[i];
        }
        plusOneAt(newDigits,newDigits.length-1,1);
        if(newDigits[0] > 0){
            return newDigits;
        }
        else{
            return Arrays.copyOfRange(newDigits,1,newDigits.length);
        }
    }

    private static void plusOneAt(int[] digits,int position,int carry){
        if(carry <= 0){
            return;
        }
        int tempSum = digits[position] + carry;
        if(tempSum >= 10){
            digits[position] = tempSum % 10;
            plusOneAt(digits,position-1,1);
        }
        else {
            digits[position] = tempSum;
        }
    }
}
