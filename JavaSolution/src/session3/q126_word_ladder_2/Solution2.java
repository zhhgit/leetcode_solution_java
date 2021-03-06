package session3.q126_word_ladder_2;

import java.util.*;

public class Solution2 {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        String[] strArr = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new LinkedList<>(Arrays.asList(strArr));
        System.out.println(findLadders(beginWord,endWord,wordList));
    }

    private static List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> lists = new ArrayList<>();
        // 保存每个节点的相邻节点
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        // 从start到当前节点的最短距离
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> tempList = new ArrayList<>();
        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, nodeNeighbors, distance, tempList, lists);
        return lists;
    }

    // 广度优先遍历，得到所有节点能够到达的最近距离
    private static void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    // 没有访问过
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        // 找到最短路径
                        if (end.equals(neighbor))
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // 变化node字符串中某一位字符，要求变化后的字符串在dict中，返回所有下一层次的节点，
    private static ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // 深度优先遍历，输出所有最短路径
    private static void dfs(String cur, String end, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> tempList, List<List<String>> lists) {
        tempList.add(cur);
        // 找到最终字符串就添加到lists中去
        if (end.equals(cur)) {
            lists.add(new ArrayList<String>(tempList));
        }
        else {
            // 所有有可能达到的下一层次节点
            for (String next : nodeNeighbors.get(cur)) {
                // next节点的最近距离正好等于当前节点最近距离+1，这一条件是为了满足最短的限定条件
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, nodeNeighbors, distance, tempList, lists);
                }
            }
        }
        tempList.remove(tempList.size() - 1);
    }
}
