package session1.q113_path_sum_2;

import session1.common.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb = new TreeBuilder();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        tb.createBinTree(arr);
        TreeNode root = tb.nodeList.get(0);
        int sum = 8;
        List<List<Integer>> list = new LinkedList<>();
        list = pathSum(root,sum);
        System.out.println(list);
    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        if(root!=null){
            backTracking(list,tempList,root,sum);
        }
        return list;
    }

    private static void backTracking(List<List<Integer>> list, LinkedList<Integer> tempList, TreeNode curr, int remainSum){
        if(curr.left == null && curr.right == null){
            if(remainSum == curr.val){
                tempList.add(curr.val);
                List<Integer> insert = new LinkedList<>(tempList);
                list.add(insert);
                tempList.remove(tempList.size()-1);
                return;
            }
            else{
                return;
            }
        }
        else{
            if(curr.left!=null){
                tempList.add(curr.val);
                backTracking(list,tempList,curr.left,remainSum-curr.val);
                tempList.remove(tempList.size()-1);
            }
            if(curr.right!=null){
                tempList.add(curr.val);
                backTracking(list,tempList,curr.right,remainSum-curr.val);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
