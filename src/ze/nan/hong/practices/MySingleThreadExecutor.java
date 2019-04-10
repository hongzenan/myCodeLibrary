package ze.nan.hong.practices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySingleThreadExecutor {

    public static void main(String[] args) throws InterruptedException {
        //能保证当一个线程发生异常时继续执行下去.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; ++i) {
            executorService.execute(new MyThreadNumber(i));
            Thread.sleep(1000);
        }
    }
}

class MyThreadNumber implements Runnable {

    int i = 0;

    public MyThreadNumber() {
    }

    public MyThreadNumber(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        int num = 100 / i;
        System.out.println(Thread.currentThread().getName() + "-----" + i);
    }
}
