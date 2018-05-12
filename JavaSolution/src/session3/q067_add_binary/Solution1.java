package session3.q067_add_binary;

public class Solution1 {
    public static void main(String[] args){
        String[] aArr = {"11","1010","0"};
        String[] bArr = {"1","1011","0"};
        for(int i = 0;i<aArr.length;i++){
            System.out.println(addBinary(aArr[i],bArr[i]));
        }
    }

    private static String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        String aStr,bStr;
        if(aLen > bLen){
            aStr = a;
            bStr = extend(b,aLen - bLen);
        }
        else{
            aStr = extend(a,bLen - aLen);
            bStr = b;
        }
        return addBinarySameLen(aStr,bStr);
    }

    private static String addBinarySameLen(String a,String b){
        int len = a.length();
        int increase = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = len - 1;i>=0;i--){
            int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + increase;
            if(sum >= 2){
                stringBuilder.append(sum % 2);
                increase = sum / 2;
            }
            else{
                stringBuilder.append(sum);
                increase = 0;
            }
        }
        if(increase > 0){
            stringBuilder.append(increase);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    private static String extend(String s,int len){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<len;i++){
            stringBuilder.append("0");
        }
        stringBuilder.append(s);
        return stringBuilder.toString();
    }
}
