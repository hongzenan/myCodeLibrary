package ze.nan.hong.practices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
