package com.example.hangryappandroid;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // Usar um Handler para atrasar a transição para a MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Iniciar a MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // Finalizar a SplashActivity
                finish();
            }
        }, SPLASH_DELAY);
    }
}