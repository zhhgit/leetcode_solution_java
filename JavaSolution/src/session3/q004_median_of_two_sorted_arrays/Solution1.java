package session3.q004_median_of_two_sorted_arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2,5,6};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arrLong,arrShort;
        if (len1 < len2){
            arrLong = nums2;
            arrShort = nums1;
        }
        else {
            arrLong = nums1;
            arrShort = nums2;
        }
        int m = arrShort.length;
        int n = arrLong.length;
        if(m == 0){
            return directMedian(arrLong);
        }
        // 短数组长度为m,切割点为i,左侧i个数字[0,i-1],右侧m-i个数字[i,m-1]
        // 长数组长度为n,切割点为j,左侧j个数字[0,j-1],右侧n-j个数字[j,n-1]
        // 应该满足i + j == (m + n + 1) / 2，奇数时候左侧比右侧长1，偶数时左右两侧相等
        int left = 0;
        // 注意right的取值不是m-1，而是m,因为i的概念其实是左侧数字的个数
        int right = m;
        int i,j;
        while (left < right){
            i = (left + right) / 2;
            j = (m + n + 1) / 2 - i;
            if (i == 0){
                //找到符合的
                if(arrLong[j-1] <= arrShort[i]){
                    return calMedian(arrShort,arrLong,i,j);
                }
                else{
                    left++;
                }
            }
            else if (i == m){
                //找到符合的
                if(arrShort[i-1] <= arrLong[j]){
                    return calMedian(arrShort,arrLong,i,j);
                }
                else{
                    right--;
                }
            }
            else {
                if (arrShort[i-1] <= arrLong[j] && arrLong[j-1] <= arrShort[i]){
                    return calMedian(arrShort,arrLong,i,j);
                }
                else if (arrShort[i-1] > arrLong[j]){
                    right = i - 1;
                }
                else {
                    left = i + 1;
                }
            }
        }
        i = left;
        j = (m + n + 1) / 2 - i;
        return calMedian(arrShort,arrLong,i,j);
    }

    // 找到i,j，计算平均值
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
        //总个数为奇数，返回单个的数字，也就是左侧最大值（跟j = (m + n + 1) / 2的计算方法有关）
        if((m+n) % 2 == 1){
            return (double) leftMax;
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
