package exceptiontest;

/**
 * @author liu peng bo
 * @date 2019/1/25
 */
public class TryFinallyTest {
    static void get(){
        try{
            int i=1/0;
        }
        finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        try{
        get();}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
