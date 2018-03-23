package session2.q374_guess_number_higher_or_lower;

public class Solution1 {
	public static void main(String[] args) {
		int n = 2126753390;
		System.out.println(guessNumber(n));
	}
	
	private static int ret;
	
    private static int guessNumber(int n) {
    	guessWithRange(1, n);
    	return ret;
    }
    
    private static void guessWithRange(int start,int end) {
    	if(start == end) {
    		ret = start;
    		return;
    	}
    	else {
    		int middle = (end - start) / 2 + start;
    		int guessResult = guess(middle);
    		if(guessResult == 0) {
    			ret = middle;
    			return;
    		}
    		else if(guessResult == 1) {
    			guessWithRange(middle+1, end);
    		}
    		else {
    			guessWithRange(start, middle-1);
    		}
    	}
    }
    
    private static int guess(int n) {
    	int target = 1702766719;
    	if(n == target) {
    		return 0;
    	}
    	else if(n > target){
    		return -1;
    	}
    	else {
    		return 1;
    	}
    }
}
