package com.example.tp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView logo = findViewById(R.id.logo);
        logo.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, View.SCALE_Y, 1f, 0f);
                scaleY.setDuration(500);
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, View.SCALE_X, 1f, 2f);
                scaleX.setDuration(500);
                scaleY.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        logo.setVisibility(View.INVISIBLE);
                    }
                });
                scaleY.start();
                scaleX.start();
            }
        }, 500);

        Button button = findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator fromLeft = ObjectAnimator.ofFloat(button, "translationX", 0f, 400f);
                fromLeft.setDuration(500);
                fromLeft.start();
                button.setVisibility(View.VISIBLE);
            }
        }, 800);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator scaleY = ObjectAnimator.ofFloat(button, View.SCALE_Y, 1f, 0f);
                        scaleY.setDuration(500);
                        ObjectAnimator scaleX = ObjectAnimator.ofFloat(button, View.SCALE_X, 1f, 2.5f);
                        scaleX.setDuration(500);
                        scaleY.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                button.setVisibility(View.INVISIBLE);
                            }
                        });
                        scaleY.start();
                        scaleX.start();
                    }
                }, 0);
                startActivity(new Intent(getApplicationContext(), DisplayActivity.class));
            }
        });
    }
}