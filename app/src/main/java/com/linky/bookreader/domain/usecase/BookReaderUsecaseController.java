package com.linky.bookreader.domain.usecase;

import com.linky.bookreader.domain.api.BookReaderAPI;

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
    public Observable<String> getNextTextBlock() {
        return mBookReaderAPI.getNextTextBlock()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
