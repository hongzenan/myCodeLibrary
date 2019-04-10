package ze.nan.hong.practices.thread;

public class MyThreadLocal {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        ThreadLocal threadLocal1 = new ThreadLocal();

        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            threadLocal1.set(11);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            System.out.println(threadLocal1.get());
            threadLocal.remove();
            threadLocal1.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal1.set(22);
            threadLocal.remove();
            threadLocal1.remove();
        });
        thread1.start();
        thread2.start();
    }
}
