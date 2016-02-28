package com.linky.bookreader.mvp.presentation;

import android.os.Bundle;
import android.util.Log;

import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SynthesizerListener;
import com.linky.bookreader.R;
import com.linky.bookreader.callback.DefaultSubscriber;
import com.linky.bookreader.dagger.provider.UsecaseProvider;
import com.linky.bookreader.dao.config.SpeechConstants;
import com.linky.bookreader.domain.usecase.BookReaderUsecase;
import com.linky.bookreader.domain.usecase.SpeechTextToVoice;
import com.linky.bookreader.mvp.BaseFragmentPresenter;
import com.linky.bookreader.mvp.views.ReaderView;
import com.linky.bookreader.support.utils.ResUtils;
import com.linky.bookreader.support.utils.ToastUtils;

/**
 * Created by Linky on 16-2-3.
 */
public class ReaderFragment extends BaseFragmentPresenter<ReaderView> {

    private SpeechTextToVoice mSpeechTextToVoice;
    private BookReaderUsecase mBookReaderUsecase;

    private int mBuffPercent;   // 合成进度
    private int mPlayPercent;   // 播放进度

    public static ReaderFragment newInstance() {
        return new ReaderFragment();
    }

    @Override
    public void onBindView() {

        mBookReaderUsecase = UsecaseProvider.getBookReaderUsecase();

        mSpeechTextToVoice = new SpeechTextToVoice(getActivity());
        mSpeechTextToVoice.initParameters(SpeechConstants.reader, SpeechConstants.speed, SpeechConstants.pitch, SpeechConstants.volume);
        bv.setOnActionListener(mOnActionListener);
    }

    private SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {
            ToastUtils.showToast("开始播放");
        }

        @Override
        public void onSpeakPaused() {
            ToastUtils.showToast("暂停播放");
        }

        @Override
        public void onSpeakResumed() {
            ToastUtils.showToast("继续播放");
        }

        // 合成进度
        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
            mBuffPercent = percent;
            ToastUtils.showToast(ResUtils.getString(R.string.toast_tts_format, mBuffPercent, mPlayPercent));
        }

        // 播放进度
        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            mPlayPercent = percent;
            ToastUtils.showToast(ResUtils.getString(R.string.toast_tts_format, mBuffPercent, mPlayPercent));
        }

        @Override
        public void onCompleted(SpeechError error) {
            if (error == null) {
                ToastUtils.showToast("播放完成");

                readBook();
            } else {
                ToastUtils.showToast(error.getPlainDescription(true));
            }
        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }
    };


    private ReaderView.OnActionListener mOnActionListener = text -> {
        readBook();
    };

    private void readBook() {
        mBookReaderUsecase.getNextTextBlock()
                .compose(bindToLifecycle())
                .subscribe(new DefaultSubscriber<String>(){

                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        Log.e("TAG", s);
                        mSpeechTextToVoice.startRead(s, mTtsListener);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }
                });
    }

    @Override
    protected void afterBindData() {

    }

    @Override
    public Class<ReaderView> getViewClass() {
        return ReaderView.class;
    }


}
