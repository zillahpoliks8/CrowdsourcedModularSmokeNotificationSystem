package com.app.uic.crowdsourcedmodularsmokenotificationsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashscreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent splash = new Intent(splashscreen.this,frmLogin.class);
                startActivity(splash);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
