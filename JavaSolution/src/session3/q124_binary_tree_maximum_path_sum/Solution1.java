package session3.q124_binary_tree_maximum_path_sum;

import session3.common.TreeBuilder;
import session3.common.TreeNode;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {2,1,3};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(maxPathSum(treeBuilder.getRoot()));
    }

    private static int maxValue;

    private static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    // 以输入节点为父节点的单条路径的最大值（不能左右子树的路径都包括，这样就分叉了），递归更新maxValue，返回值为可以作为其父节点的子节点的最大值
    private static int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        // 更新maxValue
        maxValue = Math.max(maxValue, left + right + node.val);
        // 重要：注意这里的返回值，取左右子树其中一条路径，而不是左右节点之和，不然会分叉就不是一条路径了
        return Math.max(left, right) + node.val;
    }
}
