package com.raokui.autoscreenadapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by 饶魁 on 2018/1/5.
 */

public class ViewCalculateUtils {

    // 获取调用层传入的值进行设置

    public static void setViewLinearLayoutParam(Context context, View view, int width, int height, int topMargin, int bottomMargin, int leftMargin, int rightMargin) {

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (width != LinearLayout.LayoutParams.MATCH_PARENT && width != LinearLayout.LayoutParams.WRAP_CONTENT) {
            layoutParams.width = UIUtils.getInstance(context).getWidth(width);
        } else {
            layoutParams.width = width;
        }

        if (height != LinearLayout.LayoutParams.MATCH_PARENT && height != LinearLayout.LayoutParams.WRAP_CONTENT) {
            layoutParams.height = UIUtils.getInstance(context).getWidth(height);
        } else {
            layoutParams.height = height;
        }


//            height 是竖着缩放，width是横向缩放
        layoutParams.topMargin = UIUtils.getInstance(context).getHeight(topMargin);
        layoutParams.bottomMargin = UIUtils.getInstance(context).getHeight(bottomMargin);
        layoutParams.leftMargin = UIUtils.getInstance(context).getWidth(leftMargin);
        layoutParams.rightMargin = UIUtils.getInstance(context).getWidth(rightMargin);
        view.setLayoutParams(layoutParams);
    }

    public static void setViewRelativeParam(Context context, View view, int width, int height, int topMargin, int bottomMargin, int leftMargin, int rightMargin) {

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT) {
            layoutParams.width = UIUtils.getInstance(context).getWidth(width);
        } else {
            layoutParams.width = width;
        }

        if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT) {
            layoutParams.height = UIUtils.getInstance(context).getWidth(height);
        } else {
            layoutParams.height = height;
        }


//            height 是竖着缩放，width是横向缩放
        layoutParams.topMargin = UIUtils.getInstance(context).getHeight(topMargin);
        layoutParams.bottomMargin = UIUtils.getInstance(context).getHeight(bottomMargin);
        layoutParams.leftMargin = UIUtils.getInstance(context).getWidth(leftMargin);
        layoutParams.rightMargin = UIUtils.getInstance(context).getWidth(rightMargin);
        view.setLayoutParams(layoutParams);
    }

}
