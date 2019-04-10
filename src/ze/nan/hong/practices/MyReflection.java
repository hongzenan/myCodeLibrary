package ze.nan.hong.practices;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflection {

    public static void main(String[] args) {

    }

    private static Class<?> getClassForMe() {
//         Class<?> klass = Class.forName(driver);

        Class<?> klass = int.class;
//        Class<?> classInteger = Integer.TYPE;

//        StringBuilder str = new StringBuilder("123");
//        Class<?> klass = str.getClass();

        return klass;
    }

    private static Object newInstanceForMe(Class<?> klass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        klass.newInstance();

        Constructor constructor = klass.getConstructor(String.class);
        Object obj = constructor.newInstance("123");

        return obj;
    }

    private static Method[] getMethodsForMe(Class<?> klass) throws NoSuchMethodException {
        Method[] declaredMethods = klass.getDeclaredMethods();
        Method[] methods = klass.getMethods();
        Method method = klass.getMethod("add", int.class);

        return methods;
    }

    private static void invokeForMe(Method method, Class<?> klass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object obj = klass.newInstance();
        method.invoke(method, obj);
    }

    private static void getArrayForMe(Class<?> klass) {
        Object array = Array.newInstance(klass, 25);
        Array.set(array, 0, "aaa");
        Array.get(array, 0);
    }
}
