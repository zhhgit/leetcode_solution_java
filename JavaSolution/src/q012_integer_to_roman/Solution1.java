package q012_integer_to_roman;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {56};
        for(int num: nums){
            System.out.println(intToRoman(num));
        }
    }

    private static String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        String numStr = Integer.toString(num);
        int len = numStr.length();
        for(int i=0;i<len;i++){
            sb.append(appendEach(numStr.charAt(i) - '0',len - 1 -i));
        }
        return sb.toString();
    }

    private static String appendEach(int digit,int pos){
        StringBuffer eachSb = new StringBuffer();
        char full,half,one;
        switch (pos){
            case 0:
                full = 'X';
                half = 'V';
                one = 'I';
                break;
            case 1:
                full = 'C';
                half = 'L';
                one = 'X';
                break;
            case 2:
                full = 'M';
                half = 'D';
                one = 'C';
                break;
            case 3:
                full = ' ';
                half = ' ';
                one = 'M';
                break;
            default:
                full = ' ';
                half = ' ';
                one = ' ';
        }
        if(digit <= 3){
            for(int i = 0;i<digit;i++){
                eachSb.append(one);
            }
        }
        else if(digit == 4){
            eachSb.append(one).append(half);
        }
        else if(digit == 5){
            eachSb.append(half);
        }
        else if(digit < 9){
            eachSb.append(half);
            for(int i=0;i<digit-5;i++){
                eachSb.append(one);
            }
        }
        else{
            eachSb.append(one).append(full);
        }
        return eachSb.toString();
    }
}
