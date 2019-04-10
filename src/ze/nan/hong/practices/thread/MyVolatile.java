package ze.nan.hong.practices.thread;

import jdk.internal.util.xml.impl.Pair;

public class MyVolatile {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("------------");
                break;
            }
        }
    }

    static class ThreadDemo implements Runnable {
        private volatile boolean flag = false;

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag = " + isFlag());
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }
}
