package q345_reverse_vowels_of_a_string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Solution1 {
	public static void main(String[] args) {
		String str = "leetcode";
		System.out.println(reverseVowels(str));
	}
	
    private static String reverseVowels(String s) {
        HashSet<Character> hSet = new HashSet<>();
        hSet.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int len = s.length();
        if(len == 0) {
        	return "";
        }
        else {
        	Stack<Character> stack = new Stack<>();
        	boolean[] flag = new boolean[len];
        	for(int i=0;i<len;i++) {
        		if(hSet.contains(s.charAt(i))) {
        			flag[i] = true;
        			stack.push(s.charAt(i));
        		}
        	}
        	StringBuffer sb = new StringBuffer();
        	for(int i=0;i<len;i++) {
        		if(flag[i]) {
        			sb.append(stack.pop());
        		}
        		else {
        			sb.append(s.charAt(i));
        		}
        	}
        	return sb.toString();
        }
    }
}
