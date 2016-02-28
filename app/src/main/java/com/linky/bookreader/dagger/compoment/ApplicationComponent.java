package com.linky.bookreader.dagger.compoment;

import android.content.Context;

import com.linky.bookreader.dagger.module.ApplicationModule;
import com.linky.bookreader.dao.orm.DaoSession;
import com.linky.bookreader.domain.api.BookReaderAPI;
import com.linky.bookreader.mvp.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by linky on 16-2-3.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    // Exposed to sub_graph
    Context context();

    DaoSession daoSession();

    BookReaderAPI movieApi();
}
