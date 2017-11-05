package com.ramesh.gitsample.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.ramesh.gitsample.R;

public class LoginActivity extends AppCompatActivity {

  private ProgressBar progressBar;
  private EditText username;
  private EditText password;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    progressBar = (ProgressBar) findViewById(R.id.progress);
    username = (EditText) findViewById(R.id.username);
    password = (EditText) findViewById(R.id.password);
  }

  @Override protected void onStart() {
    super.onStart();
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  @Override protected void onRestart() {
    super.onRestart();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }
}
