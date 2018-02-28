package q292_nim_game;

public class Solution1 {
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7,8};
		for(int n:nums){
			System.out.println(canWinNim(n));
		}
	}
	
    public static boolean canWinNim(int n) {
    	int remain = n % 4;
    	return (remain != 0);
    }
}
