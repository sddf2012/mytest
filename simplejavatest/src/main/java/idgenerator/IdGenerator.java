package idgenerator;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/24 10:56
 */
public class IdGenerator {
    private long beginTime = 1557546517634L;
    private int seqLength = 12;
    private int workIdLength = 10;
    private int timeLeftShift = seqLength + workIdLength;
    private int workIdLeftShift = seqLength;

    private int maxSeq = (1 << seqLength) - 1;
    private int maxWorkId = (1 << workIdLength) - 1;

    private int workId;
    private int workIdLeft;
    private long lastTime = beginTime;
    private int lastSeq;


    public IdGenerator(int workId) {
        if (workId < 0 || workId > maxWorkId) {
            throw new IllegalArgumentException("workId must less than " + maxWorkId);
        }
        this.workId = workId;
        this.workIdLeft = this.workId << workIdLeftShift;
    }

    public synchronized long nextId() {
        long currentTime = System.currentTimeMillis();
        if (currentTime < lastTime) {
            long i = lastTime - currentTime;
            if (i <= 2) {
                currentTime = nextTimestamp(lastTime);
            } else {
                throw new RuntimeException("当前时间异常!");
            }
        }
        if (currentTime == lastTime) {
            lastSeq = lastSeq + 1;
            if (lastSeq > maxSeq) {
                lastSeq = 0;
                currentTime = currentTime + 1;
            }
        } else {
            lastSeq = 0;
        }
        lastTime = currentTime;
        return ((lastTime - beginTime) << timeLeftShift) | workIdLeft | lastSeq;
    }

    private long nextTimestamp(long lastTimestamp) {
        long current = System.currentTimeMillis();
        while (current < lastTimestamp) {
            current = System.currentTimeMillis();
        }
        return current;
    }
}
