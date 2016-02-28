package com.linky.bookreader.support.utils;

import android.content.Context;
import android.widget.Toast;

import com.linky.bookreader.VoiceApp;

/**
 * Created by linky on 16-2-4.
 */
public class ToastUtils {

    public static void showToast(int resId) {
        Toast.makeText(getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(String info) {
        Toast.makeText(getContext(), info, Toast.LENGTH_SHORT).show();
    }

    public static Context getContext() {
        return VoiceApp.mVoiceApp.getApplicationContext();
    }
}
