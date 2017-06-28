package com.ramesh.gitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayToast();
    }

    private void displayToast() {
        Toast.makeText(this, "My sample", Toast.LENGTH_SHORT).show();
    }
}
