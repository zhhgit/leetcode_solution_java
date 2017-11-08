package q008_string_to_integer_atoi;

/**
 * Created by zhanghao1 on 2017/11/8.
 */
public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"-1","1","0","1345","1111111111111111111111111111"};
        for(String s:strs){
            System.out.println(myAtoi(s));
        }
    }

    private static int myAtoi(String str) {
        long result = 0;
        int i=0;
        int sign = 1;
        while(indexInRange(str,i) && str.charAt(i) == ' '){
            i++;
        }
        if(indexInRange(str,i) && isSignChar(str.charAt(i))){
            if(str.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        for(int j=i;j<str.length();j++){
            if(isNum(str.charAt(j))){
                result = result * 10 + (str.charAt(j) - '0');
                if(sign * result > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                else if(sign * result < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
            else{
                break;
            }
        }
        if(sign * result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(sign * result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) (sign * result);
    }

    private static boolean indexInRange(String str,int index){
        return index >= 0 && index < str.length();
    }

    private static boolean isNum(char c){
        int num = c - '0';
        return num <= 9 && num >=0;
    }

    private static boolean isSignChar(char c){
        return c == '-' || c == '+';
    }
}
