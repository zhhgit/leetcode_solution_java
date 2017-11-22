package q060_permutation_sequence;

public class Solution1 {
    public static void main(String[] args){
        int n = 3;
        int k = 4;
        System.out.println(getPermutation(n,k));
    }

    private static boolean[] used;

    private static String getPermutation(int n, int k) {
        int[] divisorArr = getDivisorArr(n);
        used = new boolean[n];
        StringBuffer sb = new StringBuffer();
        calEachPos(sb,divisorArr,n,k,0);
        return sb.toString();
    }

    private static void calEachPos(StringBuffer sb,int[] divisorArr,int n, int k,int pos){
        if(pos >= n){
            return;
        }
        if (k<=0){
            return;
        }
        int num,remain;
        //pos位置的值是应该是((k-1)/(n-1-pos)!) + 1个未使用的数字
        if(n-2-pos >=0){
            num = ((k-1) / divisorArr[n-2-pos]) + 1;
            remain = k - (num-1) * divisorArr[n-2-pos];
        }
        else{
            num = 1;
            remain = 0;
        }
        int i = 0;
        while(num >0){
            if (!used[i]){
                num--;
            }
            i++;
        }
        used[i-1] = true;
        sb.append(i);
        calEachPos(sb,divisorArr,n,remain,++pos);
    }

    //保存阶乘，i位置保存(i+1)!
    private static int[] getDivisorArr(int n){
        int[] divisorArr = new int[n];
        divisorArr[0] = 1;
        for(int i=1;i<n;i++){
            divisorArr[i] = divisorArr[i-1] * (i+1);
        }
        return divisorArr;
    }
}
