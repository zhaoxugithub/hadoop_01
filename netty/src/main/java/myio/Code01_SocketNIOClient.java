package myio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Code01_SocketNIOClient {

    public static void main(String[] args) throws IOException {

        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 9090);
        ArrayList<SocketChannel> socketChannels = new ArrayList<>();

        SocketChannel client1 = SocketChannel.open();
        SocketChannel client2 = SocketChannel.open();


        client1.bind(new InetSocketAddress("localhost", 1));
        boolean connect = client1.connect(socketAddress);
        if (connect) socketChannels.add(client1);


        client2.bind(new InetSocketAddress("localhost", 2));
        boolean connect1 = client2.connect(socketAddress);
        if (connect1) socketChannels.add(client2);
    }
}
