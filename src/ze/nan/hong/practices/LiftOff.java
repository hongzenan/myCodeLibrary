package ze.nan.hong.practices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ").";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(" " + status());
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; ++i) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
