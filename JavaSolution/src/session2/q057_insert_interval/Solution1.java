package session2.q057_insert_interval;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,5,6,7,8,10,12,16};
        List<Interval> intervals = new LinkedList<>();
        for(int i = 0;i<nums.length / 2;i++){
            intervals.add(new Interval(nums[2*i],nums[2*i+1]));
        }
        Interval newInteval = new Interval(4,9);
        printIntervals(insert(intervals,newInteval));
    }

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new LinkedList<>();
        int i = 0;
        //newInteval的start大于intevals.get(i)的end，一定不相交，
        while (i<intervals.size() && newInterval.start > intervals.get(i).end){
            list.add(intervals.get(i));
            i++;
        }
        //相交的intervals,不断更新
        while (i<intervals.size() && newInterval.end >= intervals.get(i).start){
            int start = Math.min(newInterval.start,intervals.get(i).start);
            int end = Math.max(newInterval.end,intervals.get(i).end);
            newInterval = new Interval(start,end);
            i++;
        }
        list.add(newInterval);
        //最后的一定不相交的
        while (i < intervals.size()){
            list.add(intervals.get(i));
            i++;
        }
        return list;
    }

    private static void printIntervals(List<Interval> intervals){
        for(int i=0;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            System.out.println("<"+ curr.start + "," + curr.end + ">");
        }
    }
}
