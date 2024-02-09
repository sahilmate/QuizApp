package com.example.bootcampapp.Screens.Screens.Helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bootcampapp.R;

public class AndroidActivity extends AppCompatActivity {


    Button btnOption1;
    Button btnOption2;
    Button btnOption3;

    TextView questionText;

    // ARRAY OF QUESTIONS ============================================
    private String[] questionsArray= {"Q.1 Which company developed android?", "Q.2 Which company bought android?", "Q.3 Web browser available in android is based on",
            "Q.4 Android is based on which kernel?"};


    // ARRAY OF OPTION TEXT (INDEX - WISE) ============================================
    private String[] btnOption1_text = {"Google", "Amazon", "Chrome", "Linux"};
    private String[] btnOption2_text = {"Android", "Google", "Opera", "MAC"};
    private String[] btnOption3_text = {"TCS", "HCL", "Open-source Webkit", "Hybrid"};


    // ARRAY OF OPTION VALIDATION ============================================
    private boolean[] validate1 = {false, false,false,true};
    private boolean[] validate2 = {true, true,false,false};
    private boolean[] validate3 = {false, false,true,false};



    // INITIALISE THE VARIABLES ===============================================
    private int index = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);




        // REFER THE OPTION BUTTONS =====================================
        btnOption1 = findViewById(R.id.opt1);
        btnOption2 = findViewById(R.id.opt2);
        btnOption3 = findViewById(R.id.opt3);





        // REFER THE QUESTIONS TEXTVIEW & SET TEXT =====================================
        questionText = findViewById(R.id.question);
        questionText.setText(questionsArray[index]);




        // REFER THE OPTION BUTTON & SET TEXT =====================================
        btnOption1.setText(btnOption1_text[index]);
        btnOption2.setText(btnOption2_text[index]);
        btnOption3.setText(btnOption3_text[index]);






        View.OnClickListener optionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= questionsArray.length - 1) {
                    boolean[] currentValidation = null;
                    Button clickedButton = (Button) view;

                    if (view == btnOption1) {
                        currentValidation = validate1;
                    } else if (view == btnOption2) {
                        currentValidation = validate2;
                    } else if (view == btnOption3) {
                        currentValidation = validate3;
                    }

                    if (currentValidation != null) {
                        if (currentValidation[index]) {
                            score++;
                        }
                        index++;
                        if (index <= questionsArray.length - 1) {
                            questionText.setText(questionsArray[index]);
                            btnOption1.setText(btnOption1_text[index]);
                            btnOption2.setText(btnOption2_text[index]);
                            btnOption3.setText(btnOption3_text[index]);
                        } else {
                            Toast.makeText(AndroidActivity.this, "Your score is: " + score + "/" + questionsArray.length, Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(AndroidActivity.this, "Restart the app", Toast.LENGTH_SHORT).show();
                }
            }
        };


        btnOption1.setOnClickListener(optionClickListener);
        btnOption2.setOnClickListener(optionClickListener);
        btnOption3.setOnClickListener(optionClickListener);


    }
}