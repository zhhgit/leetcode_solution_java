package session3.q002_add_two_numbers;

import session3.common.ListBuilder;
import session3.common.ListNode;
import session3.common.PrintUtil;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {5,6,7};
		ListBuilder listBuilder1 = new ListBuilder(nums1);
		ListBuilder listBuilder2 = new ListBuilder(nums2);
		PrintUtil.printList(addTwoNumbers(listBuilder1.getHead(), listBuilder2.getHead()));
	}
	
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int len1 = getListLen(l1);
    	int len2 = getListLen(l2);
    	ListNode l1New,l2New;
    	if(len1 == len2) {
    		l1New = l1;
    		l2New = l2;
    	}
    	else if(len1 < len2) {
    		l1New = improveListToLen(l1,len2 - len1);
    		l2New = l2;
    	}
    	else {
    		l1New = l1;
    		l2New = improveListToLen(l2,len1 - len2);
    	}
    	return addTwoNumbersSameLen(l1New, l2New);
    }
    
    private static ListNode addTwoNumbersSameLen(ListNode l1, ListNode l2) {
    	ListNode fakeHead = new ListNode(0);
    	ListNode curr = fakeHead;
    	ListNode pointer1 = l1;
    	ListNode pointer2 = l2;
    	int add = 0;
    	while(pointer1 != null && pointer2 != null) {
    		int sum = pointer1.val + pointer2.val + add;
    		if(sum >= 10) {
    			sum = sum % 10;
    			add = 1;
    		}
    		else {
    			add = 0;
    		}
    		curr.next = new ListNode(sum);
    		curr = curr.next;
    		pointer1 = pointer1.next;
    		pointer2 = pointer2.next;
    	}
    	if(add == 1) {
    		curr.next = new ListNode(1);
    	}
    	return fakeHead.next;
    }
    
    private static int getListLen(ListNode head) {
    	int len = 0;
    	ListNode pointer1 = head;
    	while(pointer1 != null) {
    		len++;
    		pointer1 = pointer1.next;
    	}
    	return len;
	}
    
    private static ListNode improveListToLen(ListNode head,int addlen) {
    	ListNode curr = head;
    	while(curr.next != null) {
    		curr = curr.next;
    	}
    	for(int i=0;i<addlen;i++) {
    		curr.next = new ListNode(0);
    		curr = curr.next;
    	}
    	return head;
    }
}
