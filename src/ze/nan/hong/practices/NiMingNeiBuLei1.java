package ze.nan.hong.practices;

public class NiMingNeiBuLei1 {

    public static void main(String[] args) {
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; ++i) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; ++i) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        }).start();


    }
}
