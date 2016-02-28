package com.linky.bookreader.dagger.compoment;

import com.linky.bookreader.dagger.PerActivity;
import com.linky.bookreader.dagger.module.ReaderModule;
import com.linky.bookreader.domain.usecase.BookReaderUsecase;

import dagger.Component;

/**
 * Created by linky on 16-2-3.
 */
@PerActivity
@Component(modules = ReaderModule.class, dependencies = ApplicationComponent.class)
public interface ReaderComponent {

    BookReaderUsecase bookReaderUsecase();
}
