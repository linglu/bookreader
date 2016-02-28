package com.linky.bookreader.dagger.compoment;

import android.app.Activity;

import dagger.Component;
import com.linky.bookreader.dagger.PerActivity;
import com.linky.bookreader.dagger.module.ActivityModule;

/**
 * Created by linky on 16-2-3.
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    // Exposed to sub_graph
    Activity activity();
}
