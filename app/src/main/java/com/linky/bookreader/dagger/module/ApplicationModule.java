package com.linky.bookreader.dagger.module;

import android.content.Context;

import com.linky.bookreader.VoiceApp;
import com.linky.bookreader.dao.orm.DaoSession;
import com.linky.bookreader.domain.api.BookLocalSource;
import com.linky.bookreader.domain.api.BookReaderAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linky on 16-2-3.
 */
@Module
@Singleton
public class ApplicationModule {

    private final VoiceApp mVoiceApp;

    public ApplicationModule(VoiceApp voiceApp) {
        mVoiceApp = voiceApp;
    }

    @Provides
    @Singleton
    public Context providerContext() {
        return this.mVoiceApp;
    }

    @Provides
    @Singleton
    public DaoSession providerDaoSession() {
        return this.mVoiceApp.getDaoSession();
    }

    @Provides
    public BookReaderAPI providerMovieAPI(DaoSession daoSession) {
        return new BookLocalSource();
    }
}
