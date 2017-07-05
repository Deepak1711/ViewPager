package com.example.deepak.viewpagerwithselector;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    SwipeLayout adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(MultiViewPager)findViewById(R.id.view_Pager);
        adapter=new SwipeLayout(this);
        viewPager.setAdapter(adapter);
    }
}
