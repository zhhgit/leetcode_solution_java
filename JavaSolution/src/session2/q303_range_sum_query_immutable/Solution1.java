package session2.q303_range_sum_query_immutable;

public class Solution1 {
	public static void main(String[] args){
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray obj = new NumArray(nums);
		System.out.println(obj.sumRange(0, 2));
		System.out.println(obj.sumRange(2, 5));
		System.out.println(obj.sumRange(0, 5));
		System.out.println(obj.sumRange(4, 5));
		System.out.println(obj.sumRange(1, 3));
	}
	
	
	private static class NumArray {
		private int[] sums;
	    public NumArray(int[] nums) {
	        int len = nums.length;
	        sums = new int[len];
	        for(int i=0;i<len;i++){
	        	if(i == 0){
	        		sums[i] = nums[i];
	        	}
	        	else{
	        		sums[i] = sums[i-1] + nums[i];
	        	}
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	    	if(i == 0){
	    		return sums[j];
	    	}
	    	else{
	    		return sums[j] - sums[i-1];
	    	}
	    }
	}
}
