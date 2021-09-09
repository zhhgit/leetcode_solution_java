package algorithm1.other;

public class HammingWeight {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int temp = 1;
        int ret = 0;
        for (int i = 0;i < 32;i++ ){
            if ((n & (temp << i)) != 0){
                ret++;
            }
        }
        return ret;
    }
}
