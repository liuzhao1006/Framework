package com.lz.login.app;

import android.app.Application;

import com.lz.base.app.BaseApplication;
import com.lz.base.factory.ContextFactory;


/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午9:55
 * 描述     :
 */
public class LoginApplication extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        ContextFactory.init(getApplicationContext());
    }

    @Override
    public void onCreateAsLibrary(Application application) {
        super.onCreateAsLibrary(application);

    }
}
