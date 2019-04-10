package ze.nan.hong.practices.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger {

    private AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        testAtomicInteger();
    }

    private static void testAtomicInteger() throws InterruptedException {
        final int threadSize = 1000;
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        MyAtomicInteger myAtomicInteger = new MyAtomicInteger();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; ++i) {
            executorService.execute(() -> {
                myAtomicInteger.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(myAtomicInteger.get());
    }

    public void add() {
        atomicInteger.incrementAndGet();
    }

    public int get() {
        return atomicInteger.get();
    }
}
