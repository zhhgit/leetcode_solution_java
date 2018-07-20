package session3.q155_min_stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private static class MinStack {

        List<Integer> stack;
        Map<Integer,Integer> map;

        public MinStack() {
            stack = new LinkedList<>();
            map = new HashMap<>();
        }

        public void push(int x) {
            if (stack.size() == 0){
                map.put(1,x);
            }
            else{
                int currSize = stack.size();
                map.put(currSize + 1,Math.min(x,map.get(currSize)));
            }
            stack.add(x);
        }

        public void pop() {
            int currSize = stack.size();
            stack.remove(stack.size() - 1);
            map.remove(currSize);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            int size = stack.size();
            return map.get(size);
        }
    }
}
