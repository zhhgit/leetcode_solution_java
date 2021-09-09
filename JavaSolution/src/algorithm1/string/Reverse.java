package algorithm1.string;

public class Reverse {

    public static void main(String[] args) {
        int[] nums = {34,-356,12345,0,Integer.MAX_VALUE,Integer.MIN_VALUE};
        for(int num: nums){
            System.out.println(reverse(num));
        }
    }

    public static int reverse(int x) {
        // 注意负数取模
        int ret = 0;
        while (x != 0){
            int temp = x % 10;
            int newRes = ret * 10 + temp;
            if ((newRes - temp) / 10 != ret){
                return 0;
            }
            ret = newRes;
            x = x / 10;
        }
        return ret;
    }
}
