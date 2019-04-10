package ze.nan.hong.practices.fanxing;

import javax.swing.*;

public class BoxFanxing<T> {

    // T stands for "Type"
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        BoxFanxing<String> boxFanxing = new BoxFanxing<>();
        boxFanxing.setT("a");
        System.out.println(boxFanxing.getT());

        BoxFanxing<Integer> boxFanxing1 = new BoxFanxing<>();
        boxFanxing1.setT(12);
        System.out.println(boxFanxing1.getT());
    }
}
