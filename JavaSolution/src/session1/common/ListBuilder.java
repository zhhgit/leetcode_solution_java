package session1.common;

import java.util.*;

public class ListBuilder {
    public List<ListNode> nodeList = null;
    public void createList(int[] nums){
        nodeList = new LinkedList<ListNode>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            nodeList.add(new ListNode(nums[i]));
        }
        for(int i=0;i<len - 1;i++){
            nodeList.get(i).next = nodeList.get(i+1);
        }
        nodeList.get(len-1).next = null;
    }
}
