package com.viewtest.design.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "Rx";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                textView.setText("hi");
                //testRxJava();
            }
        });
        thread.start();

        UserInfo[] userInfos = new UserInfo[5];

        for(int i=0;i<5;i++){
            UserInfo user = new UserInfo("john"+i,i);
            userInfos[i] = user;
        }

        testUserInfoRxJava(userInfos);
    }

//    private void testRxJava(){
//        //定义一个观察者
//        Observer<String> observer = new Observer<String>() {
//            @Override
//            public void onNext(String s) {
//                Log.d(tag, "Item: " + Thread.currentThread());
//            }
//
//            @Override
//            public void onCompleted() {
//               // textView.setText("I am completed");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(tag, "Error!");
//            }
//        };
//
//
//        //定义一个被观察者
//        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                Log.d(tag, "call: " + Thread.currentThread());
//                subscriber.onNext("Hello");
//                subscriber.onNext("world");
//                subscriber.onCompleted();
//                //textView.setText("error");
//            }
//        });
//
//        //绑定
//        observable.subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()).subscribe(observer);
//    }


    private void testUserInfoRxJava(UserInfo[] userInfos){
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(tag, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, "Error!");
            }

            @Override
            public void onNext(String s) {
                Log.d(tag, "s:"+s);
            }
        };


        Observable.from(userInfos).map(new Func1<UserInfo, String>() {
            @Override
            public String call(UserInfo userInfo) {
                return userInfo.getName();
            }
        }).subscribe(subscriber);
    }
}

