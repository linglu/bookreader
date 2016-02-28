package com.linky.bookreader.dagger.provider;

import com.linky.bookreader.VoiceApp;
import com.linky.bookreader.dagger.compoment.DaggerReaderComponent;
import com.linky.bookreader.dagger.module.ReaderModule;
import com.linky.bookreader.domain.usecase.BookReaderUsecase;

/**
 * Created by linky on 16-2-28.
 * Usecase 提供器
 */
public class UsecaseProvider {

    public static BookReaderUsecase getBookReaderUsecase() {
        return DaggerReaderComponent.builder()
                .applicationComponent(VoiceApp.mVoiceApp.getApplicationComponent())
                .readerModule(new ReaderModule())
                .build().bookReaderUsecase();
    }
}
