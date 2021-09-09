package algorithm1.common;

public class ListBuilder {
    private ListNode head,tail;

    public ListBuilder(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            ListNode n = new ListNode(nums[i]);
            if(head == null){
                tail = n;
                head = tail;
            }
            else{
                tail.next = n;
                tail = n;
            }
        }
    }

    public ListNode getHead(){
        return head;
    }
}
