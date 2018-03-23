package session1.q092_reverse_linked_list_2;

import session1.common.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListBuilder lb = new ListBuilder();
        lb.createList(nums);
        ListNode head = lb.nodeList.get(0);
        int m = 3,n = 3;
        ListNode ret = reverseBetween(head,m,n);
        while(ret!=null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m<n){
            ListNode fakeHead = new ListNode(0);
            fakeHead.next = head;
            //找到m左侧、n右侧
            ListNode left = new ListNode(0);
            ListNode right = new ListNode(0);
            left.next = fakeHead;
            right.next = fakeHead;
            for(int i=0;i<m-1;i++){
                left.next = left.next.next;
            }
            for(int i=0;i<n+1;i++){
                right.next = right.next.next;
            }
            //重建指向关系
            ListNode prev = new ListNode(0);
            ListNode curr = new ListNode(0);
            ListNode temp;
            curr.next = left.next.next;
            //重建right与翻转之间指向
            temp = curr.next.next;
            curr.next.next = right.next;
            prev.next = curr.next;
            curr.next = temp;
            //循环重建
            for(int i=m;i<n-1;i++){
                temp = curr.next.next;
                curr.next.next = prev.next;
                prev.next = curr.next;
                curr.next = temp;
            }
            //重建left与翻转之间指向
            curr.next.next = prev.next;
            left.next.next = curr.next;
            //返回
            return fakeHead.next;
        }
        else{
            return head;
        }
    }
}
