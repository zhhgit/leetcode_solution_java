package algorithm1.sortAndSearch;

import algorithm1.common.PrintUtil;

public class Merge {

    public static void main(String[] args) {
        int m = 0,n = 1;
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1,m,nums2,n);
        PrintUtil.printNumArray(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = n + m;
        int pos = total - 1;
        while (m > 0 && n > 0){
            if (nums1[m - 1] < nums2[n - 1]){
                nums1[pos--] = nums2[n - 1];
                n--;
            }
            else {
                nums1[pos--] = nums1[m - 1];
                m--;
            }
        }
        if (m == 0){
            while (n > 0){
                nums1[pos--] = nums2[n - 1];
                n--;
            }
        }
    }
}
