package ze.nan.hong.practices.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testFutureTask();
    }

    private static void testFutureTask() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            int result = 0;
            for (int i = 0; i < 100; ++i) {
                Thread.sleep(10);
                result += i;
            }
            return result;
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
