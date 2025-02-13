package com.example.hangryappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button signInButton;
    private TextView signUpButton, resetPasswordButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_screen);

        mAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        signInButton = findViewById(R.id.cirLoginButton);
        signUpButton = findViewById(R.id.signUpButton);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("email")) {
            String email = intent.getStringExtra("email");
            editTextEmail.setText(email);
        }

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {

                    Toast.makeText(SigninActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Fazer login com Firebase Authentication
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SigninActivity.this, task -> {
                                if (task.isSuccessful()) {

                                    Toast.makeText(SigninActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();


                                    Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {

                                    Toast.makeText(SigninActivity.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SigninActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SigninActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}
