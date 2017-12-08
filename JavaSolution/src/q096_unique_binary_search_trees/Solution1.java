package q096_unique_binary_search_trees;

import common.PrintUtil;
import common.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 19;
        System.out.println(numTrees(n));
    }

    private static int numTrees(int n) {
        int[] store = new int[n+1];
        store[0] = 1;
        store[1] = 1;
        return generateTreeWithRange(1,n,store);
    }

    private static int generateTreeWithRange(int left,int right,int[] store){
        if(left == right){
            return 1;
        }
        if(left > right){
            return 0;
        }
        int gap = right - left + 1;
        if(store[gap] != 0){
            return store[gap];
        }
        int ret = 0;
        for(int i=left;i<=right;i++){
            int leftSize = generateTreeWithRange(left,i-1,store);
            int rightSize = generateTreeWithRange(i+1,right,store);
            if(leftSize != 0 && rightSize != 0){
                ret += leftSize * rightSize;
            }
            else if(leftSize != 0 && rightSize == 0){
                ret += leftSize;
            }
            else if(leftSize == 0 && rightSize != 0){
                ret += rightSize;
            }
        }
        store[gap] = ret;
        return ret;
    }
}
