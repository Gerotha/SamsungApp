package com.insightvalley.samsungapp;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    ImageView mAxions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTheme(R.style.LoginTheme);

        mAxions = (ImageView) findViewById(R.id.axions_login);

        Animation animation = new AlphaAnimation(0.5f, 0.2f);
        animation.setDuration(1300);
        animation.setInterpolator(new FastOutLinearInInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);

        mAxions.startAnimation(animation);
    }
}
