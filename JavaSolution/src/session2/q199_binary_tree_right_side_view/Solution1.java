package session2.q199_binary_tree_right_side_view;

import session2.common.TreeBuilder;
import session2.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(rightSideView(treeBuilder.getRoot()));
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        List<TreeNode> levelList = new LinkedList<>();
        List<TreeNode> nextLevelList;
        if(root == null){
            return list;
        }
        levelList.add(root);
        while (levelList.size() != 0){
            nextLevelList = new LinkedList<>();
            for(int i = 0;i<levelList.size();i++){
                TreeNode curr = levelList.get(i);
                if(curr.left != null){
                    nextLevelList.add(curr.left);
                }
                if(curr.right != null){
                    nextLevelList.add(curr.right);
                }
                if(i == levelList.size()-1){
                    list.add(curr.val);
                }
            }
            levelList = nextLevelList;
        }
        return list;
    }
}
