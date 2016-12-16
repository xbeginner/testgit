package com.viewtest.design.myview;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
    private List<String> mData;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        initData();
        initRecyclerView();
        initSwipeLayout();


    }


    private void initSwipeLayout(){
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.srl);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // 开始刷新，设置当前为刷新状态
                swipeRefreshLayout.setRefreshing(true);

                // 这里是主线程
                // 一些比较耗时的操作，比如联网获取数据，需要放到子线程去执行
                // TODO 获取数据
                final Random random = new Random();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mData.add(0, "我是天才" + random.nextInt(100) + "号");
                        mAdapter.notifyDataSetChanged();

                        Toast.makeText(RecyclerViewActivity.this, "刷新了一条数据", Toast.LENGTH_SHORT).show();

                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1200);

            }
        });
    }


    private void initData() {
        mData = new ArrayList<>();
        for(int i=0;i<20;i++){
            mData.add("Item "+i);
        }
    }



    private void initRecyclerView() {
    //1 实例化RecyclerView
    mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
    mLayoutManager = new LinearLayoutManager(this);
    //2 为RecyclerView创建布局管理器，这里使用的是LinearLayoutManager，表示里面的Item排列是线性排列
    mRecyclerView.setLayoutManager(mLayoutManager);
    mAdapter = new RecyclerAdapter(mData);
    //3 设置数据适配器
    mRecyclerView.setAdapter(mAdapter);
   }
}
