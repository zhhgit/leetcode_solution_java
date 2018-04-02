package session3.common;

import java.util.LinkedList;

/**
 * Created by zhanghao1 on 2017/11/3.
 */
public class PrintUtil {
    //广度遍历并打印整棵树
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        while (curr.size() > 0){
            //打印当前level
            for(int i=0;i<curr.size();i++){
                System.out.print(curr.get(i).val + " ");
            }
            System.out.println();
            LinkedList<TreeNode> next = new LinkedList<>();
            for(int i=0;i<curr.size();i++){
                TreeNode node = curr.get(i);
                if(node.left != null){
                    next.add(node.left);
                }
                if(node.right != null){
                    next.add(node.right);
                }
            }
            curr = next;
        }
    }

    //打印链表
    public static void printList(ListNode head){
        ListNode pointer = head;
        while (pointer != null){
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }

    //打印数字数组
    public static void printNumArray(int[] nums){
        for(int num:nums){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

    //打印二维数组
    public static void print2DMatrix(int[][] matrix){
        int row = matrix.length;
        int column = 0;
        if(row > 0){
            column = matrix[0].length;
        }
        else{
            return;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j< column;j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
