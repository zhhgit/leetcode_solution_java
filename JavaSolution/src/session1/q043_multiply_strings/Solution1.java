package session1.q043_multiply_strings;

public class Solution1 {
    public static void main(String[] args){
        String num1 = "123";
        String num2 = "10";
        System.out.println(multiply(num1,num2));
    }

    private static String multiply(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ret = new int[len1+len2];
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int temp = (num1.charAt(i)-'0') * (num2.charAt(j)-'0') + ret[i+j+1];
                ret[i+j+1] = temp%10;
                ret[i+j] += temp/10;
            }
        }
        System.out.println();
        int i=0;
        while((i<len1+len2-1)&&(ret[i]==0)){
            i++;
        }
        while(i<len1+len2){
            sb.append(Integer.toString(ret[i++]));
        }
        return sb.toString();
    }
}
