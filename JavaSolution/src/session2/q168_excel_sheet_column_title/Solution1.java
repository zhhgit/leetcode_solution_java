package session2.q168_excel_sheet_column_title;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {4,26,27,28,52};
        for(int num:nums){
            System.out.println(convertToTitle(num));
        }
    }

    private static String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n > 26){
            //要注意进位与十进制的差别
            int convertValue = (n-1) % 26 + 1;
            sb.append(intToChar(convertValue));
            n = (n - convertValue) / 26;
        }
        sb.append(intToChar(n));
        return sb.reverse().toString();
    }

    private static char intToChar(int x){
        return (char) ((x-1) + 'A');
    }
}
