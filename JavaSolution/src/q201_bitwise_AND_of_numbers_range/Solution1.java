package q201_bitwise_AND_of_numbers_range;

public class Solution1 {
	public static void main(String[] args) {
		int m = 23423;
		int n = 23434;
		System.out.println(rangeBitwiseAnd(m,n));
	}
	
    private static int rangeBitwiseAnd(int m, int n) {
    	long mLong = (long) m;
    	long nLong = (long) n;
    	long gap = n - m;
    	long i = 1;
    	while(i <= gap) {
    		i = i << 1;
    	}
    	int result = 0;
    	while(i <= nLong) {
    		if((i & mLong) == (i & nLong)) {
        		result += i & nLong;
        	}
    		i = i << 1;
    	}
    	return result;
    }
}
