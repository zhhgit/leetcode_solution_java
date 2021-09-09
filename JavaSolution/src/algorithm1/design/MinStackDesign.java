package algorithm1.design;

import java.util.*;

public class MinStackDesign {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

    private static class MinStack {

        Map<Integer,Integer> innerMap;
        List<Integer> innerStack;

        public MinStack() {
            innerMap = new HashMap<>();
            innerStack = new LinkedList<>();
        }

        public void push(int val) {
            innerStack.add(val);
            int size = innerStack.size();
            if (size == 1){
                innerMap.put(size,val);
            }
            else {
                innerMap.put(size,  Math.min(innerMap.get(size - 1),val));
            }
        }

        public void pop() {
            int size = innerStack.size();
            if (innerStack.size() > 0){
                innerStack.remove(size - 1);
                innerMap.remove(size);
            }
            else {
                innerMap.remove(size);
            }
        }

        public int top() {
            int size = innerStack.size();
            return innerStack.get(size - 1);
        }

        public int getMin() {
            int size = innerStack.size();
            return innerMap.get(size);
        }
    }
}
