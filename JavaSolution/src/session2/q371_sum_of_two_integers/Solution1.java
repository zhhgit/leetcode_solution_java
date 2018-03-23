package session2.q371_sum_of_two_integers;

public class Solution1 {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(getSum(a, b));
	}
	
    private static int getSum(int a, int b) {
    	if(b == 0) {
    		return a;
    	}
        return getSum((a^b), ((a&b)<<1));
    }
}
