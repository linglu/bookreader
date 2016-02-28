package com.linky.bookreader.callback;

import com.linky.bookreader.support.utils.ToastUtils;
import rx.Subscriber;

/**
 * Created by linky on 16-2-16.
 */
public class DefaultSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        ToastUtils.showToast(e.getMessage());
    }

    @Override
    public void onNext(T t) {

    }
}
