package type;

/**
 * @author liu peng bo
 * @date 2018/12/28
 */
public class TestNull {
    public static void main(String[] args) {
        byte[] a=new byte[1];
        System.out.println(a[0]);
        int b = a[0] & 0xFF;
        System.out.println(b);
    }
}
