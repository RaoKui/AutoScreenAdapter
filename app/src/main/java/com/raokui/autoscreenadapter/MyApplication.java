package com.raokui.autoscreenadapter;

import android.app.Application;

/**
 * Created by 饶魁 on 2018/1/5.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UIUtils.getInstance(getApplicationContext()).init(400, 800, false);
    }
}
