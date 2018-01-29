package q165_compare_version_numbers;

public class Solution1 {
    public static void main(String[] args){
        String version1 = "1.0";
        String version2 = "1";
        System.out.println(compareVersion(version1,version2));
    }

    private static int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int pos1 = 0;
        int pos2 = 0;
        int v1,v2;
        //两个都没有结束，函数也没有return，继续比较
        while (pos1 < len1 && pos2 < len2){
            v1 = 0;
            while (pos1 < len1){
                if(version1.charAt(pos1) != '.'){
                    v1 = v1 * 10 + version1.charAt(pos1) - '0';
                    pos1++;
                }
                else{
                    pos1++;
                    break;
                }
            }
            v2 = 0;
            while (pos2 < len2){
                if(version2.charAt(pos2) != '.'){
                    v2 = v2 * 10 + version2.charAt(pos2) - '0';
                    pos2++;
                }
                else{
                    pos2++;
                    break;
                }

            }
            if(v1 < v2){
                return -1;
            }
            else if(v1 > v2){
                return 1;
            }
        }
        if(pos1 == len1 && pos2 != len2){
            if(isZero(version2.substring(pos2))){
                return 0;
            }
            else{
                return -1;
            }
        }
        else if(pos1 != len1 && pos2 == len2){
            if(isZero(version1.substring(pos1))){
                return 0;
            }
            else{
                return 1;
            }
        }
        else{
            return 0;
        }
    }

    private static boolean isZero(String version){
        String[] arr = version.split("\\.");
        for(String str:arr){
            if(Integer.valueOf(str) != 0){
                return false;
            }
        }
        return true;
    }
}
