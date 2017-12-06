package com.ramesh.gitsample.ui;

import com.ramesh.gitsample.api.ApiService;

/**
 * Created by lencare on 05-Dec-17.
 */

public class LoginPresenderImp implements LoginPresender {
  LoginView loginView;
  ApiService apiService;

  public LoginPresenderImp(LoginView loginView, ApiService apiService) {
    this.loginView = loginView;
    this.apiService = apiService;
  }

  @Override public void loadData() {

  }
}
