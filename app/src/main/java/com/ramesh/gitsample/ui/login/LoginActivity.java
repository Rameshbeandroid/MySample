package com.ramesh.gitsample.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.ramesh.gitsample.R;
import com.ramesh.gitsample.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

  @BindView(R.id.et_user_name) EditText etUserName;

  @BindView(R.id.et_user_password) EditText etPassword;

  @Override public LoginPresenter intPresenter() {
    Log.d("LogTrack", " : LoginPresenter() ");
    return new LoginPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d("LogTrack", " : onCreate() ");
    bindLayout(R.layout.activity_login);

  }

  @Override protected void onResume() {
    super.onResume();
    presenter.isLogin();
  }

  @OnClick() public void btUserLogin() {
    String userName = etUserName.getText().toString();
    String userPassword = etPassword.getText().toString();
    presenter.loginRequest(userName,userPassword);
  }

  @Override public void onSuccess(Object model) {

  }

  @Override public void onError(String s) {
    Toast.makeText(this, "" + s, Toast.LENGTH_LONG).show();
  }

  @Override public void onNavigation() {
    /*Moving to another activity*/
  }
}
