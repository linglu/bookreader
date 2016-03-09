package com.linky;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by linky on 16-2-28.
 */
public class MapBuffer {

    public static void main(String[] args) {

    }

    public static void a() {

        File file = new File("/home/linky/share/shendiao.txt");

        if (!file.exists()) {
            System.out.println("文件不存在");
        } else {

            MappedByteBuffer buffer = createMappedByteBuffer(file, 512);

            if (buffer != null) {

                try {
                    byte[] array = new byte[buffer.limit()];
                    for (int i = 0; i < buffer.limit(); i++) {
                        array[i] = buffer.get(i);
                    }

                    String s = new String(array, "UTF-8");
                    System.out.println("string : " + s);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(" buffer == null ");
            }
        }
    }

    public static MappedByteBuffer createMappedByteBuffer(File file, int length) {
        try {

            FileChannel channel = new RandomAccessFile(file, "r").getChannel();
            return channel.map(FileChannel.MapMode.READ_ONLY, 0, length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
