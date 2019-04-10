package ze.nan.hong.practices.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; ++i) {
            executorService.execute(new MyRunnable());
        }

        executorService.shutdown();
    }
}
