package algorithm1.common;

import java.util.LinkedList;

public class TreeBuilder {

    LinkedList<TreeNode> innerList;

    public TreeBuilder(Integer[] nums) {

        innerList = new LinkedList<>();

        for(Integer num: nums){
            if (num != null){
                innerList.add(new TreeNode(num));
            }
            else {
                innerList.add(null);
            }
        }

        // 得到有子节点的最后一个节点的索引
        int lastIndex = nums.length / 2 -1;
        //最后一个有子节点的节点可能有一个或者两个子节点，它之前的都有两个子节点
        for(int i=0;i <= lastIndex;i++){
            TreeNode eachNode = innerList.get(i);
            if(eachNode != null){
                // 左节点都有
                eachNode.left = innerList.get(i*2+1);
                // 右节点
                if(i<lastIndex){
                    innerList.get(i).right = innerList.get(i*2+2);
                }
                else{
                    //在最后一个有子节点的节点，长度为奇数时有右节点
                    if(nums.length % 2 == 1){
                        innerList.get(i).right = innerList.get(i*2+2);
                    }
                }
            }
        }
    }

    // 返回根节点
    public TreeNode getRoot(){
        return innerList.get(0);
    }
}
