package com.example.projeh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        login.playAnimation();

    }

}