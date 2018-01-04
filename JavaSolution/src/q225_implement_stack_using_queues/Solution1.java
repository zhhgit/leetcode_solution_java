package q225_implement_stack_using_queues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args){
        MyStack obj = new MyStack();
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }

    static class MyStack {

        public Queue<Integer> queue1;
        public Queue<Integer> queue2;
        public List<Integer> topList;

        /** Initialize your data structure here. */
        public MyStack() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
            this.topList = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if(queue1.isEmpty()){
                queue2.add(x);
            }
            else{
                queue1.add(x);
            }
            topList.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Queue<Integer> target,another;
            if(queue1.isEmpty()){
                target = queue2;
                another = queue1;
            }
            else{
                target = queue1;
                another = queue2;
            }
            topList.remove(topList.size()-1);
            while(target.size() > 1){
                int curr = target.poll();
                another.add(curr);
            }
            return target.poll();
        }

        /** Get the top element. */
        public int top() {
            return topList.get(topList.size()-1);
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}
