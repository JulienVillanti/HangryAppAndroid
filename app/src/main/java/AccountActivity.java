package com.example.hangryappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_screen);


        Button driverButton = findViewById(R.id.driverButton);
        Button userButton = findViewById(R.id.userButton);
        Button restaurantButton = findViewById(R.id.restaurantButton);
        Button adminButton = findViewById(R.id.adminButton);


//        driverButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(AccountActivity.this, com.example.hangryappandroid.DriverLoginActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        userButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Abrir a tela de login do usuário
//                Intent intent = new Intent(AccountActivity.this, com.example.hangryappandroid.UserLoginActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        restaurantButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Abrir a tela de login do restaurante
//                Intent intent = new Intent(AccountActivity.this, com.example.hangryappandroid.RestaurantLoginActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        adminButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(AccountActivity.this, com.example.hangryapp.AdminLoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
