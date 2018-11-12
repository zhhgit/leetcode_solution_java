package session3.q149_max_points_on_a_line;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[][] board = {{1,1},{1,1},{1,1}};
        Point[] points = new Point[board.length];
        for (int i = 0;i<board.length;i++){
            points[i] = new Point(board[i][0],board[i][1]);
        }
        System.out.println(maxPoints(points));
    }

    private static int maxPoints(Point[] points) {
        if (points.length <= 2){
            return points.length;
        }
        int result = 1;
        Map<String,Integer> map = new HashMap<>();
        // 分别以每个节点为起点发散
        for (int i = 0;i<points.length;i++){
            int max = 0;
            int overlap = 0;
            map.clear();
            for (int j = i + 1;j<points.length;j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0){
                    overlap++;
                    // 注意结束当前次循环
                    continue;
                }
                int gcd = getGCD(x,y);
                if (gcd != 0){
                    x /= gcd;
                    y /= gcd;
                }
                // 取已经互质的x,y拼接字符串代表斜率
                String key = x + "&" + y;
                if (map.containsKey(key)){
                    map.put(key,map.get(key) + 1);
                }
                else {
                    map.put(key,1);
                }
                // max为以point[i]为起点的发散线，斜率相等的直线条数最大值
                max = Math.max(max,map.get(key));
            }
            // 斜率相等的直线条数最大值 + 重合点 + 发散点本身
            result = Math.max(result,max + overlap + 1);
        }
        return result;
    }

    // 辗转相除法求最大公约数
    private static int getGCD(int a, int b){
        if (b == 0){
            return a;
        }
        return getGCD(b,a%b);
    }

    private static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

}
