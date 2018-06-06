package session3.q103_binary_tree_zigzag_level_order_traversal;

import session3.common.TreeBuilder;
import session3.common.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(zigzagLevelOrder(treeBuilder.getRoot()));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null){
            return lists;
        }
        List<TreeNode> prev = new LinkedList<>();
        prev.add(root);
        boolean flag = true;
        while (prev.size() > 0){
            List<Integer> addList = new LinkedList<>();
            List<TreeNode> next = new LinkedList<>();
            for(int i = prev.size() - 1;i>=0;i--){
                TreeNode node = prev.get(i);
                addList.add(node.val);
                if (flag){
                    if (node.left != null){
                        next.add(node.left);
                    }
                    if (node.right != null){
                        next.add(node.right);
                    }
                }
                else{
                    if (node.right != null){
                        next.add(node.right);
                    }
                    if (node.left != null){
                        next.add(node.left);
                    }
                }
            }
            lists.add(addList);
            flag = !flag;
            prev = next;
        }
        return lists;
    }
}
