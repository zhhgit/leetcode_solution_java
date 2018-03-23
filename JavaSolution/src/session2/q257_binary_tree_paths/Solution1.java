package session2.q257_binary_tree_paths;

import common.TreeBuilder;
import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        TreeBuilder treeBuilder = new TreeBuilder(nums);
        System.out.println(binaryTreePaths(treeBuilder.getRoot()));
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new LinkedList<>();
        if(root == null){
            return ret;
        }
        List<List<TreeNode>> lists = new LinkedList<>();
        List<TreeNode> tempList = new LinkedList<>();
        tempList.add(root);
        backTracking(root,lists,tempList);
        for(int i = 0;i<lists.size();i++){
            ret.add(listToString(lists.get(i)));
        }
        return ret;
    }

    private static void backTracking(TreeNode root,List<List<TreeNode>> lists,List<TreeNode> tempList){
        if(root.left == null && root.right == null){
            List<TreeNode> addList = new LinkedList<>(tempList);
            lists.add(addList);
        }
        else{
            if(root.left != null){
                tempList.add(root.left);
                backTracking(root.left,lists,tempList);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size()-1);
                }
            }
            if(root.right != null){
                tempList.add(root.right);
                backTracking(root.right,lists,tempList);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    private static String listToString(List<TreeNode> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<list.size();i++){
            stringBuilder.append(list.get(i).val);
            if(i != list.size()-1){
                stringBuilder.append("->");
            }
        }
        return stringBuilder.toString();
    }
}
