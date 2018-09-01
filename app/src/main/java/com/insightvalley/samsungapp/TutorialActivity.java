package com.insightvalley.samsungapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class TutorialActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private RelativeLayout  mSlideBackground;
    private LinearLayout mDotsLayout;

    private TextView[] mDots;
    private SliderAdapter sliderAdapter;

    private Button mSlideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_tutorial);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mSlideBackground = (RelativeLayout) findViewById(R.id.slide_background);
        mDotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mSlideButton = (Button) findViewById(R.id.slide_button);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mSlideButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



    public void addDotsIndicator(int position) {
        mDots = new TextView[4];
        mDotsLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#9898") + " ");
            mDots[i].setTextSize(17);
            mDots[i].setTextColor(getResources().getColor(R.color.dotEnable));

            mDotsLayout.addView(mDots[i]);
        }

        if(mDots.length > 0) {
            mDots[position].setText(Html.fromHtml("&#9899") + " ");
            mDots[position].setTextSize(17);
            mDots[position].setTextColor(getResources().getColor(R.color.dotEnable));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            switch(i){
                case 0: mSlideBackground.setBackgroundColor(getResources().getColor(R.color.tutor1));break;
                case 1: mSlideBackground.setBackgroundColor(getResources().getColor(R.color.tutor2));break;
                case 2: mSlideBackground.setBackgroundColor(getResources().getColor(R.color.tutor3));break;
                case 3: mSlideBackground.setBackgroundColor(getResources().getColor(R.color.colorPrimary));break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };
}
