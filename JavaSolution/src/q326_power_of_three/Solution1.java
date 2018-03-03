package q326_power_of_three;

import java.io.Console;

import com.sun.org.apache.regexp.internal.recompile;

public class Solution1 {
	public static void main(String[] args){
		System.out.println(isPowerOfThree(1));
		System.out.println(isPowerOfThree(2));
		System.out.println(isPowerOfThree(3));
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(29));
		System.out.println(isPowerOfThree(9));
	}
	
    private static boolean isPowerOfThree(int n) {
        long max3PowerLong = 1;
        while(max3PowerLong * 3 < Integer.MAX_VALUE){
        	max3PowerLong *= 3;
        }
        int max = (int) max3PowerLong;
        return (n > 0 && max % n == 0);
    }
}
