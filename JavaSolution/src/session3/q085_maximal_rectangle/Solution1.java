package session3.q085_maximal_rectangle;

import session3.common.PrintUtil;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        char[][] matrix = {"10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()};
        PrintUtil.print2DCharMatrix(matrix);
        System.out.println("--------------------");
        System.out.println(maximalRectangle(matrix));
    }

    private static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        //fill right with n, no need to fill left, height since int[] is 0 by default
        Arrays.fill(right, n);
        int maxArea = 0;

        for(int i=0; i<m; i++) {
            int currLeft = 0;
            int currRight = n;

            //height是当前列连续1的高度
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                }
                else {
                    height[j] = 0;
                }
            }

            // 从当前列往左看，如果出现0，则为0，如果出现1，则为向左扩展的最大值
            // currLeft为从当前位置看，本行最左边的1的列号
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                }
                else {
                    left[j] = 0;
                    currLeft = j+1;
                }
            }

            // 从当前列往右看，如果出现0，则为n，如果出现1，则为向右扩展的最小值
            // currRight为从当前位置看，本行最右侧的i的列号
            for(int j=n-1; j>=0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                }
                else {
                    right[j] = n;
                    currRight = j;
                }
            }

            // 计算面积
            for(int j=0; j<n; j++) {
                maxArea = Math.max(maxArea, (right[j]-left[j])*height[j]);
            }
        }

        return maxArea;
    }
}
