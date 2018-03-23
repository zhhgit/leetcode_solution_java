package session1.q007_reverse_integer;

public class Solution1 {
    public static  void main(String[] args){
        int[] inputArr = {10,123,-123,0,1212121213};
        for(int i = 0; i< inputArr.length; i++){
            System.out.println(reverse(inputArr[i]));
        }
    }

    private static int reverse(int x){
        long result = 0;
        int tail;
        while(x != 0){
            //负数取余也是负数
            tail = x % 10;
            result = result * 10 + tail;
            x = x / 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            result = 0;
        }
        return (int)result;
    }
}
