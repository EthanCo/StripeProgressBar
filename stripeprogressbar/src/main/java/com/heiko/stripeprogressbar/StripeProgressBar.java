package com.heiko.stripeprogressbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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
public class StripeProgressBar extends FrameLayout {
    private RoundCornerImageView mProgressIv;
    private ImageView mBotIv;
    private int maxProgress = 100;
    private int progress = 0;

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
        mProgressIv.setRadiusDp(5);
    }

    /**
     * 设置进度条最大进度
     *
     * @param maxProgress
     */
    public void setMax(int maxProgress) {
        this.maxProgress = maxProgress;
    }

    /**
     * 设置进度条当前进度
     *
     * @param progress
     */
    public void setProgress(int progress) {
        this.progress = progress;
        float percent = this.progress / (maxProgress * 1.0F);
        final int ivWidth = mBotIv.getWidth();
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mProgressIv.getLayoutParams();
        int marginEnd = (int) ((1 - percent) * ivWidth);
        lp.width = ivWidth - marginEnd;
        mProgressIv.setLayoutParams(lp);
        mProgressIv.postInvalidate();
    }
}