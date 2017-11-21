package q056_merge_intervals;

import java.util.*;

public class Solution1 {
    private static class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args){
        int[] positions = {15,18,2,6,8,10,1,3};
        List<Interval> intervals = new LinkedList<>();
        for(int i=0;i<positions.length-1;i = i+2){
            intervals.add(new Interval(positions[i],positions[i+1]));
        }
        for(int i=0;i<intervals.size();i++){
            printInterval(intervals.get(i));
            System.out.println();
        }
        System.out.println("----------------");
        List<Interval> result = merge(intervals);
        for(int i=0;i<result.size();i++){
            printInterval(result.get(i));
            System.out.println();
        }
    }

    private static void printInterval(Interval i){
        System.out.print("<");
        System.out.print(i.start);
        System.out.print(",");
        System.out.print(i.end);
        System.out.print(">");
    }

    private static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new LinkedList<>();
        int size = intervals.size();
        if(size == 0){
            return list;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval temp = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            int relation = judgeRelation(temp,intervals.get(i));
            if(relation == 0){
                list.add(temp);
                temp = intervals.get(i);
            }
            else if(relation == 1){
                temp = new Interval(temp.start,intervals.get(i).end);
            }
            else{
            }
        }
        list.add(temp);
        return list;
    }

    //o2的start一定大于o1的start，0,1,2分别代表o2与o1分离，相交，在其中
    private static int judgeRelation(Interval o1,Interval o2){
        if(o2.start > o1.end){
            return 0;
        }
        else{
            if(o2.end <= o1.end){
                return 2;
            }
            else{
                return 1;
            }
        }
    }
}
