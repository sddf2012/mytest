package enum1;

/**
 * @author liu peng bo
 * @date 2019/3/5
 */
public class Test {
    static  enum TestE{
        Q{
            @Override
            public void test(){
                System.out.println("qqq");
            }
        };

     public abstract void test();
    }

    public static void main(String[] args) {
        TestE testE=TestE.Q;
        testE.test();
    }
}
