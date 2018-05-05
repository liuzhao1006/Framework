package com.lz.base.app;

import android.app.Application;

import com.apkfuns.logutils.LogUtils;
import com.lz.base.api.IApplication;


/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午1:54
 * 描述     : 应用程序基类
 */
public class BaseApplication extends Application implements IApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i("程序入口--应用程序基类");
        onCreateAsLibrary(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        onLowMemoryAsLibrary(this);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        onTrimMemoryAsLibrary(this, level);
    }


    @Override
    public void onCreateAsLibrary(Application application) {

    }

    @Override
    public void onLowMemoryAsLibrary(Application application) {

    }

    @Override
    public void onTrimMemoryAsLibrary(Application application, int level) {

    }
}
