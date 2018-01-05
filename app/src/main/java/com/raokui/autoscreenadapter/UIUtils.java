package com.raokui.autoscreenadapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by 饶魁 on 2017/11/24.
 */

public class UIUtils {

    private static UIUtils mInstance;

    private int stand_width = 1080;

    private int stand_height = 1872;
    // 默认非全屏幕
    private boolean isFullScreen = false;

    public static UIUtils getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UIUtils.class) {
                if (mInstance == null) {
                    mInstance = new UIUtils(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化UI工具
     *
     * @param stand_width  ui设计标准宽度
     * @param stand_height ui设计标准高度
     * @param isFullScreen 是否为全屏
     */
    public void init(int stand_width, int stand_height, boolean isFullScreen) {
        if (stand_width > 0) {
            this.stand_width = stand_width;
        }

        if (stand_height > 48) {
            this.stand_height = stand_height - 48;
        }
        this.isFullScreen = isFullScreen;
        // 获取屏幕真实宽高
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (true_width == 0.0F || true_height == 0.0F) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            Log.i(TAG, "UIUtils: 测量的手机宽：" + displayMetrics.widthPixels + "测量的手机高:" + displayMetrics.heightPixels);
            // 获取系统状态栏高度
            int systemBarHeight = getSystemBarHeight(mContext);
            Log.i(TAG, "UIUtils: 状态栏高度" + systemBarHeight);
            // 测量的宽大于高，为横屏
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.true_width = (float) displayMetrics.heightPixels;
                this.true_height = (float) displayMetrics.widthPixels - systemBarHeight;
            } else {
                // 竖屏
                this.true_width = (float) displayMetrics.widthPixels;
                this.true_height = (float) displayMetrics.heightPixels - systemBarHeight;
            }
        }

        Log.i(TAG, "UIUtils: 真实的宽：" + true_width + "真实的高:" + true_height);
    }

    private float true_height;
    private float true_width;

    private Context mContext;

    private UIUtils(Context context) {
        this.mContext = context;
    }

    private static final String TAG = "UIUtils";

    private int getSystemBarHeight(Context context) {
        return getValue(context, "com.android.internal.R$dimen", "system_bar_height", 48);
    }

    /**
     * @param context
     * @param attrGroupClass 安卓源码中找打存放围度的类
     * @param attrName
     * @param defaultValue
     * @return
     */
    private int getValue(Context context, String attrGroupClass, String attrName, int defaultValue) {
        try {
            Class e = Class.forName(attrGroupClass);
            Object obj = e.newInstance();
            Field field = e.getField(attrName);

            int x = Integer.parseInt(field.get(obj).toString());
            return context.getResources().getDimensionPixelOffset(x);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public float getWidth(float width) {
        return width * this.true_width / stand_width;
    }

    public float getHeight(float height) {
        return height * this.true_height / stand_height;
    }

    public int getWidth(int width) {
        return (int) (width * this.true_width / stand_width);
    }

    public int getHeight(int height) {
        return (int) (height * this.true_height / stand_height);
    }

}
