package session3.q008_string_to_integer_atoi;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"42","   -42","4193 with words","words and 987","-91283472332"};
        for(String s:strs){
            System.out.println(myAtoi(s));
        }
    }

    private static int myAtoi(String str) {
        int pos = 0;
        int ret = 0;
        int len = str.length();
        //跳过开头空格
        while (pos < len && str.charAt(pos) == ' '){
            pos++;
        }
        //全部空格
        if(pos == len){
            return 0;
        }
        //开头既不是数字，也不是正负号
        if(!isNum(str.charAt(pos)) && !isSign(str.charAt(pos))){
            return 0;
        }
        //开头是符号
        if(isSign(str.charAt(pos))){
            if(str.charAt(pos) == '-'){
                return 0-parsePositiveNum(str,pos+1,false);
            }
            else{
                return parsePositiveNum(str,pos+1,true);
            }
        }
        //无符号数字
        else{
            return parsePositiveNum(str,pos,true);
        }
    }

    private static boolean isNum(char c){
        int num = c - '0';
        return num<=9 && num>=0;
    }

    private static boolean isSign(char c){
        return (c == '+') || (c =='-');
    }

    private static int parsePositiveNum(String str,int pos,boolean sign){
        int len = str.length();
        long ret = 0;
        int i = pos;
        while (i<len && isNum(str.charAt(i))){
            int c = str.charAt(i) - '0';
            ret = ret * 10 + c;
            if(sign){
                if(ret > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }
            else{
                if(Integer.MIN_VALUE + ret > 0){
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return (int) ret;
    }
}
