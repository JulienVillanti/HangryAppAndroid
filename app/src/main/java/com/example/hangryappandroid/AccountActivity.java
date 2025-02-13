package com.example.hangryappandroid;

import android.os.Bundle;
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


    }
}
