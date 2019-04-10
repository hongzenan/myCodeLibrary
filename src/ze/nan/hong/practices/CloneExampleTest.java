package ze.nan.hong.practices;

public class CloneExampleTest {

    public static void main(String[] args) {
        CloneExample c1 = new CloneExample();
        CloneExample c2 = null;

        try {
            c2 = c1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        c1.set(2, 222);
        System.out.println(c2.get(2));
    }
}
