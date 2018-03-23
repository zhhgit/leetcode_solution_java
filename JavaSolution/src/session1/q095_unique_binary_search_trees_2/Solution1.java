package session1.q095_unique_binary_search_trees_2;

import session1.common.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int n = 2;
        List<TreeNode> list = new LinkedList<>();
        list = generateTrees(n);
        System.out.println("finished");
    }

    private static List<TreeNode> generateTrees(int n) {
        if(n>=1){
            return generator(1,n);
        }
        else{
            return (new LinkedList<>());
        }
    }

    private static List<TreeNode> generator(int start, int end){
        List<TreeNode> list = new LinkedList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        else if(start==end){
            TreeNode insert = new TreeNode(start);
            list.add(insert);
            return list;
        }
        else{
            List<TreeNode> left,right;
            for(int i=start;i<=end;i++){
                left = generator(start,i-1);
                right = generator(i+1,end);
                for(TreeNode leftTree:left){
                    for(TreeNode rightTree:right){
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }
}
