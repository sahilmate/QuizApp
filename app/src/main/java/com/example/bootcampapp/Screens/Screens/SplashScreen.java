package com.example.bootcampapp.Screens.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.bootcampapp.R;
import com.example.bootcampapp.Screens.Screens.MainActivity;

public class SplashScreen extends AppCompatActivity {


    private static int SPLASH_TIME_OUT = 1900;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(Authentication.PREFS_NAME,0);
                boolean hasRegistered = sharedPreferences.getBoolean("hasRegistered",false);


                Intent i;
                if(hasRegistered){

                    i = new Intent(com.example.bootcampapp.Screens.Screens.SplashScreen.this, MainActivity.class);

                }
                else{
                    i = new Intent(com.example.bootcampapp.Screens.Screens.SplashScreen.this, Authentication.class);
                }
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(Authentication.PREF_NAME,0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);


                Intent i;
                if(hasLoggedIn){

                    i = new Intent(com.example.bootcampapp.Screens.Screens.SplashScreen.this, MainActivity.class);

                }
                else{
                    i = new Intent(com.example.bootcampapp.Screens.Screens.SplashScreen.this, Authentication.class);
                }
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}