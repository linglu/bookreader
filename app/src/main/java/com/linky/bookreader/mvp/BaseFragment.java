package com.linky.bookreader.mvp;

import android.app.Activity;
import android.content.Context;

import com.linky.bookreader.VoiceApp;
import com.linky.bookreader.dagger.compoment.ApplicationComponent;
import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Created by linky on 16-2-4.
 */
public class BaseFragment extends RxFragment {

    private Activity mAct;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAct = (BaseActivity) context;
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((VoiceApp) mAct.getApplication()).getApplicationComponent();
    }

}
