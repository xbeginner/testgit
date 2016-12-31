package com.viewtest.design.myview;


import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;




public class AsyncLoaderActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_loader);
//        Bundle bundle = new Bundle();
//        bundle.putString("key", "value");
//        Loader loader = getSupportLoaderManager().initLoader(0, bundle, this);
//        loader.startLoading();

        HandlerThread thread = new HandlerThread("myHandlerThread");
        thread.start();
        Looper looper = thread.getLooper();
        Handler handler = new Handler(looper);
        handler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread:"+Thread.currentThread().getName());
            }
        });
    }


    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        AsyncTaskLoader<String> loader = new AsyncTaskLoader<String>(AsyncLoaderActivity.this) {
            @Override
            public String loadInBackground() {

                System.out.println(args.getString("key"));
                return args.getString("key");
            }
        };
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

        System.out.println("loadFinished");
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

        System.out.println("reset");
    }


    private class myHandlerThread extends HandlerThread {

        public myHandlerThread(String name) {
            super(name);
        }


        @Override
        public void run() {
            super.run();
            Looper.prepare();
            Looper.loop();
        }
    }


}
