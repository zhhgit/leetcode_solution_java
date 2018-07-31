package session3.q057_insert_interval;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        List<Interval> intervals = new LinkedList<>();
        Interval newInterval = new Interval(2,5);
        int[] arr = {1,3,6,9};
        for (int i = 0;i<arr.length;i+=2){
            intervals.add(new Interval(arr[i],arr[i + 1]));
        }
        printIntervalList(intervals);
        System.out.println();
        System.out.println("----------------");
        printIntervalList(insert(intervals,newInterval));
    }

    private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new LinkedList<>();
        Interval curr = newInterval;
        for (int i = 0;i<intervals.size();i++){
            if (!canMerge(curr,intervals.get(i))){
                if (curr.start <= intervals.get(i).start){
                    ret.add(curr);
                    curr = intervals.get(i);
                }
                else {
                    ret.add(intervals.get(i));
                }
            }
            else {
                curr = getMergeResult(curr,intervals.get(i));
            }
        }
        ret.add(curr);
        return ret;
    }

    private static boolean canMerge(Interval interval1,Interval interval2){
        Interval newInterval1,newInterval2;
        if (interval1.start <= interval2.start){
            newInterval1 = interval1;
            newInterval2 = interval2;
        }
        else{
            newInterval1 = interval2;
            newInterval2 = interval1;
        }
        return !(newInterval2.start > newInterval1.end);
    }

    private static Interval getMergeResult(Interval interval1,Interval interval2){
        Interval newInterval1,newInterval2;
        if (interval1.start <= interval2.start){
            newInterval1 = interval1;
            newInterval2 = interval2;
        }
        else{
            newInterval1 = interval2;
            newInterval2 = interval1;
        }
        if (newInterval2.end <= newInterval1.end){
            return newInterval1;
        }
        else {
            return new Interval(newInterval1.start,newInterval2.end);
        }
    }

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private static void printIntervalList(List<Interval> list){
        for (int i = 0;i<list.size();i++){
            Interval interval = list.get(i);
            System.out.print("<" + interval.start + "," + interval.end + "> ");
        }
    }
}
