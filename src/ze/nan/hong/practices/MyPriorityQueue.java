package ze.nan.hong.practices;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyPriorityQueue {

    public static void main(String[] args) {
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = new PriorityQueue<>(10, comparator);
        queue.add("short");
        queue.add("middle");
        queue.add("very long");
        while (queue.size() != 0) {
            System.out.println(queue.remove());
        }

        PriorityQueue<String> que = new PriorityQueue<>(10, Comparator.comparing(String::length));
        que.add("short");
        que.add("middle");
        que.add("very long");
        while (que.size() != 0) {
            System.out.println(que.remove());
        }
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
        return t1.length() - s.length();
    }
}
