package stream;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author liu peng bo
 * @date 2018/11/20
 */
public class GZipTest {
    public static void main(String[] args) throws IOException {
        String a = "123123";
        String b="";
        OutputStream outputStream = new ByteOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
        gzipOutputStream.write(a.getBytes());
        InputStream inputStream = new ByteArrayInputStream(a.getBytes());
        GZIPInputStream inputStream1 = new GZIPInputStream(inputStream);

    }
}
