package com.ramesh.gitsample.di;

import android.app.Application;
import android.content.Context;
import com.ramesh.gitsample.database.DbComponant;
import com.ramesh.gitsample.ui.LoginComponent;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by lencare on 05-Dec-17.
 */

@Module(subcomponents = { LoginComponent.class, DbComponant.class})
public class AppModule {

  @Singleton
  @Provides Context provideContext(Application application) {
    return application;
  }
}