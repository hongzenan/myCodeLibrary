package ze.nan.hong.practices;

public class CloneExample implements Cloneable {

    private int[] arr;

    public CloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i;
        }
    }

    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        CloneExample result = (CloneExample) super.clone();
        System.out.println("c1 arr area: " + System.identityHashCode(this));
        System.out.println("c2 arr area: " + System.identityHashCode(result));
//        result.arr = new int[arr.length];
//        for (int i = 0; i < arr.length; ++i) {
//            result.arr[i] = arr[i];
//        }
        return result;
    }
}
