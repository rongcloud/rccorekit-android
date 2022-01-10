package cn.rongcloud.kitdemo;

import android.app.Application;

import cn.rongcloud.corekit.api.RCSceneKitEngine;

/**
 * Created by gyn on 2021/11/15
 */
public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getSimpleName();
    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        RCSceneKitEngine.getInstance().initWithAppKey(this, null);
    }
}
