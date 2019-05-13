package reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/26 10:26
 */
public class TestReferenceQueue2 {
    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        WeakReference<Object> ref1 = new WeakReference<>(new Object(), referenceQueue);
        WeakReference<Object> ref2 = new WeakReference<>(new Object(), referenceQueue);
        Reference reference;

        System.out.println("gc前");
        System.out.println("ref1 "+ref1.get());
        System.out.println("ref2 "+ref1.get());
        while ((reference=referenceQueue.poll())!=null){
            System.out.println("reference:"+reference.get());
        }

        System.out.println("gc后");
        System.gc();
        System.out.println("ref1 "+ref1.get());
        System.out.println("ref2 "+ref1.get());
        while ((reference=referenceQueue.poll())!=null){
            System.out.println("reference:"+reference.get());
        }


    }
}
