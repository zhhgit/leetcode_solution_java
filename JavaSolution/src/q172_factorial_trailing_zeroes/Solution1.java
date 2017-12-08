package q172_factorial_trailing_zeroes;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,3,5,7,10,22,26};
        for(int n:nums){
            System.out.println(trailingZeroes(n));
        }
    }

    private static int trailingZeroes(int n) {
        int ret = 0;
        while (n > 0){
            ret += n / 5;
            n = n / 5;
        }
        return ret;
    }
}
