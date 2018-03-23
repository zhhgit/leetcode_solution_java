package session2.q171_excel_sheet_column_number;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"AB","D"};
        for(String s:strs){
            System.out.println(titleToNumber(s));
        }
    }

    private static int titleToNumber(String s) {
        if(s.length() == 0){
            return 0;
        }
        int ret = 0;
        int index = 1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(s.length()-1-i);
            ret += convertEach(c) * index;
            index = index * 26;
        }
        return ret;
    }

    private static int convertEach(char c){
        return c - 'A' + 1;
    }
}
