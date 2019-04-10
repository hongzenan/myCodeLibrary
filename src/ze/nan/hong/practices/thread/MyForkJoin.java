package ze.nan.hong.practices.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class MyForkJoin extends RecursiveTask<Integer> {

    private final int threadhold = 5;
    private int first;
    private int last;

    public MyForkJoin(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testForkJoin();
    }

    private static void testForkJoin() throws ExecutionException, InterruptedException {
        MyForkJoin myForkJoin = new MyForkJoin(1, 10000);
        // 类似于线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(myForkJoin);
        System.out.println(result.get());
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (last - first <= threadhold) {
            for (int i = first; i <= last; ++i) {
                result += i;
            }
        } else {
            int middle = (last - first) / 2 + first;
            MyForkJoin leftTask = new MyForkJoin(first, middle);
            MyForkJoin rightTask = new MyForkJoin(middle + 1, last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }
}
