package session2.common;

import java.util.LinkedList;

/**
 * Created by zhanghao1 on 2017/11/2.
 */
public class TreeBuilder {
    LinkedList<TreeNode> linkedList;

    public TreeBuilder(int[] nums) {
        linkedList = new LinkedList<>();
        //添加进linkedList
        for(int num: nums){
            linkedList.add(new TreeNode(num));
        }
        //得到有子节点的最后一个节点的索引
        int lastIndex = nums.length / 2 -1;
        //最后一个有子节点的节点可能有一个或者两个子节点，它之前的都有两个子节点
        for(int i=0;i<=lastIndex;i++){
            //左节点都有
            linkedList.get(i).left = linkedList.get(i*2+1);
            if(i<lastIndex){
                linkedList.get(i).right = linkedList.get(i*2+2);
            }
            else{
                //在最后一个有子节点的节点，长度为奇数时有右节点
                if(nums.length % 2 == 1){
                    linkedList.get(i).right = linkedList.get(i*2+2);
                }
            }
        }
    }

    //返回根节点
    public TreeNode getRoot(){
        return linkedList.get(0);
    }
}
