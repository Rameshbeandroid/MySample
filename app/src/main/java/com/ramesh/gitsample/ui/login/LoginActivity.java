package com.ramesh.gitsample.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.ramesh.gitsample.R;

public class LoginActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    displayBranchOne();
  }

  private void displayBranchOne() {
    Log.d("BRANCH"," : BRANCH 01");
  }

  @Override protected void onResume() {
    super.onResume();
  }

}
