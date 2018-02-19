package com.ramesh.gitsample;

import android.app.Application;
import com.ramesh.gitsample.di.component.ApiComponent;
import com.ramesh.gitsample.di.ApiModule;
import com.ramesh.gitsample.di.AppModule;
import com.ramesh.gitsample.di.DaggerApiComponent;

/**
 * Created by lencare on 05-Dec-17.
 */

public class AppClass extends Application {

  private ApiComponent mApiComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mApiComponent = DaggerApiComponent
        .builder()
        .appModule(new AppModule(this))
        .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
        .build();

  }

  public ApiComponent getNetComponent() {
    return mApiComponent;
  }
}
