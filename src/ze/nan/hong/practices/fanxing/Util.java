package ze.nan.hong.practices.fanxing;

public class Util {

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(2, "pear");
        Pair<Integer, String> pair2 = new Pair<>(2, "pear");
        System.out.println(Util.compare(pair1, pair2));
    }
}

class Pair<K, V> {
    private K key;

    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    V getValue() {
        return value;
    }

    void setValue(V value) {
        this.value = value;
    }
}
