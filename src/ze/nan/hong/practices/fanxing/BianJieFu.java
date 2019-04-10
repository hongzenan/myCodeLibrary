package ze.nan.hong.practices.fanxing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BianJieFu {
    public static <T extends Comparable<T>> int countGreaterThan(T[] arrays, T element) {
        int count = 0;
        for (T e : arrays) {
            if (e.compareTo(element) > 0) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] string5 = (String[]) Arrays.asList("1", "2", "3").toArray();
        System.out.println(BianJieFu.countGreaterThan(string5, "2"));
    }

    private static void initialStrins() {
        String[] strings1 = {"1", "2", "3"};
        String[] strings2 = new String[]{"1", "2", "3"};
        String[] strings3 = new String[3];
        String[] strings4 = new String[3];
        Arrays.fill(strings4, "1");
        Arrays.fill(strings4, "2");
        Arrays.fill(strings4, "3");
        // use Arrays.asList() get Arrays.ArrayList`, and it extends AbstractList which
        // has toArray return Object[]
        String[] string5 = (String[]) Arrays.asList("1", "2", "3").toArray();
        Map<String, String[]> maps = new HashMap<>();
        maps.put("strings1", strings1);
        maps.put("strings2", strings2);
        maps.put("strings3", strings3);
        maps.put("strings4", strings4);
        maps.put("strings5", string5);
        System.out.println(BianJieFu.countGreaterThan(string5, "2"));
        for (int i : new Integer[] {1, 2, 3, 4, 5}) {
            // simple print String[] Arrays.toString()
            System.out.println(Arrays.toString(maps.get("strings" + i)));
        }

        String[][] strings6 = new String[][]{{"1", "11", "111"}, {"2", "22", "222"}, {"3", "33", "333"}};
        System.out.println(Arrays.deepToString(strings6));
    }
}

