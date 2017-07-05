package com.example.deepak.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{
    ViewPager viewPager;
    SwipeLayout adapter;
    RadioButton radioButton1;
    RadioButton radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.view_Pager);
        adapter=new SwipeLayout(this);
        viewPager.setAdapter(adapter);
        int position=viewPager.getCurrentItem();

        viewPager.addOnPageChangeListener(this);
        radioButton1=(RadioButton)findViewById(R.id.radio1);
        radioButton2=(RadioButton)findViewById(R.id.radio2);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==0)
        {
            radioButton1.toggle();
        }
        else if(position==1)
        {
            radioButton2.toggle();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.radio1:
                if (checked)
                    viewPager.setCurrentItem(0);
                    break;
            case R.id.radio2:
                if (checked)
                    viewPager.setCurrentItem(1);
                    break;
        }
    }
}
