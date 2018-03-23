package session2.q138_copy_list_with_random_pointer;

import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args){

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> hashMap = new HashMap<>();
        RandomListNode fakeHead = new RandomListNode(0);
        RandomListNode tail = fakeHead;
        RandomListNode curr = head;
        while (curr != null){
            RandomListNode addNode = new RandomListNode(curr.label);
            hashMap.put(curr,addNode);
            tail.next = addNode;
            tail = tail.next;
            curr = curr.next;
        }
        for(RandomListNode node: hashMap.keySet()){
            RandomListNode target = node.random;
            if(target != null){
                hashMap.get(node).random = hashMap.get(target);
            }
        }
        return fakeHead.next;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    };
}
