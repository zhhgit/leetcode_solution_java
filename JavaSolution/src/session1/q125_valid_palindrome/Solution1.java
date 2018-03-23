package session1.q125_valid_palindrome;

public class Solution1 {
    public static void main(String[] args){
        String[] arr = {"A man, a plan, a canal: Panama","race a car","0p"};
        for(int i = 0;i < arr.length; i++){
            System.out.println(isPalindrome(arr[i]));
        }
    }

    private static boolean isPalindrome(String s){
        char[] cArr1 = s.toCharArray();
        int len1 = cArr1.length;
        int len2 = 0;
        if(len1 == 0){
            return true;
        }
        else{
            char[] cArr2 = new char[len1];
            for(int i = 0; i < len1; i++){
                if(Character.isLetter(cArr1[i])){
                    cArr2[len2++] = Character.toLowerCase(cArr1[i]);
                }
                else if(Character.isDigit(cArr1[i])){
                    cArr2[len2++] = cArr1[i];
                }
            }
            if(len2 == 0){
                return true;
            }
            else{
                int head = 0, tail = len2-1;
                while(head <= tail){
                    if(head == tail){
                        return true;
                    }
                    else{
                        if(cArr2[head] == cArr2[tail]){
                            head++;
                            tail--;
                        }
                        else{
                            return false;
                        }
                    }
                }
                return true;
            }
        }
    }
}
