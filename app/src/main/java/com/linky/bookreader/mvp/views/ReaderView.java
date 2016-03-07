package com.linky.bookreader.mvp.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linky.bookreader.R;

/**
 * Created by linky on 16-2-3.
 */
public class ReaderView implements BaseView {

    private View mRootView;
    private TextView mTvContent;
    private OnActionListener mOnActionListener;

    @Override
    public void init(LayoutInflater inflater, ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.movie_layout, parent, false);
        initViews(mRootView);
    }

    @Override
    public View getView() {
        return mRootView;
    }

    private void initViews(View view) {
        mTvContent = (TextView) view.findViewById(R.id.tv_content);

        view.findViewById(R.id.btn_read).setOnClickListener(v -> {
            mOnActionListener.onRead();
        });

        view.findViewById(R.id.btn_pause).setOnClickListener(v -> {
            mOnActionListener.onPause();
        });

        view.findViewById(R.id.btn_continue).setOnClickListener(v -> {
            mOnActionListener.onContinue();
        });

        view.findViewById(R.id.btn_stop).setOnClickListener(v -> {
            mOnActionListener.onStop();
        });
    }

    public void setOnActionListener(OnActionListener onActionListener) {
        this.mOnActionListener = onActionListener;
    }

    /**
     * 显示正在阅读的文本
     */
    public void setReadingText(String text) {
        mTvContent.setText(text);
    }

    public interface OnActionListener {
        void onRead();
        void onPause();
        void onContinue();
        void onStop();
    }
}
