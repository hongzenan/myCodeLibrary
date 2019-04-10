package ze.nan.hong.practices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyFixedThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //业务超过线程数量，就排队排队的时候谁的线程结束了直接拿来使用。但是线程充足的情况下它会直接拿新的线程。
        //线程池10个大小的时候，每个业务一个线程直接用。线程池5个大小的时候，先结束的先拿来用
        //需要在业务使用线程达到它的固定值的线程的时候进行空闲线程回收，否则新建线程.
        for (int i = 0; i < 10; ++i) {
            executorService.execute(new MyThreadNum(i));
//            Thread.sleep(1000);
        }
        executorService.shutdown();
    }
}
