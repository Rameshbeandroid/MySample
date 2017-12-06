package com.ramesh.gitsample.di;

import android.app.Activity;
import com.ramesh.gitsample.ui.LoginActivity;
import com.ramesh.gitsample.ui.LoginComponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by lencare on 04-Dec-17.
 */
@Module
public abstract class ActivityBuilder {

  @Binds
  @IntoMap
  @ActivityKey(LoginActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> buildMainActivity(LoginComponent.Builder builder);
}
