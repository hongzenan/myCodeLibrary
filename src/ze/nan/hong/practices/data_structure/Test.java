package ze.nan.hong.practices.data_structure;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ClassDianThis classDianThis = new ClassDianThis();
        ClassDianThis.Method method = classDianThis.new Method();
        method.add("adf");
        List<String> lists = classDianThis.get();
        for (String string : lists) {
            System.out.println(string);
        }
    }
}
