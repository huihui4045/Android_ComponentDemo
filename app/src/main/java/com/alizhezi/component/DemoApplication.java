package com.alizhezi.component;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.init(this);
    }
}
