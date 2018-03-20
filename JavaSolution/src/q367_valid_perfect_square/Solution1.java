package q367_valid_perfect_square;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums = {1,16,14};
		for(int num:nums) {
			System.out.println(isPerfectSquare(num));	
		}
	}
	
    private static boolean isPerfectSquare(int num) {
    	if(num < 0) {
    		return false;
    	}
    	String[] stringArr = (Math.sqrt(num) + "").split("\\.");
    	int sqrtResult = Integer.parseInt(stringArr[0]);
    	return (sqrtResult * sqrtResult == num);
    }
}
