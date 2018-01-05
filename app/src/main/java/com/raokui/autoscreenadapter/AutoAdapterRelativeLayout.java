package com.raokui.autoscreenadapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by RaoKui on 2017/11/24.
 */

public class AutoAdapterRelativeLayout extends RelativeLayout {

    public AutoAdapterRelativeLayout(Context context) {
        super(context);
    }

    public AutoAdapterRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoAdapterRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 测量子控件的宽高进行改变
        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = this.getChildAt(i);
            AutoAdapterRelativeLayout.LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
            // 把已经的布局参数更改
            float newWidth = 0.0f;
            float newHeight = 0.0f;
            float newMarginTop = 0.0f;
            float newMarginBottom = 0.0f;
            float newMarginLeft = 0.0f;
            float newMarginRight = 0.0f;

            if (layoutParams instanceof AutoAdapterRelativeLayout.LayParams) {
                // 获取布局上的自定义宽高
                newWidth = ((LayParams) layoutParams).getAutoAdapterWidth();
                newHeight = ((LayParams) layoutParams).getAutoAdapterHeight();
                newMarginTop = ((LayParams) layoutParams).getAutoAdapterMarginTop();
                newMarginBottom = ((LayParams) layoutParams).getAutoAdapterMarginBottom();
                newMarginLeft = ((LayParams) layoutParams).getAutoAdapterMarginLeft();
                newMarginRight = ((LayParams) layoutParams).getAutoAdapterMarginRight();
                Log.i(TAG, "onMeasure: 布局中的宽：" + newWidth + "布局中的高：" + newHeight);
            }

            if (newWidth > 0) {
                layoutParams.width = (int) UIUtils.getInstance(getContext().getApplicationContext()).getWidth(newWidth);
            }

            if (newHeight > 0) {
                layoutParams.height = (int) UIUtils.getInstance(getContext().getApplicationContext()).getHeight(newHeight);
            }

            if (newMarginBottom > 0) {
                layoutParams.bottomMargin = (int) UIUtils.getInstance(getContext().getApplicationContext()).getHeight(newMarginBottom);
            }
            if (newMarginTop > 0) {
                layoutParams.topMargin = (int) UIUtils.getInstance(getContext().getApplicationContext()).getHeight(newMarginTop);
            }
            if (newMarginLeft > 0) {
                layoutParams.leftMargin = (int) UIUtils.getInstance(getContext().getApplicationContext()).getWidth(newMarginLeft);
            }
            if (newMarginRight > 0) {
                layoutParams.rightMargin = (int) UIUtils.getInstance(getContext().getApplicationContext()).getWidth(newMarginRight);
            }

            Log.i(TAG, "onMeasure: " + "计算后宽:" + layoutParams.width + "计算后高：" + layoutParams.height);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private static final String TAG = "AdapterRelativeLayout";

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayParams(getContext(), attrs);
    }

    public static class LayParams extends RelativeLayout.LayoutParams {

        private float mAutoAdapterWidth;
        private float mAutoAdapterHeight;

        private float mAutoAdapterMarginTop;
        private float mAutoAdapterMarginBottom;
        private float mAutoAdapterMarginLeft;
        private float mAutoAdapterMarginRight;


        private void setAutoAdapterWidth(float autoAdapterWidth) {
            this.mAutoAdapterWidth = autoAdapterWidth;
        }

        private void setAutoAdapterHeight(float autoAdapterHeight) {
            this.mAutoAdapterHeight = autoAdapterHeight;
        }

        private void setAutoAdapterMarginTop(float mAutoAdapterMarginTop) {
            this.mAutoAdapterMarginTop = mAutoAdapterMarginTop;
        }

        private void setAutoAdapterMarginBottom(float mAutoAdapterMarginBottom) {
            this.mAutoAdapterMarginBottom = mAutoAdapterMarginBottom;
        }

        private void setAutoAdapterMarginLeft(float mAutoAdapterMarginLeft) {
            this.mAutoAdapterMarginLeft = mAutoAdapterMarginLeft;
        }

        private void setAutoAdapterMarginRight(float mAutoAdapterMarginRight) {
            this.mAutoAdapterMarginRight = mAutoAdapterMarginRight;
        }

        private float getAutoAdapterWidth() {
            return mAutoAdapterWidth;
        }

        private float getAutoAdapterHeight() {
            return mAutoAdapterHeight;
        }

        private float getAutoAdapterMarginTop() {
            return mAutoAdapterMarginTop;
        }

        private float getAutoAdapterMarginBottom() {
            return mAutoAdapterMarginBottom;
        }

        private float getAutoAdapterMarginLeft() {
            return mAutoAdapterMarginLeft;
        }

        private float getAutoAdapterMarginRight() {
            return mAutoAdapterMarginRight;
        }

        public LayParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray array = c.obtainStyledAttributes(attrs, R.styleable.AutoAdapterRelativeLayout);
            mAutoAdapterWidth = array.getFloat(R.styleable.AutoAdapterRelativeLayout_layout_adapterWidth, 0);
            mAutoAdapterHeight = array.getFloat(R.styleable.AutoAdapterRelativeLayout_layout_adapterHeight, 0);

            mAutoAdapterMarginBottom = array.getFloat(R.styleable.AutoAdapterRelativeLayout_layout_adapterMarginBottom, 0);
            mAutoAdapterMarginTop = array.getFloat(R.styleable.AutoAdapterRelativeLayout_layout_adapterMarginTop, 0);
            mAutoAdapterMarginLeft = array.getFloat(R.styleable.AutoAdapterRelativeLayout_layout_adapterMarginLeft, 0);
            mAutoAdapterMarginRight = array.getFloat(R.styleable.AutoAdapterRelativeLayout_layout_adapterMarginRight, 0);

        }

        public LayParams(int w, int h) {
            super(w, h);
        }

        public LayParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayParams(MarginLayoutParams source) {
            super(source);
        }

        public LayParams(LayoutParams source) {
            super(source);
        }
    }

}
