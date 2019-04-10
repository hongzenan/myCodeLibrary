package ze.nan.hong.practices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class practices2 {

    private int n;

    public practices2(int n) {
        this.n = n;
    }

    public int getNumber() {
        return n * 2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            practices2 practices2 = new practices2(i);
            Thread t = new Thread(() -> {
                System.out.println(practices2.getNumber());
            });
            t.start();
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            System.out.println("Hello");
        });
        executorService.shutdown();
        executorService.execute(() -> {
            System.out.println(" World");
        });
    }
}
