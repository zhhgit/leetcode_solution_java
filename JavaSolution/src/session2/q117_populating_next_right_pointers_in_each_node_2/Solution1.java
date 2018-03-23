package session2.q117_populating_next_right_pointers_in_each_node_2;

import common.TreeLinkNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        List<TreeLinkNode> nextList;
        List<TreeLinkNode> currList = new LinkedList<>();
        currList.add(root);
        while(currList.size() > 0){
            nextList = new LinkedList<>();
            for(int i = 0;i<currList.size();i++){
                TreeLinkNode node = currList.get(i);
                if(node.left != null){
                    nextList.add(node.left);
                }
                if(node.right != null){
                    nextList.add(node.right);
                }
                if(currList.size() - 1 != i){
                    node.next = currList.get(i+1);
                }
                else{
                    node.next = null;
                }
            }
            currList = new LinkedList<>(nextList);
        }
    }
}
