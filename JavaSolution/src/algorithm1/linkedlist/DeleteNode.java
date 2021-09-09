package algorithm1.linkedlist;

import algorithm1.common.ListBuilder;
import algorithm1.common.ListNode;
import algorithm1.common.PrintUtil;

public class DeleteNode {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListBuilder listBuilder = new ListBuilder(nums);
        ListNode head = listBuilder.getHead();
        PrintUtil.printLinkedList(head);
        deleteNode(head);
        PrintUtil.printLinkedList(head);
    }

    /**
     *
     * @param node 待删除的节点
     */
    public static void deleteNode(ListNode node) {
        ListNode remain = node.next.next;
        node.val = node.next.val;
        node.next = remain;
    }
}
