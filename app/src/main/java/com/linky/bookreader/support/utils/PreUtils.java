package com.linky.bookreader.support.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.linky.bookreader.VoiceApp;

/**
 * Created by linky on 16-2-4.
 */
public class PreUtils {

    private static Context appContext = VoiceApp.getAppContext();

    //长整形
    public static long getLongPref(String filename, String key, long value) {
        SharedPreferences prefs = appContext.getSharedPreferences(filename, Context.MODE_PRIVATE);
        return prefs.getLong(key, value);
    }

    public static void setLongPref(String filename, String key, long value) {
        SharedPreferences prefs = appContext.getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putLong(key, value);
        ed.apply();
    }

    //字符串
    public static String getStringPref(String filename, String key, String def) {
        SharedPreferences prefs = appContext.getSharedPreferences(filename, Context.MODE_PRIVATE);
        return prefs.getString(key, def);
    }

    public static void setStringPref(String filename, String key, String value) {
        SharedPreferences prefs = appContext.getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString(key, value);
        ed.apply();
    }

    // 整数类型
    public static int getIntPref(String filename, String key, int value) {
        SharedPreferences prefs = appContext.getSharedPreferences(filename, Context.MODE_PRIVATE);
        return prefs.getInt(key, value);
    }

    public static void setIntPref(String filename, String key, int value) {
        SharedPreferences prefs = appContext.getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putInt(key, value);
        ed.apply();
    }

}
