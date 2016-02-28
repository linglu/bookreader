package com.linky.bookreader.mvp.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.linky.bookreader.R;

/**
 * Created by linky on 16-2-3.
 */
public class ReaderView implements BaseView {

    private View mRootView;
    private EditText mEtText;
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
        mEtText = (EditText) view.findViewById(R.id.et_text);
        view.findViewById(R.id.btn_read).setOnClickListener(v -> {
            String text = mEtText.getText().toString();
            mOnActionListener.onRead(text);
        });
    }

    public void setOnActionListener(OnActionListener onActionListener) {
        this.mOnActionListener = onActionListener;
    }

    public interface OnActionListener {
        void onRead(String text);
    }
}
