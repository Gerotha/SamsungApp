package com.insightvalley.samsungapp;

import android.content.Intent;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    ImageView mAxions;

    Button mEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTheme(R.style.LoginTheme);

        mAxions = (ImageView) findViewById(R.id.axions_login);
        mEntrar = (Button) findViewById(R.id.botaoLogin);

        Animation animation = new AlphaAnimation(0.5f, 0.2f);
        animation.setDuration(1300);
        animation.setInterpolator(new FastOutLinearInInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);

        mAxions.startAnimation(animation);

        mEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,
                        HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
