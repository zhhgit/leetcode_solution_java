package session3.q146_lru_cache;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    private static class LRUCache {
        Map<Integer,Integer> map;
        List<Integer> list;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)){
                return -1;
            }
            else{
                int index = list.indexOf(key);
                list.remove(index);
                list.add(key);
                return map.get(key);
            }
        }

        public void put(int key, int value) {
            // key已经存在，更新map
            if (map.containsKey(key)){
                int index = list.indexOf(key);
                list.remove(index);
                list.add(key);
                map.put(key,value);
            }
            // key不存在
            else{
                if (list.size() == this.capacity){
                    int oldKey = list.get(0);
                    map.remove(oldKey);
                    int index = list.indexOf(oldKey);
                    list.remove(index);
                }
                list.add(key);
                map.put(key,value);
            }
        }
    }
}
