package com.linky.bookreader.dagger.module;

import com.linky.bookreader.dagger.PerActivity;
import com.linky.bookreader.domain.api.BookReaderAPI;
import com.linky.bookreader.domain.usecase.BookReaderUsecase;
import com.linky.bookreader.domain.usecase.BookReaderUsecaseController;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linky on 16-2-3.
 */
@Module
public class ReaderModule {

    @Provides
    @PerActivity
    BookReaderUsecase providerMovieUsecase(BookReaderAPI bookReaderAPI) {
        return new BookReaderUsecaseController(bookReaderAPI);
    }
}
