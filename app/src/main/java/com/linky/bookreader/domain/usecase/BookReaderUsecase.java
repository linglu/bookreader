package com.linky.bookreader.domain.usecase;

import rx.Observable;

/**
 * Created by linky on 16-2-3.
 */
public interface BookReaderUsecase {

    Observable<String> getNextTextBlock();
}
