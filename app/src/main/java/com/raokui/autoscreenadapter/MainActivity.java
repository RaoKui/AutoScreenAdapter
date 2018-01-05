package com.raokui.autoscreenadapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ThreadLocal<Boolean> threadLocal = new ThreadLocal<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





//        threadLocal.set(true);
//        Log.i(TAG, "onCreate: " + Thread.currentThread().getName() + " : " + threadLocal.get());
//
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                threadLocal.set(false);
//                Log.i(TAG, "onCreate: " + Thread.currentThread().getName() + " : " + threadLocal.get());
//            }
//        }.start();
//
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                Log.i(TAG, "onCreate: " + Thread.currentThread().getName() + " : " + threadLocal.get());
//            }
//        }.start();

    }


    class MyThread extends Thread {

        private Handler handler;

        @Override
        public void run() {
            super.run();
            handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }

}
