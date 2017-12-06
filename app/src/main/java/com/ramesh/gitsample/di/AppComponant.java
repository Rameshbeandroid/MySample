package com.ramesh.gitsample.di;

import android.app.Application;
import com.ramesh.gitsample.AppClass;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by lencare on 04-Dec-17.
 */
@Component(modules =
    { AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
    })
public interface AppComponant {

  @Component.Builder interface Builder {
     @BindsInstance Builder application(Application application);
     AppComponant build();
  }

void inject(AppClass appClass);
}
