package com.lz.base.api;

import android.app.Application;

/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 上午8:53
 * 描述     :  基类application接口
 */
public interface IApplication {

    public void onCreateAsLibrary(Application application);
    public void onLowMemoryAsLibrary(Application application);
    public void onTrimMemoryAsLibrary(Application application, int level);
}
