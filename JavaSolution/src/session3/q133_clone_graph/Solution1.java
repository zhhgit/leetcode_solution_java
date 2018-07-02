package session3.q133_clone_graph;

import java.util.*;

public class Solution1 {

    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };

    private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode curr;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0){
            curr = queue.poll();
            if (!map.containsKey(curr)){
                UndirectedGraphNode addNode = new UndirectedGraphNode(curr.label);
                map.put(curr,addNode);
                List<UndirectedGraphNode> neighbour = curr.neighbors;
                for (UndirectedGraphNode n:neighbour){
                    queue.offer(n);
                }
            }
        }
        for (UndirectedGraphNode key:map.keySet()){
            List<UndirectedGraphNode> neighbours = key.neighbors;
            for (int i = 0;i<neighbours.size();i++){
                map.get(key).neighbors.add(map.get(neighbours.get(i)));
            }
        }
        return map.get(node);
    }

}
