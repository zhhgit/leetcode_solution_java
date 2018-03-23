package session2.q350_intersection_of_two_arrays_2;

import java.util.HashMap;
import java.util.Map;

import session2.common.PrintUtil;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		PrintUtil.printNumArray(intersect(nums1,nums2));
	}
	
    private static int[] intersect(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> hMap = new HashMap<>();
    	for(int i=0;i<nums1.length;i++) {
    		int key = nums1[i];
    		if(!hMap.containsKey(key)) {
    			hMap.put(key, 1);
    		}
    		else {
    			hMap.put(key, hMap.get(key)+1);
    		}
    	}
    	Map<Integer, Integer> resultMap = new HashMap<>();
    	int count = 0;
    	for(int i=0;i<nums2.length;i++) {
    		int key = nums2[i];
    		if(hMap.containsKey(key)) {
    			if(!resultMap.containsKey(key)) {
    				resultMap.put(key, 1);
    				count++;
    			}
    			else if(resultMap.get(key) < hMap.get(key)) {
    				resultMap.put(key, resultMap.get(key) + 1);
    				count++;
    			}
    		}
    		
    	}
    	return mapToArray(resultMap,count);
    }
    
    private static int[] mapToArray(Map<Integer,Integer> map,int count) {
    	int[] ret = new int[count];
    	int index = 0;
    	for(int key:map.keySet()) {
    		int num = map.get(key);
    		for(int i=0;i<num;i++) {
    			ret[index++] = key;
    		}
    	}
    	return ret;
    }
}
