package session1.q012_integer_to_roman;

public class Solution1 {
    public static void main(String[] args){
        int[] intArr = {2,3,4,5,8,9};
        for(int i=0;i<intArr.length;i++){
            sb.delete(0,sb.length());
            System.out.println(intToRoman(intArr[i]));
        }
    }

    private static StringBuffer sb = new StringBuffer();

    private static String intToRoman(int num) {
        int pos = 0,curr = 0;
        while(num > 0){
            curr = num%10;
            appendEach(curr,pos);
            pos++;
            num = num/10;
        }
        return sb.reverse().toString();
    }

    private static void appendEach(int curr, int pos){
        String full,half,one;
        switch (pos){
            case 0:{
                full = "X";
                half = "V";
                one = "I";
                break;
            }
            case 1:{
                full = "C";
                half = "L";
                one = "X";
                break;
            }
            case 2:{
                full = "M";
                half = "D";
                one = "C";
                break;
            }
            case 3:{
                full="";
                half="";
                one = "M";
                break;
            }
            default:{
                full="";
                half="";
                one="";
                break;
            }
        }
        if(curr<=3){
            for(int i=0;i<curr;i++){
                sb.append(one);
            }
        }
        else if(curr==4){
            sb.append(half);
            sb.append(one);
        }
        else if(curr==5){
            sb.append(half);
        }
        else if(curr>5 && curr<=8){
            for(int i=0;i<curr-5;i++){
                sb.append(one);
            }
            sb.append(half);
        }
        else if(curr==9){
            sb.append(full);
            sb.append(one);
        }
    }
}
