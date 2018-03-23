package session1.q014_longest_common_prefix;

public class Solution1 {
    public static  void main(String[] args){
        String[] strs = {"aaa","aa"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuffer sbRet = new StringBuffer();
        char temp;
        int i;
        int strsLength = strs.length;
        int minLength;
        int breakPos = 0;
        boolean endFlag = false;
        if(strsLength != 0){
            minLength = strs[0].length();
            for(i= 0; i<strs.length; i++){
                if(strs[i].length() < minLength){
                    minLength = strs[i].length();
                }
            }
            i=0;
            while(i<minLength){
                if(!endFlag){
                    temp = strs[0].charAt(i);
                    for(int j=0; j<strsLength; j++){
                        if(temp != strs[j].charAt(i)){
                            breakPos = i;
                            endFlag =true;
                            break;
                        }
                    }
                }
                i++;
            }
            if(endFlag){
                for(i= 0; i<breakPos; i++){
                    sbRet.append(strs[0].charAt(i));
                }
            }
            else{
                for(i= 0; i<minLength; i++){
                    sbRet.append(strs[0].charAt(i));
                }
            }
        }
        return sbRet.toString();
    }
}
