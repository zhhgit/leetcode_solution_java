package q155_min_stack;

import java.util.LinkedList;

public class Solution1 {
    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(-1);
        obj.push(1);
        obj.push(2);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }


    private static class MinStack {
        LinkedList<Integer> list;
        LinkedList<Integer> minList;
        public MinStack() {
            list = new LinkedList<>();
            minList = new LinkedList<>();
        }

        public void push(int x) {
            list.add(x);
            if(minList.size() == 0){
                minList.add(x);
                return;
            }
            int tempMin = minList.get(minList.size()-1);
            if(x < tempMin){
                minList.add(x);
            }
            else{
                minList.add(tempMin);
            }
        }

        public void pop() {
            list.remove(list.size() - 1);
            minList.remove(minList.size() - 1);
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            return minList.get(minList.size()-1);
        }
    }
}
