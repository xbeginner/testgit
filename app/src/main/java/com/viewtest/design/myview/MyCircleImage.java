package com.viewtest.design.myview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by pc on 2016/11/23.
 */
public class MyCircleImage extends View{
    private Paint mPaint = new Paint();
    private Bitmap bitmap;
    private int imgId;

    public MyCircleImage(Context context) {
        super(context);

    }

    public MyCircleImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAttrs(context,attrs);

    }

    public MyCircleImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context, attrs);

    }

    private void getAttrs(Context context,AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.myCircleImage);
        imgId = ta.getResourceId(R.styleable.myCircleImage_img,0);
        Resources res = getResources();
        bitmap= BitmapFactory.decodeResource(res, imgId);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        mPaint.setColor(Color.RED);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height)/2;
        int layerId = canvas.saveLayer(0, 0, getWidth(),getHeight() , null, Canvas.ALL_SAVE_FLAG);
        canvas.drawCircle(width / 2, height / 2, radius, mPaint);
        PorterDuffXfermode mode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mPaint.setXfermode(mode);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restoreToCount(layerId);
    }
}
