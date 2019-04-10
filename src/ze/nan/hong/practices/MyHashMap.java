package ze.nan.hong.practices;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MyHashMap {

    private static Map<String, Object> map1 = new HashMap<>();
    private static Map<String, Object> map2 = new Hashtable<>();
    private static Map<String, Object> map3 = new ConcurrentHashMap<>();
    private static Map<String, Object> map4 = Collections.synchronizedMap(new HashMap<>());

    private static Map<String, Object> map = map3;

    public static void main(String[] args) {

        Map<String, Object> map1 = new HashMap<>();
        writeMap(map1);
        printMap(map1);
        System.out.println();

        Map<String, Object> map2 = Collections.synchronizedMap(new TreeMap<>());
        writeMap(map2);
        printMap(map2);
        System.out.println();

        Map<String, Object> map3 = new ConcurrentHashMap<>();
        writeMap(map3);
        printMap(map3);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    if (map.size() > 0) {
//                        for (Map.Entry<String, Object> entry : map.entrySet()) {
//                            System.out.println(String.format("%s : %s", entry.getKey(), entry.getValue()));
//                        }
//                        map.clear();
//                    }
//                    try {
//                        Thread.sleep((new Random().nextInt(10) + 1) * 1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; ++i) {
//                    map.put("key" + i, "value" + i);
//                    try {
//                        Thread.sleep((new Random().nextInt(10) + 1) * 1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }

    private static void writeMap(Map<String, Object> map) {
        for (int i = 0; i < 10; ++i) {
            map.put("key-" + i, "value-" + i);
        }
    }

    private static void printMap(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value" + entry.getValue());
        }
    }
}
