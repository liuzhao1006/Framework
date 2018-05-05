package com.lz.framework.app;

import com.lz.base.api.IApplication;
import com.lz.base.app.BaseApplication;
import com.lz.base.factory.ContextFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午9:34
 * 描述     :
 */
public class MainApplication extends BaseApplication {
    private List<IApplication> mChildApplicationList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        ContextFactory.init(getApplicationContext());

//        mChildApplicationList.add();
        for (IApplication app : mChildApplicationList){
            app.onCreateAsLibrary(this);
        }

    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IApplication app : mChildApplicationList){
            app.onTrimMemoryAsLibrary(this,level);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for(IApplication app : mChildApplicationList){
            app.onLowMemoryAsLibrary(this);
        }
    }
}
