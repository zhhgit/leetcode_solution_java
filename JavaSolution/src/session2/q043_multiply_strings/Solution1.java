package session2.q043_multiply_strings;

public class Solution1 {
    public static void main(String[] args){
        String num1 = "45";
        String num2 = "3";
        System.out.println(multiply(num1,num2));
    }

    private static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] retArr1 = new int[len1+len2];
        int[] retArr2 = new int[len1+len2];
        //获得每一位计算值，不考虑进位
        for(int i=0;i<len1 + len2;i++){
            retArr1[i] = eachPosValue(num1,num2,i);
        }
        //考虑进位
        int carry = 0;
        for(int i=0;i<len1 + len2;i++){
            retArr2[i] = (carry + retArr1[i]) % 10;
            carry = (carry + retArr1[i]) / 10;
        }
        StringBuffer sb = new StringBuffer();
        int i = len1 + len2-1;
        while(i>0 && retArr2[i] == 0){
            i--;
        }
        while(i>=0){
            sb.append(retArr2[i--]);
        }
        return sb.toString();
    }

    private static int eachPosValue(String num1,String num2,int backPos){
        int ret = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        int value1 = 0;
        int value2 = 0;
        for(int i=0;i<=backPos;i++){
            if(len1 -1 - i >=0){
                value1 = (num1.charAt(len1 -1 - i) - '0');
            }
            else{
                value1 = 0;
            }
            if(len2 - 1 - (backPos - i) >=0){
                value2 = (num2.charAt(len2 - 1 - (backPos - i)) - '0');
            }
            else{
                value2 = 0;
            }
            ret += value1 * value2;
        }
        return ret;
    }
}