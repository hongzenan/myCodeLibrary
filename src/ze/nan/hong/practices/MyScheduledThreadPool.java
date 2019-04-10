package ze.nan.hong.practices;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduledThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; ++i) {
            //第二个参数是在某个时间点开始执行，第三个参数是间隔时间。而且这个是有空闲的就用。
//            scheduledExecutorService.scheduleAtFixedRate(new MyThreadNum(i), 1, 1000, TimeUnit.MILLISECONDS);
            scheduledExecutorService.schedule(new MyThreadNum(i), 1000, TimeUnit.MILLISECONDS);
            Thread.sleep(1000);
        }
        System.out.println("a");
    }
}
