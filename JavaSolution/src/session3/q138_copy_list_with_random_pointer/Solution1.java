package session3.q138_copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode fakeHead = new RandomListNode(0);
        RandomListNode addCurr = fakeHead;
        RandomListNode curr = head;
        while (curr != null){
            addCurr.next = new RandomListNode(curr.label);
            addCurr = addCurr.next;
            map.put(curr,addCurr);
            curr = curr.next;
        }
        for (RandomListNode key:map.keySet()){
            if (key.random != null){
                RandomListNode from = map.get(key);
                from.random = map.get(key.random);
            }
        }
        return fakeHead.next;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };


}
