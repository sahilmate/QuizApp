package com.example.bootcampapp.Screens.Screens.Helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bootcampapp.R;

public class WebDevActivity extends AppCompatActivity {

    private String[] questions= {"Q.1 Which company developed android?", "Q.2 Which company bought android?", "Q.3 Web browser available in android is based on",
            "Q.4 Android is based on which kernel?"};
    private boolean[] rightAnsBA = {false, false,false,true};
    private boolean[] rightAnsBB = {true, true,false,false};
    private boolean[] rightAnsBC = {false, false,true,false};
    private boolean[] rightAnsBD = {false, false,false,false};

    private String[] buttonA = {"Google", "Amazon", "Chrome", "Linux"};
    private String[] buttonB = {"Android", "Google", "Opera", "MAC"};
    private String[] buttonC = {"TCS", "HCL", "Open-source Webkit", "Hybrid"};
    private String[] buttonD = {"Info sys", "Cognizant", "Firefox", "Windows"};


    Button opt1;
    Button opt2;
    Button opt3;
    Button opt4;
    TextView question;
    private int index = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_dev);


        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);


        question = findViewById(R.id.question);
        question.setText(questions[index]);

        opt1.setText(buttonA[index]);
        opt2.setText(buttonB[index]);
        opt3.setText(buttonC[index]);
        opt4.setText(buttonD[index]);


        opt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(index<=questions.length-1){
                    if(rightAnsBA[index]){
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1) {

                        question.setText(questions[index]);
                        opt1.setText(buttonA[index]);
                        opt2.setText(buttonB[index]);
                        opt3.setText(buttonC[index]);
                        opt4.setText(buttonD[index]);
                    }
                    else{
                        Toast.makeText(WebDevActivity.this, "Your score is: " +score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(WebDevActivity.this, "Restart the app", Toast.LENGTH_SHORT).show();
                }
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index<=questions.length-1){
                    if(rightAnsBB[index]){
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1){

                        question.setText(questions[index]);
                        opt1.setText(buttonA[index]);
                        opt2.setText(buttonB[index]);
                        opt3.setText(buttonC[index]);
                        opt4.setText(buttonD[index]);
                    }
                    else{
                        Toast.makeText(WebDevActivity.this, "Your score is: " +score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(WebDevActivity.this, "Restart the app", Toast.LENGTH_SHORT).show();
                }
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index<=questions.length-1){
                    if(rightAnsBC[index]){
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1){

                        question.setText(questions[index]);
                        opt1.setText(buttonA[index]);
                        opt2.setText(buttonB[index]);
                        opt3.setText(buttonC[index]);
                        opt4.setText(buttonD[index]);
                    }
                    else{
                        Toast.makeText(WebDevActivity.this, "Your score is: " +score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(WebDevActivity.this, "Restart the app", Toast.LENGTH_SHORT).show();
                }
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index<=questions.length-1){
                    if(rightAnsBD[index]){
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1){

                        question.setText(questions[index]);
                        opt1.setText(buttonA[index]);
                        opt2.setText(buttonB[index]);
                        opt3.setText(buttonC[index]);
                        opt4.setText(buttonD[index]);
                    }
                    else{
                        Toast.makeText(WebDevActivity.this, "Your score is: " +score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(WebDevActivity.this, "Restart the app", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}









