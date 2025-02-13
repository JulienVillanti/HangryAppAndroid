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
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button signUpButton;
    private TextView signInTextView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        mAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        signUpButton = findViewById(R.id.singUpBtn);
        signInTextView = findViewById(R.id.signIn);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(SignUpActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(SignUpActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                } else {

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUpActivity.this, task -> {
                                if (task.isSuccessful()) {
                                    // Cadastro bem-sucedido
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user != null) {
                                        Toast.makeText(SignUpActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();

                                        // Redirecionar para a SigninActivity com o email preenchido
                                        Intent intent = new Intent(SignUpActivity.this, SigninActivity.class);
                                        intent.putExtra("email", email); // Passar o email como extra
                                        startActivity(intent);
                                        finish();
                                    }
                                } else {

                                    Toast.makeText(SignUpActivity.this, "Sign up failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

                    signInTextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(SignUpActivity.this, SigninActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
