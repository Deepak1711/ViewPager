package com.example.deepak.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainInterface {
    ViewPager viewPager;
    SwipeLayout adapter;
    TextView textView;
    Animation animFadein,animFadeout;
    //int image_resources[] = {R.drawable.birthday, R.drawable.anniversary, R.drawable.graduate, R.drawable.birthday, R.drawable.anniversary, R.drawable.graduate, R.drawable.birthday, R.drawable.anniversary};
    String title[] = {"Birthday", "Anniversary", "Graduate", "Holiday Party", "Baby Shower", "Graduate", "Birthday Surprise", "Other"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_Pager);
        adapter = new SwipeLayout(this,this,title);
        //adapter.setCallback(this);
        viewPager.setAdapter(adapter);
        textView= (TextView) findViewById(R.id.next);
        animFadein= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        animFadeout= AnimationUtils.loadAnimation(this,R.anim.fade_out);
    }


    @Override
    public void showNext() {
        textView.startAnimation(animFadein);
    }

    @Override
    public void hideNext() {
        textView.startAnimation(animFadeout);
    }
}
