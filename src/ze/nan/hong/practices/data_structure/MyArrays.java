package ze.nan.hong.practices.data_structure;

import java.util.Arrays;
import java.util.List;

public class MyArrays {

    public static void main(String[] args) {
        List list = Arrays.asList("a", "c", "b");
        System.out.println(Arrays.toString(list.toArray()));
        String[] strings = {"s", "g", "f"};
        List lists = Arrays.asList(strings);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
