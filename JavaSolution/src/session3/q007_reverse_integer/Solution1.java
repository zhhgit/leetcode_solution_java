package session3.q007_reverse_integer;

public class Solution1 {
	public static void main(String[] args) {
		int[] arr = {123,-123,120,-1200,102};
		for(int i=0;i<arr.length;i++) {
			System.out.println(reverse(arr[i]));
		}
	}
	
    private static int reverse(int x) {
    	long xLong = (long) x;
        if(x < 0) {
        	long retLong = 0 - reversePositive(-xLong);
        	if(retLong < Integer.MIN_VALUE) {
        		return 0;
        	}
        	else {
        		return (int) retLong;
        	}
        	
        }
        else {
        	long retLong = reversePositive(xLong);
        	if(retLong > Integer.MAX_VALUE) {
        		return 0;
        	}
        	else {
        		return (int) retLong; 
        	}
        }
    }
    
    private static long reversePositive(long x) {
    	long ret = 0;
    	while(x > 0) {
    		long tail = x % 10;
    		ret = ret * 10 + tail;
    		x = x / 10;
    	}
    	return ret;
    }
}
