package com.linky.bookreader.domain.usecase;

import android.content.Context;

import com.linky.bookreader.dao.orm.EbookBean;

import rx.Observable;

/**
 * Created by linky on 16-2-3.
 */
public interface BookReaderUsecase {

    Observable<String> getNextTextBlock(int lastPosition, int blockSize);
    Observable<EbookBean> getTextFromClipboard(Context context);
}
