package com.example.skillsacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.skillsacademy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
public ActivityMainBinding mainBinding;
    public Animation leftAnim,rightAnim,topAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        leftAnim= AnimationUtils.loadAnimation(this,R.anim.left_animation);
        rightAnim=AnimationUtils.loadAnimation(this,R.anim.right_animation);


        mainBinding.textView.setAnimation(leftAnim);
        mainBinding.imageViewLogo.setAnimation(topAnim);
        mainBinding.cardPremium.setAnimation(rightAnim);
        mainBinding.cardOther.setAnimation(leftAnim);





    }
}