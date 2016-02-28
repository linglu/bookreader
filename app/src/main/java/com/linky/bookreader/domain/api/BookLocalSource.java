package com.linky.bookreader.domain.api;

import android.os.Environment;

import com.linky.bookreader.support.utils.SettingInfo;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import rx.Observable;

/**
 * Created by linky on 16-2-4.
 */
public class BookLocalSource implements BookReaderAPI {

    public BookLocalSource() {
    }

    @Override
    public Observable<String> getNextTextBlock() {
        return Observable.create(subscriber -> {
            // TODO: 从 TXT 中获取下一段要读的文本；

            String state = Environment.getExternalStorageState();
            if (!Environment.MEDIA_MOUNTED.equals(state)) {
                subscriber.onError(new Exception("SD 卡不存在"));
            } else {

                File dir = Environment.getExternalStorageDirectory();
                File file = new File(dir + File.separator + "shendiao.txt");

                if (!file.exists()) {
                    subscriber.onError(new Exception("文件不存在"));
                } else {

                    int lastPosition = SettingInfo.getLastPosition();
                    int blockSize = SettingInfo.getTextBlockSize();
                    MappedByteBuffer buffer = createMappedByteBuffer(file, lastPosition, blockSize);

                    if (buffer != null) {

                        try {
                            byte[] array = new byte[buffer.limit()];
                            for (int i = 0; i < buffer.limit(); i++) {
                                array[i] = buffer.get(i);
                            }

                            String s = new String(array, "UTF-8");

                            lastPosition += blockSize;
                            SettingInfo.setLastPosition(lastPosition);

                            subscriber.onNext(s);
                            subscriber.onCompleted();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            subscriber.onError(e);
                        }
                    } else {
                        subscriber.onError(new Exception(" buffer == null "));
                    }
                }
            }
        });
    }

    public MappedByteBuffer createMappedByteBuffer(File file, int position, int length) {
        try {
            FileChannel channel = new RandomAccessFile(file, "r").getChannel();
            return channel.map(FileChannel.MapMode.READ_ONLY, position, length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Logger.i(e.getMessage());
        } catch (IOException e) {
            Logger.i(e.getMessage());
        }
        return null;
    }
}
