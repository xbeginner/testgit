package com.viewtest.design.myview;


import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class FragmentActivity extends AppCompatActivity
implements BlankFragment1.OnFragmentInteractionListener,
BlankFragment2.OnFragmentInteractionListener,
BlankFragment3.OnFragmentInteractionListener{

    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        toolbar = (Toolbar)findViewById(R.id.myToolbar);
        viewPager = (ViewPager)findViewById(R.id.myViewPager);
        FragmentManager manager = getSupportFragmentManager();

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(manager);

        setSupportActionBar(toolbar);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        System.out.println(uri);
    }
}
