package com.viewtest.design.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initData();


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
