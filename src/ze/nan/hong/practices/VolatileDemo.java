package ze.nan.hong.practices;

public class VolatileDemo {

    private volatile int number = 0;

    public int getNumber() {
        return this.number;
    }

    public void increase() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.number++;
    }

    public static void main(String[] args) {
        final VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 500; ++i) {
            new Thread(() -> {
                volatileDemo.increase();
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("number: " + volatileDemo.getNumber());
    }
}
