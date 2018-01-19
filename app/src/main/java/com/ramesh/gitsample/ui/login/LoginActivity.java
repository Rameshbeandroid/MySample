package com.ramesh.gitsample.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.ramesh.gitsample.R;

public class LoginActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    displayLogForBranch01();
  }

  private void displayLogForBranch01() {
    Toast.makeText(this, "Branch01", Toast.LENGTH_SHORT).show();
  }

  @Override protected void onResume() {
    super.onResume();
  }
}
