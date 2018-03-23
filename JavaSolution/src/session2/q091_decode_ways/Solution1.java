package session2.q091_decode_ways;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"1111"};
        for(String str:strs){
            System.out.println(numDecodings(str));
        }
    }

    private static int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] arr = new int[len + 1];
        //这里注意！！
        arr[len] = 1;
        if(getValue(s,len -1) == 0){
            arr[len -1] = 0;
        }
        else{
            arr[len -1] = 1;
        }
        for(int i=len-2;i>=0;i--){
            if(getValue(s,i) != 0){
                if(Integer.parseInt(s.substring(i,i+2)) <=26){
                    arr[i] = arr[i+1] + arr[i+2];
                }
                else{
                    arr[i] = arr[i+1];
                }
            }
        }
        return arr[0];
    }

    private static int getValue(String s,int pos){
        char temp = s.charAt(pos);
        return temp - '0';
    }
}
