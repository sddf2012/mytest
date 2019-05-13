package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/13 17:57
 */
public class NioServer extends Thread{
    int port;
    ServerSocketChannel serverSocketChannel;
    Selector selector;

    public NioServer(int port,String name) {
        super(name);
        this.port=port;
    }

    @Override
    public void run() {
        try {
             selector=Selector.open();
            serverSocketChannel= ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }
}
