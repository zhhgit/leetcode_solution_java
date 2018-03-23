package session1.common;

import java.util.*;

public class TreeBuilder {
    //链表
    public List<TreeNode> nodeList = null;
    //建树
    public void createBinTree(int[] array) {
        nodeList = new LinkedList<TreeNode>();
        //将一个数组的值依次转换为TreeNode节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }
        //最后一个节点的索引
        int lastParentIndex = array.length / 2 - 1;
        //对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < lastParentIndex; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            //右孩子
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        if(array.length > 1){
            //最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
            //左孩子
            nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
            //右孩子,如果数组的长度为奇数才建立右孩子
            if (array.length % 2 == 1) {
                nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
            }
        }
    }
}
