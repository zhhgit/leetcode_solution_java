package session3.q038_count_and_say;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        for(int i = 0;i<arr.length;i++){
            System.out.println(countAndSay(arr[i]));
        }
    }

    private static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String last = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = 1;i<last.length();i++){
            if(last.charAt(i) != last.charAt(i-1)){
                sb.append(i-start);
                sb.append(last.charAt(start));
                start = i;
            }
        }
        sb.append(last.length()-start);
        sb.append(last.charAt(start));
        return sb.toString();
    }
}
