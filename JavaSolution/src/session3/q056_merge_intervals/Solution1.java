package session3.q056_merge_intervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[][] intervalsArr = {{1,3},{2,6},{8,10},{15,18}};
        List<Interval> list = new LinkedList<>();
        for(int i = 0;i<intervalsArr.length;i++){
            list.add(new Interval(intervalsArr[i][0],intervalsArr[i][1]));
        }
        for(int i = 0;i<list.size();i++){
            printInterval(list.get(i));
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("-----------------------");
        List<Interval> result = merge(list);
        for(int i = 0;i<result.size();i++){
            printInterval(result.get(i));
            System.out.print(" ");
        }
    }

    private static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        int len = intervals.size();
        if(len == 0){
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval temp = intervals.get(0);
        for(int i = 1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(!canMerge(temp,curr)){
                result.add(temp);
                temp = curr;
            }
            else{
                temp = mergeTwo(temp,curr);
            }
        }
        result.add(temp);
        return result;
    }

    private static boolean canMerge(Interval interval1,Interval interval2){
        return !(interval2.start > interval1.end);
    }

    private static Interval mergeTwo(Interval interval1,Interval interval2){
        if(interval2.end <= interval1.end){
            return interval1;
        }
        else{
            return new Interval(interval1.start,interval2.end);
        }
    }

    private static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    private static void printInterval(Interval interval){
        System.out.print("[" + interval.start + "," + interval.end + "]");
    }
}
