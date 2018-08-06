package com.fjl.xiachufangmodel.runalone;



import com.orhanobut.logger.Logger;

import assembly.fjl.com.basiclib.application.BaseApplication;


public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.d("初始化完成");
    }
}
