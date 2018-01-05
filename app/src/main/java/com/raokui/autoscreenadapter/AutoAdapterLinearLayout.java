package com.raokui.autoscreenadapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by 饶魁 on 2018/1/5.
 */

public class AutoAdapterLinearLayout extends LinearLayout {

    private static final String TAG = "AdapterLinearLayout";

    public AutoAdapterLinearLayout(Context context) {
        super(context);
    }

    public AutoAdapterLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoAdapterLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AutoAdapterLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = this.getChildAt(i);
            AutoAdapterLinearLayout.LayoutParams layoutParams = (LayoutParams) childView.getLayoutParams();

            float newWidth = 0.0F;
            float newHeight = 0.0F;

            float newMarginLeft = 0.0F;
            float newMarginRight = 0.0F;
            float newMarginTop = 0.0F;
            float newMarginBottom = 0.0F;

            if (layoutParams instanceof AutoAdapterLinearLayout.LayParams) {
                // 获取布局上自定义的尺寸
                newWidth = ((LayParams) layoutParams).getAdapterWidth();
                newHeight = ((LayParams) layoutParams).getAdapterHeight();
                newMarginBottom = ((LayParams) layoutParams).getAdapterMarginBottom();
                newMarginTop = ((LayParams) layoutParams).getAdapterMarginTop();
                newMarginLeft = ((LayParams) layoutParams).getAdapterMarginLeft();
                newMarginRight = ((LayParams) layoutParams).getAdapterMarginRight();
                Log.d(TAG, "onMeasure: 布局中的宽：" + newWidth + "布局中的高：" + newHeight);
            }

            if (newWidth > 0) {
                layoutParams.width = (int) UIUtils.getInstance(getContext().getApplicationContext()).getWidth(newWidth);
            }
            if (newHeight > 0) {
                layoutParams.height = (int) UIUtils.getInstance(getContext().getApplicationContext()).getHeight(newHeight);
            }
            if (newMarginTop > 0) {
                layoutParams.width = (int) UIUtils.getInstance(getContext().getApplicationContext()).getHeight(newMarginTop);
            }
            if (newMarginBottom > 0) {
                layoutParams.width = (int) UIUtils.getInstance(getContext().getApplicationContext()).getHeight(newMarginBottom);
            }
            if (newMarginLeft > 0) {
                layoutParams.width = (int) UIUtils.getInstance(getContext().getApplicationContext()).getWidth(newMarginLeft);
            }
            if (newMarginRight > 0) {
                layoutParams.width = (int) UIUtils.getInstance(getContext().getApplicationContext()).getWidth(newMarginRight);
            }
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public static class LayParams extends LinearLayout.LayoutParams {

        private float adapterMarginLeft;
        private float adapterMarginRight;
        private float adapterMarginTop;
        private float adapterMarginBottom;

        private float adapterWidth;
        private float adapterHeight;


        public float getAdapterMarginLeft() {
            return adapterMarginLeft;
        }

        public void setAdapterMarginLeft(float adapterMarginLeft) {
            this.adapterMarginLeft = adapterMarginLeft;
        }

        public float getAdapterMarginRight() {
            return adapterMarginRight;
        }

        public void setAdapterMarginRight(float adapterMarginRight) {
            this.adapterMarginRight = adapterMarginRight;
        }

        public float getAdapterMarginTop() {
            return adapterMarginTop;
        }

        public void setAdapterMarginTop(float adapterMarginTop) {
            this.adapterMarginTop = adapterMarginTop;
        }

        public float getAdapterMarginBottom() {
            return adapterMarginBottom;
        }

        public void setAdapterMarginBottom(float adapterMarginBottom) {
            this.adapterMarginBottom = adapterMarginBottom;
        }

        public float getAdapterWidth() {
            return adapterWidth;
        }

        public void setAdapterWidth(float adapterWidth) {
            this.adapterWidth = adapterWidth;
        }

        public float getAdapterHeight() {
            return adapterHeight;
        }

        public void setAdapterHeight(float adapterHeight) {
            this.adapterHeight = adapterHeight;
        }

        public LayParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray array = c.obtainStyledAttributes(attrs, R.styleable.AutoAdapterLinearLayout);
            adapterHeight = array.getFloat(R.styleable.AutoAdapterLinearLayout_layout_adapterHeight, 0);
            adapterWidth = array.getFloat(R.styleable.AutoAdapterLinearLayout_layout_adapterWidth, 0);
            adapterMarginTop = array.getFloat(R.styleable.AutoAdapterLinearLayout_layout_adapterMarginTop, 0);
            adapterMarginBottom = array.getFloat(R.styleable.AutoAdapterLinearLayout_layout_adapterMarginBottom, 0);
            adapterMarginLeft = array.getFloat(R.styleable.AutoAdapterLinearLayout_layout_adapterMarginLeft, 0);
            adapterMarginRight = array.getFloat(R.styleable.AutoAdapterLinearLayout_layout_adapterMarginRight, 0);
        }

        public LayParams(int width, int height) {
            super(width, height);
        }

        public LayParams(int width, int height, float weight) {
            super(width, height, weight);
        }

        public LayParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        public LayParams(MarginLayoutParams source) {
            super(source);
        }

        public LayParams(LayoutParams source) {
            super(source);
        }
    }


}
