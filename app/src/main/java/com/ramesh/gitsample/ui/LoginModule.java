package com.ramesh.gitsample.ui;

import com.ramesh.gitsample.api.ApiService;
import dagger.Module;
import dagger.Provides;

/**
 * Created by lencare on 05-Dec-17.
 */

@Module
public class LoginModule {
  @Provides LoginView provideMainView(LoginActivity loginActivity) {
    return loginActivity;
  }

  @Provides LoginPresender provideMainPresender(LoginView loginView, ApiService apiService) {
    return new LoginPresenderImp(loginView,apiService);
  }
}
