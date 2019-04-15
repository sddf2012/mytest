package classloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author liu peng bo
 * @date 2019/1/24
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String path = getPath(name);
            InputStream inputStream = getClass().getResourceAsStream(path);
            byte[] b = new byte[4096];
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int n;
            while ((n = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, n);
            }
            byte[] classByte = outputStream.toByteArray();
            return defineClass(name, classByte, 0, classByte.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

    private String getPath(String name) {
        return name.substring(name.lastIndexOf(".") + 1) + ".class";
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader my = new MyClassLoader();
        //Class clazz = my.loadClass("classloader.Demo");
        Class clazz = my.findClass("classloader.Demo");
        Object demo = clazz.newInstance();
        Demo demo1 = new Demo();
        System.out.println(demo.getClass().equals(demo1.getClass()));
        System.out.println(demo.getClass());
        System.out.println(demo instanceof Demo);
        System.out.println(demo.getClass().getMethod("getI").invoke(demo));

    }
}
