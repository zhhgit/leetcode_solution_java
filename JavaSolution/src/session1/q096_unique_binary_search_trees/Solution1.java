package session1.q096_unique_binary_search_trees;

public class Solution1 {
    public static void main(String[] args){
        int n=3;
        System.out.println(numTrees(n));
    }

    private static int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }
        else{
            int[] arr = new int[n+1];
            arr[0] = 1;
            arr[1] = 1;
            int each;
            for(int i=2;i<=n;i++){
                each = 0;
                for(int j=0;j<i;j++){
                    each += arr[j]*arr[i-1-j];
                }
                arr[i] = each;
            }
            return arr[n];
        }
    }
}
