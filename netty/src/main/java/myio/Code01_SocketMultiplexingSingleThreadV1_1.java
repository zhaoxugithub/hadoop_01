package myio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 實現客戶端与服务端不间断通信
 */
public class Code01_SocketMultiplexingSingleThreadV1_1 {

    private ServerSocketChannel serverSocketChannel = null;
    private Selector selector = null;
    int port = 9991;

    public Code01_SocketMultiplexingSingleThreadV1_1() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port));
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {
        System.out.println("server is starting....");
        while (true) {
            try {
                while (selector.select(500) > 0) {
                    //获取变化的key
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                        } else if (key.isWritable()) {
                            writeHandler(key);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void writeHandler(SelectionKey key) {
        System.out.println(key.hashCode());
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
        try {
            System.out.println(client.getRemoteAddress() + "  write start...");
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                client.write(byteBuffer);
            }
            byteBuffer.clear();
            //这个地方很重要。。。实现客户端与服务端不间断通信的关键
            client.register(selector, SelectionKey.OP_READ, byteBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readHandler(SelectionKey key) {
        try {
            System.out.println(key.hashCode());
            SocketChannel client = (SocketChannel) key.channel();
            System.out.println(client.getRemoteAddress() + ": start reading.....");
            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
            byteBuffer.clear();
            while (true) {
                int read = client.read(byteBuffer);
                if (read > 0) {
                    client.register(selector, SelectionKey.OP_WRITE, byteBuffer);
                } else if (read == 0) {
                    System.out.println("read over...");
                    break;
                } else {
                    //read <0 表示客户端断开连接了
                    System.out.println("client close...");
                    key.cancel();
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void acceptHandler(SelectionKey key) {

        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
        try {
            SocketChannel client = serverSocketChannel1.accept();
            System.out.println(client.hashCode());
            client.configureBlocking(false);
            System.out.println("=========================================================");
            System.out.println("client connect address is =" + client.getRemoteAddress());
            System.out.println("=========================================================");
            client.register(selector, SelectionKey.OP_READ, byteBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Code01_SocketMultiplexingSingleThreadV1_1().init();
    }

}
