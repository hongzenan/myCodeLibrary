package ze.nan.hong.practices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class MyForkJoin extends RecursiveTask<Integer> {

    private final int threshold = 5;
    private int first;
    private int last;

    public MyForkJoin(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if ((last - first) <= threshold) {
            for (int i = first; i <= last; ++i) {
                result += i;
            }
        } else {
            int middle = first + (last - first) / 2;
            MyForkJoin leftForkJoin = new MyForkJoin(first, middle);
            MyForkJoin rightForkJoin = new MyForkJoin(middle + 1, last);
            leftForkJoin.fork();
            rightForkJoin.fork();
            result = leftForkJoin.join() + rightForkJoin.join();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyForkJoin myForkJoin = new MyForkJoin(1, 1000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future future = forkJoinPool.submit(myForkJoin);
        System.out.println(future.get());
    }
}
