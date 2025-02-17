package com.example.hangryappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class AccountActivity extends AppCompatActivity {

    private Button driverButton, userButton, restaurantButton;
    private FirebaseAuth auth;
    private DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_screen);

        auth = FirebaseAuth.getInstance();
        databaseRef = FirebaseDatabase.getInstance().getReference();

        driverButton = findViewById(R.id.driverButton);
        userButton = findViewById(R.id.userButton);
        restaurantButton = findViewById(R.id.restaurantButton);

        driverButton.setOnClickListener(v -> redirectToSignUp("driver"));
        userButton.setOnClickListener(v -> redirectToSignUp("user"));
        restaurantButton.setOnClickListener(v ->redirectToSignUp("restaurant"));
    }

    private void redirectToSignUp(String accountType) {

        Intent intent = new Intent(AccountActivity.this, SignUpActivity.class);
        intent.putExtra("accountType", accountType);
        startActivity(intent);
        finish(); 
    }
}
