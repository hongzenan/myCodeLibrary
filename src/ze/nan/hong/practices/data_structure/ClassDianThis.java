package ze.nan.hong.practices.data_structure;

import java.util.ArrayList;
import java.util.List;

public class ClassDianThis {

    private List<String> lists = new ArrayList<>();

    public void add(String s) {
        lists.add(s);
    }

    public List<String> get() {
        return lists;
    }

    public class Method {
        public void add(String string) {
            // 此处是指ClassDianThis的add方法
            ClassDianThis.this.add(string);
        }
    }

    public static void main(String[] args) {
        ClassDianThis classDianThis = new ClassDianThis();
        Method method = classDianThis.new Method();
        method.add("aaa");
        List<String> lists = classDianThis.get();
        for (String string : lists) {
            System.out.println(string);
        }
    }
}
