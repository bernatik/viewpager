package com.alexbernat.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by alexbernat on 17.03.18.
 */

public class ViewWithTransparentCircle extends LinearLayout {

    private Paint mBackgroundPaint;
    private int mMainColor = getResources().getColor(R.color.colorPrimary);

    public ViewWithTransparentCircle(Context context) {
        super(context);
        init();
    }

    public ViewWithTransparentCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewWithTransparentCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(mMainColor);
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        float radius = Math.min(getWidth(), getHeight()) / 3;
        canvas.drawCircle(centerX, centerY, radius, mBackgroundPaint);
    }

    private void init() {
        setWillNotDraw(false);
        setLayerType(LAYER_TYPE_HARDWARE, null);

        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }


}
