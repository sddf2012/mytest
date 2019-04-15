package concurrent.lock.locksupport;

/**
 * @author liu peng bo
 * @date 2018/12/9
 */
public class MyBlock {
    private String reason;

    public MyBlock(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
