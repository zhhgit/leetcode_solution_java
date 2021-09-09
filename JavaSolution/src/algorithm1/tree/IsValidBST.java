package algorithm1.tree;

import algorithm1.common.TreeBuilder;
import algorithm1.common.TreeNode;

public class IsValidBST {

    public static void main(String[] args) {
        Integer[][] numsArr = {{5,1,4,null,null,3,6},{5,4,6,null,null,3,7}};
        for (Integer[] nums: numsArr){
            TreeBuilder treeBuilder = new TreeBuilder(nums);
            System.out.println(isValidBST(treeBuilder.getRoot()));
        }
    }

    // 根节点值大于左子树所有值，小于右子树所有值，注意是所有
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTWithRange(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static boolean isValidBSTWithRange(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if (root.val >= max || root.val <= min){
            return false;
        }
        return isValidBSTWithRange(root.left, min, root.val) && isValidBSTWithRange(root.right, root.val, max);
    }
}
