package q190_reverse_bits;

public class Solution1 {
    public static void main(String[] args){
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    private static int reverseBits(int n) {
        long longN = (long) n;
        long comb = 1;
        int ret = 0;
        long dividend = 1;
        for(int i=0;i<31;i++){
            dividend = dividend * 2;
        }
        for(int i=0;i<32;i++){
            long current = longN & comb;
            if(current != 0){
                ret += dividend / current;
            }
            comb = comb << 1;
        }
        return ret;
    }
}
