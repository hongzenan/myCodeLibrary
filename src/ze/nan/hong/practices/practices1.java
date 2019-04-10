package ze.nan.hong.practices;

public class practices1 implements Runnable {

    public practices1() {
        System.out.println("starting...");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; ++i) {
            System.out.println("i am " + i);
//            Thread.yield();
        }
        System.out.println("stopping...");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new practices1());
        thread.start();
    }
}
