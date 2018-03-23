package session1.q091_decode_ways;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {"122","","4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"};
        for(String s:sArr){
            System.out.println(numDecodings(s));
        }
    }

    private static int numDecodings(String s) {
        int len = s.length();
        if(len==0){
            return 0;
        }
        else{
            int[] result = new int[len+1];
            result[len] = 1;
            result[len-1] = (s.charAt(len-1)!='0') ? 1 : 0;
            for(int i=len-2;i>=0;i--){
                if(s.charAt(i)=='0'){
                    continue;
                }
                else{
                    result[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? (result[i+1] + result[i+2]) : result[i+1];
                }
            }
            return result[0];
        }
    }
}
