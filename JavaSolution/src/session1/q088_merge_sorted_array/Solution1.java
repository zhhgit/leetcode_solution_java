package session1.q088_merge_sorted_array;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] num1 = {1,3,6,7};
        int m = num1.length;
        int[] num2 = {4,5};
        int n = num2.length;
        merge(num1,m,num2,n);
        System.out.println(num1.length);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int i = 0,j = 0;
        int size;
        while((i < m) && (j < n)){
            if(nums1[i] <= nums2[j]){
                al.add(nums1[i++]);
            }
            else{
                al.add(nums2[j++]);
            }
        }
        if(i == m){
            while(j<n){
                al.add(nums2[j]);
                j++;
            }
        }
        else if(j == n){
            while(i<m){
                al.add(nums1[i]);
                i++;
            }
        }
        size = al.size();
        for(i = 0;i<size;i++){
            nums1[i] = al.get(i);
        }
    }
}
