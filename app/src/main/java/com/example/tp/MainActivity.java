package com.example.tp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        Button button = findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        logo.setVisibility(View.VISIBLE);
        //button first Animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.reapparition);
        button.startAnimation(animation);
        button.setVisibility(View.VISIBLE);
        //logo first Animation
        Animation animationlogo = AnimationUtils.loadAnimation(this, R.anim.welcome);
        logo.startAnimation(animationlogo);
        logo.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animationbutton2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tv_off);
                v.startAnimation(animationbutton2);
                animationbutton2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        v.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });



        /*new Handler().postDelayed(new Runnable() {
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
        });*/
    }
}