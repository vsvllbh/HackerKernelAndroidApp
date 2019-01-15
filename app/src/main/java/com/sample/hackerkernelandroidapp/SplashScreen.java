package com.sample.hackerkernelandroidapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.hackerkernelandroidapp.Activity.HomepageActivity;
import com.sample.hackerkernelandroidapp.Activity.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    private String api_token = "", Logout_status = "";
    private String name = "";
    private String email = "";
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setTitle("WEL COME");
        SharedPreferences pref = getApplicationContext().getSharedPreferences("LOGIN_PREF", 0);
        api_token = pref.getString("api_token", "");
        name = pref.getString("name", "");
        email = pref.getString("email", "");
        Logout_status = pref.getString("Logout_status", "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!api_token.equalsIgnoreCase("")) {
                    Intent i3 = new Intent(SplashScreen.this, HomepageActivity.class);
                    startActivity(i3);
                    finish();
                } else if (Logout_status.equalsIgnoreCase("LOG_OUT")) {
                    Intent i2 = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i2);
                    finish();
                } else {
                    Intent i2 = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i2);
                    finish();
                }
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}
