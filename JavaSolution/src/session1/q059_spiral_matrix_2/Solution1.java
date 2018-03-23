package session1.q059_spiral_matrix_2;

public class Solution1 {
    public static void main(String[] args){
        int n=5;
        int[][] ret = new int[n][n];
        ret = generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ret[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        if(n>=1){
            backTracking(ret,1,n);
        }
        return ret;
    }

    private static void backTracking(int[][] ret,int index,int remainDimen){
        int n = ret.length;
        int halfExt = (n-remainDimen)/2;
        if(remainDimen==0){
            return;
        }
        else if(remainDimen==1){
            ret[n/2][n/2] = index++;
            return;
        }
        else{
            for(int j=halfExt;j<remainDimen+halfExt;j++){
                ret[halfExt][j] = index++;
            }
            for(int i=halfExt+1;i<remainDimen+halfExt;i++){
                ret[i][n-halfExt-1] = index++;
            }
            for(int j=n-halfExt-2;j>=halfExt;j--){
                ret[n-halfExt-1][j] = index++;
            }
            for(int i=n-halfExt-2;i>=halfExt+1;i--){
                ret[i][halfExt] = index++;
            }
            backTracking(ret,index,remainDimen-2);
        }
    }
}
