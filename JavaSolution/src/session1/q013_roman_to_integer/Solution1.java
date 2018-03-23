package session1.q013_roman_to_integer;

public class Solution1 {
    public static  void main(String[] args){
        String[] strs = {"DCXXI","DCIX"};
        for(int i=0; i < strs.length; i++){
            System.out.println(romanToInt(strs[i]));
        }
    }

    private static int romanToInt(String s) {
        int ret = 0;
        char[] sArr = s.toCharArray();
        int len = sArr.length;
        for (int i = 0; i < len; i++){
            switch(sArr[i]){
                case 'I': ret+=1;break;
                case 'X': ret+=10;break;
                case 'C': ret+=100;break;
                case 'M': ret+=1000;break;
                case 'V': ret+=5;break;
                case 'L': ret+=50;break;
                case 'D': ret+=500;break;
                default: ret+=0;
            }
        }
        //特殊情况2倍减
        if((s.indexOf("IV")>=0) || (s.indexOf("IX")>=0) ){
            ret-=2;
        }
        if((s.indexOf("XL")>=0) || (s.indexOf("XC")>=0) ){
            ret-=20;
        }
        if((s.indexOf("CD")>=0) || (s.indexOf("CM")>=0) ){
            ret-=200;
        }
        return ret;
    }
}
