package session2.q349_intersection_of_two_arrays;

import java.util.HashSet;
import common.PrintUtil;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,3};
		int[] nums2 = {2,2,3};
		PrintUtil.printNumArray(intersection(nums1, nums2));
	}
	
	private static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> hashSet = new HashSet<>();
		for(int num:nums1) {
			hashSet.add(num);
		}
		HashSet<Integer> hashSet2 = new HashSet<>();
		for(int i=0;i<nums2.length;i++) {
			if(hashSet.contains(nums2[i])) {
				hashSet2.add(nums2[i]);
			}
		}
		int size = hashSet2.size();
		int[] result = new int[size];
		int index = 0;
		for(int num:hashSet2) {
			result[index++] = num;
		}
		return result;
    }
}
