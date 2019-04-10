package ze.nan.hong.practices.thread;

public class MyRunnable implements Runnable {

    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread thread = new Thread(mr);
        thread.start();
    }
}
