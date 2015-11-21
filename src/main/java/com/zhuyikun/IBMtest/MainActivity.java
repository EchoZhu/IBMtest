package com.zhuyikun.IBMtest;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.zhuyikun.IBMtest.base.BaseActivity;
import com.zhuyikun.IBMtest.helper.ForwardHelper;


public class MainActivity extends BaseActivity{

    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler(){
            public void handleMessage(Message msg) {
                ForwardHelper.toHomePage(MainActivity.this);
            };
        };
        startSplashActivity();
    }
    private void startSplashActivity() {
        // TODO Auto-generated method stub
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                mHandler.sendMessage(mHandler.obtainMessage());
            }
        }).start();
    }

}
