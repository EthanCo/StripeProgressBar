package com.heiko.stripeprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 条纹进度条
 *
 * @author Heiko
 * @date 2019/2/12
 */
public class StripeProgressBar extends FrameLayout implements IProgress {
    public static final String TAG = "StripeProgressBar";
    private RoundCornerImageView mProgressIv;
    private ImageView mBotIv;
    private int maxProgress;
    private int progress = 0;
    private int progressRadius;
    private Drawable progressImage;

    public StripeProgressBar(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public StripeProgressBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public StripeProgressBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View root = LayoutInflater.from(context).inflate(R.layout.layout_stripe_progress_bar, this);
        mProgressIv = root.findViewById(R.id.p_cover_iv);
        mBotIv = root.findViewById(R.id.p_bot_iv);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StripeProgressBar);

        int defProgressRadius = Utils.dp2px(getContext(), 10);
        progressRadius = (int) ta.getDimension(R.styleable.StripeProgressBar_progress_radius, defProgressRadius);
        int progressBackgroundColor = ta.getColor(R.styleable.StripeProgressBar_progress_background, Color.parseColor("#d9d9d9"));
        progressImage = ta.getDrawable(R.styleable.StripeProgressBar_progress_image);
        maxProgress = ta.getInteger(R.styleable.StripeProgressBar_progress_max,100);
        if (progressImage == null) {
            throw new IllegalArgumentException("app:progressImage must not null.");
        }
        ta.recycle();

        Log.i(TAG, "defProgressRadius:" + defProgressRadius + " progressRadius:" + progressRadius);
        mProgressIv.setImageDrawable(progressImage);
        mProgressIv.setRadiusPx(progressRadius);
        GradientDrawable drawable = new GradientDrawable();
        //设置圆角大小
        drawable.setCornerRadius(progressRadius);
        //设置边缘线的宽以及颜色
        //drawable.setStroke(1, Color.parseColor("#FF00FF"));
        //设置shape背景色
        drawable.setColor(progressBackgroundColor);
        //设置到TextView中
        mBotIv.setImageDrawable(drawable);
        setProgress(0);
    }

    /**
     * 设置进度条最大进度
     *
     * @param maxProgress
     */
    @Override
    public void setMax(int maxProgress) {
        this.maxProgress = maxProgress;
    }

    /**
     * 设置进度条当前进度
     *
     * @param progress
     */
    @Override
    public void setProgress(int progress) {
        this.progress = progress;
        float percent = this.progress / (maxProgress * 1.0F);
        final int ivWidth = mBotIv.getWidth();
        //final int initWidth = (int) (ivWidth * 0.08);
        final int calcWidth = ivWidth - progressRadius * 2;
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mProgressIv.getLayoutParams();
        int marginEnd = (int) ((1 - percent) * calcWidth);
        lp.width = ivWidth - marginEnd;
        mProgressIv.setLayoutParams(lp);
        mProgressIv.postInvalidate();
    }

    /**
     * 获取当前进度
     *
     * @return
     */
    @Override
    public int getProgress() {
        return this.progress;
    }
}
