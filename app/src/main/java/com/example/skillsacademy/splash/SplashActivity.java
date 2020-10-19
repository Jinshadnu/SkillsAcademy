package com.example.skillsacademy.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.skillsacademy.MainActivity;
import com.example.skillsacademy.R;
import com.example.skillsacademy.welcome.OnboardActivity;

public class SplashActivity extends AppCompatActivity {
public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        imageView=(ImageView)findViewById(R.id.image_logo);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.mytransition);

        imageView.startAnimation(animation);
        final Intent intent=new Intent(this, OnboardActivity.class);
        final Thread timer=new Thread(){
            @Override
            public void run() {
               try {
                   sleep(5000);
                   }catch (InterruptedException e){
                   e.printStackTrace();
               }
               finally {
                startActivity(intent);
                finish();
               }

            }

        };

         timer.start();
    }
}