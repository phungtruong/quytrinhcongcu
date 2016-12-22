package com.example.pig.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Pig on 12/16/2016.
 */

//Dùng để gắn kết giữa PaperView và các fragment
public class MyPaperViewAdapter extends FragmentPagerAdapter {
    public MyPaperViewAdapter(FragmentManager m)
    {
        super(m);
    }
    @Override
    public Fragment getItem(int position) {
        return FoodMenuFragment.getnewInstance();
    }

    @Override
    public int getCount() {
        return MainActivity.FRAGMENT_COUNT;
    }
}
