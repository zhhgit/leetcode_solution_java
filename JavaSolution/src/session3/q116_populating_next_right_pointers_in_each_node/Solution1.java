package session3.q116_populating_next_right_pointers_in_each_node;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        List<TreeLinkNode> prev = new LinkedList<>();
        prev.add(root);
        while (prev.size() > 0 ){
            int size = prev.size();
            for(int i = 0;i<size - 1;i++){
                prev.get(i).next = prev.get(i+1);
            }
            List<TreeLinkNode> next = new LinkedList<>();
            for(int i = 0;i<size;i++){
                TreeLinkNode node = prev.get(i);
                if(node.left != null){
                    next.add(node.left);
                }
                if(node.right != null){
                    next.add(node.right);
                }
            }
            prev = next;
        }
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
