package com.huoxy.coolweather;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "HaHa", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
