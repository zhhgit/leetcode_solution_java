package session1.q056_merge_intervals;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        List<Interval> intervals = new LinkedList<>();
        List<Interval> ret = new LinkedList<>();
        int[] arr = {1,3,2,6,8,10,15,18};
        if(arr.length%2==1){
            System.out.println("非偶数");
        }
        else{
            for(int i=0;i<arr.length;i+=2){
                Interval insert = new Interval(arr[i],arr[i+1]);
                intervals.add(insert);
            }
            ret = merge(intervals);
            System.out.println("finished");
        }
    }

    private static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new LinkedList<>();
        if(intervals.size()==0){
            return list;
        }
        else{
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return Integer.compare(o1.start,o2.start);
                }
            });

            int start = intervals.get(0).start;
            int end = intervals.get(0).end;
            for(Interval inter:intervals){
                if(inter.start<=end){
                    end = Math.max(end,inter.end);
                }
                else{
                    Interval insert = new Interval(start,end);
                    list.add(insert);
                    start = inter.start;
                    end = inter.end;
                }
            }
            list.add(new Interval(start,end));
            return list;
        }
    }
}
