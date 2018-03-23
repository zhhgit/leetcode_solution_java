package session1.q103_binary_tree_zigzag_level_order_traversal;

import session1.common.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb = new TreeBuilder();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        tb.createBinTree(arr);
        TreeNode root = tb.nodeList.get(0);
        System.out.println(zigzagLevelOrder(root));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        List<TreeNode> prev,curr;
        boolean direction = true;
        if(root != null){
            prev = new LinkedList<>();
            curr = new LinkedList<>();
            curr.add(root);
            while(curr.size()!=0){
                List<Integer> insert = new LinkedList<>();
                if(direction){
                    for(int i = 0;i<curr.size();i++){
                        insert.add(curr.get(i).val);
                    }
                }
                else{
                    for(int i = curr.size()-1;i>=0;i--){
                        insert.add(curr.get(i).val);
                    }
                }
                direction = !direction;
                list.add(insert);
                prev = curr;
                curr = new LinkedList<>();
                for(TreeNode node:prev){
                    if(node.left!=null){
                        curr.add(node.left);
                    }
                    if(node.right !=null){
                        curr.add(node.right);
                    }
                }
            }
        }
        return list;
    }
}
