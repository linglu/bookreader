package com.linky.bookreader.dagger.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import com.linky.bookreader.dagger.PerActivity;

/**
 * Created by linky on 16-2-3.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity act) {
        activity = act;
    }

    @Provides
    @PerActivity
    Activity providersActivity() {
        return this.activity;
    }
}
