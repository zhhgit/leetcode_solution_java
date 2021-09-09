package algorithm1.dynamicProgramming;

public class MaxProfit {

    public static void main(String[] args) {
        int[][] numsArr = {{7,1,5,3,6,4},{7,6,4,3,1}};
        for (int[] nums: numsArr){
            System.out.println(maxProfit(nums));
        }
    }

    // 找到当前数字此前的最小数，差值即为利润。
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1 ){
            return 0;
        }
        int maxRet = 0;
        int minVal = prices[0];
        for (int i = 1;i <= len - 1; i++){
            minVal = Math.min(minVal,prices[i - 1]);
            maxRet = Math.max(maxRet, prices[i] - minVal);
        }
        return maxRet;
    }
}
