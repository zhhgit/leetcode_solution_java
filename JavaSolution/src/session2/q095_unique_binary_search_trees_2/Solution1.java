package session2.q095_unique_binary_search_trees_2;

import common.PrintUtil;
import common.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 3;
        List<TreeNode> list = generateTrees(n);
        System.out.println(list.size());
        System.out.println("------------------");
        for(int i=0;i<list.size();i++){
            PrintUtil.printTree(list.get(i));
            System.out.println("------------------");
        }
    }

    private static List<TreeNode> generateTrees(int n) {
        return generateTreeWithRange(1,n);
    }

    private static List<TreeNode> generateTreeWithRange(int left,int right){
        List<TreeNode> list = new LinkedList<>();
        if(left> right){
            return list;
        }
        if(left == right){
            list.add(new TreeNode(right));
            return list;
        }
        for(int i=left;i<=right;i++){
            List<TreeNode> listLeft = generateTreeWithRange(left,i-1);
            List<TreeNode> listRight = generateTreeWithRange(i+1,right);
            if(listLeft.size() != 0 && listRight.size() != 0){
                for(int j=0;j<listLeft.size();j++){
                    for(int k=0;k<listRight.size();k++){
                        TreeNode root = new TreeNode(i);
                        root.left = listLeft.get(j);
                        root.right = listRight.get(k);
                        if(!list.contains(root)){
                            list.add(root);
                        }
                    }
                }
            }
            else if(listLeft.size() != 0 && listRight.size() == 0){
                for(int j=0;j<listLeft.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.left = listLeft.get(j);
                    if(!list.contains(root)){
                        list.add(root);
                    }
                }
            }
            else if(listLeft.size() == 0 && listRight.size() != 0){
                for(int k=0;k<listRight.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.right = listRight.get(k);
                    if(!list.contains(root)){
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}
