package ze.nan.hong.practices.data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyVector {
    public static void main(String[] args) {
//        现在不推荐用vector

    }

    private static void testVector() {
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);

        // CopyOnWriteArrayList 读写分离，在写的时候锁表，并且复制一个新数组，内存占用为原来的两倍
        // 读操作不能读取实时性的数据，因为部分写操作还未同步到读数组中.
        List<String> list1 = new CopyOnWriteArrayList<>();
    }
}
