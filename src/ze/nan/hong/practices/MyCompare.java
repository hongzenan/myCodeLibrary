package ze.nan.hong.practices;

import java.util.Arrays;
import java.util.Comparator;

public class MyCompare {
    public static void main(String[] args) {
        Integer[] ints = {3, 4, 1, 2, 5};
        Arrays.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }
        });
        for (int i : ints) {
            System.out.println(i);
        }

        String[] strings = {"aa", "a", "aaaa", "aaa", "aaaaaaa"};
        Arrays.sort(strings, (s1, s2) -> s1.length() - s2.length());
        for (String string: strings) {
            System.out.println(string);
        }

        String[] stringss = {"aa", "a", "aaaa", "aaa", "aaaaaaa"};
        Arrays.sort(stringss, Comparator.comparing(String::length));
        for (String string: stringss) {
            System.out.println(string);
        }
    }
}
