package type;

/**
 * @author liu peng bo
 * @date 2018/12/27
 */
public class TestByte {
    public static byte[] intToBytes(int value) {
        byte[] src = new byte[4];
        src[3] = (byte) ((value >> 24) & 0xFF);
        src[2] = (byte) ((value >> 16) & 0xFF);
        src[1] = (byte) ((value >> 8) & 0xFF);
        src[0] = (byte) (value & 0xFF);
        return src;
    }

    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset + 1] & 0xFF) << 8)
                | ((src[offset + 2] & 0xFF) << 16)
                | ((src[offset + 3] & 0xFF) << 24));
        return value;
    }

    public static byte[] intToBytes2(int value) {
        byte[] src = new byte[4];
        src[3] = (byte) ((value >> 24));
        src[2] = (byte) ((value >> 16) );
        src[1] = (byte) ((value >> 8) );
        src[0] = (byte) (value);
        return src;
    }

    public static int bytesToInt2(byte[] src) {
        int value;
        value = (int) ((src[0] )
                | ((src[1] ) << 8)
                | ((src[2] ) << 16)
                | ((src[3] ) << 24));
        return value;
    }

    public static void main(String[] args) {
        int a=-1222222222;
        byte[] intByte= intToBytes(a);
        byte[] bytes=intToBytes2(a);
        System.out.println(bytesToInt(intByte,0));
        System.out.println(bytesToInt2(intByte));
    }
}
