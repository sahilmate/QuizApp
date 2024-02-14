package com.example.bootcampapp.Screens.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button android = findViewById(R.id.buttonAndroid);
        Button webDev = findViewById(R.id.buttonWebDev);
        Button flutter = findViewById(R.id.buttonFlutter);
        Button cloud = findViewById(R.id.buttonCloud);

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AndroidActivity.class);
                startActivity(intent);
            }
        });
        webDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebDevActivity.class);
                startActivity(intent);
            }
        });
        flutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FlutterActivity.class);
                startActivity(intent);
            }
        });
        cloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, G_CloudActivity.class);
                startActivity(intent);
            }
        });
    }
    public void send(View view) {
        // Perform actions when the "Login" TextView is clicked
        Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show();

    }

}