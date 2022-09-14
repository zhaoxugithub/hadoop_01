package myio;


import java.io.*;
import java.net.Socket;

public class Code01_SocketClient {

    public void client() {
        try {
            Socket socket = new Socket("127.0.0.1", 9090);
            socket.setSendBufferSize(20);
            socket.setTcpNoDelay(true);
            OutputStream outputStream = socket.getOutputStream();
            InputStream in = System.in;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String s = reader.readLine();
                System.out.println(s);
                if (s != null) {
                    outputStream.write(s.getBytes());
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        Code01_SocketClient code01_socketIO = new Code01_SocketClient();
        code01_socketIO.client();
    }

}
