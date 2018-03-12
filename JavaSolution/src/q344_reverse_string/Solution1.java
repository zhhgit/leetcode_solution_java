package q344_reverse_string;

public class Solution1 {
	public static void main(String[] args) {
		String str = "hehe";
		System.out.println(reverseString(str));
	}
	
    private static String reverseString(String s) {
    	int len = s.length();
    	if(len == 0) {
    		return "";
    	}
    	else {
    		StringBuffer sb = new StringBuffer();
    		for(int i = len-1;i>=0;i--) {
    			sb.append(s.charAt(i));
    		}
    		return sb.toString();
    	}
    }

}
