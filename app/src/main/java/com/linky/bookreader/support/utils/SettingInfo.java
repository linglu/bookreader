package com.linky.bookreader.support.utils;

/**
 * Created by linky on 16-2-4.
 */
public class SettingInfo {

    private static final String NAME = "SettingInfo";

    public static final String LAST_POSITION = "LAST_POSITION";
    public static final String TEXT_BLOCK_SIZE = "TEXT_BLOCK_SIZE";

    /**
     * 获取当前的文本位置
     */
    public static int getLastPosition() {
        return PreUtils.getIntPref(NAME, LAST_POSITION, 0);
    }

    /**
     * 设置当前的文本位置
     */
    public static void setLastPosition(int position) {
        PreUtils.setIntPref(NAME, LAST_POSITION, position);
    }

    /**
     * 获取一次缓存的文本大小
     */
    public static int getTextBlockSize() {
        return PreUtils.getIntPref(NAME, TEXT_BLOCK_SIZE, 512);
    }

    /**
     * 设置一次缓存的文本大小
     */
    public static void setTextBlockSize(int blockSize) {
        PreUtils.setIntPref(NAME, TEXT_BLOCK_SIZE, blockSize);
    }

}
