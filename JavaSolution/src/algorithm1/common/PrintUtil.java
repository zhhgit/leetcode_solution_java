package algorithm1.common;

import java.util.LinkedList;

public class PrintUtil {

    public static void printNumArray(int[] nums){
        for (int num :nums){
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

    // 打印链表
    public static void printLinkedList(ListNode head){
        ListNode pointer = head;
        while (pointer != null){
            System.out.print(pointer.val);
            System.out.print("---->");
            pointer = pointer.next;
        }
        System.out.println("null");
    }

    // 广度遍历并打印整棵树
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
}