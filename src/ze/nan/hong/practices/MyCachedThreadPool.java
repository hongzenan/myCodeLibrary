package ze.nan.hong.practices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCachedThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; ++i) {
            executorService.execute(new MyThreadNum(i));
//            Thread.sleep(1000);//Thread.sleep()是用于让线程在处理完一个之后处于空闲状态,注释掉之后是不让主线程休息
        }
        executorService.shutdown();
    }
}

class MyThreadNum implements Runnable {

    int i = 0;

    public MyThreadNum() {
    }

    public MyThreadNum(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "=====" + i);
    }
}
