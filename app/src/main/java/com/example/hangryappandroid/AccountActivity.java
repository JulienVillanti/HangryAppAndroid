package com.example.hangryappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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

        driverButton.setOnClickListener(v -> saveAccountTypeAndRedirect("driver"));
        userButton.setOnClickListener(v -> saveAccountTypeAndRedirect("user"));
        restaurantButton.setOnClickListener(v -> saveAccountTypeAndRedirect("restaurant"));
    }

    private void saveAccountTypeAndRedirect(String accountType) {

        FirebaseUser user = auth.getCurrentUser();

        if (user != null) {

            String userId = user.getUid();
            String userEmail = user.getEmail();

            HashMap<String, Object> userData = new HashMap<>();
            userData.put("email", userEmail);
            userData.put("accountType", accountType);

            databaseRef.child("users").child(userId).child("accountType").setValue(accountType)
                    .addOnSuccessListener(aVoid -> {

                        Intent intent = new Intent(AccountActivity.this, SigninActivity.class);
                        startActivity(intent);
                        finish();
                    })
                    .addOnFailureListener(e -> {

                    });
        } else {

            Intent intent = new Intent(AccountActivity.this, SigninActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

