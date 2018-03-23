package session2.q342_power_of_four;

public class Solution1 {
	public static void main(String[] args){
		System.out.println(isPowerOfFour(1));
		System.out.println(isPowerOfFour(2));
		System.out.println(isPowerOfFour(4));
		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerOfFour(64));
		System.out.println(isPowerOfFour(5));
	}
	
    private static boolean isPowerOfFour(int num) {
    	return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}
