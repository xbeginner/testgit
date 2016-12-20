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
    String[] titles = {"测试1","测试2","测试3"};

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);

        BlankFragment1 fragment1 = new BlankFragment1();
        BlankFragment2 fragment2 = new BlankFragment2();
        BlankFragment3 fragment3 = new BlankFragment3();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
