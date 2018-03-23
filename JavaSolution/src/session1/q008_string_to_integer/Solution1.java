package session1.q008_string_to_integer;

public class Solution1 {
    public static  void main(String[] args){
        String[] str = {"  123","123","+1","4111111111","1.23","123abc","abc","-123","","9223372036854775809"};
        for(int i=0; i < str.length; i++){
            System.out.println(myAtoi(str[i]));
        }
    }

    private static int myAtoi(String str){
        long result = 0;
        int i,eachValue;
        int sign = 0;
        if(!str.equalsIgnoreCase("")){
            char[] strArray = str.toCharArray();
            for(i = 0; (i < strArray.length) && (Character.isWhitespace(strArray[i]));i++){
            }
            if(Character.compare(strArray[i],'-') == 0){
                sign = -1;
                i++;
            }
            else if(Character.compare(strArray[i],'+') == 0){
                sign = 1;
                i++;
            }
            for(; (i < strArray.length) && (Character.isDigit(strArray[i])); i++ ){
                eachValue = strArray[i] - '0';
                result = result * 10 + eachValue;
                if(checkOverflow(result)){
                    if(sign == -1){
                        result = 0-Integer.MIN_VALUE;
                    }
                    else{
                        result = Integer.MAX_VALUE;
                    }
                    break;
                };
            }
            if(sign == -1){
                result = 0 - result;
            }
        }
        return (int)result;

    }

    private static boolean checkOverflow(long result){
        boolean ret = false;
        if(result > Integer.MAX_VALUE){
            ret = true;
        }
        return  ret;
    }
}