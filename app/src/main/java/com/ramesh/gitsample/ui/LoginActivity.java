package com.ramesh.gitsample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import com.ramesh.gitsample.R;
import com.squareup.sqlbrite3.BriteDatabase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginView {

  private EditText etuserName;
  private EditText etPassWord;
  private Button btSingIn;
  @Inject BriteDatabase db;
  private Disposable disposable;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    intiUIElement();

  }
  private void intiUIElement() {
    etuserName = (EditText) findViewById(R.id.et_user_name);
    etPassWord = (EditText) findViewById(R.id.et_user_pass_word);
    btSingIn = (Button) findViewById(R.id.bt_sign_in);
  }

  @Override public void onUserNameEmpty() {

  }

  @Override public void onPasswordEmpty() {

  }

  @Override protected void onResume() {
    super.onResume();
    //disposable = db.createQuery(ListsItem.TABLES, ListsItem.QUERY)
    //    .mapToList(ListsItem.MAPPER)
    //    .observeOn(AndroidSchedulers.mainThread());
  }
}