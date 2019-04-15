package math.yiyuanyunsuan;

/**
 * @author liu peng bo
 * @date 2018/12/11
 */
public class Test {
    public static void main(String[] args) {
        int a = 1; //1
        int b = 2; //10
        //System.out.println(1&2);
        int init = -1 << 29;
        int capacity = (1 << 29) - 1;
        int max = init + capacity;
        System.out.println(capacity);
        System.out.println(init & capacity);
        System.out.println((init + 1) & capacity);
        System.out.println(max & capacity);

        System.out.println(init & (~capacity));
        System.out.println((init + 1) & (~capacity));
        System.out.println(max & (~capacity));

        System.out.println(1 & (~capacity));
    }
}
