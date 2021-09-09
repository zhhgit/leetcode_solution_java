package algorithm1.string;

public class ReverseString {

    public static void main(String[] args) {
        String str = new String("abcd123ABCD");
        System.out.println(str);
        char[] strCharArray = str.toCharArray();
        reverseString(strCharArray);
        String newStr = new String(strCharArray);
        System.out.println(newStr);
    }

    public static void reverseString(char[] s) {
        int len = s.length;
        if (len <= 1){
            return;
        }
        int left = 0;
        int right = len - 1;
        char temp;
        while (left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
