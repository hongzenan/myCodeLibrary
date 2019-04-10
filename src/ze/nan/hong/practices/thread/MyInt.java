package ze.nan.hong.practices.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyInt {

    // volatile不能保证整体操作原子性，最多只能保证单个操作原子性
    private int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        testInt();
    }

    private static void testInt() throws InterruptedException {
        final int threadSize = 1000;
        MyInt myInt = new MyInt();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; ++i) {
            executorService.execute(() -> {
                myInt.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(myInt.get());
    }

    public void add() {
        cnt++;
    }

    //synchronized可帮助原子性
    public int get() {
        return cnt;
    }
}
