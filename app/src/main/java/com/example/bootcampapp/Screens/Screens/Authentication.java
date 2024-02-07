package com.example.bootcampapp.Screens.Screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bootcampapp.R;
import com.example.bootcampapp.Screens.Screens.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Authentication extends AppCompatActivity {

    EditText editTextSignUpName, editTextSignUpEmail, editTextSignUpPassword, editTextSignUpConfPassword;
    EditText editTextLogInEmail, editTextLoginPassword;

    Button btnSignUp, btnLogIn;

    FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;

    User user;

    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String PREF_NAME = "MyPrefFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);


        editTextLogInEmail = findViewById(R.id.logEmail);
        editTextLoginPassword = findViewById(R.id.logPass);

        editTextSignUpName = findViewById(R.id.signUpName);
        editTextSignUpEmail = findViewById(R.id.signUpEmail);
        editTextSignUpPassword = findViewById(R.id.signUpPassword);
        editTextSignUpConfPassword = findViewById(R.id.signUpPassConfirm);

        btnLogIn = findViewById(R.id.login_button);
        btnSignUp = findViewById(R.id.signUpButton);

        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();



        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void signUp() {
        String name = editTextSignUpName.getText().toString().trim();
        String email = editTextSignUpEmail.getText().toString().trim();
        String password = editTextSignUpPassword.getText().toString().trim();

        // Check if any field is empty
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Email and password are required", Toast.LENGTH_SHORT).show();
            return;
        }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign up success, update UI with the signed-in user's information
                                Toast.makeText(Authentication.this, "Sign up successful", Toast.LENGTH_SHORT).show();

                                // Store user information to Firestore
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (user != null) {
                                    String userId = user.getUid();
                                    DocumentReference userRef = mFirestore.collection("users").document(userId);

                                    Map<String, Object> userData = new HashMap<>();
                                    userData.put("userName", name);
                                    userData.put("userEmail", user.getEmail());

                                    userRef.set(userData)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        // User data saved successfully
                                                        Toast.makeText(Authentication.this, "User data saved", Toast.LENGTH_SHORT).show();
                                                        sendUserToNextActivity();
                                                    } else {
                                                        Toast.makeText(Authentication.this, "Failed to save user data", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                }
                            } else {
                                // If sign up fails, display a message to the user.
                                Toast.makeText(Authentication.this, "Authentication failed: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }



    private void sendUserToNextActivity() {
        Toast.makeText(this, "sendusertonextactivity() called", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Authentication.this, MainActivity.class);
        startActivity(intent);

    }

    private void login() {
        String email = editTextLogInEmail.getText().toString().trim();
        String password = editTextLoginPassword.getText().toString().trim();

        // Check if any field is empty
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Email and password are required", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform Firebase logi
    }

    }
