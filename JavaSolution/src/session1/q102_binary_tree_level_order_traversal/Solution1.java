package session1.q102_binary_tree_level_order_traversal;

import session1.common.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        tb1.createBinTree(arr);
        TreeNode root = tb1.nodeList.get(0);
        List<List<Integer>> list;
        list = levelOrder(root);
        System.out.println(list);
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        int size;
        int level;
        if (root == null) {
            return ret;
        }
        else {
            ArrayList<TreeNode> ar = new ArrayList<TreeNode>();
            ar.add(root);
            while(!ar.isEmpty()){
                size = ar.size();
                ArrayList<Integer> arVal = new ArrayList<Integer>();
                for(int i = 0; i < size; i++){
                    arVal.add(ar.get(i).val);
                }
                ret.add(arVal);
                ArrayList<TreeNode> arTemp = new ArrayList<TreeNode>();
                arTemp.clear();
                for(int i = 0; i < size; i++){
                    if(ar.get(i).left != null){
                        arTemp.add(ar.get(i).left);
                    }
                    if(ar.get(i).right != null){
                        arTemp.add(ar.get(i).right);
                    }
                }
                ar = arTemp;
            }
            return ret;
        }
    }
}
