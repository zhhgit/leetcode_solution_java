package session3.q060_permutation_sequence;

public class Solution1 {
    public static void main(String[] args){
        int[] nArr = {3,4};
        int[] kArr = {3,9};
        for(int i = 0;i<nArr.length;i++){
            System.out.println(getPermutation(nArr[i],kArr[i]));
        }
    }

    private static String getPermutation(int n, int k) {
        boolean[] visit = new boolean[n];
        int[] nArr = getNArr(n);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<n;i++){
            if(i != n-1){
                int dividend = nArr[n-2-i];
                int pos = (k - 1) / dividend;
                k = k - (pos * dividend);
                stringBuilder.append(getNumInVisit(visit,pos+1));
            }
            else{
                stringBuilder.append(getNumInVisit(visit,1));
            }
        }
        return stringBuilder.toString();
    }

    private static int[] getNArr(int n){
        int[] result = new int[n];
        int index = 1;
        result[0] = index;
        for(int i = 1;i<n;i++){
            index++;
            result[i] = index * result[i-1];
        }
        return result;
    }

    private static int getNumInVisit(boolean[] visit,int pos){
        int len = visit.length;
        int count = 0;
        for(int i = 0;i<len;i++){
            if(!visit[i]){
                count++;
                if(pos == count){
                    visit[i] = true;
                    return (i+1);
                }
            }
        }
        return 0;
    }
}
