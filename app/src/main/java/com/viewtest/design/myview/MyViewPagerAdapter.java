package com.viewtest.design.myview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2016/12/19.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {


    List<Fragment> fragments = new ArrayList<Fragment>();

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);

     

    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
