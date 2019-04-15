package suanfa.shijianfuzadu;

/**
 * @author liu peng bo
 * @date 2018/10/18
 */
public class Test {
    static int sum = 0;

    static int f(int n) {
        if (n <= 1) {
            sum++;
            return 1;
        } else {
            sum++;
            return f(n - 1)+f(n-2);
        }
    }

    public static void main(String[] args) {
        f(20);
        System.out.println(sum);
    }
}
