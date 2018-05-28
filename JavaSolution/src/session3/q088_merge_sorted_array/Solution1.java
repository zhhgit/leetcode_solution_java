package session3.q088_merge_sorted_array;

import session3.common.PrintUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        PrintUtil.printNumArray(nums1);
        merge(nums1,m,nums2,n);
        System.out.println("------------------------");
        PrintUtil.printNumArray(nums1);
    }
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i<m;i++){
            list.add(nums1[i]);
        }
        for(int i = 0;i<n;i++){
            list.add(nums2[i]);
        }
        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i = 0;i<m + n;i++){
            nums1[i] = list.get(i);
        }
    }
}
