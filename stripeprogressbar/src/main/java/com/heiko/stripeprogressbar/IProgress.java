package com.heiko.stripeprogressbar;

/**
 * 进度条接口
 *
 * @author Heiko
 * @date 2019/2/13
 */
public interface IProgress {
    /**
     * 设置进度条最大进度
     *
     * @param maxProgress
     */
    void setMax(int maxProgress);

    /**
     * 设置进度条当前进度
     *
     * @param progress
     */
    void setProgress(int progress);

    /**
     * 获取当前进度
     *
     * @return
     */
    int getProgress();
}
