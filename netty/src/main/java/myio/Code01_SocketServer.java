package myio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Code01_SocketServer {

    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("server is starting");
        while (true) {
            //等待客户端连接，阻塞状态
            Socket accept = serverSocket.accept();
            System.out.println("client port:" + accept.getPort());
            new Thread(() -> {
                try {
                    InputStream inputStream = accept.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    // 处于阻塞状态
                    while (true) {
                        String s = reader.readLine();
                        System.out.println(s);
                        if (s != null) {
                            System.out.println(s);
                        } else {
                            accept.close();
                            break;
                        }
                    }
                    System.out.println("客户端断开");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        Code01_SocketServer code01_socketServer = new Code01_SocketServer();
        code01_socketServer.server();
    }
}
