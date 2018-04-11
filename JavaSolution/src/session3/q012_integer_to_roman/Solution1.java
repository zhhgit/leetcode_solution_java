package session3.q012_integer_to_roman;

public class Solution1 {
    public static void main(String[] args){
        int num = 2329;
        System.out.println(intToRoman(num));
    }

    private static String intToRoman(int num) {
        int len = (num + "").length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            int eachNum = (num + "").charAt(i) - '0';
            appendEach(sb,len - 1 - i,eachNum);
        }
        return sb.toString();
    }

    private static void appendEach(StringBuilder sb,int pos,int num){
        char one = ' ',half = ' ',full = ' ';
        switch (pos){
            case 0:{
                one = 'I';
                half = 'V';
                full = 'X';
                break;
            }
            case 1:{
                one = 'X';
                half = 'L';
                full = 'C';
                break;
            }
            case 2:{
                one = 'C';
                half = 'D';
                full = 'M';
                break;
            }
            case 3:{
                one = 'M';
                half = ' ';
                full = ' ';
                break;
            }
            default:break;
        }
        if(num <= 3){
            for(int i=0;i<num;i++){
                sb.append(one);
            }
        }
        else if(num == 4){
            sb.append(one);
            sb.append(half);
        }
        else if(num == 5){
            sb.append(half);
        }
        else if(num < 9){
            sb.append(half);
            for(int i=0;i<num-5;i++){
                sb.append(one);
            }
        }
        else {
            sb.append(one);
            sb.append(full);
        }
    }
}
