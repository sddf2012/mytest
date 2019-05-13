package enum1;

/**
 * @author liu peng bo
 * @date 2019/1/23
 */
public enum  TestEnum {

    a(1,11),
    b(2,22);

    private int i;
    private int j;
    TestEnum(int i,int j) {
        this.i = i;
        this.j=j;
    }

}
