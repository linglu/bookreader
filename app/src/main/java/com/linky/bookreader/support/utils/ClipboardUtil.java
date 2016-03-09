package com.linky.bookreader.support.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import com.orhanobut.logger.Logger;

/**
 * Created by Linky on 16-2-17.
 * 剪贴板工具
 */
public class ClipboardUtil {

    private ClipboardManager mClipboardManager;

    public ClipboardUtil(Context context) {
        mClipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void copyToClipBoard(String content) {
        mClipboardManager.setPrimaryClip(ClipData.newPlainText("url", content));
    }

    /**
     * 从剪贴板中获取文本内容
     */
    public String getTextFromClipBoard() {

        if (mClipboardManager.hasPrimaryClip()) {
            ClipData clip = mClipboardManager.getPrimaryClip();
            int itemCount = clip.getItemCount();

            Logger.i(" itemCount : " + itemCount);

            for (int i = 0; i < itemCount; i++) {
                ClipData.Item item = clip.getItemAt(i);
                CharSequence text = item.getText();
                Logger.i(text.toString());
            }
        }

        return null;
    }
}
