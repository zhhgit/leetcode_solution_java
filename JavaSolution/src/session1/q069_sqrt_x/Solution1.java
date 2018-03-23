package session1.q069_sqrt_x;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {0,1,2,4,5,232323,2147483647};
        for(int i=0;i<arr.length;i++){
            System.out.println(mySqrt(arr[i]));
        }
    }

    private static int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        else{
            int left = 1;
            int right = x;
            while(left<right){
                int mid = (left+right+1)/2;
                if(mid>x/mid){
                    right = mid-1;
                }
                else{
                    if((mid+1)>x/(mid+1)){
                        return mid;
                    }
                    else{
                        left = mid;
                    }
                }
            }
            return left;
        }
    }
}
