package nio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author liu peng bo
 * date: 2020/4/23 17:23
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(Client.class.getResource("/1.txt").getFile());
            BufferedReader fileBuffer=new BufferedReader(new InputStreamReader(fileInputStream));
            socket = new Socket("localhost", 20000);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer=new PrintWriter(outputStream);
            String line;
            while ((line = fileBuffer.readLine()) != null) {
                writer.write(line);
            }
            writer.flush();
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null) {
                log.info(Thread.currentThread().getName() + " receive:" + line);
            }
            //socket.shutdownInput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
