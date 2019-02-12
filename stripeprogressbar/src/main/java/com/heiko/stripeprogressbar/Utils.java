package com.heiko.stripeprogressbar;

import android.content.Context;

/**
 * 工具类
 *
 * @author Heiko
 * @date 2019/2/12
 */
class Utils {
    /*
     * dp转换成px
     */
    static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
