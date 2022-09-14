package myio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class Code01_SocketNIOServer {


    public static void main(String[] args) throws IOException, InterruptedException {

        List<SocketChannel> channelList = new ArrayList<>();
        ServerSocketChannel channel = ServerSocketChannel.open();
        //绑定端口
        channel.bind(new InetSocketAddress(9090));
        channel.configureBlocking(false);

        while (true) {
            Thread.sleep(1000);
            //监听客户端连接,NIO不会阻塞，BIO会阻塞
            SocketChannel client = channel.accept();
            //如果没有客户端连接
            if (client == null) {
                //todo
            } else {
                // 设置客户端非阻塞
                client.configureBlocking(false);
                // 获取客户端端口
                int port = client.socket().getPort();
                System.out.println("client:" + port);
                channelList.add(client);
            }
            ByteBuffer buffer = ByteBuffer.allocate(8192);
            for (SocketChannel channel1 : channelList) {
                //将数据读入到buffer中
                int read = channel1.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.limit()];
                    String s = new String(bytes);
                    System.out.println(s);
                    buffer.clear();
                }
            }
        }
    }
}
