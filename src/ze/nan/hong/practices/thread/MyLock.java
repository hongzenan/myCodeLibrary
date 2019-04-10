package ze.nan.hong.practices.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

    public static void main(String[] args) {
        testReentrantLock();
    }

    private static void testReentrantLock() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitReentrantLock awaitReentrantLock = new AwaitReentrantLock();
        executorService.execute(() -> awaitReentrantLock.after());
        executorService.execute(() -> awaitReentrantLock.before());
    }

    static class AwaitReentrantLock {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void before() {
            lock.lock();
            try {
                System.out.println("before");
//                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void after() {
            lock.lock();
            try {
//                condition.await();
                System.out.println("after");
                Thread.sleep(2000);
                System.out.println("after2");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
