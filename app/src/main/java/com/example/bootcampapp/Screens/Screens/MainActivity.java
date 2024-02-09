package com.example.bootcampapp.Screens.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bootcampapp.R;
import com.example.bootcampapp.Screens.Screens.Helper.AndroidActivity;
import com.example.bootcampapp.Screens.Screens.Helper.FlutterActivity;
import com.example.bootcampapp.Screens.Screens.Helper.G_CloudActivity;
import com.example.bootcampapp.Screens.Screens.Helper.WebDevActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void android(View view){

        Toast.makeText(this, "Best of luck, mate!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AndroidActivity.class);
        startActivity(intent);
//        Animatoo.INSTANCE.animateSwipeRight(this);

    }


    public void webDev(View view){

        Toast.makeText(this, "Best of luck, mate!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, WebDevActivity.class);
        startActivity(intent);
//        Animatoo.INSTANCE.animateSwipeRight(this);

    }

    public void flutter(View view){

        Toast.makeText(this, "Best of luck, mate!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, FlutterActivity.class);
        startActivity(intent);
//        Animatoo.INSTANCE.animateSwipeRight(this);

    }

    public void g_cloud(View view){

        Toast.makeText(this, "Best of luck, mate!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, G_CloudActivity.class);
        startActivity(intent);
//        Animatoo.INSTANCE.animateSwipeRight(this);

    }



}