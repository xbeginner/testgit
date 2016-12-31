package com.viewtest.design.myview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;

import java.io.File;
import java.io.FileDescriptor;

/**
 * Created by pc on 2016/12/31.
 */
public class decodeBitmap {

    public static Bitmap decodeSampledBitmapFromResource
            (Resources res,int resId,int reqWidth,int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(res,resId,options);
    }


    public static int calculateInSampleSize
            (BitmapFactory.Options options,int reqWidth,int reqHeight){

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if(height>reqHeight||width>reqWidth){
            final int halfWidth = width/2;
            final int halfHeight = height/2;
            while((halfHeight/inSampleSize)>=reqHeight&&(halfWidth/inSampleSize)>=reqWidth){
                inSampleSize*=2;
            }
        }
        return inSampleSize;
    }

    //LruCache基本使用方法
    int maxMemory = (int)(Runtime.getRuntime().maxMemory()/1024);
    int cacheSize = maxMemory/8;
    LruCache lruCache = new LruCache<String,Bitmap>(cacheSize){
        @Override
        protected int sizeOf(String key, Bitmap bitmap) {
            return bitmap.getRowBytes()*bitmap.getHeight()/1024;
        }
    };



}
