package ze.nan.hong.practices;

public class Volatile {

    private static boolean ok = true;

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (Volatile.ok) {
                i++;
                System.out.println(Volatile.ok);
            }
            System.out.println(i);
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Volatile.ok = false;
        System.out.println("stop");
    }
}
