package session2.q014_longest_common_prefix;

/**
 * Created by zhanghao1 on 2017/10/24.
 */
public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"aa","a"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int currPos = 0;
        if(strs.length == 0){
            return "";
        }
        else if(strs.length == 1){
            return strs[0];
        }
        else{
            while(checkEach(strs,currPos)){
                sb.append(strs[0].charAt(currPos));
                currPos++;
            }
            return sb.toString();
        }
    }

    private static boolean checkEach(String[] strs,int currPos){
        boolean ret = true;
        for(int i = 0;i<strs.length; i++){
            if(strs[i].length() <= currPos){
                return false;
            }
            if(strs[0].charAt(currPos) != strs[i].charAt(currPos)){
                return false;
            }
        }
        return ret;
    }
}
