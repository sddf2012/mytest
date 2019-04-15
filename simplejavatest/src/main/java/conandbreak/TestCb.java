package conandbreak;

/**
 * @author liu peng bo
 * @date 2019/2/25
 */
public class TestCb {
    public static void main(String[] args) {
        outer:
            for (int i = 0; i < 2; i++) {
                if (i == 1) {
                    continue outer;
                }
                System.out.println("for " + i);
            }
    }
}
