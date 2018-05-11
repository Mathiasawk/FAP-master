package com.group5.fap;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageAdapter extends PagerAdapter {
    Context context;
    private LayoutInflater layoutInflater;

    private int[] GalImages = new int[] {
            R.drawable.fish,
            R.drawable.football,
            R.drawable.petanque,
            R.drawable.rollespil
    };

    ImageAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_home_screen, null);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(GalImages[position]);
        ((ViewPager) container).addView(imageView, 0);



        return imageView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }


}
