package ze.nan.hong.practices.fanxing;

import java.util.ArrayList;
import java.util.List;

public class TongPeiFu {
    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruits = new ArrayList<>();
    static class Reader<T> {
        // 通配符<? extends T> 用于get()
        T readExact(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f1() {
        Reader<Fruit> reader = new Reader<>();
        Fruit a = reader.readExact(apples);
        Fruit f = reader.readExact(fruits);
        System.out.println(a);
        System.out.println(f);
    }

    public static void main(String[] args) {
        f3();
        f1();
        // 有些源码会将这两个通配符结合起来用，比如说Collections中的copy()
    }

    static void f3() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruits, new Apple());
    }

    // 通配符<? super T>用于set()
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }
}

class Fruit {
}

class Apple extends Fruit {
}

class Orange extends Fruit {
}
