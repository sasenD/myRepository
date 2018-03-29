package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by denghh on 2018/3/27.
 */
public class TestChannel {

    public void test() throws Exception {
        RandomAccessFile file = new RandomAccessFile("F://xiaobaituinfo.sql","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = channel.read(buffer);

        while (bytesRead != -1) {
            System.out.print("read:" + bytesRead);
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            bytesRead = channel.read(buffer);
        }

        file.close();
    }

    public static void main(String[] args) {
        try {
            new TestChannel().test();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
