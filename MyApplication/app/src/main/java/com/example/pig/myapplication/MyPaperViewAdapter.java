package com.example.pig.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by Pig on 12/16/2016.
 */

//Dùng để gắn kết giữa PaperView và các fragment
public class MyPaperViewAdapter extends FragmentPagerAdapter {
    CartFragment cartFragment;
    FoodMenuFragment foodMenuFragment;
    public CartFragment getCartFragment() {
        return cartFragment;
    }

    public FoodMenuFragment getFoodMenuFragment() {
        return foodMenuFragment;
    }

    public MyPaperViewAdapter(FragmentManager m)
    {
        super(m);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment o = (Fragment) super.instantiateItem(container, position);
        if(position == 1)
        {
            cartFragment = (CartFragment)o;
        }
        else if(position == 0)
        {
            foodMenuFragment = (FoodMenuFragment)o;
        }
        return o;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return FoodMenuFragment.getnewInstance();
            case 1: return CartFragment.getnewInstance();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return MainActivity.FRAGMENT_COUNT;
    }
}
