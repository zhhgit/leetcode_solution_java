package algorithm1.array;

public class MaxProfit {

    public static void main(String[] args) {
        int[][] priceExamples = {{7,1,5,3,6,4},{1,2,3,4,5},{7,6,4,3,1}};
        for (int[] prices: priceExamples){
            System.out.println(maxProfit(prices));
        }
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int sum = 0;
        int temp = 0;
        for (int i = 1;i <len;i++){
            if (prices[i] - prices[i - 1] > 0){
                temp += prices[i] - prices[i - 1];
            }
            else {
                sum += temp;
                temp = 0;
            }
        }
        if (temp > 0){
            sum += temp;

        }
        return sum;
    }
}
