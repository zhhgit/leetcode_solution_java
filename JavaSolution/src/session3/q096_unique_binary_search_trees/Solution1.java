package session3.q096_unique_binary_search_trees;

public class Solution1 {
    public static void main(String[] args){
        int[] nArr = {1,2,3,4};
        for(int n:nArr){
            System.out.println(numTrees(n));
        }
    }

    private static int numTrees(int n) {
        if(n == 0  || n == 1){
            return 1;
        }
        int[] store = new int[n + 1];
        store[0] = 1;
        store[1] = 1;
        for(int i = 2;i<=n;i++){
            int sum = 0;
            for(int j = 0;j<i;j++){
                sum += store[j] * store[i-1-j];
            }
            store[i] = sum;
        }
        return store[n];
    }
}
