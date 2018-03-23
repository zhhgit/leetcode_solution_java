package session2.q173_binary_search_tree_iterator;

import session2.common.TreeBuilder;
import session2.common.TreeNode;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {4,2,6,1,3,5,7};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        BSTIterator i = new BSTIterator(treeBuilder.getRoot());
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }

    public static class BSTIterator {
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushAllLeft(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            pushAllLeft(node.right);
            return node.val;
        }

        public void pushAllLeft(TreeNode root){
            if(root == null){
                return;
            }
            TreeNode curr = root;
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
        }
    }
}