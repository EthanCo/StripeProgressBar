package com.heiko.stripeprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * 圆角图形
 */
public class RoundCornerImageView extends android.support.v7.widget.AppCompatImageView {
    private float mRadius = 18;
    private Path mClipPath = new Path();
    private RectF mRect = new RectF();

    public RoundCornerImageView(Context context) {
        super(context);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setRadiusDp(float dp) {
        mRadius = Utils.dp2px(getContext(),dp);
        postInvalidate();
    }

    public void setRadiusPx(int px) {
        mRadius = px;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mRect.set(0, 0, this.getWidth(), this.getHeight());
        mClipPath.reset(); // remember to reset path
        mClipPath.addRoundRect(mRect, mRadius, mRadius, Path.Direction.CW);
        canvas.clipPath(mClipPath);
        super.onDraw(canvas);
    }
}