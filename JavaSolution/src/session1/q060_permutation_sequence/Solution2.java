package session1.q060_permutation_sequence;

public class Solution2 {
    public static void main(String[] args){
        int n = 7;
        int k = 12;
        System.out.println(getPermutation(n,k));
    }

    private static String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        boolean[] used = new boolean[n];
        backTracking(sb,n,n,k,used);
        return sb.toString();
    }

    private static void backTracking(StringBuffer sb,int n, int remain,int k,boolean[] used){
        if(remain==0){
            return;
        }
        else{
            int divisor = 1;
            for(int i=remain-1;i>=1;i--){
                divisor *=i;
            }
            int tempIndex = (k-1)/divisor;
            k = k-tempIndex*divisor;
            for(int i=0;i<n;i++){
                if(!used[i]){
                    if(tempIndex>=0){
                        if(tempIndex==0){
                            sb.append(i+1);
                            used[i] = true;
                        };
                        tempIndex--;
                    }
                }
            }
            backTracking(sb,n,remain-1,k,used);
        }
    }
}
