package ze.nan.hong.practices.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySynchronized {

    public static void main(String[] args) {
//        testSynchronizedFunc();
        testSynchronizedBlock();
//        testWait();
    }

    private static void testSynchronizedBlock() {
        SynchronizedBlockExample e1 = new SynchronizedBlockExample();
        SynchronizedBlockExample e2 = new SynchronizedBlockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e2.func1());


    }

    private static void testSynchronizedFunc() {

    }

    static class SynchronizedBlockExample {

        public void func1() {
            synchronized (this) {
                for (int i = 0; i < 10; ++i) {
                    System.out.print(i + " ");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SynchronizedFuncExample {
        public synchronized void func() {
            for (int i = 0; i < 10; ++i) {
                System.out.print(i + " ");
            }
        }
    }

    static class WaitNotifyExample {

        // 这边需要注意的是，锁在对象的锁（块和方法上的锁），会在整个对象生效，即synchronized了两个方法，那调用第一个
        // 方法的时候，第二个加锁的方法也会被锁住。（估计锁的是对象的内存空间）
        public synchronized void before() {
            System.out.println("before");
//            notifyAll();
        }

        public synchronized void after() {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("after");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testWait() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        executorService.execute(() -> waitNotifyExample.after());
        executorService.execute(() -> waitNotifyExample.before());
    }
}
