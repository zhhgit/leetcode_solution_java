package session3.q091_decode_ways;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {"100","12","226","10","0"};
        for(String s:sArr){
            System.out.println(numDecodings(s));
        }
    }

    private static int numDecodings(String s) {
        int len = s.length();
        if(s.charAt(0) == '0'){
            return 0;
        }
        int[] result = new int[len];
        for(int i = len - 1;i >= 0;i--){
            if(i == len - 1){
                int sum = 0;
                if(charInRange(s.charAt(i))){
                    sum++;
                }
                result[i] = sum;
            }
            else if(i == len - 2){
                int sum = 0;
                if(strInRange(s.substring(i,i+2))){
                    sum++;
                }
                if(charInRange(s.charAt(i)) && charInRange(s.charAt(i+1))){
                    sum++;
                }
                result[i] = sum;
            }
            else {
                int sum = 0;
                if(charInRange(s.charAt(i))){
                    sum += result[i + 1];
                }
                if(strInRange(s.substring(i,i+2))){
                    sum += result[i + 2];
                }
                result[i] = sum;
            }
        }
        return result[0];
    }

    //两位字符符合
    private static boolean strInRange(String s){
        int ret = Integer.parseInt(s);
        return (s.equals(ret + "") && ret >= 1 && ret <= 26);
    }

    //一位字符符合
    private static boolean charInRange(char c){
        int ret = c - '0';
        return (ret >= 1 && ret <= 9);
    }
}
