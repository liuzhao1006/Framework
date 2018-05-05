package com.lz.base.factory;

import com.google.gson.Gson;
import com.lz.base.base.BaseFactory;


/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午3:05
 * 描述     :
 */
public class GsonFactory extends BaseFactory {

    private static Gson mGsonInstance;
    public static Gson getInstance(){
        if(mGsonInstance == null){
            synchronized (GsonFactory.class){
                if(mGsonInstance == null){
                    mGsonInstance = new Gson();
                }
            }
        }

        return mGsonInstance;
    }


}
