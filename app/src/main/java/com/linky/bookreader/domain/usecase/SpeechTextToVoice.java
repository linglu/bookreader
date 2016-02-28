package com.linky.bookreader.domain.usecase;

import android.content.Context;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

/**
 * Created by Linky on 16-2-28.
 * 语音合成工具
 */
public class SpeechTextToVoice {

    private SpeechSynthesizer mTts;

    public SpeechTextToVoice(Context context) {
        mTts = SpeechSynthesizer.createSynthesizer(context, null);
    }

    /**
     * 初始化参数
     * @param reader    发音人
     * @param speed     语速
     * @param pitch     语调
     * @param volume    音量
     */
    public void initParameters(String reader, String speed, String pitch, String volume) {
        mTts.setParameter(SpeechConstant.PARAMS, null);

        // 设置合成引擎
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
        // 设置在线合成发音人
        mTts.setParameter(SpeechConstant.VOICE_NAME, reader);
        //设置合成语速
        mTts.setParameter(SpeechConstant.SPEED, speed);     // PreUtils.getStringPref("speed_preference", "50"));
        //设置合成音调
        mTts.setParameter(SpeechConstant.PITCH, pitch);     // mSharedPreferences.getString("pitch_preference", "50"));
        //设置合成音量
        mTts.setParameter(SpeechConstant.VOLUME, volume);   // mSharedPreferences.getString("volume_preference", "50"));
    }

    /**
     * 开始朗读
     * @param text 要朗读的文本
     * @param mTtsListener 朗读回调监听
     */
    public void startRead(String text, SynthesizerListener mTtsListener) {
        mTts.startSpeaking(text, mTtsListener);
    }
}
