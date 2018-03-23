package session1.q143_reorder_list;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        ListBuilder lb = new ListBuilder();
        lb.createList(nums);
        ListNode head = lb.nodeList.get(0);
        reorderList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head,fast = head;
        while((slow.next != null) && (fast.next != null) && (fast.next.next != null)){
            slow = slow.next;
            fast = fast.next.next;
        }
        //奇数时前半段长度比后半段长1，偶数时一样长
        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;
        list2 = reverse(list2);
        merge(list1,list2);
    }

    //后半截倒序
    private static ListNode reverse(ListNode head){
        ListNode curr = head,prev = null,next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //合并两个list
    private  static void merge(ListNode head1, ListNode head2){
        ListNode next1 = null,next2 = null;
        while(head1!= null){
            next1 = head1.next;
            if(head2 != null){
                next2 = head2.next;
            }
            else{
                break;
            }
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }
}
