package ze.nan.hong.practices.data_structure;

import java.util.*;

public class MyMap {

    public static void main(String[] args) {
        int a = (int) Math.pow(2, 3);
        System.out.println(a);
    }

    private static void testLinkedIterator() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "1");
        map.put("3", "3");
        map.put("2", "2");
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            System.out.println(string);
        }
    }

    private static void testMap() {
        // TreeMap基于红黑树
        // HashMap基于哈系表
        // HashTable类似与HashMap但是线程安全，但是不推荐使用
        // ConcurrentHashMap支持线程安全，分段锁,效率比HashTable高，用于替换HashTable
        // LinkedHashMap使用双向链表维护元素顺序，顺序为插入顺序或者最近最少使用（LRU）顺序。
    }

    private static void testHashMap() {
        Map<String, String> map = new HashMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Iterator<String> iterator = linkedHashMap.keySet().iterator();
    }

    // HashMap初始扩容,大于自身的最小2的次方
    private static int tableSizeFor(int cap) {
        int MAXIMUM_CAPACITY = (int) Math.pow(2, 16);
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 :(n > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : n);
    }

    private static int tableSizeFor2(int cap) {
        int capacity = 1;
        while (capacity < cap) {
            capacity <<= 1;
        }
        return capacity;
    }
}
