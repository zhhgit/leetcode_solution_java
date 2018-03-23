package session2.q133_clone_graph;

import session2.common.UndirectedGraphNode;

import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args){

    }

    private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        HashMap<Integer,UndirectedGraphNode> existNodes = new HashMap<>();
        return backTracking(node,existNodes);
    }

    private static UndirectedGraphNode backTracking(UndirectedGraphNode node,HashMap<Integer,UndirectedGraphNode> existNodes){
        //新建未曾拷贝的节点
        UndirectedGraphNode retNode = new UndirectedGraphNode(node.label);
        existNodes.put(node.label,retNode);
        //建立与其他节点的链接
        for(UndirectedGraphNode neighbour:node.neighbors){
            //已经新建了
            if(existNodes.containsKey(neighbour.label)){
                retNode.neighbors.add(existNodes.get(neighbour.label));
            }
            else{
                retNode.neighbors.add(backTracking(neighbour,existNodes));

            }
        }
        return retNode;
    }
}
