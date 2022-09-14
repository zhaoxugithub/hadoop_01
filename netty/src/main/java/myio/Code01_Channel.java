package myio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
 java.nio.channels.Channel 接口
             |--FileChannel
             |--SocketChannel
             |--ServerSocketChannel
             |--DatagramChannel
 */
public class Code01_Channel {

    public void fileChannel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/serendipity/IdeaProjects/hadoop_01/netty/src/outbuffer.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 将channel 中的数据写到buffer中
        while (channel.read(buffer) > 0) {
            buffer.flip();
            //读取buffer中的数据
            String b = new String(buffer.array(), 0, buffer.limit());
            System.out.println(b);
            buffer.clear();
        }
        channel.close();
        fileInputStream.close();
    }

    public void fileChannel2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/serendipity/IdeaProjects/hadoop_01/netty/src/outbuffer.txt");
        FileChannel channel = fileInputStream.getChannel();
        try {
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
            // 将channel 中的数据写到buffer中
            String s = new String(map.array());
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            channel.close();
            fileInputStream.close();
        }
    }

    public void copy01() throws IOException {
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("/Users/serendipity/IdeaProjects/hadoop_01/netty/src/outbuffer.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/serendipity/IdeaProjects/hadoop_01/netty/src/outbuffer22.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();
        long end = System.currentTimeMillis();
        System.out.println("内存映射文件所花时间：" + (end - start));
    }

    public static void main(String[] args) throws IOException {
        new Code01_Channel().fileChannel();
    }

}
