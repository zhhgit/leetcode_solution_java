package session2.q204_count_primes;

public class Solution1 {
    public static void main(String[] args){
        int n = 1500000;
        System.out.println(countPrimes(n));
    }

    private static int countPrimes(int n) {
        int count = 0;
        //假设所有都是prime
        boolean[] notPrime = new boolean[n];
        for(int i = 2;i<n;i++){
            //如果不是非prime，也就是prime
            if(!notPrime[i]){
                count++;
                for(int j = 2;j*i<n;j++){
                    notPrime[j*i] = true;
                }
            }
        }
        return count;
    }
}
