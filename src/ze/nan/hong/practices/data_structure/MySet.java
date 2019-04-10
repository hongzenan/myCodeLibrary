package ze.nan.hong.practices.data_structure;

import java.util.*;

public class MySet {

    public static void main(String[] args) {
        testTreeSet();
        testHashSet();
    }

    private static void testTreeSet() {
        // 红黑树，时间复杂度O(logn), 插入就排序
        Set<Integer> sets = new TreeSet<>();
        sets.add(1);
        sets.add(3);
        sets.add(2);
        sets.add(11);
        sets.add(6);
        sets.add(5);
        Iterator<Integer> a = sets.iterator();
        while (a.hasNext()) {
            Integer integer = a.next();
            System.out.println(integer);
        }
    }

    private static void testHashSet() {
        // 时间复杂度O(1), 失去插入顺序
        Map<String, String> hashMap = new HashMap<>();

        // 具有HashMap的查找效率，且内部双向链表维护插入顺序。
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
    }
}
