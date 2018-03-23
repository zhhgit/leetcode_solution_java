package session2.q237_delete_node_in_a_linked_list;

import session2.common.ListNode;

public class Solution1 {
    public static void main(String[] args){

    }

    private static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}