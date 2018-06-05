package session3.q107_binary_tree_level_order_traversal_2;

import session3.common.TreeBuilder;
import session3.common.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(levelOrderBottom(treeBuilder.getRoot()));
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }
        List<TreeNode> prev = new LinkedList<>();
        prev.add(root);
        while (prev.size() > 0){
            List<TreeNode> next = new LinkedList<>();
            List<Integer> addList = new LinkedList<>();
            int size = prev.size();
            for(int i = 0;i<size;i++){
                TreeNode node = prev.get(i);
                addList.add(node.val);
                if(node.left != null){
                    next.add(node.left);
                }
                if(node.right != null){
                    next.add(node.right);
                }
            }
            lists.add(addList);
            prev = next;
        }
        return reverseList(lists);
    }

    private static List<List<Integer>> reverseList(List<List<Integer>> lists){
        List<List<Integer>> ret = new LinkedList<>();
        int size = lists.size();
        for(int i = size -1;i>=0;i--){
            ret.add(lists.get(i));
        }
        return ret;
    }
}
