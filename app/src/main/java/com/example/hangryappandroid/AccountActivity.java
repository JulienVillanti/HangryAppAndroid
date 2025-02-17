package com.example.hangryappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class AccountActivity extends AppCompatActivity {

    private Button driverButton, userButton, restaurantButton;
    private TextView textViewSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_screen);


        driverButton = findViewById(R.id.driverButton);
        userButton = findViewById(R.id.userButton);
        restaurantButton = findViewById(R.id.restaurantButton);

        driverButton.setOnClickListener(v -> redirectToSignUp("driver"));
        userButton.setOnClickListener(v -> redirectToSignUp("user"));
        restaurantButton.setOnClickListener(v ->redirectToSignUp("restaurant"));

        textViewSignIn = findViewById(R.id.textViewSignIn);

        textViewSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, SigninActivity.class);
            startActivity(intent);
            finish();
        });
    }


    private void redirectToSignUp(String accountType) {

        Intent intent = new Intent(AccountActivity.this, SignUpActivity.class);
        intent.putExtra("accountType", accountType);
        startActivity(intent);
        finish();
    }
}
