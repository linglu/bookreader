package com.linky.bookreader.domain.api;

import rx.Observable;

/**
 * Created by linky on 16-2-4.
 */
public interface BookReaderAPI {

    Observable<String> getNextTextBlock();
}
