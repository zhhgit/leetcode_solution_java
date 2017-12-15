package q191_number_of_1_bits;

public class Solution1 {
    public static void main(String[] args){
        int n = 11;
        System.out.println(hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        long longN = (long) n;
        long comb = 1;
        int count = 0;
        for(int i=0;i<32;i++){
            long eachVal = comb & longN;
            if(eachVal > 0){
                count++;
            }
            comb = comb << 1;
        }
        return count;
    }
}
