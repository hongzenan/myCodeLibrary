package ze.nan.hong.practices.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyInterrupted {
    public static void main(String[] args) {
        Future<?> future = testSubmit();
//        future.cancel(true);
    }

    private static Future<?> testSubmit() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
        });
        return future;
    }

    private static void testInterrupted() {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        myThread2.interrupt();
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {

            }
            System.out.println("Thread end");
        }
    }
}
