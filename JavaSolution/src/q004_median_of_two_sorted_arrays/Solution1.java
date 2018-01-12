package q004_median_of_two_sorted_arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = {};
        int[] nums2 = {2,3};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numsShort,numsLong;
        if(nums1.length > nums2.length){
            numsShort = nums2;
            numsLong = nums1;
        }
        else{
            numsShort = nums1;
            numsLong = nums2;
        }
        int m = numsShort.length;
        int n = numsLong.length;
        if(m == 0){
            return directMedian(numsLong);
        }
        else {
            int left = 0;
            int right = m;
            while(left < right){
                int i = (left + right) / 2;
                int j = (m + n) / 2 - i;
                if(i == 0){
                    //找到符合的
                    if(numsLong[j-1] <= numsShort[i]){
                        return calMedian(numsShort,numsLong,i,j);
                    }
                    else{
                        left++;
                    }
                }
                else if(i == m){
                    //找到符合的
                    if(numsShort[i-1] <= numsLong[j]){
                        return calMedian(numsShort,numsLong,i,j);
                    }
                    else{
                        right--;
                    }
                }
                else {
                    //找到符合的
                    if(numsLong[j-1] <= numsShort[i] && numsShort[i-1] <= numsLong[j]){
                        return calMedian(numsShort,numsLong,i,j);
                    }
                    else if(numsShort[i-1] > numsLong[j]){
                        right = i-1;
                    }
                    else if(numsLong[j-1] > numsShort[i]){
                        left = i+1;
                    }
                }
            }
            int i = left;
            int j = (m + n) / 2 - i;
            return calMedian(numsShort,numsLong,i,j);
        }
    }

    private static double calMedian(int[] nums1,int[] nums2,int i,int j){
        int m = nums1.length;
        int n = nums2.length;
        int leftMax,rightMin;
        if(i == 0){
            leftMax = nums2[j-1];
        }
        else if(j == 0){
            leftMax = nums1[i-1];
        }
        else{
            leftMax = Math.max(nums1[i-1],nums2[j-1]);
        }
        if(i == m){
            rightMin = nums2[j];
        }
        else if(j == n){
            rightMin = nums1[i];
        }
        else{
            rightMin = Math.min(nums1[i],nums2[j]);
        }
        //总个数为奇数，返回单个的数字，也就是右侧最小值
        if((m+n) % 2 == 1){
            return (double) rightMin;
        }
        //总个数为偶数，返回左侧最大与右侧最小的平均值
        else{
            return ((double) (leftMax + rightMin)) / 2;
        }
    }

    private static double directMedian(int[] nums){
        int len = nums.length;
        //奇数
        if(len % 2 == 1){
            return (double) nums[len / 2];
        }
        //偶数
        else{
            return (double) (nums[len / 2] + nums[(len-1) / 2]) / 2;
        }
    }
}
