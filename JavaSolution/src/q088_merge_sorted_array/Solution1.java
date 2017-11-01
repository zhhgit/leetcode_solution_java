package q088_merge_sorted_array;

import java.util.LinkedList;

public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = new int[100];
        int[] nums2 = new int[100];
        int[] intArr1 = {1};
        int[] intArr2 = {2};
        for(int i=0;i<intArr1.length;i++){
            nums1[i] = intArr1[i];
        }
        for(int i=0;i<intArr2.length;i++){
            nums2[i] = intArr2[i];
        }
        merge(nums1,intArr1.length,nums2,intArr2.length);
        for(int num:nums1){
            System.out.println(num);
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        //考虑特殊情况
        if(m == 0){
            for(int i = 0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        else if(n == 0){
            return;
        }
        //非特殊情况
        LinkedList<Integer> linkedList = new LinkedList<>();
        int pointer1 = 0, pointer2 = 0;
        while(pointer1 < m && pointer2 < n){
            if(nums1[pointer1] < nums2[pointer2]){
                linkedList.add(nums1[pointer1++]);
            }
            else{
                linkedList.add(nums2[pointer2++]);
            }
        }
        if(pointer1 == m){
            while (pointer2 < n){
                linkedList.add(nums2[pointer2++]);
            }
        }
        else{
            while (pointer1 < m){
                linkedList.add(nums1[pointer1++]);
            }
        }
        for(int i=0;i<m+n;i++){
            nums1[i] = linkedList.get(i);
        }
    }
}