package io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu peng bo
 * @date 2019/2/27
 */
@Slf4j
public class BioSocket {

    static class ClientThread implements Runnable {
        private long time = 0;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        @Override
        public void run() {
            Socket socket = null;
            try {
                socket = new Socket("localhost", 20000);
                OutputStream outputStream = socket.getOutputStream();
                log.info(Thread.currentThread().getName() + " begin connect!");
                if (time > 0) {
                    Thread.sleep(time);
                }
                PrintWriter writer = new PrintWriter(outputStream);
                writer.write(Thread.currentThread().getName());
                writer.flush();
                socket.shutdownOutput();
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    log.info(Thread.currentThread().getName() + " receive:" + line);
                }
                //socket.shutdownInput();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        /*Socket socket = new Socket("localhost", 20000);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        writer.write("tom");
        writer.flush();
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        socket.shutdownInput();
        socket.close();*/
        int n = 2;
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < n; i++) {
            ClientThread clientThread = new ClientThread();
            /*if (i == 0) {
                clientThread.setTime(3000);
            }*/
            executorService.submit(clientThread);
            //Thread.sleep(500);
        }
    }
}
