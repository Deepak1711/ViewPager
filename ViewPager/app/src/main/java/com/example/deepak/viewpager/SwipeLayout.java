package com.example.deepak.viewpager;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import static java.lang.StrictMath.ceil;

/**
 * Created by deepak on 27/6/16.
 */
public class SwipeLayout extends PagerAdapter {
    int image_resources[]={R.drawable.bday,R.drawable.bday,R.drawable.bday,R.drawable.bday,R.drawable.bday,R.drawable.bday,R.drawable.bday,R.drawable.bday};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public SwipeLayout(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length/2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       //int tmp=0;

        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.layout_swipe,container,false);
        ImageView imageView1=(ImageView)view.findViewById(R.id.image_view1);
        //ImageView imageView2=(ImageView)view.findViewById(R.id.image_view2);
//        ImageView imageView3=(ImageView)view.findViewById(R.id.image_view3);
//        ImageView imageView4=(ImageView)view.findViewById(R.id.image_view4);
        //tmp=position*2;
        imageView1.setImageResource(image_resources[position]);
       // imageView2.setImageResource(image_resources[tmp+1]);
//        imageView3.setImageResource(image_resources[tmp+2]);
//        imageView4.setImageResource(image_resources[tmp+3]);



        container.addView(view);
        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
