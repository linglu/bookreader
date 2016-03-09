package com.linky.bookreader.domain.usecase;

import android.content.Context;

import com.linky.bookreader.dao.orm.EbookBean;
import com.linky.bookreader.domain.api.BookReaderAPI;
import com.linky.bookreader.support.utils.ClipboardUtil;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by linky on 16-2-3.
 *
 */
public class BookReaderUsecaseController implements BookReaderUsecase {

    private final BookReaderAPI mBookReaderAPI;

    public BookReaderUsecaseController(BookReaderAPI bookReaderAPI) {
        this.mBookReaderAPI = bookReaderAPI;
    }

    @Override
    public Observable<String> getNextTextBlock(int lastPosition, int blockSize) {
        return mBookReaderAPI.getNextTextBlock(lastPosition, blockSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<EbookBean> getTextFromClipboard(Context context) {
        ClipboardUtil mClipBoard = new ClipboardUtil(context);
        String text = mClipBoard.getTextFromClipBoard();
        return null;
    }
}
