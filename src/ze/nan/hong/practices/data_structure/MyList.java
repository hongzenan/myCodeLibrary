package ze.nan.hong.practices.data_structure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MyList {

    public static void main(String[] args) {

    }

    private static void testArrayList() {
        // ArrayList 基于动态数组实现，支持随机访问
    }

    private static void testLinkedList() {
        // LinkedList 基于双向链表实现，只能顺序访问，但是可以快速地在表中间插入和删除数据，
        //而且可以用作栈、队列和双向队列.
    }

    private static void testQueue() {
        Queue<String> queue = new PriorityQueue<>();
        Deque<String> deque = new ArrayDeque<>();
    }
}
