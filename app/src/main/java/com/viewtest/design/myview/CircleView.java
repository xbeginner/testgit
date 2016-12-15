package com.viewtest.design.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by pc on 2016/11/22.
 */
public class CircleView extends View{

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int redColor = Color.RED;
    private int blueColor = Color.BLUE;
    private int maxColor = (redColor&0xFFFF0000)|(blueColor&0xFF0000FF);
    private int cutColor = maxColor&(~blueColor|0xFF000000);
    private int isRedColor = maxColor&redColor;
    //

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    private void init(){
        mPaint.setColor(redColor);
        System.out.println(Integer.toBinaryString(redColor));
        System.out.println(Integer.toBinaryString(blueColor));
        System.out.println(Integer.toBinaryString(maxColor));
        System.out.println(Integer.toBinaryString(cutColor));
        System.out.println(Integer.toBinaryString(isRedColor));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width,height)/2;
        canvas.drawCircle(width/2,height/2,radius,mPaint);

    }
}
