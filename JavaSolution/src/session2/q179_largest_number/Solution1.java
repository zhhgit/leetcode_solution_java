package session2.q179_largest_number;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        System.out.println(largestNumber(nums));
    }

    private static String largestNumber(int[] nums) {
        List<Integer> numsList = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            numsList.add(nums[i]);
        }
        sortNums(numsList);
        return getRetStr(numsList);
    }

    private static void sortNums(List<Integer> list){
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "";
                String str2 = o2 + "";
                String case1 = str1 + str2;
                String case2 = str2 + str1;
                return case2.compareTo(case1);
            }
        });
    }

    private static String getRetStr(List<Integer> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<list.size();i++){
            stringBuilder.append(list.get(i));
        }
        return trimHeadZero(stringBuilder.toString());
    }

    private static String trimHeadZero(String str){
        int i= 0;
        while (i<str.length() && str.charAt(i) == '0'){
            i++;
        }
        if(i == str.length()){
            return "0";
        }
        else{
            return str.substring(i);
        }
    }
}
