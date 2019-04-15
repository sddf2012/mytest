package concurrent.threadlocal;

/**
 * @author liu peng bo
 * @date 2018/12/20
 */
public class MyThreadLocal {
    public static final ThreadLocal<Integer> tl = new ThreadLocal<Integer>()/* {
        @Override
        public String initialValue() {
            return "1";
        }
    }*/;
}
