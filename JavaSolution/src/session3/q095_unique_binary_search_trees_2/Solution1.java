package session3.q095_unique_binary_search_trees_2;

import session3.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 3;
        List<TreeNode> list = generateTrees(n);
        System.out.println(list);
    }

    private static List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new LinkedList<>();
        if (n == 0){
            return list;
        }
        return generateTreesWithRange(1,n);
    }

    private static List<TreeNode> generateTreesWithRange(int start,int end) {
        List<TreeNode> list = new LinkedList<>();
        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        for(int i = start;i <= end; i++){
            if(i == start){
                List<TreeNode> rightList = generateTreesWithRange(start+1,end);
                for(int j = 0;j<rightList.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.right = rightList.get(j);
                    if(!list.contains(root)){
                        list.add(root);
                    }
                }
            }
            else if(i == end){
                List<TreeNode> leftList = generateTreesWithRange(start,end-1);
                for(int j = 0;j<leftList.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    if(!list.contains(root)){
                        list.add(root);
                    }
                }
            }
            else{
                List<TreeNode> leftList = generateTreesWithRange(start,i-1);
                List<TreeNode> rightList = generateTreesWithRange(i+1,end);
                for(int j = 0;j<leftList.size();j++){
                    for(int k = 0;k<rightList.size();k++){
                        TreeNode root = new TreeNode(i);
                        root.left = leftList.get(j);
                        root.right = rightList.get(k);
                        if(!list.contains(root)){
                            list.add(root);
                        }
                    }
                }
            }
        }
        return list;
    }
}
