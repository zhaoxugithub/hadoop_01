package myhttp.net;

import org.mortbay.jetty.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Function;

public class Step1Server {

    private ServerSocket serverSocket = null;
    private Function<String, String> handler = null;

    public Step1Server(Function<String, String> handler) {
        this.handler = handler;
    }

    public void listen() throws IOException {
        serverSocket = new ServerSocket(9990);
        while (true) {
            this.accept();
        }
    }

    public void accept() {
        try {
            Socket client = serverSocket.accept();
            System.out.println("socket created");

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();
            String line = "";

            while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
                stringBuilder.append(line);
            }

            String request = bufferedReader.toString();
            System.out.println(request);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String response = this.handler.apply(request);
            bufferedWriter.write(response);
            bufferedWriter.flush();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        new Step1Server((s) -> {
            return "HTTP/1.1 200 ok\n\nhello ssssss\n";
        }).listen();
    }


}
