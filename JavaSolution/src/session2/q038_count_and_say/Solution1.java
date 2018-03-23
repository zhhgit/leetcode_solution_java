package session2.q038_count_and_say;

/**
 * Created by zhanghao1 on 2017/10/26.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nArr = {1,2,3,4,5};
        for(int n:nArr){
            System.out.println(countAndSay(n));
        }
    }

    private static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        else if(n == 2){
            return "11";
        }
        else{
            StringBuffer sb = new StringBuffer();
            String last = countAndSay(n-1);
            char temp = last.charAt(0);
            int tempCount = 1;
            for(int i = 1;i<last.length();i++){
                if(last.charAt(i) == temp){
                    tempCount++;
                }
                else{
                    sb.append(tempCount);
                    sb.append(temp);
                    temp = last.charAt(i);
                    tempCount = 1;
                }
            }
            sb.append(tempCount);
            sb.append(temp);
            return sb.toString();
        }
    }
}
