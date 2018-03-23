package session1.q107_binary_tree_level_order_traversal_2;

import session1.common.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        TreeBuilder tb1 = new TreeBuilder();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        tb1.createBinTree(arr);
        TreeNode root = tb1.nodeList.get(0);
        List<List<Integer>> list;
        list = levelOrderBottom(root);
        System.out.println(list);
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<List<Integer>> retReverse = new ArrayList<>();
        int size;
        int level;
        if (root == null) {
            return retReverse;
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
            size = ret.size();
            for(int i = size-1; i>=0; i--){
                retReverse.add(ret.get(i));
            }
            return retReverse;
        }
    }
}
