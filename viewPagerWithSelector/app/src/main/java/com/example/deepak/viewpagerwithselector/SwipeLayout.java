package com.example.deepak.viewpagerwithselector;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
;

/**
 * Created by deepak on 1/7/16.
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
        int tmp=0;
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.layout_swipe,container,false);
        ImageView imageView1=(ImageView)view.findViewById(R.id.image_view1);
        ImageView imageView2=(ImageView)view.findViewById(R.id.image_view2);
        tmp=position*2;
        imageView1.setImageResource(image_resources[tmp]);
        imageView2.setImageResource(image_resources[tmp+1]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
