package ze.nan.hong.practices.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySynchronizedBlock {

    public static void main(String[] args) {
        SynchronizedBlock synchronizedBlock = new SynchronizedBlock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedBlock.before());
        executorService.execute(() -> synchronizedBlock.after());
        executorService.shutdown();
    }

    static class SynchronizedBlock {
        public void before() {
            synchronized (this) {
                System.out.println("before");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void after() {
            synchronized (this) {
                System.out.println("after");
            }
        }
    }
}
