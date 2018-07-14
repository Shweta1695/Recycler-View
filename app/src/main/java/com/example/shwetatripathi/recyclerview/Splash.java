package com.example.shwetatripathi.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedpref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedpref.getString("username", "");
        String pass = sharedpref.getString("password", "");


           /*// to delete data fromm shared prefrences
               sharedpref.edit().clear().commit();
               sharedpref.edit().remove("username").commit();
          */


        if (name.equals("")) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Splash.this, NewUser.class);
                    startActivity(i);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent in = new Intent(Splash.this, MainActivity.class);
                    startActivity(in);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }

    }
}
