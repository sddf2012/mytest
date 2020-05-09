package io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liu peng bo
 * @date 2019/2/27
 */
@Slf4j
public class BioServerSocket {

    public static void handle(Socket socket) {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder instr = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                instr.append(line);
            }
            log.info(instr.toString());
            //Thread.sleep(2000L);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(("hello " + instr).getBytes());
            outputStream.flush();
            socket.shutdownOutput();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(20000);
        while (true) {
            Socket socket = serverSocket.accept();
            log.info("accept");
            handle(socket);
            //new Thread(() -> handle(socket)).start();
        }

        /*InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        socket.shutdownInput();*/
        //serverSocket.close();


    }
}
