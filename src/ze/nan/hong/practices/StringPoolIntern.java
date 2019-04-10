package ze.nan.hong.practices;

import java.util.Random;

public class StringPoolIntern {

    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];

    public static void main(String[] args) {
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < DB_DATA.length; ++i) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; ++i) {
            //其实在内存空间充足的情况下，不带intern方法的例子不需要jvm垃圾回收的话，比带intern方法的例子快一些
            //毕竟多调了intern方法，需要多花一些时间
//            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
        }

        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();

        //测试字符串是否相等,感觉在jdk7及之后,s.intern()如果发现常量池中没有该值，则会将常量池中存储的常量直接指向
        //同样在heap中的s的地址。
//        testEquals();

        //测试String相加(+),其最终是new StringBuilder的形式相加，最后返回new String(),但是
        //此处的new String()和String a = new String("11")不一样，此处的不会将"11"放入常量池。
//        test();
    }

    private static void testEquals() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    private static void test() {
        String s1 = "HelloMe";
        String s2 = "Hello";
        String s3 = "Me";
        String s4 = "Hello" + "Me";
        String s5 = s2 + s3;
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
    }
}
