package com.ramesh.gitsample;

import android.app.Activity;
import android.app.Application;
import com.ramesh.gitsample.di.DaggerAppComponant;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

/**
 * Created by lencare on 05-Dec-17.
 */

public class AppClass extends Application implements HasActivityInjector {

  @Inject DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

  @Override public void onCreate() {
    super.onCreate();
    DaggerAppComponant
        .builder()
        .application(this)
        .build()
        .inject(this);
  }

  @Override public AndroidInjector<Activity> activityInjector() {
    return activityDispatchingAndroidInjector;
  }
}
