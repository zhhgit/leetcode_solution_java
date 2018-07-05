Solution1 backTracking时间超限

Solution2
先BFS
// 保存每个节点的相邻节点
HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
// 从start到当前节点的最短距离
HashMap<String, Integer> distance = new HashMap<>();
再DFS得到所有解