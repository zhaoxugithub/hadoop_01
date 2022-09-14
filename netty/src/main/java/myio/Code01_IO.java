package myio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//参考博客
//https://blog.csdn.net/weixin_37778801/article/details/86699341
//https://ifeve.com/overview/
public class Code01_IO {

    public void test01() {
        // 0<= mark <=position<=limit <=capacity
        String ss = "sss";
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put(ss.getBytes());

        System.out.println(allocate);

        //写变成读
        allocate.flip();
        System.out.println(allocate);
        //如果加上下面这个方法，get()之后，limit的值并不会减少，所以allocate.get(bytes, 0, allocate.limit()); 会抛出异常
//        byte b = allocate.get();
//        System.out.println(b);
        byte[] bytes = new byte[allocate.limit()];
        allocate.get(bytes, 0, allocate.limit());
        String s = new String(bytes, 0, bytes.length);
        System.out.println(s);
        System.out.println(allocate);


        //报错
//        byte b = allocate.get();
//        System.out.println(b);


        //--------------------------------------
        //将position 置为0,limit 就不会变了
        allocate.flip();
        System.out.println(allocate);

        //经过flip之后就不会报错
        byte b = allocate.get();
        allocate.put("aa".getBytes());
        System.out.println(b);
        System.out.println(allocate);

        //-------------------------------

        allocate.clear();
        System.out.println(allocate);
    }

    public void test02() throws IOException {
        long start = System.currentTimeMillis();
        File file = new File("/Users/serendipity/IdeaProjects/hadoop_01/netty/src/out.txt");
        OutputStream outputStream = new FileOutputStream(file);
        for (int i = 0; i < 100000; i++) {
            outputStream.write(("aaaaa" + i).getBytes());
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    // 与test0w相比减少了系统调用,在jvm开辟了一个8k的缓存，每8k进行一次系统调用
    public void test03() throws IOException {
        long start = System.currentTimeMillis();
        File file = new File("/Users/serendipity/IdeaProjects/hadoop_01/netty/src/outbuffer.txt");
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
        for (int i = 0; i < 100000; i++) {
            outputStream.write(("aaaaa" + i).getBytes());
        }
        outputStream.flush();
        System.out.println(System.currentTimeMillis() - start);
    }

    public void test04() throws IOException {
        long start = System.currentTimeMillis();
        RandomAccessFile file = new RandomAccessFile("/Users/serendipity/IdeaProjects/hadoop_01/netty/src/randomAccessFile.txt", "rw");
        for (int i = 0; i < 100000; i++) {
            file.write(("aaaaa" + i).getBytes());
        }
        System.out.println(System.currentTimeMillis() - start);
    }


    //不是系统调用，但是数据会达到内核的pagecache
    public void test05() throws IOException {
        long start = System.currentTimeMillis();
        RandomAccessFile file = new RandomAccessFile("/Users/serendipity/IdeaProjects/hadoop_01/netty/src/randomAccessFile2.txt", "rw");
        FileChannel channel = file.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, Integer.MAX_VALUE);
        for (int i = 0; i < 100000; i++) {
            map.put(("aaaaa" + i).getBytes());
        }
        System.out.println(System.currentTimeMillis() - start);


        //读取
        file.seek(0);

        ByteBuffer buffer = ByteBuffer.allocate(8092);
        //将内核pagecache 的数据通过channel 读取到jvm堆缓存中
        int read = channel.read(buffer);
        System.out.println(buffer);
        System.out.println(read);

        buffer.flip();
        System.out.println(buffer);


        for (int i = 0; i < buffer.limit(); i++) {
            char b = (char) buffer.get(i);
            System.out.print(b);
        }
    }


    //传统BIO
    public void bio() throws IOException {
        //添加线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            //如果没有客户端连接，会一直阻塞
            Socket accept = serverSocket.accept();
            executorService.execute(() -> dataRead(accept));
        }
    }

    //NIO

    public void nio() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(9999));
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            SocketChannel accept = serverSocketChannel.accept();
            if (accept != null) {
                SocketAddress remoteAddress = accept.getRemoteAddress();
                int port = accept.socket().getPort();
                System.out.printf("from IP={},port = {}", remoteAddress, port);
                executorService.execute(() -> nioData(accept));
            }
        }
    }

    //NIO数据处理
    public void nioData(SocketChannel socketChannel) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.clear();
        while (true) {
            try {
                int read = socketChannel.read(allocate);
                if (read > 0) {
                    allocate.flip();
                    byte[] bytes = new byte[allocate.limit()];
                    allocate.get(bytes);
                    String s = new String(bytes);
                    System.out.println(s);
                    allocate.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void dataRead(Socket accept) {
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = accept.getInputStream();
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bytes);
                if (read == -1) {
                    break;
                }
                //todo 数据处理
                String s = new String(bytes, 0, read);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //-===============================================================

    private ServerSocketChannel serverSocketChannel = null;

    //多路复用器
    public void multiplexingIo() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(9999));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //性能比较：  test02 > test05() > test01() > test03()
    public static void main(String[] args) throws IOException {
        Code01_IO code01_io = new Code01_IO();
//        code01_io.test02();
//        code01_io.test03();
//        code01_io.test04();
        code01_io.test05();
    }
}
