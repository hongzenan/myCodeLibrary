package ze.nan.hong.practices.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {

    public static void main(String[] args) throws InterruptedException {
        MyReentrantLock myReentrantLock = new MyReentrantLock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> myReentrantLock.func());
        Thread.sleep(1000);
        executorService.execute(() -> myReentrantLock.func1());
        executorService.shutdown();
    }

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void func() {
        lock.lock();
        try {
            condition.await();
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void func1() {
        lock.lock();
        try {
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
