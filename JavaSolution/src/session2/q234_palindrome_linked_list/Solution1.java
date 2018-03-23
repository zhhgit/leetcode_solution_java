package session2.q234_palindrome_linked_list;

import common.ListBuilder;
import common.ListNode;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{1,2,3,4,3,2,1},{1,2,3,3,2,1},{1,2,3,4}};
        for(int[] nums:numsArr){
            ListBuilder listBuilder = new ListBuilder(nums);
            System.out.println(isPalindrome(listBuilder.getHead()));
        }
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //偶数时，slow正好位于后一半的起始位置；奇数时，slow正好位于中间位置
        while (slow!= null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转后一半
        ListNode half = reverse(slow);
        return compareList(head,half);
    }

    private static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static boolean compareList(ListNode head1,ListNode head2){
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while (curr1!=null && curr2!=null){
            if(curr1.val != curr2.val){
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }
}