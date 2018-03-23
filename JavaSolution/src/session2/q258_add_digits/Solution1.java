package session2.q258_add_digits;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {38,23,34434};
        for(int num: nums){
            System.out.println(addDigits(num));
        }
    }

    private static int addDigits(int num) {
        return ((num-1) % 9) + 1;
    }
}
