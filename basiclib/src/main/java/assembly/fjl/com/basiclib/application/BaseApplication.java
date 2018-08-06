package assembly.fjl.com.basiclib.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import assembly.fjl.com.basiclib.rxutils.RxCrashUtils;
import assembly.fjl.com.basiclib.utils.Utils;

public class BaseApplication extends Application {

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this); // Enable MultiDex.
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        RxCrashUtils.getInstance(this).init();
        Logger.addLogAdapter(new AndroidLogAdapter());
        if(Utils.isAppDebug()){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
