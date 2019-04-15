package suanfa.concurrent.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author liu peng bo
 * @date 2018/10/24
 */
public class TestUnSafe {
    int a;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        TestUnSafe testUnSafe = new TestUnSafe();

        Class<Unsafe> clazz= Unsafe.class;
        Constructor<Unsafe> constructor= clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Unsafe unsafe =constructor.newInstance();
        /*Field field=clazz.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe =(Unsafe) field.get(null) ;*/

        Field field2 = TestUnSafe.class.getDeclaredField("a");
        long unSafeA = unsafe.objectFieldOffset(field2);
        unsafe.compareAndSwapInt(testUnSafe,unSafeA,0,3);
        System.out.println(testUnSafe.a);

    }
}
