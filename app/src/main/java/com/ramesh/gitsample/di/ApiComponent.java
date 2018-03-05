package com.ramesh.gitsample.di;

import com.ramesh.gitsample.ui.login.LoginActivity;
import com.ramesh.gitsample.ui.login.LoginPresenter;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Belal on 12/2/2017.
 */

@Singleton @Component(modules = { AppModule.class, ApiModule.class })
public interface ApiComponent {

  void inject(LoginActivity loginActivity);

}
