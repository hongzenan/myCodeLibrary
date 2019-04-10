package ze.nan.hong.practices.fanxing;


import java.util.ArrayList;
import java.util.List;

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}
// 上面的结果是：
/*
class Node {
    private Object data;
    private Node next;
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }
}
*/

class Node1<T extends Comparable<T>> {
    private T data;
    private Node1<T> next;

    public Node1(T data, Node1<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}
// 上面的结果是
/*
class Node1 {
    private Comparable data;
    private Node next;

    public Node1(Comparable data, Node1 next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() {
        return data;
    }
}
*/


// java中不允许创建泛型数组
// 因为类型擦除，所以jvm不知道new ArrayList<String>() 和 new ArrayList<Integer>()的区别（原来为new ArrayList<T>,
// 擦除后成了new ArrayList<Object>）。

public class LeixingChaChu {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        test1();
        test2();
    }

    // 类型擦除后，jvm把new ArrayList<String>和new ArrayList<Integer>类型认为是同一种
    private static void test1() {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }

    private static void test2() throws InstantiationException, IllegalAccessException {
        List<String> ls = new ArrayList<>();
        append(ls, String.class);
    }

    private static <E> void append(List<E> list, Class<E> cls) throws IllegalAccessException, InstantiationException {
        E elem = cls.newInstance();
        list.add(elem);
    }
}
