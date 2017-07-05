package com.example.deepak.viewpager;

import android.content.Context;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.StrictMath.ceil;

/**
 * Created by deepak on 27/6/16.
 */
public class SwipeLayout extends PagerAdapter implements ViewPager.OnClickListener {
    String occasion;
    TextView text1;
    TextView text2;
    CheckBox checkBox;
    FrameLayout frameLayout1;
    FrameLayout frameLayout2;
    FrameLayout frameLayout;
    FrameLayout tempFrame;
    int select = 0;
    View view;

    String title[];
    private Context ctx ;
    private LayoutInflater layoutInflater;
    private MainInterface mainInterface;

    public SwipeLayout(Context ctx,MainInterface mainInterface,String title[]) {
        this.ctx = ctx;
        this.mainInterface=mainInterface;
        this.title=title;
    }

    @Override
    public int getCount() {
        return title.length / 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public float getPageWidth(int position) {
        return 0.45f;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int tmp = 0;

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.layout_swipe, container, false);
        frameLayout1 = (FrameLayout) view.findViewById(R.id.flContainer);
        frameLayout2 = (FrameLayout) view.findViewById(R.id.flContainer1);
//        checkBox1=(CheckBox)view.findViewById(R.id.checkbox1);
//        checkBox2=(CheckBox)view.findViewById(R.id.checkbox2);
        text1 = (TextView) view.findViewById(R.id.text1);
        text2 = (TextView) view.findViewById(R.id.text2);
        tmp = position * 2;
        frameLayout1.setBackgroundResource(R.drawable.icon_selector);
        frameLayout2.setBackgroundResource(R.drawable.icon_selector);
        text1.setText(title[tmp]);
        text2.setText(title[tmp + 1]);
        frameLayout1.setOnClickListener(this);
        frameLayout2.setOnClickListener(this);


        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }


    @Override
    public void onClick(View v) {
        if (frameLayout != null) {
            tempFrame = frameLayout;
        }
        frameLayout = (FrameLayout) v.findViewById(v.getId());
        frameLayout.setSelected(!frameLayout.isSelected());
        switch (v.getId()) {
            case R.id.flContainer:
                checkBox = (CheckBox) v.findViewById(R.id.checkbox1);
                text1 = (TextView) v.findViewById(R.id.text1);
                break;
            case R.id.flContainer1:
                checkBox = (CheckBox) v.findViewById(R.id.checkbox2);
                text1 = (TextView) v.findViewById(R.id.text2);
                break;
        }
        checkBox.setChecked(v.isSelected());
        if (frameLayout.isSelected() && select == 0) {
            text1.setTextColor(ctx.getResources().getColor(R.color.white));
            occasion = text1.getText().toString();
            select = 1;
            mainInterface.showNext();
        } else if (frameLayout.isSelected() && select == 1) {
            tempFrame.setSelected(!tempFrame.isSelected());
            CheckBox tempCheck = (CheckBox) tempFrame.findViewById(R.id.checkbox1);
            TextView tempText = (TextView) tempFrame.findViewById(R.id.text1);
            switch (tempFrame.getId()) {
                case R.id.flContainer1:
                    tempText = (TextView) tempFrame.findViewById(R.id.text2);
                    tempCheck = (CheckBox) tempFrame.findViewById(R.id.checkbox2);
                    break;
            }
            tempCheck.setChecked(false);
            tempText.setTextColor(ctx.getResources().getColor(R.color.colorPrimary));

            text1.setTextColor(ctx.getResources().getColor(R.color.white));


            occasion = text1.getText().toString();
        } else {
            text1.setTextColor(ctx.getResources().getColor(R.color.colorPrimary));
            select = 0;
            occasion = null;
            mainInterface.hideNext();
        }

        //Toast.makeText(ctx, occasion, Toast.LENGTH_SHORT).show();
    }
//    public void setCallback(MainInterface mainInterface){
//          this.mainInterface=mainInterface;
//    }
}

