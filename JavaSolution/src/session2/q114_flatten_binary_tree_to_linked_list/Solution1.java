package session2.q114_flatten_binary_tree_to_linked_list;

import session2.common.PrintUtil;
import session2.common.TreeBuilder;
import session2.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        flatten(treeBuilder.getRoot());
        PrintUtil.printTree(treeBuilder.getRoot());
    }

    private static void flatten(TreeNode root) {
        if(root != null){
            if(root.left == null){
                if(root.right != null){
                    flatten(root.right);
                }
            }
            else{
                TreeNode temp = root.right;
                flatten(root.left);
                root.right = root.left;
                root.left = null;
                TreeNode curr = root;
                while(curr.right != null){
                    curr = curr.right;
                }
                flatten(temp);
                curr.right = temp;
            }
        }
    }
}
